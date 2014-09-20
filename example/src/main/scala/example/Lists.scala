package example

import common._

import scala.annotation.tailrec

object Lists extends App {
  /**
   * This method computes the sum of all elements in the list xs. There are
   * multiple techniques that can be used for implementing this method, and
   * you will learn during the class.
   *
   * For this example assignment you can use the following methods in class
   * `List`:
   *
   *  - `xs.isEmpty: Boolean` returns `true` if the list `xs` is empty
   *  - `xs.head: Int` returns the head element of the list `xs`. If the list
   *    is empty an exception is thrown
   *  - `xs.tail: List[Int]` returns the tail of the list `xs`, i.e. the the
   *    list `xs` without its `head` element
   *
   *  ''Hint:'' instead of writing a `for` or `while` loop, think of a recursive
   *  solution.
   *
   * @param xs A list of natural numbers
   * @return The sum of all elements in `xs`
   */
  def sum(xs: List[Int]): Int = {
    // The "standard" recursive approach. Can yield a
    // "java.lang.StackOverflowError" with large lists
    xs match {
       // if there is an element, add it to the sum of the tail
      case x :: tail => x + sum(tail)
      // else this sum is 0
      case Nil => 0
    }
    
    /*
    // Tail-recursive implementation. It will be more efficient that the
    // non-tail-recursive function because the compiler turns it into a while loop
    // that doesn't require pushing a new frame on the stack for every recursive
    // call.
    @tailrec
    def inner(xs: List[Int], accum: Int): Int = {
      xs match {
        case x :: tail => inner(tail, accum +x)
        case Nil => accum
      }
    }
    inner(xs, 0)
    */
  }

  /**
   * This method returns the largest element in a list of integers. If the
   * list `xs` is empty it throws a `java.util.NoSuchElementException`.
   *
   * You can use the same methods of the class `List` as mentioned above.
   *
   * ''Hint:'' Again, think of a recursive solution instead of using looping
   * constructs. You might need to define an auxiliary method.
   *
   * @param xs A list of natural numbers
   * @return The largest element in `xs`
   * @throws java.util.NoSuchElementException if `xs` is an empty list
   */
  def max(xs: List[Int]): Int = {
    if (xs.isEmpty) throw new java.util.NoSuchElementException
    
    // Using "match"
    @tailrec
    def maxAccum(xs: List[Int], theMax: Int): Int = {
      xs match {
        case Nil => theMax
        case x :: tail =>
          val newMax = if (x > theMax) x else theMax
          maxAccum(tail, newMax)
      }
    }
    maxAccum(xs, 0)
    
    /*
    // Using if/else
    @tailrec
    def maxAccum(xs: List[Int], theMax: Int): Int = {
      if (xs.isEmpty) {
        return theMax
      } else {
        val newMax = if (xs.head > theMax) xs.head else theMax
        maxAccum(xs.tail, newMax)
      }
    }
    maxAccum(xs, 0)
    */
  }
}
