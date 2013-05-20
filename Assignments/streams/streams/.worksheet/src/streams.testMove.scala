package streams

object testMove {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(78); 
  println("Welcome to the Scala worksheet")

  trait SolutionChecker2 extends GameDef with Solver with StringParserTerrain {
    val level =
      """ooo-------
      |oSoooo----
      |ooooooooo-
      |-ooooooooo
      |-----ooToo
      |------ooo-""".stripMargin
  };$skip(346); 

  val t1= new SolutionChecker2{
    
    def testLegalNeighbours: Unit = {
      println(pathsToGoal.toList)
    }
  };System.out.println("""t1  : streams.testMove.SolutionChecker2{def testLegalNeighbours: Unit} = """ + $show(t1 ));$skip(34); 
  
  
  
  t1.testLegalNeighbours}
 
}
