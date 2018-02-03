package com.test.scala

/**
  * Created by aayushraj on 03-02-2018.
  */
object RuntimeFunctionDemo {

   def main(args: Array[String]) {
     var inc = (x:Int) => x+1
     var x = inc(7)-1
     println(x)

     var mul = (x: Int, y: Int) => x*y

     println(mul(3, 4))


     //It is also possible to define functions with no parameter as follows ?

     var userDir = () => { System.getProperty("user.dir") }
     //Variable userDir is now a function that can be used the usual way ?

     println( userDir )
   }


 }
