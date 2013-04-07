package learn.fp

object balanced {
  println("Test balance")                         //> Test balance
  
  
  def appendChar(s:Char, stack:List[Char]): List[Char] = s::stack
                                                  //> appendChar: (s: Char, stack: List[Char])List[Char]
  
  def tail(stack:List[Char]): List[Char] = stack match{
    case Nil => Nil
    case x::xs => xs
  }                                               //> tail: (stack: List[Char])List[Char]
  
  def isEmpty(stack:List[Char]) = stack.isEmpty   //> isEmpty: (stack: List[Char])Boolean
  
  
  def balance(chars: List[Char]): Boolean = {
    def balanceAux(chars: List[Char], stack:List[Char]): Boolean = chars match {
      case Nil => isEmpty(stack)
      case x::xs => x match {
        case '(' =>
          balanceAux(xs, appendChar(x, stack))
        case ')' =>
          if (isEmpty(stack))
            false
          else
            balanceAux(xs, tail(stack))
        case _   => balanceAux(xs, stack)
      }
    }
    balanceAux(chars, List())
  }                                               //> balance: (chars: List[Char])Boolean
  
  
  balance("(a)".toList) == true                   //> res0: Boolean = true
  
  balance("abc".toList) == true                   //> res1: Boolean = true

  balance("".toList) == true                      //> res2: Boolean = true
    
  balance("(())".toList) == true                  //> res3: Boolean = true
  
  balance("()()".toList) == true                  //> res4: Boolean = true
  
  balance("(((())))".toList) == true              //> res5: Boolean = true
  
  balance(" a ( bc ( def ( ghij ( klmno ) pqrs ) tuv ) wx ) y (and z)".toList) == true
                                                  //> res6: Boolean = true
  // negative tests
  balance(")(".toList) == false                   //> res7: Boolean = true
  
  balance("())".toList) == false                  //> res8: Boolean = true
  
  balance(")())((".toList) == false               //> res9: Boolean = true
  
  balance("(".toList) == false                    //> res10: Boolean = true

  balance(")".toList) == false                    //> res11: Boolean = true
  
  balance("())(".toList) == false                 //> res12: Boolean = true

  balance(":-)".toList) == false                  //> res13: Boolean = true

}