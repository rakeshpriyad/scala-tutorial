package com.test.scala.io;

import scala.collection.mutable.HashMap
import scala.collection.JavaConverters._
import scala.io.Source
import util.control.Breaks._                                                                                                                                                                    
import java.nio.file.attribute._                                                                                                                                                                
import java.io.IOException                                                                                                                                                                      
import java.nio.file._                                                                                                                                                                          
                                                                                                                                                                                                
class DirectoryWatcher(val path:Path, val recursive:Boolean) extends Runnable {                                                                                                                 
                                                                                                                                                                                                
  val watchService = path.getFileSystem().newWatchService()                                                                                                                                     
  val keys = new HashMap[WatchKey,Path]                                                                                                                                                         
  var trace = false                                                                                                                                                                             
                                                                                                                                                                                                
  /**                                                                                                                                                                                           
  * Print an event                                                                                                                                                                              
  */                                                                                                                                                                                            
  def printEvent(event:WatchEvent[_]) : Unit = {                                                                                                                                                
    val kind = event.kind                                                                                                                                                                       
    val event_path = event.context().asInstanceOf[Path]
    if(kind.equals(StandardWatchEventKinds.ENTRY_CREATE)) {
      println("Entry created: " + event_path)
      println("path created: " + path + "/"+ event_path.toString)
      val lines =Source.fromFile(path + "/"+ event_path.toString).getLines.toList
      lines.zipWithIndex.foreach {
        case(content, lineNo) => println(s" line No: $lineNo and content:  $content")
      }
      val it =lines.iterator
      var lineNo :Int = 0
      while (it.hasNext){

        println("line no: " +lineNo + " " +it.next())
        lineNo += 1;
      }
    }
    else if(kind.equals(StandardWatchEventKinds.ENTRY_DELETE)) {
      println("Entry deleted: " + event_path)
    }
    else if(kind.equals(StandardWatchEventKinds.ENTRY_MODIFY)) {
      println("Entry modified: " + event_path)
    }
  }

  /** 
  * Register a particular file or directory to be watched
  */ 
  def register(dir:Path): Unit = {
    val key = dir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                           StandardWatchEventKinds.ENTRY_MODIFY,
                           StandardWatchEventKinds.ENTRY_DELETE)

    if (trace) {
      val prev = keys.getOrElse(key, null)
      if (prev == null) {
        println("register: " + dir)
      } else {
        if (!dir.equals(prev)) {
          println("update: " + prev + " -> " + dir)
        }
      }
    }

    keys(key) = dir
  }

  /** 
  * Makes it easier to walk a file tree 
  */ 
  implicit def makeDirVisitor(f: (Path) => Unit) = new SimpleFileVisitor[Path] {
    override def preVisitDirectory(p: Path, attrs: BasicFileAttributes) = {
      f(p)
      FileVisitResult.CONTINUE
    }
  }

  /** 
  *  Recursively register directories
  */ 
  def registerAll(start:Path): Unit = {
    Files.walkFileTree(start, (f: Path) => {
      register(f)
    })
  }

  /** 
  * The main directory watching thread 
  */ 
  override def run(): Unit = {
    try {
      if(recursive) {
        println("Scanning " + path + "...")
        registerAll(path)
        println("Done.")
      } else {
        register(path)
      }

      trace = true

      breakable {
        while (true) {
          val key = watchService.take()
          val dir = keys.getOrElse(key, null)
          if(dir != null) {
            key.pollEvents().asScala.foreach( event => {
              val kind = event.kind

              if(kind != StandardWatchEventKinds.OVERFLOW) {
                val name = event.context().asInstanceOf[Path]
                var child = dir.resolve(name)

                printEvent(event)

                if (recursive && (kind == StandardWatchEventKinds.ENTRY_CREATE)) {
                  try {
                    if (Files.isDirectory(child, LinkOption.NOFOLLOW_LINKS)) {
                      registerAll(child);
                    }
                  } catch {
                    case ioe: IOException => println("IOException: " + ioe)
                    case e: Exception => println("Exception: " + e)
                    break
                  }
                }
              }
            })
          } else {
            println("WatchKey not recognized!!")
          }

          if (!key.reset()) {
            keys.remove(key);
            if (keys.isEmpty) {
              break
            }
          }
        }
      }
    } catch {
      case ie: InterruptedException => println("InterruptedException: " + ie)
      case ioe: IOException => println("IOException: " + ioe)
      case e: Exception => println("Exception: " + e)
    }
  }
}

object WatchApp extends App {
  val path = FileSystems.getDefault().getPath("G:\\scalla-tutorial\\dir-watch")
  val dir_watcher = new DirectoryWatcher(path, true)
  val watch_thread = new Thread(dir_watcher)
  watch_thread.start()
}