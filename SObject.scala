package com.askmeipaas.scalabasics

object SObject extends App {

  val u1 = new User("Alpha", 20)
  val u2 = new User("Alpha", 20)

  val u3 = User
  val u4 = User

  println(u1 == u2) //prints false
  println(u3 == u4) //prints true as object is singleton


  //Factory method - apply
  val u5 = User("Beta", 20)
  val u6 = User("Gamma")


  println(u5.name + " " + u5.age)
  println(u6.name + " " + u6.age)

}

class User(val name: String, val age: Int)

//Object can't have constructor parameters
//static
//If object has the same name as class then it is called Companion Object
//A placeholder to define factory methods in form of apply overloading
object User {

  val age = 10;

  def apply(name: String, age: Int): User = new User(name, age)

  def apply(name: String): User = new User(name, age)
}
