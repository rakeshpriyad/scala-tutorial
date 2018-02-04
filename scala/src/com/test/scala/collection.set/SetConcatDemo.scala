package com.test.scala.collection.set

/**
  * Created by aayushraj on 03-02-2018.
 * Scala Lists are quite similar to arrays which means, all the elements of a list have the same type but there are two important differences. First, lists are immutable, which means elements of a list cannot be changed by assignment. Second, lists represent a linked list whereas arrays are flat.
You can use either ++ operator or Set.++() method to concatenate two or more sets, but while adding sets it will remove duplicate elements.

The Following is the example to concatenate two sets.*/
object SetConcatDemo {

  def main(args: Array[String]) {
    val fruit1 = Set("apples", "oranges", "pears")
    val fruit2 = Set("mangoes", "banana")

    // use two or more sets with ++ as operator
    var fruit = fruit1 ++ fruit2
    println( "fruit1 ++ fruit2 : " + fruit )

    // use two sets with ++ as method
    fruit = fruit1.++(fruit2)
    println( "fruit1.++(fruit2) : " + fruit )
  }
}
