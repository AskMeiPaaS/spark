package lectures.part1basic

object Expressions extends App {

  val x = 1 + 2 //Expression evaluated to a value and its has a type

  // Mathematical operators + - * / & ! ^ << >> >>> (right shift with zero extension)

  //Relational expression != == > >= < <= evaluates to Boolean

  //Logical operator ! && ||

  // Short operators += -= *= /= works only with vars side effects.

  //Instructions mean execution of something/ take action - Imperative Languages like Java

  // Expressions computes a value or type

  val aCondition = true
  val aConditionedValue = if(aCondition) "hello" else "bye" //IF is an Expression not an instruction
  //println(aConditionedValue)

  //Scala discourages use of loops. DO NOT DO IT :)
  var i = 0
  while (i < 10) {
    //println(i)
    i += 1
  }
  var aVariable = 1
  val aWeirdValue = (aVariable = 3) // unit === void | Side effects are the expressions which return unit
  //println(aWeirdValue)
  //example of side effects: println(), while, reassignment

  //A code block is an expression. A code block returns the last line
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if(z>2) "hello" else "bye"
    "this will be returned from the code block"
  }
  println(aCodeBlock)
}
