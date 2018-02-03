package com.test.scala

/**
 * Created by aayushraj on 03-02-2018.
 *
 * String Interpolation
 */
object StringInterpolationDemo {

  def main(args: Array[String]) {
    val name = "James"

    println(s"Hello, $name")
    println(s"1 + 1 = ${1 + 1}")
  }

}
