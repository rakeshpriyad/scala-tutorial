package com.test.scala.collection.iterator

/**
  * Created by aayushraj on 03-02-2018.*/
object IteratorMinMaxDemo {

  def main(args: Array[String]) {
    val ita = Iterator(20,40,2,50,69, 90)
    val itb = Iterator(20,40,2,50,69, 90)

    println("Maximum valued element " + ita.max )
    println("Minimum valued element " + itb.min )
  }


}
