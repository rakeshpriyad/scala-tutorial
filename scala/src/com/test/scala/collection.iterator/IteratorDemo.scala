package com.test.scala.collection.iterator

/**
  * Created by aayushraj on 03-02-2018.
 Scala Option[ T ] is a container for zero or one element of a given type. An Option[T] can be either Some[T] or None object, which represents a missing value. For instance, the get method of Scala's Map produces Some(value) if a value corresponding to a given key has been found, or None if the given key is not defined in the Map.

Option type is used frequently in Scala programs and you can compare this with the null value available in Java which indicate no value. For example, the get method of java.util.HashMap returns either a value stored in the HashMap, or null if no value was found.

Let's say we have a method that retrieves a record from the database based on a primary key.

def findPerson(key: Int): Option[Person]
  */
object IteratorDemo {

  def main(args: Array[String]) {
    val it = Iterator("a", "number", "of", "words")

    while (it.hasNext){
      println(it.next())
    }
  }
}
