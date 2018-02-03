package com.test.scala

/**
  * Created by aayushraj on 03-02-2018.
  */
object FunctionDemo {

   def main(args: Array[String]) {
     var s =add(10,20)
     println("sum is : " + s)
      var subs = sub(20,10)
     println("sub is : " + subs)
   }

  def add(a : Int, b :Int): Int ={
  var sum : Int =0
    sum = a+b
    return sum
  }

  def sub ( a: Integer , b: Integer) : Integer ={
    var sub : Integer =0;
    sub = a -b
    return sub
  }
 }
