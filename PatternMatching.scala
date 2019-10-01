package com.askmeipaas.scalabasics

object PatternMatching extends App {
  //like a switch statement

  val x: Int = 10

  x match {
    case 1 => println(s"Value of x is $x")
    case 2 => println(s"Value of x is $x")
    case _ => println(s"x is a wildcard")
  }

  //variant 2
  x match {
    case n if n % 2 == 0 => println(s"x is even : $x")
    //case n if n%2==1 => println(s"Value of x is $x") //No need to check this
    case _ => println("x is a odd")
  }

  case class Person(name: String, age: Int)

  //val alpha = Person("Alpha", 30)
  val alpha = Person("Alpha", 13)

  //Ordering matters. case is executed top to bottom and exit at the matching case
  alpha match {
    case Person(n, a) if a < 18 => println(s"Person name is: $n and I am a minor") //rearrangement
    case Person(n, a) => println(s"Person name is: $n and age is $a")
    //case Person(n,a) if a < 18 => println(s"Person name is: $n and I am a minor") //unreachable code
    case _ => println("I am ghost")
  }

  //variant 2
  alpha match {
    case Person(n, _) => println(s"Person name is: $n")
    case Person(_, a) if a < 18 => println(s"I am a minor, age: $a")
    case _ => println("I am ghost")
  }

  val myTuple = (1, (2, 3))
  //variant 3
  var result = myTuple match {
    case (_, (_, x)) => x
  }
  println(result)

  val list = List(1,2,3,4)
  //val list = List()

  val isEmpty = list match {
    case Nil => true
    case head :: List(_*) => head
  }

  println(isEmpty)
}
