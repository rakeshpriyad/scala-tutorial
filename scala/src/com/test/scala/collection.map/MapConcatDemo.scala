package com.test.scala.collection.map

/**
  * Created by aayushraj on 03-02-2018.
 * Scala Lists are quite similar to arrays which means, all the elements of a list have the same type but there are two important differences. First, lists are immutable, which means elements of a list cannot be changed by assignment. Second, lists represent a linked list whereas arrays are flat.
You can use either ++ operator or Set.++() method to concatenate two or more sets, but while adding sets it will remove duplicate elements.

The Following is the example to concatenate two sets.*/
object MapConcatDemo {

  def main(args: Array[String]) {
    val colors1 = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")
    val colors2 = Map("blue" -> "#0033FF", "yellow" -> "#FFFF00", "red" -> "#FF0000")

    // use two or more Maps with ++ as operator
    var colors = colors1 ++ colors2
    println( "colors1 ++ colors2 : " + colors )

    // use two maps with ++ as method
    colors = colors1.++(colors2)
    println( "colors1.++(colors2)) : " + colors )
  }
}
