package lectures

import lectures.Inheritance.Animal

object Inheritance extends App {

  class Animal {
    def eat = println("momomommmm")
    def creatureType = "Animal"
  }

  //Single class inheritance - only public def is inherited
  //public, protected, and <default> modifiers
  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch")
    }
  }

  var cat = new Cat
  //cat.crunch

  //Constructors
  class Person(name: String, age: Int)

  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  //Overiding
  class Dog (override val creatureType: String) extends Animal {
    override def eat: Unit = {
      //super.eat
      println("crunch, crunch")
    }
  }

  var dog = new Dog("K9")
  //dog.eat

  //Type Substitution - in broader sense  - polymorphism
  val unknownAnimal: Animal  = new Dog("K9")
  unknownAnimal.eat //derived implementation is called. line 31

  //Preventing overrides - final keyword and sealing (sealed) a class (accessed only in the class)

}