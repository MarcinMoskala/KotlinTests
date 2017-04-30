val doubleFun: (Int)->Int = { it * 2 }

val tripleFun: (Int)->Int = { it * 3 }

fun quadroFun(): (Int)->Int = doubleFun flow doubleFun

fun sessoFun(): (Int)->Int = tripleFun flow doubleFun

operator fun <T, R, L> ((T)->R).plus(sec: (R)->L): (T) -> L = { sec(invoke(it)) }

infix fun <T, R, L> ((T)->R).flow(sec: (R)->L): (T) -> L = { sec(invoke(it)) }

fun main(args: Array<String>) {
    println(doubleFun(1))
    println(tripleFun(1))
    println(quadroFun()(1))
    println(sessoFun()(1))
}