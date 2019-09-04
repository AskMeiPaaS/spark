package lectures

/*
Quick lightweight data structures with little boilerplate
Companions - apply method
equals, hashCode, toString
Aut-promoted params to fields
serializable cloning
 */
object CaseClasses extends App {
/*
equals, hashCode, toString - regular applied methods to classes
 */

  case class Person(name: String, age: Int)

  //1. class parameters are fields
  val jim = new Person("Jim", 34)
  //println(jim.name)

  //2. sensible toString
  // println instance is converted to instance.toString()
  //println(jim.toString)

  //3. equals and hashCode are implemented OOB
  val jim2 = new Person("Jim", 34)
  println(jim == jim2) //true. If "case" was not in the class definition, then it gives false.

  //4. Case classes have handy copy method
  val jim3 = jim.copy(age=45)
  println(jim3.name + " <-- Name | Age --> " + jim3.age)

  // 5. Case classes have companion objects - we don not use new to initiate a class
  val thePerson = Person
  val mary = Person("Mary",32)

  //6. CCs are serializable - Akka

  //7. CCs have extractor patterns = CCs can be used in PATTERN MATCHING
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }
}
