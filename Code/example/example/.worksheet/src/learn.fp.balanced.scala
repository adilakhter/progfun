package learn.fp

object balanced {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(61); 
  println("Test balance");$skip(72); 
  
  
  def appendChar(s:Char, stack:List[Char]): List[Char] = s::stack;System.out.println("""appendChar: (s: Char, stack: List[Char])List[Char]""");$skip(104); 
  
  def tail(stack:List[Char]): List[Char] = stack match{
    case Nil => Nil
    case x::xs => xs
  };System.out.println("""tail: (stack: List[Char])List[Char]""");$skip(51); 
  
  def isEmpty(stack:List[Char]) = stack.isEmpty;System.out.println("""isEmpty: (stack: List[Char])Boolean""");$skip(476); 
  
  
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
  };System.out.println("""balance: (chars: List[Char])Boolean""");$skip(38); val res$0 = 
  
  
  balance("(a)".toList) == true;System.out.println("""res0: Boolean = """ + $show(res$0));$skip(35); val res$1 = 
  
  balance("abc".toList) == true;System.out.println("""res1: Boolean = """ + $show(res$1));$skip(30); val res$2 = 

  balance("".toList) == true;System.out.println("""res2: Boolean = """ + $show(res$2));$skip(38); val res$3 = 
    
  balance("(())".toList) == true;System.out.println("""res3: Boolean = """ + $show(res$3));$skip(36); val res$4 = 
  
  balance("()()".toList) == true;System.out.println("""res4: Boolean = """ + $show(res$4));$skip(40); val res$5 = 
  
  balance("(((())))".toList) == true;System.out.println("""res5: Boolean = """ + $show(res$5));$skip(90); val res$6 = 
  
  balance(" a ( bc ( def ( ghij ( klmno ) pqrs ) tuv ) wx ) y (and z)".toList) == true;System.out.println("""res6: Boolean = """ + $show(res$6));$skip(52); val res$7 = 
  // negative tests
  balance(")(".toList) == false;System.out.println("""res7: Boolean = """ + $show(res$7));$skip(37); val res$8 = 
  
  balance("())".toList) == false;System.out.println("""res8: Boolean = """ + $show(res$8));$skip(40); val res$9 = 
  
  balance(")())((".toList) == false;System.out.println("""res9: Boolean = """ + $show(res$9));$skip(34); val res$10 = 
  
  balance("(".toList) == false;System.out.println("""res10: Boolean = """ + $show(res$10));$skip(32); val res$11 = 

  balance(")".toList) == false;System.out.println("""res11: Boolean = """ + $show(res$11));$skip(37); val res$12 = 
  
  balance("())(".toList) == false;System.out.println("""res12: Boolean = """ + $show(res$12));$skip(34); val res$13 = 

  balance(":-)".toList) == false;System.out.println("""res13: Boolean = """ + $show(res$13))}

}
