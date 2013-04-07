package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * The method computes and returns a number stored in a particular position
   * in pascal's triangle. The position is specified by its column and row
   * number counting from 0. 
   * 
   * @param c An integer that represents column counting from 0
   * @param r An integer that represents row counting from 0
   * @return Number at the spot in the pascal's triangle
   */
  def pascal(c: Int, r: Int): Int = {
    /**
     * This recursive method uses memoization technique to compute 
     * the number at `(n,k)` in pascal's triangle.
     * 
     * @param n An integer that represents row number.
     * @param k An integer that represents column number
     * @return An integer at the particular position.
     */
    def pascalAux(n: Int, k: Int): Int = (n, k) match {
      case (n, k) if n < k || n <0 || k<0 => 0
      case (n,k) if k==0 || n==k => 1
      //case (n, 1) => n 
      case (n, k) if n > k => pascalAux(n - 1, k) + pascalAux(n - 1, k - 1)
    }
    
    pascalAux(r, c)
  } 

  /**
   * This method verifies whether a given string has balanced parentheses. That is, it checks
   * whether every opening parenthesis has a closing counterpart. Note that, the string is
   * provided as a `List[String]`. This method uses an internal stack that verifies every
   * opening parenthesis, which is retrieved upon encountering a closing parenthesis
   * (i.e., `)`). Thus, at the end of the provided string, if the stack is empty then
   * this method returns `true`; otherwise, `false`.
   *
   * @param chars A list of characters to check
   * @return Boolean value referring to whether chars is balanced or not.
   */
  def balance(chars: List[Char]): Boolean = {
    /**
     * This recursive method iterates over a given list of characters to verify whether 
     * it contains balanced parentheses. As noted previously, to verify that it uses an
     * additional data structure-- stack.     
     * 
     * @param chars A list of characters
     * @param stack A list that acts as stack and stores opening parentheses encountered
     * @return Boolean value `true` if the given string is balanced; otherwise, `false`
     */
    def balanceAux(chars: List[Char], stack: List[Char]): Boolean = chars match {
      case Nil => stack.isEmpty
      case x :: xs => x match {
        case '(' =>
          balanceAux(xs, x::stack)
        case ')' =>
          if (stack.isEmpty)
            false
          else
            balanceAux(xs, stack.tail)
        case _ => balanceAux(xs, stack)
      }
    }

    balanceAux(chars, List())
  }

  /**
   * This method returns the number of way money can be exchanged
   * by using a given list of coins. Both money and the value of
   * coin are represented using `Int`.
   *
   * @param money Money to exchange
   * @param coins Number of available coins
   * @return An integer representing the number of ways money can exchanged
   * using the given coins
   */
  def countChange(money: Int, coins: List[Int]): Int = money match {
    case 0 => 1  //only one solution exists if `money = 0` , which is do not include any coins
    case _ if money < 0 => 0 // no solution exits if `money < 0`
    case _ if money > 0 =>
      coins match {
        case Nil => 0 // `money > 0` and has more coins, then no solution exists
        case x :: xs => countChange(money - x, coins) + countChange(money, xs)
      }
  } 
}
