package lectures.part1basic

object TypeInference extends App {

  val message: String = "Hello, World!";
  val aMessage = "Hello, World!" //Type inference

  // The compiler infers the return type from the implementation
  def succ(x: Int) = x + 1

  //Compiler does a type check
  //val x: Int = "Hello, World"

  //Compiler may not able to identify the return type
//  def factorial(n: Int) = {
//    if (n <= 0) 1
//    else n * factorial(n-1)
//  }
  //println(factorial(5))
}
