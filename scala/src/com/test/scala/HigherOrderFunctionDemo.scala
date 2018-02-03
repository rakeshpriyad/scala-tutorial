package com.test.scala

/**
  * Created by aayushraj on 03-02-2018.
 * Scala allows the definition of higher-order functions. These are functions that take other functions as parameters, or whose result is a function.
  */
object HigherOrderFunctionDemo {

  def main(args: Array[String]) {
    println( apply( layout, 10) )
  }

  def apply(f: Int => String, v: Int) = f(v)

  def layout[A](x: A) = "[" + x.toString() + "]"

 }
