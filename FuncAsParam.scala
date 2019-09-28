package com.askmeipaas.scalabasics

object FuncAsParam extends App {

  val transferCharge = 10
  val commission10 = (x:Double) => x/10
  val commission5 = (x:Double) => x/20

  def transfer(amount: Double, comm: Double => Double) :Double = {
    amount - transferCharge - comm(amount)
  }

  println(transfer(200,commission5))

  def addInts(x: Int, y:Int): Int = x + y

  def actAndPrint(act: (Int, Int) => Int, a: Int, b: Int) = {
    println(act(a,b))
  }

  actAndPrint(addInts, 4,5) //prints 9 - Sum function
  actAndPrint((x: Int, y: Int) => x*y, 2,3) //prints 6 / anonymous multiple function
}
