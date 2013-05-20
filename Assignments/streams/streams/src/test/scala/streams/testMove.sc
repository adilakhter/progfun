package streams

object testMove {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  trait SolutionChecker2 extends GameDef with Solver with StringParserTerrain {
    val level =
      """ooo-------
      |oSoooo----
      |ooooooooo-
      |-ooooooooo
      |-----ooToo
      |------ooo-""".stripMargin
  }

  val t1= new SolutionChecker2{
    
    def testLegalNeighbours: Unit = {
      println(pathsToGoal.toList)
    }
  }                                               //> t1  : streams.testMove.SolutionChecker2{def testLegalNeighbours: Unit} = str
                                                  //| eams.testMove$$anonfun$main$1$$anon$1@6513cf0
  
  
  
  t1.testLegalNeighbours                          //> List((Block(Pos(4,7),Pos(4,7)),List(Down, Right, Right, Right, Down, Right, 
                                                  //| Right)), (Block(Pos(4,7),Pos(4,7)),List(Right, Down, Down, Right, Right, Dow
                                                  //| n, Right)), (Block(Pos(4,7),Pos(4,7)),List(Right, Down, Right, Right, Down, 
                                                  //| Down, Right)))
 
}