package com.askmeipaas.scalabasics

object MapFlatMap extends App {

  //map function - converts X to y

  val list = List(1, 2, 3, 4, 5, 6, 7)
  //println(list.map(x => x.toString + "-o"))

  //comprehension - same as above
  println(for {
    x <- list
  } yield x.toString + "-c")

  //filter - get even numbers
  println(list.filter(n=> n%2==0))

  class User(
  val name: String
  ,
  val age: Int
  )
  val u1 = new User(name = "Alpha", age = 30)
  val u2 = new User(name = "Beta", age = 35)
  val u3 = new User(name = "Gamma", age = 40)

  val userList = List(u1, u2, u3)
  //for ((k) <- userList) printf("Name: %s, Age: %d\n", k.name, k.age)
  //extracting data from an object with multiple variables
  //println(userList.map(u => u.name))

  //filter
  //println(userList.filter(_.age>= 35).map(_.name))

  //comprehension
  println( for {
    u <- userList if u.age >= 35
  } yield u.name

  )

  //FlatMap - Nested Maps
  val nestedList = List(List(u1, u2),List(u3, u2, u1))
 // println(nestedList.map(list => list.map(u => u.name)))
  //flatMap = map + flatten
  //println(nestedList.map(list => list.map(u => u.name).flatten)) //check flatten
  //println(nestedList.map(list => list.flatMap(u => u.name))) //check flatMap

  //cross product map
  val numbers = List(1,2)
  val chars = List('a','b','c')
  val langs = List("Java", "Scala","Go")
  //println(numbers.flatMap(n => chars.flatMap(c => langs.map(l => (n,c,l))))) //tuple

  //comprehension is handy in complex flattening
  println( for {
    n <- numbers
    c <- chars
    l <- langs
  } yield (n,c,l))



}
