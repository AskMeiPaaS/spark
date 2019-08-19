package lectures.part1basic

object DefaultArgs extends App {

  //Does accumulator pollute the function definition? Notice the default value of accumulator = 1
  //Pass in every leading argument
  //name the argument i.e accumulator = 2, could change the order if you pass named argument
  def trailRecFactorial(n: Int, accumulator: Int = 1): Int =
    if (n <= 1) accumulator
    else trailRecFactorial(n - 1, n * accumulator)
}
