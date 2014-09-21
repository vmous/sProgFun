package week1

object newtonsqrt {
  println("Newton's approximation algorithm to compute the square root of a number!")
                                                  //> Newton's approximation algorithm to compute the square root of a number!

  1 + 3                                           //> res0: Int(4) = 4

  def abs(x: Double): Double = {
    if (x < 0) -x else x
  }                                               //> abs: (x: Double)Double

  def sqrt(x: Double): Double = {

    def sqrtIter(guess: Double): Double = {
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))
    }

    def isGoodEnough(guess: Double): Boolean = {
      /*
  	// We ask here for the absolute difference of the squared guess and x be
  	// smaller than the threshold value ε. That is not very good for very small
  	// numbers because the number we are seeking (the squered value) might be
  	// a lot smaller than ε. Moreover, for very large numbers we can end up
  	// with values that distances from one number to the next are so far appart
  	// that never converges to be smaller than the given threshold.
  	// Check the following examples
  	// sqrt(1e-6)
  	// sqrt(1e60)
  	abs(guess * guess - x) < 0.001
  	*/
      // We can solve both the above problems by making the test proportional to x.
      abs(guess * guess - x) / x < 0.001
    }

    def improve(guess: Double): Double = {
      (guess + x / guess) / 2
    }
    
    sqrtIter(1.0)
    
  }                                               //> sqrt: (x: Double)Double
  
  //sqrt(0)
  sqrt(2)                                         //> res1: Double = 1.4142156862745097
  sqrt(4)                                         //> res2: Double = 2.000609756097561
  sqrt(1e-6)                                      //> res3: Double = 0.0010000001533016628
  sqrt(1e60)                                      //> res4: Double = 1.0000788456669446E30
}