package lectures

object Generics extends App {

  class MyList[+A] { // you can put anything in place of A - Trait can also be parameterized
    //use the type A
    def add[B >: A] (element: B): MyList[B] = ???
    /*
    * A = Cat
    * B = Dog --> Animal i.e. B = Animal
     */
  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  //generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  //variance problem
  class Animal
  class Dog extends Animal
  class Cat extends Animal

  //COVARIANCE: List[Cat] extends List[Animal]
  class CovarianceList[+A]
  val animal:Animal = new Cat
  val animalList: CovarianceList[Animal] = new CovarianceList[Cat]
  // animalList.add(new Dog) - valid  - but it will pollute the object

  //INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal] //you can't out extended types

  //CONTRAVARIANCE
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Animal] = new ContravariantList[Animal] //poor choice

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

//Bounded Types
class Cage [A <: Animal] (animal :A)
  val cage = new Cage (new Dog)

  class Car
  //val newCage = new Cage (new Car) // ERROR

}

