package lectures

/*
Throwable classes extend the Throwable class
Exception: Something went wrong with program
Error: Something went wrong with the program doing System Interaction
 */

object Exceptions extends App {

  val x: String = null
  //println(x.length) - throws NullPointerException

  //1. throwing exceptions
  //val weirdValue: String = throw new NullPointerException

  //2. catch exception
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException ("No int for you!")
    else 42

  val potentialFail = try {
    //code that might throw error
    getInt(false)
  } catch {
    case e: RuntimeException => 43
  } finally {
    //code that will get executed NO MATTER WHAT
    //optional
    // does not influence the return type
    //use finally only for side effects
    println("finally")
  }

  println(potentialFail)

  //3. how to define your own Exception
  class MyException extends Exception
  val exception = new MyException
  //throw exception - Custom exception


}
