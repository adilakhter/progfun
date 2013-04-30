package forcomp

object vector {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(83); 
  println("Welcome to the Scala Vector worksheet");$skip(34); 
  
  val nums = Vector(1.2,3,-99);System.out.println("""nums  : scala.collection.immutable.Vector[Double] = """ + $show(nums ));$skip(66); 
  
  val people: Vector[String] = Vector("Bob", "James", "Peter");System.out.println("""people  : Vector[String] = """ + $show(people ));$skip(15); val res$0 = 
  
  0 +: nums;System.out.println("""res0: scala.collection.immutable.Vector[AnyVal] = """ + $show(res$0));$skip(201); 
  
  // Another simple kind of sequence is the range. It represents a sequence of evenly
  // spaced numbers.
  // Three operators:
  //  - `to`
  //  - `until`
  //  - `by`
  val r: Range = 1 until 5;System.out.println("""r  : Range = """ + $show(r ));$skip(28); 
  
  var r1: Range = 1 to 5;System.out.println("""r1  : Range = """ + $show(r1 ));$skip(18); val res$1 = 
  
  1 to 10 by 3;System.out.println("""res1: scala.collection.immutable.Range = """ + $show(res$1));$skip(18); val res$2 = 
  
  6 to 1 by -2;System.out.println("""res2: scala.collection.immutable.Range = """ + $show(res$2));$skip(71); 
  
  def isPrime(n:Int): Boolean = (2 until n) forall (d => n%d != 0);System.out.println("""isPrime: (n: Int)Boolean""");$skip(14); val res$3 = 
  isPrime(10);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(16); val res$4 = 
  
  isPrime(5);System.out.println("""res4: Boolean = """ + $show(res$4))}
  
}
