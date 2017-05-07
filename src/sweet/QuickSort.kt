package sweet

import measureTime
import java.util.*

fun <T : Comparable<T>> List<T>.quickSort(): List<T> = when {
    size < 2 -> this
    else -> {
        val pivot = first()
        val (smaller, greater) = drop(1).partition { it <= pivot }
        smaller.quickSort() + pivot + greater.quickSort()
    }
}

fun main(args: Array<String>) {
    listOf(10, 100, 1000, 10000, 100000, 1000000)
            .asSequence()
            .map { (1..it).map { (1..100).map { Random().nextInt(1000000000) } } }
            .forEach { a ->
                measureTime { a.forEach { it.sorted() } }
                measureTime { a.forEach { it.quickSort() } }
            }
}