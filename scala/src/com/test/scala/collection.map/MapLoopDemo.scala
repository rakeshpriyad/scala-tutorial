package com.test.scala.collection.map

/**
  * Created by aayushraj on 03-02-2018.*/
object MapLoopDemo {

  def main(args: Array[String]) {
    val colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")

    colors.keys.foreach { i =>
      print("Key = " + i)
      println(" Value = " + colors(i))
    }

    colors.values.foreach { i =>
      println("values = " + i)

    }
  }
}
