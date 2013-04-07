package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CountChangeSuite extends FunSuite {
  import Main.countChange
  test("countChange: example given in instructions") {
    assert(countChange(4,List(1,2)) === 3)
  }

  test("countChange: example Tests: money= 4 and List(1,2,3): 4 ") {
    assert( countChange(4,List(1,2,3))  === 4)
  }
  
  test("countChange: example Tests: money= 10 and List(2,5,3,6) ") {
    assert(countChange(10, List(2,5,3,6)) == 5)
  }
  
  // given tests 
  test("countChange: sorted CHF") {
    assert(countChange(300,List(5,10,20,50,100,200,500)) === 1022)
  }

  test("countChange: no pennies") {
    assert(countChange(301,List(5,10,20,50,100,200,500)) === 0)
  }

  test("countChange: unsorted CHF") {
    assert(countChange(300,List(500,5,50,100,20,200,10)) === 1022)
  }
  
  test("countChange: complex test: project Euler problem: 73682") {
    assert(countChange(200,List(1,2,5,10,20,50,100,200)) === 73682)
  }
  
  // testing boundary conditions
  test("countChange: boundary condition: money <0: no solution") {
    assert(countChange(-200,List(1,2,5,10,20,50,100,200)) === 0)
  }
  
  test("countChange: boundary condition: money == 0: 1 solution") {
    assert(countChange(0,List(1,2,5,10,20,50,100,200)) === 1)
  }
  
  test("countChange: boundary condition:  money = 200 and Empty coins: no solution") {
    assert(countChange(200,List()) === 0)
  }
}
