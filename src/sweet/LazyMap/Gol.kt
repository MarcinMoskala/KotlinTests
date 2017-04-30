package sweet.LazyMap

import sweet.times

val r = java.util.Random()

val gol: LazyMap3<Int, Int, Int, Boolean> = lazyMapOf { x, y, t ->
    if (t <= 0) r.nextBoolean()
    else willLive(countPrevLiving(x, y, t), ::gol.get()[x, y, t - 1])
}

private fun countPrevLiving(x: Int, y: Int, t: Int) =
        ((-1..1) * (-1..1) - (0 to 0)).count { d -> ::gol.get()[x + d.first, y + d.second, t - 1] }

private fun willLive(prevLiving: Int, isLiving: Boolean): Boolean = (isLiving && prevLiving in listOf(3, 4)) || (!isLiving && prevLiving == 3)

private fun golGame() {
    (1..10).forEach { sweet.LazyMap.printState(it) }
}

private fun printState(t: Int) {
    val size = 0..10
    size.forEach { i ->
        println(size.joinToString(separator = "", transform = { j -> if(sweet.LazyMap.gol[i, j, t]) "1" else "0" }))
    }
    println(size.joinToString(separator = "", transform = { "-" }))
}

fun main(args: Array<String>) {
    sweet.LazyMap.golGame()
}