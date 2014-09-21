package week1

object gcd {
  println("Euclid's algorithm to compute the greatest common divisor of two numbers!")
                                                  //> Euclid's algorithm to compute the greatest common divisor of two numbers!
 
  def gcd(a: Int, b: Int): Int ={
  	if (b == 0) a
  	else gcd(b, a % b)
  }                                               //> gcd: (a: Int, b: Int)Int
  
  /*
   * The rewritting sequence oscillates around the call to gcd. We always come
   * to the point that the value of gcd is evaluated. If a function, like this
   * calls itself as its last action, the function's stack frame can be reused.
   * Such processing is called **tail recursion**.
   * Modern compilers can apply that trick in order to excecute tail recursive
   * functions in constact stack frame space so it ends up to be another
   * reformulation of an iterative process.
   *
   * In general, if the last action of a function consists of calling a
   * function (which may be itself or even some other one), one stack
   * frame would be sufficient for both functions. Such calls are called
   * **tail calls**.
   *
   * Rewriting example:
   * gcd(14, 21)
   * -> if (21 == 0) 14 else gcd(21, 14 % 21)
   * -> if (false) 14 else gcd(21, 14 % 21)
   * -> gcd(21, 14 % 21)
   * -> gcd(21, 14)
   * -> if (14 == 0) 21 else gcd(14, 21 % 14)
   * -> gcd(14, 7)
   * -> gcd(7, 0)
   * -> if (0 == 0) 7 else gcd(0, 7 % 0)
   * -> 7
   */
  gcd(14, 21)                                     //> res0: Int = 7
}