package com.askmeipaas.scalabasics

object MethodsVsFunctions extends App {

  /*
  A method is a part of an object or class
   */
  def increaseOne(x: Int) = x + 1

  //function - creates an instance of Function1[Int, Int]
  /*
  val incOne = new Function1[Int, Int] {
  def apply(x: Int): Int = x + 1
  }
   */
  val incOne = (x: Int) => x + 1
  //println(incOne(10))
  //incOne is an object - through apply method
  println(incOne.isInstanceOf[Function1[Int, Int]]) //prints true
  val incOneV2: (Int) => Int = (x: Int) => x + 1
  //println(incOneV2(10))

  //use of functions
  val numList = List.range(1,100)
  val isEven = (x: Int) => x%2 == 0
  val isOdd = (x: Int) => x%2 != 0
  val oddNumList = numList.filter(isOdd)
  val evenNumList = numList.filter(isEven)

  //println(evenNumList)
  //println(oddNumList)

  //double
  //println(numList.map((x: Int) => x * 2))
  //half
  //println(numList.map( _ / 2)) //(x: Int) => x / 2)

  val strings = List("ABCDEF", "ZYXABC", "qwerty", "asdfg")
  //println(strings.filter((s: String) => s.length == 6)) // _.length == 6
  //println(strings.map(_.concat("!")))
  //strings.foreach(println(_))

  //methods can't be a final value but functions can

  //method to function - eta expansion
  val funcIncreaseOne = increaseOne _
  println(funcIncreaseOne(2)) //prints 3

  //andThen keyword - incOne(1) --> incOneV2 will have the result of incOne(1) as parameter
  println(incOne.andThen(incOneV2)(1))
}

/*
  A method is a part of an object or class
   */
class AddOne {
  def addOneToInt(x: Int) = x + 1
}