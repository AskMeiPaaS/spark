package com.askmeipaas.scalabasics

object Implicit extends App {

  //implicit declaration can be var, val, def or class
  //https://docs.scala-lang.org/tutorials/FAQ/finding-implicits.html
  //https://stackoverflow.com/questions/5598085/where-does-scala-look-for-implicits

  implicit val aString: String = "Hi"
  implicit val aInt: Int = 1
  //implicit val bString:  String = "Hi" //creates a conflict

  def sayHello(name: String)(implicit prefix: String) = s"$prefix, $name!"

  def sayHelloX(name: String)(implicit prefix: String, x: Int) = s"$prefix, $name, $x time(s)!" //prefix and x, both are implicit

  println(sayHello("Alpha")("Hello"))
  println(sayHello("Beta")) //implicit val aString will be used
  println(sayHelloX("Gamma")) //implicit val aString and x will be used

  //implicit function example and use case
  implicit def Int2String (num: Int): String = num.toString

  def randomNum: Int = scala.util.Random.nextInt()

  val randomNumStr: String = randomNum //use of Implicit function Int2String

  //implicit class helps extend the final classes (e.g. Java.lang.String)
  //"ABC" -> "BCD"
  implicit class StringUtil(s:String){
    def increment: String = s.map((c: Char) => (c+1).toChar)
  }

  println("ABC".increment)
}
