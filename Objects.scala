package lectures

object Objects { //check for main method below

  //SCALA does NOT have a class level functionality - static
  //Type and the only instance of Person - Singleton - by definition
  object Person {
    val N_EYES = 2

    def canFly: Boolean = false

    //Factory method
    //def child(mother: Person, father: Person): Person = new Person("Bobby")
    //Better way
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  //Class definition + Object Definition = Companions
  /*class Person {
    //class level method
    def saysHi(name: String) = s"Hi, $name!"
  }*/

  class Person(name: String) {
    //class level method
    def saysHi(name: String) = s"Hi, $name!"
  }

  //println(Person.N_EYES)
  //println(Person.canFly)

  /*val mary = Person //instance
  //println(mary.N_EYES)
  val john = Person
  println(mary == john) //same object - only instance - singleton

  //Class level
  val dan = new Person("Dan")
  println(dan.saysHi("there"))
  //println(dan saysHi "there") //infix notation
  val romy = new Person("Romy")

  //val bobby = Person.child(romy, dan)
  //better way
  val bobby = Person(romy, dan) //calling apply method*/

  //SCALA apps - scala object + main(args: Array[String]) : Unit
  def main(args: Array[String]): Unit = {
    val mary = Person //instance
  //println(mary.N_EYES)
  val john = Person
  println(mary == john) //same object - only instance - singleton

  //Class level
  val dan = new Person("Dan")
  println(dan.saysHi("there"))
  //println(dan saysHi "there") //infix notation
  val romy = new Person("Romy")

  //val bobby = Person.child(romy, dan)
  //better way
  val bobby = Person(romy, dan) //calling apply method
  }

}
