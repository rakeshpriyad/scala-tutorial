package com.test.scala

/**
  * Created by aayushraj on 03-02-2018.
 *
 * A closure is a function, whose return value depends on the value of one or more variables declared outside this function.

The following piece of code with anonymous function.

val multiplier = (i:Int) => i * 10
Here the only variable used in the function body, i * 10 , is i, which is defined as a parameter to the function. Try the following code ?

val multiplier = (i:Int) => i * factor
There are two free variables in multiplier: i and factor. One of them, i, is a formal parameter to the function. Hence, it is bound to a new value each time multiplier is called. However, factor is not a formal parameter, then what is this? Let us add one more line of code.

var factor = 3
val multiplier = (i:Int) => i * factor
Now factor has a reference to a variable outside the function but in the enclosing scope. The function references factor and reads its current value each time. If a function has no external references, then it is trivially closed over itself. No external context is required.
  */
object CloserDemo {

  def main(args: Array[String]) {
    println( "multiplier(1) value = " +  multiplier(1) )
    println( "multiplier(2) value = " +  multiplier(2) )
  }
  var factor = 3
  val multiplier = (i:Int) => i * factor

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
