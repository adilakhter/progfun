package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BalanceSuite extends FunSuite {
  import Main.balance
  
  test("empty string-- balanced") {
    assert(balance("".toList) == true)
  }

  test("balance: if statement is balanced '(if (zero? x) max (/ 1 x))' ") {
    assert(balance("(if (zero? x) max (/ 1 x))".toList) == true)
  }

  test("balance: 'I told him ...'-- balanced") {
    assert(balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList) == true)
  }
    
  test("balance: empty one level parentheses-- balanced") {
    assert(balance("(a)".toList) == true)
  }
  
  test("balance: no parenthesis-- balanced") {
    assert(balance("abc".toList) == true)
  }

  test("balance: two level balanced parentheses-- balanced") {
    assert(balance("(())".toList) == true)
  }
  
  test("balance: three level balanced parentheses-- balanced") {
    assert(balance("(a((b)#)!)".toList) == true)
  }
  
  test("balance: counting-- balanced") {
    assert(balance("(((())))".toList) == true)
  }
  
  test("balance: multiple set of parentheses-- balanced") {
    assert(balance("()()".toList) == true)
  }
  
  test("balance: ':-)'-- unbalanced") {
    assert(balance(":-)".toList) == false)
  }
  
  test("balance: too many closing parentheses-- unbalanced") {
    assert(balance("())".toList) == false)
  }
  
  test("balance: wrong order-- unbalanced") {
    assert(balance(")(".toList) == false)
  }
  
  test("balance: counting is not enough 2-- unbalanced") {
    assert(balance(")())((".toList) == false)
  }

  test("balance: counting is not enough-- unbalanced") {
    assert(balance("())(".toList) == false)
  }
  
  test("balance: only closing parenthese-- unbalanced") {
    assert(balance(")".toList) == false)
  }
  
  test("balance: only opening parenthese-- unbalanced") {
    assert(balance("(".toList) == false)
  }
}
