package sweet.LazyMap

import measureTime
import sweet.LazyMap.LazyMap
import sweet.LazyMap.lazyMapOf
import java.math.BigInteger

val fib: LazyMap<Int, Long> = lazyMapOf { a -> if (a < 2) 1L else ::fib.get()[a - 1] + ::fib.get()[a - 2] }

val fibBig: LazyMap<Int, BigInteger> = lazyMapOf { a -> if (a < 2) BigInteger.ONE else ::fibBig.get()[a - 1] + ::fibBig.get()[a - 2] }

infix fun Int.power(i: Int): Int = (1..i).reduce { i1, i2 -> i1 * this  }

fun main(args: Array<String>) {
//    val fib = generateSequence(Pair(1, 1)) { p -> Pair(p.second, p.first + p.second) }
//    fib.take(100).forEach { print("$it ") }

    measureTime { println((1..100).map { fib[it] }.joinToString(separator = " ")) }
    println((2..10).map { 10.power(it) }.joinToString())
    (2..10).forEach { z -> measureTime { (1..10.power(z)).forEach { i -> fibBig[i] } } }
}

