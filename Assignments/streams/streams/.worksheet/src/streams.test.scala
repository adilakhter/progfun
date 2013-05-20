package streams

import streams._

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(70); 
  println("Vector");$skip(76); 

  val vect = Vector(Vector('S', 'T'), Vector('o', 'o'), Vector('o', '-'));System.out.println("""vect  : scala.collection.immutable.Vector[scala.collection.immutable.Vector[Char]] = """ + $show(vect ));$skip(90); val res$0 = 

  vect.toStream.map(_.indexOf('T')).zipWithIndex.collectFirst { case (y, x) => (x, y) };System.out.println("""res0: Option[(Int, Int)] = """ + $show(res$0));$skip(14); 

  val i = 2;System.out.println("""i  : Int = """ + $show(i ));$skip(12); 
  val j = 1;System.out.println("""j  : Int = """ + $show(j ));$skip(67); 

  lazy val vectStream = vect.toStream.map(_.length).zipWithIndex;System.out.println("""vectStream: => scala.collection.immutable.Stream[(Int, Int)]""");$skip(92); 

  val s = vectStream.filter { case (y, x) => (x == i) && (j < y) && (vect(i)(j) != '-') };System.out.println("""s  : scala.collection.immutable.Stream[(Int, Int)] = """ + $show(s ));$skip(43); val res$1 = 
  if (s.isEmpty)
    false
  else
    true;System.out.println("""res1: Boolean = """ + $show(res$1));$skip(16); val res$2 = 

  vect.length;System.out.println("""res2: Int = """ + $show(res$2));$skip(19); val res$3 = 

  vect(0).length;System.out.println("""res3: Int = """ + $show(res$3));$skip(331); 

  def terrainFunction1(levelVector: Vector[Vector[Char]]): (Int, Int) => Boolean = {
    (x, y) =>
      {
        lazy val xLength = levelVector.length
        if (x < xLength) {
          if (y < levelVector(x).length) {
            if (levelVector(x)(y) == '-') true else false
          }
        }
        false
      }
  };System.out.println("""terrainFunction1: (levelVector: Vector[Vector[Char]])(Int, Int) => Boolean""");$skip(36); 

  val fn = terrainFunction1(vect);System.out.println("""fn  : (Int, Int) => Boolean = """ + $show(fn ));$skip(13); val res$4 = 

  fn(0, 1)

  trait SolutionChecker extends GameDef with Solver with StringParserTerrain {
    val level =
      """ST
      |oo
      |oo""".stripMargin
  }

  object TestSolution extends SolutionChecker {
    val test1 = terrain(Pos(0, 0))
    val test2 = terrain(Pos(2, 1))
    val test3 = terrain(Pos(2, 0))
    val test4 = terrain(Pos(3, 0))
    val test5 = terrain(Pos(0, 0))
  };System.out.println("""res4: Boolean = """ + $show(res$4));$skip(400); val res$5 = 

  TestSolution.test1;System.out.println("""res5: Boolean = """ + $show(res$5));$skip(21); val res$6 = 
  TestSolution.test2;System.out.println("""res6: Boolean = """ + $show(res$6));$skip(21); val res$7 = 
  TestSolution.test3;System.out.println("""res7: Boolean = """ + $show(res$7));$skip(21); val res$8 = 
  TestSolution.test4;System.out.println("""res8: Boolean = """ + $show(res$8));$skip(21); val res$9 = 
  TestSolution.test5;System.out.println("""res9: Boolean = """ + $show(res$9));$skip(22); val res$10 = 

  TestSolution.goal;System.out.println("""res10: streams.test.TestSolution.Pos = """ + $show(res$10));$skip(24); val res$11 = 
  TestSolution.startPos;System.out.println("""res11: streams.test.TestSolution.Pos = """ + $show(res$11));$skip(23); val res$12 = 
  TestSolution.terrain

  trait SolutionChecker2 extends GameDef with Solver with StringParserTerrain {
    val level =
      """ooo-------
      |oSoooo----
      |ooooooooo-
      |-ooooooooo
      |-----ooToo
      |------ooo-""".stripMargin
  }

  object TestSolution2 extends SolutionChecker2 {};System.out.println("""res12: streams.test.TestSolution.Pos => Boolean = """ + $show(res$12));$skip(307); val res$13 = 

  TestSolution2.startPos;System.out.println("""res13: streams.test.TestSolution2.Pos = """ + $show(res$13));$skip(21); val res$14 = 
  TestSolution2.goal;System.out.println("""res14: streams.test.TestSolution2.Pos = """ + $show(res$14));$skip(25); val res$15 = 

  TestSolution2.vector;System.out.println("""res15: Vector[Vector[Char]] = """ + $show(res$15));$skip(100); val res$16 = 

  
  TestSolution2.vector.toStream.map(_.indexOf('S')).zipWithIndex.filter{case (y,x) => y > -1};System.out.println("""res16: scala.collection.immutable.Stream[(Int, Int)] = """ + $show(res$16));$skip(28); 



  val s1 = Stream(1,3,4);System.out.println("""s1  : scala.collection.immutable.Stream[Int] = """ + $show(s1 ));$skip(29); 
  
  val s2 = Stream(4,5,7);System.out.println("""s2  : scala.collection.immutable.Stream[Int] = """ + $show(s2 ));$skip(24); 
  
  val s3  = s1 ++ s2;System.out.println("""s3  : scala.collection.immutable.Stream[Int] = """ + $show(s3 ));$skip(15); val res$17 = 
  
  s3.toList;System.out.println("""res17: List[Int] = """ + $show(res$17))}
   
  
}
