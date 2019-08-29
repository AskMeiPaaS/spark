package lectures

object OOBasics extends App {

  val author = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)
  //println(novel.authorAge)

  val counter = new Counter // No need to supply parameter, default value count = 0 will be applied.
  counter.inc.inc.inc(5).inc.print

  class Writer(firstName: String, surname: String, val year: Int) {
    def fullName: String = firstName + " " + surname
  }

  class Novel(name: String, year: Int, author: Writer) {
    def authorAge = year - author.year

    def isWrittenBy: Boolean = author == this.author

    def copy(newYear: Int): Novel = new Novel(name, newYear, author)
  }

  class Counter(val count: Int = 0) { //default value set to 0
    def inc = {
      println("incrementing")
      new Counter(count + 1) //immutability
    }

    def dec = {
      println("decrementing")
      new Counter(count - 1)
    }

    def inc(n: Int): Counter = {
      if (n <= 0) this
      else inc.inc(n - 1)
    }

    def dec(n: Int): Counter = {
      if (n <= 0) this
      else dec.dec(n - 1) //inc returns a counter object and inc(n-1) is called on that
    }

    def print = println(count)
  }

}
