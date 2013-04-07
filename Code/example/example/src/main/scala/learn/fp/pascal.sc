package learn.fp

//import example._
import example.Lists._

object Test {
  println("Writing Tests")                        //> Writing Tests
  
  max(List(1,2,2,43))                             //> res0: Int = 43
  
  sum(List(1,2,2,3))                              //> res1: Int = 8
  
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
  }                                               //> pascal: (c: Int, r: Int)Int
                                                  
  // Testing base case. expecting 1
  pascal(0,0) == 1                                //> res2: Boolean = true
  pascal(10,10) == 1                              //> res3: Boolean = true
  pascal(1,10) == 10                              //> res4: Boolean = true
  pascal(11,10) == 0                              //> res5: Boolean = true
 
  // given test cases
  pascal(0,2) == 1                                //> res6: Boolean = true
  pascal(1,3) == 3                                //> res7: Boolean = true
  pascal(1,2) == 2                                //> res8: Boolean = true
  
  pascal(2, 4) == 6                               //> res9: Boolean = true
 
  pascal(5,15) == 3003                            //> res10: Boolean = true
  pascal(0, 2000) == 1                            //> res11: Boolean = true
  // boundary and negative tests
  pascal(-1,202) == 0                             //> res12: Boolean = true
  pascal(-100,-100) ==0                           //> res13: Boolean = true
}