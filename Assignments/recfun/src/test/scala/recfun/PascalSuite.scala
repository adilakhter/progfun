package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PascalSuite extends FunSuite {
  import Main.pascal
  
  test("pascal: col=0,row=2") {
    assert(pascal(0,2) === 1)
  }

  test("pascal: col=1,row=2") {
    assert(pascal(1,2) === 2)
  }

  test("pascal: col=1,row=3") {
    assert(pascal(1,3) === 3)
  }

  // input validation
  test("pascal: row=-1  col=202: input validation: 0") {
    assert(pascal(202,-1) === 0)
  }
  
  test("pascal: row=-100  col=-100: input validation: 0") {
    assert(pascal(-100,-100) === 0)
  }
  
  test("pascal: row=90  col=-100: input validation: 0") {
    assert(pascal(-100,90) === 0)
  }
  
  test("pascal: row=10  col=11: input validation: 0") {
    assert(pascal(11,10) === 0)
  }
  
  // boundary condition checks 
  test("pascal: row=0  col=0: boundary condition: 1") {
    assert(pascal(0,0) === 1)
  }
  
  test("pascal: row=2000  col=0: boundary condition: 1") {
    assert(pascal(0,2000) === 1)
  }
  
  test("pascal: row=10  col=1: boundary condition: 10") {
    assert(pascal(1,10) === 10)
  }
  
  test("pascal: row=10  col=10: boundary condition: 10") {
    assert(pascal(10,10) === 1)
  }
  
  // other tests
  test("pascal: row=15  col=5: boundary condition: 3003") {
    assert(pascal(5,15) === 3003)
  }
  
  test("pascal: row=4  col=2: boundary condition: 6") {
    assert(pascal(2, 4) === 6)
  }
}
