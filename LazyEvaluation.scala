package com.askmeipaas.scalabasics

object LazyEvaluation extends App {

  def addInts(x: Int, y: Int): Unit = println(s"Sum of two Ints $x and $y is : " + (x + y)) //Not evaluated unless called.
  def addFloats(x: Float, y: Float): Unit = println(s"Sum of two Floats $x and $y is : " + (x + y)) //Not evaluated unless called.
  val block = {
    println("In a block") //Evaluated
    2 / 3 * 10 * 3
  }

  lazy val lazyBlock = {
    println("In a lazy block") //Not evaluated unless lazyBlock is called not just referred.
    2 / 3 * 10 * 3
  }

  val sum = addInts(2, 3)
  lazy val sumLazy = addInts(2, 3)
  val sumF = addFloats(3.0f, 4.0f)
  lazy val sumFLazy = addFloats(3.0f, 4.0f)

  def evaluateLazy(flag: Boolean): Unit = {
    if (flag) sum //evaluated
    else sumF //evaluated
  }
  evaluateLazy(true)
  evaluateLazy(false)

  def evaluateLazyV2(flag: Boolean): Unit = {
    if (flag) addInts(2, 3)
    else addFloats(3.0f, 4.0f) //Not evaluated
  }

  evaluateLazy(true)
  evaluateLazy(false)

  def evaluateLazyV3(flag: Boolean): Unit = {
    if (flag) sumLazy //not evaluated unless called.
    else sumFLazy //not evaluated unless called.
  }
  evaluateLazyV3(false)
  evaluateLazyV3(true)

  //List vs Stream

  val aList = (1 to 10).toList
  val aStream = (1 to 10).to(LazyList)

  println(s"List: $aList")
  println(s"Stream: $aStream") //Not evaluated
  aStream.foreach(println(_)) //evaluated

}
