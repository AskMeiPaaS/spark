package com.askmeipaas.scalabasics

object Generics extends App {

  //Generics provides a compile time safety

  val arrInt: Array[Int] = Array(1, 2, 3, 4, 5)

  //val arrT: Array[T] = Array(1,2,3,4,5, "Say")

  trait Animal

  trait Person

  case class Dog() extends Animal

  case class Cat() extends Animal

  case class Alpha() extends Person

  val docA = new Doctor[Animal]
  docA.checkHealth(Dog())
  docA.checkHealth(Cat())

  val docP = new Doctor[Person]
  docP.checkHealth(Alpha())

  class Doctor[A] {
    //Method is inside the class
    def checkHealth(thing: A) = {
      //var x = this.toString()
      println(s"Health of $thing is good!")
    }

    def checkPulse[T, X](a: T): Any = {

    }
  }

  //Maps

  val myMap = Map[String, String]("UK" -> "United Kingdom", "USA" -> "United States of America")

  /*
  Variance Types
  1. Invariant A
  2. Covariant +A
  3. Contravariant -A
   */
  class InvariantList[A] {

  }

  // Standalone Function i.e. Outside a class with type
  def checkHeart(list: InvariantList[Animal]): Unit = {
    println("Check my heart..")
  }

  checkHeart(new InvariantList[Animal]())

  //checkHeart(new InvariantList[Dog]()) //Type Mismatch

  class CovariantList[+A] {

  }

  // Standalone Function i.e. Outside a class with type
  def checkVital(list: CovariantList[Animal]): Unit = {
    println("Check my heart..")
  }

  checkVital(new CovariantList[Animal]())
  checkVital(new CovariantList[Dog]())
  checkVital(new CovariantList[Cat]())

  //checkVital(new CovariantList[Person]()) //Type Mismatch

  class ContravariantList[-A] {

  }

  // Standalone Function i.e. Outside a class with type
  def checkVision(list: ContravariantList[Dog]): Unit = {
    println("Check my heart..")
  }

  checkVision(new ContravariantList[Animal]())
  checkVision(new ContravariantList[Dog]())
  //checkVision(new ContravariantList[Cat]()) //Type Mismatch

}
