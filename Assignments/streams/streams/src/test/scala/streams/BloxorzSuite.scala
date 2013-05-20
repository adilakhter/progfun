package streams

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import Bloxorz._

@RunWith(classOf[JUnitRunner])
class BloxorzSuite extends FunSuite {

  trait SolutionChecker extends GameDef with Solver with StringParserTerrain {
    /**
     * This method applies a list of moves `ls` to the block at position
     * `startPos`. This can be used to verify if a certain list of moves
     * is a valid solution, i.e. leads to the goal.
     */
    def solve(ls: List[Move]): Block =
      ls.foldLeft(startBlock) {
        case (block, move) => move match {
          case Left => block.left
          case Right => block.right
          case Up => block.up
          case Down => block.down
        }
      }
  }

  trait Level1 extends SolutionChecker {
    /* terrain for level 1*/

    val level =
      """ooo-------
      |oSoooo----
      |ooooooooo-
      |-ooooooooo
      |-----ooToo
      |------ooo-""".stripMargin

    val optsolution = List(Right, Right, Down, Right, Right, Right, Down)
  }

  test("terrain function level 1") {
    new Level1 {
      assert(terrain(Pos(0, 0)), "0,0")
      assert(!terrain(Pos(4, 11)), "4,11")
    }
  }

  test("findChar level 1") {
    new Level1 {
      assert(startPos == Pos(1, 1))
    }
  }

  test("test isLegal") {
    new Level1 {

      val pLegal0 = Block(Pos(1, -1), Pos(1, 0))
      assert(pLegal0.isLegal === false)

      val pLegal1 = Block(Pos(0, 0), Pos(0, 0))
      assert(pLegal1.isLegal === true)

      val pos1 = Block(Pos(1, 2), Pos(1, 3))
      assert(pos1.isLegal === true)

      val pos2 = Block(Pos(1, 5), Pos(1, 6))
      assert(pos2.isLegal === false)

      val pos3 = Block(Pos(6, 6), Pos(6, 7))
      assert(pos3.isLegal === false)

      val pos4 = Block(Pos(2, 0), Pos(3, 0))
      assert(pos4.isLegal === false)

    }
  }

  test("test startBlock") {
    new Level1 {
      assert(startBlock === Block(Pos(1, 1), Pos(1, 1)))
    }
  }

  test("startBlock neighbours") {
    new Level1 {
      val expectedBlocks = List(Block(Pos(1, -1), Pos(1, 0)), Block(Pos(1, 2), Pos(1, 3)), Block(Pos(-1, 1), Pos(0, 1)), Block(Pos(2, 1), Pos(3, 1)))
      val expectedMoves = List(Left, Right, Up, Down)

      val expected = expectedBlocks zip expectedMoves

      val actual = startBlock.neighbors

      assert(expected === actual)
    }

  }

  test("neighbours isStanding") {
    new Level1 {
      val p = Pos(2, 8)
      val pu = Pos(1, 8)
      val puu = Pos(0, 8)
      val pd = Pos(3, 8)
      val pdd = Pos(4, 8)
      val pl = Pos(2, 7)
      val pll = Pos(2, 6)
      val pr = Pos(2, 9)
      val prr = Pos(2, 10)
      val b = Block(p, p)
      val n = List((Block(pll, pl), Left), (Block(pr, prr), Right), (Block(puu, pu), Up), (Block(pd, pdd), Down))
      assert(b.neighbors.toSet === n.toSet)
    }
  }

  test("neighbours !isStanding") {
    new Level1 {
      val pa = Pos(2, 8)
      val pb = Pos(3, 8)
      val pau = Pos(1, 8)
      val pbu = Pos(1, 8)
      val pad = Pos(4, 8)
      val pbd = Pos(4, 8)
      val pal = Pos(2, 7)
      val pbl = Pos(3, 7)
      val par = Pos(2, 9)
      val pbr = Pos(3, 9)
      val b = Block(pa, pb)
      val n = List((Block(pal, pbl), Left), (Block(par, pbr), Right), (Block(pau, pbu), Up), (Block(pad, pbd), Down))
      assert(b.neighbors.toSet === n.toSet)
    }
  }

