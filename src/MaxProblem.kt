import java.util.*

val r = Random()
val list = (1..1000000).map { r.nextDouble() * 100000 }

fun max10p1(l: List<Double>) = l.filter { it > l.max()!! * 0.9 }

fun max10p2(l: List<Double>): List<Double> {
    val max = l.max()!!
    return l.filter { it > max * 0.9 }
}

fun main(args: Array<String>) {
    list
    measureTime { max10p1(list) }.let(::println)
    measureTime { max10p2(list) }.let(::println)
}