package com.test.scala.collection.set

/**
  * Created by aayushraj on 03-02-2018.*/
object SetMinMaxDemo {

  def main(args: Array[String]) {
    val num = Set(5,6,9,20,30,45)

    // find min and max of the elements
    println( "Min element in Set(5,6,9,20,30,45) : " + num.min )
    println( "Max element in Set(5,6,9,20,30,45) : " + num.max )
  }
}
