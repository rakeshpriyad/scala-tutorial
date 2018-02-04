package com.test.scala.traits



/**
 * Created by aayushraj on 04-02-2018.
 */
trait Equal {
  def isEqual(x: Any): Boolean
  def isNotEqual(x: Any): Boolean = !isEqual(x)
}
