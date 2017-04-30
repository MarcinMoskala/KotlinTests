package woow

fun main(args: Array<String>) {
    val even = (1..10).filter { it % 2 == 0 }
    println(even)

    val evenDoubled = (1..10)
            .filter { it % 2 == 0 }
            .map { it * 2 }
    println(evenDoubled)

    fun toFuzzBuzz(num: Int) = when {
        num % 15 == 0 -> "fuzzbuzz"
        num % 3 == 0 -> "fuzz"
        num % 5 == 0 -> "buzz"
        else -> "$num"
    }

    val fuzzBuzz = (1..100).map { toFuzzBuzz(it) }.joinToString(separator = " ")
    println(fuzzBuzz)
}