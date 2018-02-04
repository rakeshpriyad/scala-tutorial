package com.test.scala.io
import java.io.PrintWriter
import java.io.File
/**
 * Created by aayushraj on 04-02-2018.
 * overwrite the content of file
 */
object PrintWriterDemo {
  def main(args: Array[String]) {
    val writer = new PrintWriter(new File("scala/src/test.txt" ))

    writer.write("Hello Scala")
    writer.close()
  }
}
