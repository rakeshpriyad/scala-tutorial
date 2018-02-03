package com.test.scala
import Array._

/**
  * Created by aayushraj on 03-02-2018.
  */
object MDArrayDemo {

  def main(args: Array[String]) {
    var myMatrix = ofDim[Int](3,3)

    // build a matrix
    for (i <- 0 to 2) {
      for ( j <- 0 to 2) {
        myMatrix(i)(j) = j;
      }
    }

    // Print two dimensional array
    for (i <- 0 to 2) {
      for ( j <- 0 to 2) {
        print(" " + myMatrix(i)(j));
      }
      println();
    }
  }
}
