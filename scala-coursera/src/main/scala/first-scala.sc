def countChange(money: Int, coins: List[Int]): Int = {

  def cIter(acc:Int,money: Int, coins: List[Int]): Int = {
    if (coins.isEmpty) {
      if (money != 0) acc
      else acc+1
    }
    else cIter(acc,money % coins.head, coins.tail)+cIter(acc,coins.head,)
  }

  if (money == 0 || coins.isEmpty) 0
  else
    cIter(0,money, coins.sorted.reverse)
}

countChange(5, List(1, 2))
List(56, 3, 1, 8, 33).sorted.reverse