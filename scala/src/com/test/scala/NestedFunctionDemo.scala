package com.test.scala

/**
  * Created by aayushraj on 03-02-2018.
  */
object NestedFunctionDemo {

  def main(args: Array[String]) {
    println( factorial(0) )
    println( factorial(1) )
    println( factorial(2) )
    println( factorial(3) )
  }

  def factorial(i: Int): Int = {
    def fact(i: Int, accumulator: Int): Int = {
      if (i <= 1)
        accumulator
      else
        fact(i - 1, i * accumulator)
    }
    fact(i, 1)
  }

  def sub ( a: Integer , b: Integer) : Integer ={
    var sub : Integer =0;
    sub = a -b
    return sub
  }
 }