  test("legallegalNeighbors | startBlock/isStanding ") {
    new Level1 {
      val expected = List(
        (Block(Pos(1, 2), Pos(1, 3)), Right),
        (Block(Pos(2, 1), Pos(3, 1)), Down))

      val actual = startBlock.legalNeighbors

      assert(expected === actual)
    }
  }

  test("legalneighbors | Block(Pos(2,7), Pos(2,8)) ") {
    new Level1 {
      val expected = List(
        (Block(Pos(2, 6), Pos(2, 6)), Left),
        (Block(Pos(3, 7), Pos(3, 8)), Down))

      assert(expected === Block(Pos(2, 7), Pos(2, 8)).legalNeighbors)
    }

  }

  test("legalneighbors | Block(Pos(3,9), Pos(4,9))") {
    new Level1 {
      val expected = List((Block(Pos(3, 8), Pos(4, 8)), Left))

      assert(expected === Block(Pos(3, 9), Pos(4, 9)).legalNeighbors)
    }

  }

  test("legalNeighbours isStanding") {
    new Level1 {
      val p = Pos(2, 8)
      val pu = Pos(1, 8)
      val puu = Pos(0, 8)
      val pd = Pos(3, 8)
      val pdd = Pos(4, 8)
      val pl = Pos(2, 7)
      val pll = Pos(2, 6)
      val pr = Pos(2, 9)
      val prr = Pos(2, 10)
      val b = Block(p, p)

      val n = List(
        (Block(pll, pl), Left),
        (Block(pd, pdd), Down))

      assert(b.legalNeighbors.toSet === n.toSet)
    }
  }
  test("legalNeighbours !isStanding") {
    new Level1 {
      val pa = Pos(2, 8)
      val pb = Pos(3, 8)
      val pau = Pos(1, 8)
      val pbu = Pos(1, 8)
      val pad = Pos(4, 8)
      val pbd = Pos(4, 8)
      val pal = Pos(2, 7)
      val pbl = Pos(3, 7)
      val par = Pos(2, 9)
      val pbr = Pos(3, 9)
      val b = Block(pa, pb)

      val n = List(
        (Block(pal, pbl), Left),
        (Block(pad, pbd), Down))

      assert(b.legalNeighbors.toSet === n.toSet)
    }
  }

  test("neightbors with History |B: 1.2 1.3 | Left") {
    new Level1 {
      val b = Block(Pos(1, 2), Pos(1, 3))
      val m = List(Right)

      val expected = List(
        (Block(Pos(1, 1), Pos(1, 1)), List(Left, Right)),
        (Block(Pos(1, 4), Pos(1, 4)), List(Right, Right)),
        (Block(Pos(2, 2), Pos(2, 3)), List(Down, Right)))

      val actual = (neighborsWithHistory(b, m) toList)

      assert(expected === actual)

    }

  }
  test("neightbors with History |B: 1.1 1.1 | Left Up") {
    new Level1 {
      val b = Block(Pos(1, 1), Pos(1, 1))
      val m = List(Left, Up)

      val expected = Set(
        (Block(Pos(1, 2), Pos(1, 3)), List(Right, Left, Up)),
        (Block(Pos(2, 1), Pos(3, 1)), List(Down, Left, Up)))
      val actual = (neighborsWithHistory(b, m) toSet)

      assert(expected === actual)

    }

  }
  test("new neightbors only| default test") {
    new Level1 {
      val expected = newNeighborsOnly(
        Set(
          (Block(Pos(1, 2), Pos(1, 3)), List(Right, Left, Up)),
          (Block(Pos(2, 1), Pos(3, 1)), List(Down, Left, Up))).toStream,
          
        Set(Block(Pos(1, 2), Pos(1, 3)), Block(Pos(1, 1), Pos(1, 1))))

      val actual = Set(
        (Block(Pos(2, 1), Pos(3, 1)), List(Down, Left, Up))).toStream

      assert(expected === actual)

    }

  }

  test("optimal solution for level 1") {
    new Level1 {
      assert(solve(solution) == Block(goal, goal))
    }
  }

  test("optimal solution length for level 1") {
    new Level1 {
      assert(solution.length == optsolution.length)
    }
  }

}
