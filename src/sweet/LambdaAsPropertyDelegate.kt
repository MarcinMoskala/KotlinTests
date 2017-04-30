package sweet

import kotlin.reflect.KProperty

private operator fun <R> (() -> R).getValue(thisRef: Any?, property: KProperty<*>): R = invoke()

private val a by { 1 }
private val b by { "KOKO" }
private val c by { 1 + 100 }

fun main(args: Array<String>) {
    println(a)
    println(b)
    println(c)
}