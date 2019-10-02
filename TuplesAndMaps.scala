package com.askmeipaas.scalabasics

object TuplesAndMaps extends App {
  //Extensively used

  //Tuples - hold different data types and immutable
  val intTuple1 = Tuple1(1) //Tuple1 to Tuple22
  println(intTuple1)
  val tuple2IntStr: Tuple2[Int, String] = Tuple2(1, "Hello") //Syntactic sugar could be used
  println(tuple2IntStr._1) //element is accessed through ._ notation and position

  //Map
  val aMap: Map[Int, String] = Map(1 -> "Us", 2 -> "UK", 3 -> "Singapore")
  val newMap = aMap + (4 -> "India")
  println(aMap)
  println(newMap)
  println(newMap.contains(4)) //key
  println(newMap.get(4)) //value

}
