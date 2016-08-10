def abs(x: Double) = if (x < 0) -x else x
def sqrt(x: Double) = {
  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

  def isGoodEnough(guess: Double, x: Double) = abs(x - guess * guess) < 0.00001 * x

  def improve(guess: Double, x: Double) = (guess + x / guess) / 2

  sqrtIter(1, x)
}

sqrt(5)
sqrt(0.0001)
sqrt(10e100)

def fact(x: Long): Long =
  if (x == 1) 1
  else x * fact(x - 1)

fact(13)

def fact2(x: Long): Long = {
  def ggg(n: Long, s :Long): Long =
    if (n == 1) s
    else ggg(n-1, s*n)

  ggg(x, 1)
}
fact2(13)

