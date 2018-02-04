package com.test.scala.io

import java.io.{File, PrintWriter}

/**
  * Created by aayushraj on 04-02-2018.
  * overwrite the content of file
  */
object ReadLineDemo {
   def main(args: Array[String]) {
     print("Please enter your input : " )
     val line = Console.readLine

     println("Thanks, you just typed: " + line)
   }
 }
