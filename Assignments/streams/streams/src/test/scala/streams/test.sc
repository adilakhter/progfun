package streams

import streams._

object test {
  println("Vector")                               //> Vector

  val vect = Vector(Vector('S', 'T'), Vector('o', 'o'), Vector('o', '-'))
                                                  //> vect  : scala.collection.immutable.Vector[scala.collection.immutable.Vector[
                                                  //| Char]] = Vector(Vector(S, T), Vector(o, o), Vector(o, -))

  vect.toStream.map(_.indexOf('T')).zipWithIndex.collectFirst { case (y, x) => (x, y) }
                                                  //> res0: Option[(Int, Int)] = Some((0,1))

  val i = 2                                       //> i  : Int = 2
  val j = 1                                       //> j  : Int = 1

  lazy val vectStream = vect.toStream.map(_.length).zipWithIndex
                                                  //> vectStream: => scala.collection.immutable.Stream[(Int, Int)]

  val s = vectStream.filter { case (y, x) => (x == i) && (j < y) && (vect(i)(j) != '-') }
                                                  //> s  : scala.collection.immutable.Stream[(Int, Int)] = Stream()
  if (s.isEmpty)
    false
  else
    true                                          //> res1: Boolean = false

  vect.length                                     //> res2: Int = 3

  vect(0).length                                  //> res3: Int = 2

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
  }                                               //> terrainFunction1: (levelVector: Vector[Vector[Char]])(Int, Int) => Boolean

  val fn = terrainFunction1(vect)                 //> fn  : (Int, Int) => Boolean = <function2>

  fn(0, 1)                                        //> res4: Boolean = false

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
  }

  TestSolution.test1                              //> res5: Boolean = true
  TestSolution.test2                              //> res6: Boolean = true
  TestSolution.test3                              //> res7: Boolean = true
  TestSolution.test4                              //> res8: Boolean = false
  TestSolution.test5                              //> res9: Boolean = true

  TestSolution.goal                               //> res10: streams.test.TestSolution.Pos = Pos(0,1)
  TestSolution.startPos                           //> res11: streams.test.TestSolution.Pos = Pos(0,0)
  TestSolution.terrain                            //> res12: streams.test.TestSolution.Pos => Boolean = <function1>

  trait SolutionChecker2 extends GameDef with Solver with StringParserTerrain {
    val level =
      """ooo-------
      |oSoooo----
      |ooooooooo-
      |-ooooooooo
      |-----ooToo
      |------ooo-""".stripMargin
  }

  object TestSolution2 extends SolutionChecker2 {}

  TestSolution2.startPos                          //> res13: streams.test.TestSolution2.Pos = Pos(1,1)
  TestSolution2.goal                              //> res14: streams.test.TestSolution2.Pos = Pos(4,7)

  TestSolution2.vector                            //> res15: Vector[Vector[Char]] = Vector(Vector(o, o, o, -, -, -, -, -, -, -), 
                                                  //| Vector(o, S, o, o, o, o, -, -, -, -), Vector(o, o, o, o, o, o, o, o, o, -),
                                                  //|  Vector(-, o, o, o, o, o, o, o, o, o), Vector(-, -, -, -, -, o, o, T, o, o)
                                                  //| , Vector(-, -, -, -, -, -, o, o, o, -))

  
  TestSolution2.vector.toStream.map(_.indexOf('S')).zipWithIndex.filter{case (y,x) => y > -1}
                                                  //> res16: scala.collection.immutable.Stream[(Int, Int)] = Stream((1,1), ?)



  val s1 = Stream(1,3,4)                          //> s1  : scala.collection.immutable.Stream[Int] = Stream(1, ?)
  
  val s2 = Stream(4,5,7)                          //> s2  : scala.collection.immutable.Stream[Int] = Stream(4, ?)
  
  val s3  = s1 ++ s2                              //> s3  : scala.collection.immutable.Stream[Int] = Stream(1, ?)
  
  s3.toList                                       //> res17: List[Int] = List(1, 3, 4, 4, 5, 7)
   
  
}