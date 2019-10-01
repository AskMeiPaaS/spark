package com.askmeipaas.scalabasics

object Options extends App {

  // An option is a container for an optional value - avoids NullPointerExceptions
  val name: String = "Alpha"
  val noName: String = null
  val isName: Option[String] = Option(name) //apply
  val isNameX: Option[String] = Option(noName) //apply
  println(isName) //prints Some(Alpha)
  println(isNameX) //prints None

  //use case
  println(Option(name).map(n => n.length)) //prints Some(5)
  println(Option(noName).map(n => n.length)) //prints None

  //The null case in gender
  case class User(name:String, age: Int, gender: Option[String])

  //The get option
  if(isName.isDefined){
    println(isName.get) //prints Alpha
  }
  if(isNameX.isDefined){
    println(isNameX.get) //Non-reachable code
  }

  // The getOrElse
  println(isName.getOrElse("Gamma")) //prints Alpha i.e returns the value of isName
  println(isNameX.getOrElse("Beta")) //prints Beta

  //map.get is safe due to Option
  val countries = Map ("US" -> "United States", "UK" -> "United Kingdom")
  println(countries.get("IN")) //returns None

  //More to explore in map, flatMap, and filter
}
