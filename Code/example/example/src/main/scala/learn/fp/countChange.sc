package learn.fp

object countChange {
  println("Test countChange")                     //> Test countChange
  
  
  def hasMoreCoins(coins:List[Int]):Boolean = coins.isEmpty
                                                  //> hasMoreCoins: (coins: List[Int])Boolean
  
  def countChange(money: Int, coins: List[Int]): Int =  money match {
    case 0 => 1 // only one solution exists if money = 0 => do not include any coins
    case _ if money<0 => 0 // no solution exits if money is less than 0
    case _ if money>0 =>
      coins match{
        case Nil => 0 // money > 0 and has more coints => no solution exists
        case x::xs => countChange(money-x, coins) + countChange(money, xs)
       }
  }                                               //> countChange: (money: Int, coins: List[Int])Int
  
  //r: 73682
  countChange(200,List(1,2,5,10,20,50,100,200))   //> res0: Int = 73682
  
  //r: 4
  countChange(4,List(1,2,3))                      //> res1: Int = 4
 
  //  r:Int = 5
  countChange(10, List(2,5,3,6))                  //> res2: Int = 5
 
  // boundary case, money = 0
  // r: Int = 1 => there is only one way to achieve solution. Do not include anything
  countChange(0, List(2,5,3,6))                   //> res3: Int = 1
  
   // boundary case, money < 0
  // r: Int = 0 => there is no solution
  countChange(-1, List(2,5,3,6))                  //> res4: Int = 0

}