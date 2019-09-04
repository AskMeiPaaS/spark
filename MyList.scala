package excercises

abstract class MyList[+A] {

  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  //Polymorphic call - From abstract to concrete
  def printElements: String

  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A, B]): MyList[B]

  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]

  def filter(predicate: MyPredicate[A]): MyList[A]

  def ++ [B >: A] (list: MyList[B]): MyList[B]
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException

  def tail: MyList[Nothing] = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty

  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty

  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h

  def tail: MyList[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  def printElements: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }

  /*
  [1,2,3].filter(n%2 == 0) =
    [2,3].filter(n%2 == 0) =
     = new Cons(2, [3].filter(n%2 == 0))
     = new Cons(2, Empty.filter(n%2 == 0))
     = new Cons(2, Empty)
   */

  override def filter(predicate: MyPredicate[A]): MyList[A] =
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else  t.filter(predicate)

  /*
  [1,2,3].map(n * 2)
  = new Cons (1*2, [2,3].map(n*2))
  = new Cons (1*2, new Cons (2*2, [3].map(n*2)))
  = new Cons (1*2, new Cons(2*2, new Cons(3*2, Empty.map(n*2)))

   */
  override def map[B](transformer: MyTransformer[A, B]): MyList[B] =
    new Cons(transformer.transform(h), t.map(transformer) )

  /*
  [1,2].flatMap(n ==> [n, n+1])
  = new Cons(1, [2] ++ [3,4,5])
  = new Cons(1, new Cons (2, Empty ++ [3,4,5]))
  = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5)))))
 */

  override def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] =
    transformer.transform(h) ++ t.flatMap(transformer)

  /*
  [1,2] ++ [3,4,5]
  = new Cons(1, [2] ++ [3,4,5])
  = new Cons(1, new Cons(2, Empty ++ [3,4,5]))
  = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5))))
  =
   */
  override def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
}

trait MyPredicate[-T] {
  def test(ele: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
}

object ListTest extends App {
  //val list = new Cons(1, Empty)
  val listofIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val cloneListofIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherofIntegers: MyList[Int] = new Cons(4, new Cons(5, Empty))
  val listofStrings: MyList[String] = new Cons("One", new Cons("Two", new Cons("Three", Empty)))
  //println(list.tail.head)
  //println(list.add(4).head)
  //println(listofIntegers.toString)
  //println(listofStrings.toString)

  println(listofIntegers.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int): Int = elem * 2
  }).toString)

  println(listofIntegers.filter(new MyPredicate[Int] {
    override def test(ele: Int): Boolean = ele%2 == 0
  }).toString)

  println((listofIntegers ++ anotherofIntegers).toString)
  println(listofIntegers.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem + 1, Empty))
  }).toString)

  //The power of case classes, equals is built-in OOB
  println(listofIntegers == cloneListofIntegers)
}
