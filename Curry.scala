package com.askmeipaas.scalabasics

object Curry extends App {

  //Currying: When a method is called with a fewer number of parameter lists,
  // then this will yield a function taking the missing parameter lists as its arguments.
  // i.e. split a function with multiple parameters into a chain of functions-each with one parameter

  //Normal
  def multiply(x: Double, y: Double): Double = x * y

  //Currying
  def multiplyV2(x: Double)(y:Double) = x * y

  //Currying - Another notation
  def multiplyV3(x: Double) = (y: Double) => x * y

  var mul=multiplyV2(2.3)(_) //partially applied function
  println(mul(5.1))

  def mulFunc = multiplyV2(2.3)(_) //notice the def keyword - method
  var result = mulFunc(5.1)
  println(result)
  val mulFuncV2 = multiplyV2(2.3)(_) //val is for function - ETA expansion
  println(mulFuncV2(5.1))

  //conversion of normal method to curried one
  val multiplyC = (multiply _).curried
  println(multiplyC(2.3)(5.1))

  def multiplyCV2 = multiplyC(2.3)(_)
  println(multiplyCV2(5.1))

}
