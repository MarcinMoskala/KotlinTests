package sweet

import sweet.LazyMap.LazyMap3
import sweet.LazyMap.lazyMapOf
import sweet.LazyMap.r
import java.util.*

typealias GameState = (x: Int, y: Int) -> Boolean

fun gol(generation: Int, initial: GameState): GameState = when {
    generation <= 0 -> initial
    else -> { x, y ->
        val prevState = gol(generation - 1, initial)
        val prevLivingAround = countPrevLiving(x, y, prevState)
        willLive(prevLivingAround, prevState(x, y))
    }
}

private fun countPrevLiving(x: Int, y: Int, gameState: GameState) =
        ((-1..1) * (-1..1) - (0 to 0)).count { d -> gameState(x + d.first, y + d.second) }

private fun willLive(prevLiving: Int, isLiving: Boolean): Boolean =
        (isLiving && prevLiving in listOf(3, 4)) || (!isLiving && prevLiving == 3)

private fun printState(state: GameState) {
    val size = 0..10
    size.forEach { i ->
        println(size.joinToString(separator = "", transform = { j -> if (state(i, j)) "1" else "0" }))
    }
    println(size.joinToString(separator = "", transform = { "-" }))
}

fun main(args: Array<String>) {
    val r = Random()
    val initialArray = (0..10).map { (0..10).map { r.nextBoolean() } }
    val initial: GameState = { x, y -> initialArray.getOrNull(x)?.getOrNull(y) ?: false}
    (0..10).forEach { printState(gol(it, initial)) }
}