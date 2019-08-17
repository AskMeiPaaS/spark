package lectures

import scala.annotation.tailrec

object Recursion extends App {

  //factorial with call stack - leads to StackoverflowError if value is large
  def factorial(n: Int): Int = {
    if (n <= 1) {
      println("Returned factorial(1)")
      1
    }
    else {
      println("PUSH : Need factorial(" + (n - 1) + ")")
      var fact = n * factorial(n - 1)
      println("POP : factorial(" + n + ")")
      fact
    }
  }

  //println(factorial(4))

  // factorial with tail recursion - Uses a single block in the stack
  def anotherFactorial(n: Int): Int = {
    @tailrec //if the function is not tail recursive then compiler issues an error
    def factorialHelper(x: Int, accumulator: Int): Int =
      if (x <= 1) {
        println("Returned accumulator: " + accumulator)
        accumulator
      }
      else {
        println("Same block -- Calculating : " + "factorialHelper(" + (x - 1) + "," + x * accumulator + ")")
        factorialHelper(x - 1, x * accumulator) //TAIL RECURSION = use recursive call as the LAST expression
      }

    var fact = factorialHelper(n, 1)
    println("Calculated anotherFactorial(" + n + ")")
    fact
  }

  //print(anotherFactorial(6))

  //Exercise 1: Concatenate string n times
  @tailrec
  def concatStringnTimes(aString: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else concatStringnTimes(aString, n - 1, aString + accumulator)
  }

  //println(concatStringnTimes("Hello", 3, ""))

  //Exercise 2: isPrime?
  def isPrime(n: Int): Boolean = {
    @tailrec
    def primeHelper(x: Int, isStillPrime: Boolean): Boolean = {
      println("Current status: x: " + x + ", isStillPrime: " + isStillPrime)
      if (!isStillPrime) false
      else if (x <= 1) true
      else primeHelper(x - 1, (n % x) != 0 && isStillPrime)
    }

    primeHelper(n / 2, true)
  }

  //println(isPrime(36))

  //Fibonnacci
  def fibonnacci (n: Int): Int = {
    @tailrec
    def fiboHelper(i:Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
    else fiboHelper(i+1, last+ nextToLast, last)

    if (n <= 2) 1
    else fiboHelper(2,1,1)
  }

  println(fibonnacci(8))
}
