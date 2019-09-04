package lectures

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  //Anonymous class (abstract or concrete)
  //Anonymous classes work for traits
  val animal = new Animal {
    override def eat: Unit = println("chowchow")
  }

  //Compiler generated class
  /*class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = println("chowchow")
  }
  val animal: Animal = new AnonymousClasses$$anon$1
  */

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }

  //pass in required constructor arguments if needed
  //implement all abstract fields/methods
  val jim = new Person("Jim") {
    override def sayHi: Unit = println("Hi, my name is Jim, how can I be of service?")
  }



}
