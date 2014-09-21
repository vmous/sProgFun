package week1

object factorial {
  println("Classic and tail-recursive algorithms to compute the factorial!")
                                                  //> Classic and tail-recursive algorithms to compute the factorial!
  def factorial(n: Int): Int = {
  	if (n == 0) 1
  	else n * factorial(n - 1)
  }                                               //> factorial: (n: Int)Int
  
  def factorialTailRec(n: Int): Int = {
  	def loop(acc: Int, n: Int): Int = {
  		if (n == 0) acc
  		else loop(acc * n, n - 1)
  	}
  	
  	loop(1, n)
  }                                               //> factorialTailRec: (n: Int)Int
  
  /*
   * The rewritting sequence shows that this is not a tail recursive process
   * (check gcd instead). At each step, after evaluating factorial(n - 1)
   * we then need to multiply with n, meaning that the recursive function does
   * not call itself as its last step. The reduction steps bellow show
   * a build-up of intermediate results that need to be available in the last
   * step in order to be reduced to the final computed value of the factorial.
   *
   * Rewriting example:
   * factorial(4)
   * -> if (4 == 0) 1 else 4 * factorial(4 - 1)
   * ->> 4 * factorial(3)
   * ->> 4 * (3 * factorial(2))
   * ->> 4 * (3 * (2 * factorial(1)))
   * ->> 4 * (3 * (2 * (1 * factorial (0))))
   * ->> 4 * (3 * (2 * (1 * 1)))
   * ->> 24
  */
  factorial(4)                                    //> res0: Int = 24

  factorialTailRec(4)                             //> res1: Int = 24
}