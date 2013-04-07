package learn.fp

object countChange {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(68); 
  println("Test countChange");$skip(66); 
  
  
  def hasMoreCoins(coins:List[Int]):Boolean = coins.isEmpty;System.out.println("""hasMoreCoins: (coins: List[Int])Boolean""");$skip(439); 
  
  def countChange(money: Int, coins: List[Int]): Int =  money match {
    case 0 => 1 // only one solution exists if money = 0 => do not include any coins
    case _ if money<0 => 0 // no solution exits if money is less than 0
    case _ if money>0 =>
      coins match{
        case Nil => 0 // money > 0 and has more coints => no solution exists
        case x::xs => countChange(money-x, coins) + countChange(money, xs)
       }
  };System.out.println("""countChange: (money: Int, coins: List[Int])Int""");$skip(64); val res$0 = 
  
  //r: 73682
  countChange(200,List(1,2,5,10,20,50,100,200));System.out.println("""res0: Int = """ + $show(res$0));$skip(41); val res$1 = 
  
  //r: 4
  countChange(4,List(1,2,3));System.out.println("""res1: Int = """ + $show(res$1));$skip(51); val res$2 = 
 
  //  r:Int = 5
  countChange(10, List(2,5,3,6));System.out.println("""res2: Int = """ + $show(res$2));$skip(150); val res$3 = 
 
  // boundary case, money = 0
  // r: Int = 1 => there is only one way to achieve solution. Do not include anything
  countChange(0, List(2,5,3,6));System.out.println("""res3: Int = """ + $show(res$3));$skip(107); val res$4 = 
  
   // boundary case, money < 0
  // r: Int = 0 => there is no solution
  countChange(-1, List(2,5,3,6));System.out.println("""res4: Int = """ + $show(res$4))}

}
