package lectures.part1basic

object Functions extends App {

  //A function
  def aFunction(a: String, b: Int) : String = //A single Expression
    a + " " + b

  //A block is an expression
  def bFunction(a: String, b: Int) : String = {
    a + " " + b
  }

  //A function does not need a return type, compiler figures it out
  def cFunction(a: String, b: Int) = {
    a + " " + b
  }

  //A function can return "unit"
  def dFunctionWithSideEffects(a: String, b: Int): Unit = println(a)

  //A parameterless function could be called without the function parenthesis
  def aParameterlessFunction(): Int = 42
  //println(aParameterlessFunction)

  //A recursive function - when you need loops | DO NOT remove return type in recursive function
  def aRepetitiveFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepetitiveFunction(aString, n-1)
  }
  //println(aRepetitiveFunction("Hello", 2))

  //A nested function
  def aBigFunction(n: Int) : Int = {
    def aSmallFunction(a: Int, b: Int): Int = a + b
    aSmallFunction(n, n-1)
  }

  //A greeting function
  def aGreetings(name: String, age: Int): String = {
    "Hi, my name is " + name + " and I am " + age + " years old."
  }
  //println(aGreetings("Hello", 2))

  //Factorial function
  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else n * factorial(n-1)
  }
  //println(factorial(5))

  def fibonacci(n: Int): Int =
    if (n <= 2) 1
    else fibonacci(n-1) + fibonacci(n-2)
  //println(fibonacci(7))

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)
    isPrimeUntil(n/2)
  }
  println(isPrime(37))
}

