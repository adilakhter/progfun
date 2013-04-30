package forcomp

object vector {
  println("Welcome to the Scala Vector worksheet")//> Welcome to the Scala Vector worksheet
  
  val nums = Vector(1.2,3,-99)                    //> nums  : scala.collection.immutable.Vector[Double] = Vector(1.2, 3.0, -99.0)
                                                  //| 
  
  val people: Vector[String] = Vector("Bob", "James", "Peter")
                                                  //> people  : Vector[String] = Vector(Bob, James, Peter)
  
  0 +: nums                                       //> res0: scala.collection.immutable.Vector[AnyVal] = Vector(0, 1.2, 3.0, -99.0)
                                                  //| 
  
  // Another simple kind of sequence is the range. It represents a sequence of evenly
  // spaced numbers.
  // Three operators:
  //  - `to`
  //  - `until`
  //  - `by`
  val r: Range = 1 until 5                        //> r  : Range = Range(1, 2, 3, 4)
  
  var r1: Range = 1 to 5                          //> r1  : Range = Range(1, 2, 3, 4, 5)
  
  1 to 10 by 3                                    //> res1: scala.collection.immutable.Range = Range(1, 4, 7, 10)
  
  6 to 1 by -2                                    //> res2: scala.collection.immutable.Range = Range(6, 4, 2)
  
  def isPrime(n:Int): Boolean = (2 until n) forall (d => n%d != 0)
                                                  //> isPrime: (n: Int)Boolean
  isPrime(10)                                     //> res3: Boolean = false
  
  isPrime(5)                                      //> res4: Boolean = true
  
}