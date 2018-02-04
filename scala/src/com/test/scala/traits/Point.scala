package com.test.scala.traits


/**
 * Created by aayushraj on 04-02-2018.
 */
class Point(xc: Int, yc: Int) extends Equal {
  var x: Int = xc
  var y: Int = yc

  def isEqual(obj: Any) = obj.isInstanceOf[Point] && obj.asInstanceOf[Point].x == y
}
