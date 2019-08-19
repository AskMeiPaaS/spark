package lectures.part1basic

object CBNvsCBV extends App {

  //Time nanosecond returns Long. value is evaluated before calling the function definition.
  def calledByValue(x: Long): Unit = {
    println("By value: " + x)
    println("By value: " + x)
  }

  //=> call by name syntax, lazy evaluation, expression is passed not the value
  def calledByName(x: => Long): Unit = {
    println("By name: " + x)
    println("By name: " + x)
  }

  //calledByValue(5081495850191L) is passed.
  calledByValue(System.nanoTime())

  //System.nanoTime() will be evaluated every time inside the function
  calledByName(System.nanoTime())

  //Infinite loop
  def infinite(): Int = 1 + infinite()

  //print first parameter
  def printFirst(x: Int, y: => Int) = println(x)

  //Lazy evaluation in case of pass by name
  printFirst(34, infinite())

}
