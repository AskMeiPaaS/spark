package com.askmeipaas.scalabasics

object Closure extends App {

  val myClosure = new MyClosure()
  println(myClosure.sayHello("Alpha")) //prints - Hello, my name is Alpha and I am 10 old.

  myClosure.age = 20
  println(myClosure.sayHello("Beta")) //prints - Hello, my name is Beta and I am 20 old.

}

class MyClosure {
  var age = 10

  def sayHello(s: String): String = s"Hello, my name is $s and I am $age old." //age - free variable
}