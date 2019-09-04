package lectures

object AbstractDataTypes extends App {

  //Abstract class - can not be initiated could have an abstract method or method with its definition
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "K9"

    override def eat: Unit = println("crunch, crunch") // override word can be omitted
  }

  //Traits - could have abstract methods + implemented methods
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "Croc"
    def eat: Unit = println("monomomon")
    override def eat(animal: Animal): Unit = println(s"I am a Croc and I eat ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  //traits vs abstract class
  //1 - traits do not have constructor params
  //2 -multiple traits can be inherited
  //3 -traits are behviours but abstract class is a type of things. (subtle)

  //scala.Any <-- scala.AnyRef (like java.lang.Object) - String, List, Set, etc. <-- scala.Null <-- scala.Nothing
  //scala.Any <-- scala.AnyVal - Int, Unit, Float, etc. <-- scala.Nothing
}
