package com.test.scala.collection.tupple

/**
  * Created by aayushraj on 03-02-2018.*/
object TuppleIteratorDemo {

  def main(args: Array[String]) {
    val t = (4,3,2,1)

    t.productIterator.foreach{ i =>println("Value = " + i )}
  }
}
