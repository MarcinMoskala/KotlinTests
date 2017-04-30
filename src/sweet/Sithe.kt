package sweet

import measureTime

var primes = Iterable<Long> {
    object : Iterator<Long> {
        var numbers = generateSequence(2L, { it + 1 })

        override fun hasNext() = true

        override fun next(): Long {
            val p = numbers.first()
            numbers = numbers.drop(1).filter { it % p != 0L }
            return p
        }
    }
}

fun main(args: Array<String>) {
    primes.take(100).let(::println)
    (2..10).map { z -> z * 100 }.forEach { i -> measureTime { primes.take(i).let(::println) } }
}