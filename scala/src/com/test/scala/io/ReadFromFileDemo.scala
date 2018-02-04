package com.test.scala.io

import java.io.{File, PrintWriter}

import scala.io.Source

/**
  * Created by aayushraj on 04-02-2018.
  * overwrite the content of file
  */
object ReadFromFileDemo {
   def main(args: Array[String]) {
     println("Following is the content read:" )

     Source.fromFile("scala/src/test.txt" ).foreach {
       print
     }
   }
 }
