package lectures

import scala.languageFeature.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favouriteMovie: String, var age: Int = 0) {
    def likes(movie: String): Boolean = movie == favouriteMovie

    def handOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(nickname: String): Person = new Person(s"${this.name} ${nickname}", favouriteMovie)

    def unary_! : String = s"$name, what the heck!"

    def unary_+ : Person = new Person(name, favouriteMovie, age + 1)

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"
  }

  var mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))

  //equivalent | Syntactic Sugar
  // infix notation | operator notation | works with a method with one param
  println(mary likes "Inception")

  var tom = new Person("Tom", "Fight Club")

  println(mary handOutWith tom)

  //ALL OPERATORS are METHODS
  println(1.+(2))

  //Prefix Notation | Syntactic Sugar | Unary operators are also methods | works for - + ~ !
  println(1.unary_-)
  println(!mary) // see implementation in the class above

  //Postfix notation - only possible with method with no params

  //println(mary isAlive)

  println(mary.apply())
  //trick
  println(mary()) //calling apply method

  println((+mary).age) //calling  unary_+ method
}
