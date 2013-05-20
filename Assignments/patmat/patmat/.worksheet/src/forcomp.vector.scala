package forcomp

object vector {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(84); 
  println("Welcome to the Scala Vector worksheet");$skip(35); 

  val nums = Vector(1.2, 3, -99);System.out.println("""nums  : scala.collection.immutable.Vector[Double] = """ + $show(nums ));$skip(65); 

  val people: Vector[String] = Vector("Bob", "James", "Peter");System.out.println("""people  : Vector[String] = """ + $show(people ));$skip(14); val res$0 = 

  0 +: nums;System.out.println("""res0: scala.collection.immutable.Vector[AnyVal] = """ + $show(res$0));$skip(200); 

  // Another simple kind of sequence is the range. It represents a sequence of evenly
  // spaced numbers.
  // Three operators:
  //  - `to`
  //  - `until`
  //  - `by`
  val r: Range = 1 until 5;System.out.println("""r  : Range = """ + $show(r ));$skip(27); 

  var r1: Range = 1 to 5;System.out.println("""r1  : Range = """ + $show(r1 ));$skip(17); val res$1 = 

  1 to 10 by 3;System.out.println("""res1: scala.collection.immutable.Range = """ + $show(res$1));$skip(17); val res$2 = 

  6 to 1 by -2;System.out.println("""res2: scala.collection.immutable.Range = """ + $show(res$2));$skip(72); 

  def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0);System.out.println("""isPrime: (n: Int)Boolean""");$skip(14); val res$3 = 
  isPrime(10);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(15); val res$4 = 

  isPrime(5);System.out.println("""res4: Boolean = """ + $show(res$4));$skip(47); 

  val fruit = Set("apple", "banana", "pear");System.out.println("""fruit  : scala.collection.immutable.Set[String] = """ + $show(fruit ));$skip(25); 
  val s = (1 to 6).toSet;System.out.println("""s  : scala.collection.immutable.Set[Int] = """ + $show(s ));$skip(18); val res$5 = 

  s map (_ + 2);System.out.println("""res5: scala.collection.immutable.Set[Int] = """ + $show(res$5));$skip(37); val res$6 = 
  fruit filter (_.startsWith("app"));System.out.println("""res6: scala.collection.immutable.Set[String] = """ + $show(res$6));$skip(13); val res$7 = 
  s.nonEmpty;System.out.println("""res7: Boolean = """ + $show(res$7));$skip(23); val res$8 = 

  s map (_ % 2 == 0);System.out.println("""res8: scala.collection.immutable.Set[Boolean] = """ + $show(res$8));$skip(17); val res$9 = 

  s contains 5;System.out.println("""res9: Boolean = """ + $show(res$9));$skip(132); 

  // pattern matching

  def gameResults(): Seq[(String, Int)] = ("Daniel", 3500) :: ("Melissa", 13000) :: ("John", 7000) :: Nil;System.out.println("""gameResults: ()Seq[(String, Int)]""");$skip(102); val res$10 = 

  for {
    result <- gameResults()
    (name, score) = result
    if (score > 5000)
  } yield name;System.out.println("""res10: Seq[String] = """ + $show(res$10));$skip(82); val res$11 = 

  for {
    (name, score) <- gameResults()
    if (score > 5000)
  } yield name;System.out.println("""res11: Seq[String] = """ + $show(res$11));$skip(71); 

  def lists = List(1, 2, 3, 4, 5) :: List.empty :: List(5, 5) :: Nil;System.out.println("""lists: => List[List[Int]]""");$skip(60); val res$12 = 

  for {
    list @ head :: _ <- lists
  } yield list.size;System.out.println("""res12: List[Int] = """ + $show(res$12));$skip(149); 

  val wordFrequencies = ("habitual", 6) :: ("and", 56) :: ("consuetudinary", 2) :: ("additionally", 27) :: ("homely", 5) :: ("society", 13) :: Nil;System.out.println("""wordFrequencies  : List[(String, Int)] = """ + $show(wordFrequencies ));$skip(143); 
  def wordsWithoutOutliers(wordFrequencies: Seq[(String, Int)]): Seq[String] = wordFrequencies.filter(wf => wf._2 > 3 && wf._2 < 25).map(_._1);System.out.println("""wordsWithoutOutliers: (wordFrequencies: Seq[(String, Int)])Seq[String]""");$skip(40); val res$13 = 
  wordsWithoutOutliers(wordFrequencies);System.out.println("""res13: Seq[String] = """ + $show(res$13));$skip(166); 

  def wordsWithoutOutliers_2(wordFrequencies: Seq[(String, Int)]): Seq[String] = wordFrequencies.filter { case (_, f) => f > 3 && f < 25 } map { case (w, _) => w };System.out.println("""wordsWithoutOutliers_2: (wordFrequencies: Seq[(String, Int)])Seq[String]""");$skip(42); val res$14 = 
  wordsWithoutOutliers_2(wordFrequencies);System.out.println("""res14: Seq[String] = """ + $show(res$14));$skip(130); 
                                                  
  val predicate: (String, Int) => Boolean = { case (_, f) => f > 3 && f < 25 };System.out.println("""predicate  : (String, Int) => Boolean = """ + $show(predicate ));$skip(66); 
  val transformFn: (String, Int) => String = { case (w, _) => w };System.out.println("""transformFn  : (String, Int) => String = """ + $show(transformFn ));$skip(41); 
  
  val headElem = wordFrequencies.head;System.out.println("""headElem  : (String, Int) = """ + $show(headElem ));$skip(43); val res$15 = 
  
  transformFn(headElem._1, headElem._2);System.out.println("""res15: String = """ + $show(res$15))}
  
  

}
