package com.test.scala.traits



/**
 * Created by aayushraj on 04-02-2018.
 */
object TraitDemo {
 def main(args : Array[String]){
   val p1 = new Point(2, 3)
   val p2 = new Point(2, 4)
   val p3 = new Point(3, 3)

   println(p1.isNotEqual(p2))
   println(p1.isNotEqual(p3))
   println(p1.isNotEqual(2))
 }
}
