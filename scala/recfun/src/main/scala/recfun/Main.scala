package recfun

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
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int =
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def bIter(c: Int, chars: List[Char]): Boolean = {
      if (chars.isEmpty) c == 0
      else if (c < 0) false
      else if (chars.head == '(') bIter(c + 1, chars.tail)
      else if (chars.head == ')') bIter(c - 1, chars.tail)
      else bIter(c, chars.tail)
    }
    bIter(0, chars)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int =
    if (coins.isEmpty) {
      if (money != 0) 0
      else 1
    }
    else countChange(money % coins.head, coins.tail)
}
