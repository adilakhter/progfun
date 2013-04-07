package learn.fp

//import example._
import example.Lists._

object Test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(101); 
  println("Writing Tests");$skip(25); val res$0 = 
  
  max(List(1,2,2,43));System.out.println("""res0: Int = """ + $show(res$0));$skip(24); val res$1 = 
  
  sum(List(1,2,2,3));System.out.println("""res1: Int = """ + $show(res$1));$skip(434); 
  
  //max(Nil)
  def pascal(c: Int, r: Int): Int = {
    def pascalAux (n:Int, k:Int):Int = (n,k) match {
      case (n,0)  => 1 // (n,0) = 1 for all integers n>=0
      case (n,1)  => n //
      case (n,k) if n <  k  => 0 // (n,0) = 1 for all integers n>=0
      case (n,k) if n == k  => 1
      case (n,k) if n >  k  => pascalAux(n-1,k) + pascalAux(n-1,k-1)
    }
    if (c < 0 || r < 0)
      0
    else
      pascalAux (r,c)
  };System.out.println("""pascal: (c: Int, r: Int)Int""");$skip(107); val res$2 = 
                                                  
  // Testing base case. expecting 1
  pascal(0,0) == 1;System.out.println("""res2: Boolean = """ + $show(res$2));$skip(21); val res$3 = 
  pascal(10,10) == 1;System.out.println("""res3: Boolean = """ + $show(res$3));$skip(21); val res$4 = 
  pascal(1,10) == 10;System.out.println("""res4: Boolean = """ + $show(res$4));$skip(21); val res$5 = 
  pascal(11,10) == 0;System.out.println("""res5: Boolean = """ + $show(res$5));$skip(43); val res$6 = 
 
  // given test cases
  pascal(0,2) == 1;System.out.println("""res6: Boolean = """ + $show(res$6));$skip(19); val res$7 = 
  pascal(1,3) == 3;System.out.println("""res7: Boolean = """ + $show(res$7));$skip(19); val res$8 = 
  pascal(1,2) == 2;System.out.println("""res8: Boolean = """ + $show(res$8));$skip(23); val res$9 = 
  
  pascal(2, 4) == 6;System.out.println("""res9: Boolean = """ + $show(res$9));$skip(25); val res$10 = 
 
  pascal(5,15) == 3003;System.out.println("""res10: Boolean = """ + $show(res$10));$skip(23); val res$11 = 
  pascal(0, 2000) == 1;System.out.println("""res11: Boolean = """ + $show(res$11));$skip(55); val res$12 = 
  // boundary and negative tests
  pascal(-1,202) == 0;System.out.println("""res12: Boolean = """ + $show(res$12));$skip(24); val res$13 = 
  pascal(-100,-100) ==0;System.out.println("""res13: Boolean = """ + $show(res$13))}
}
