package sweet.LazyMap

import java.util.*

class LazyMap<T, L>(val calculator: (T) -> L) {
    var map: Map<T, L> = mapOf()

    operator fun get(i: T): L =
            if (i in map) map[i]!!
            else calculator(i).apply { map += i to this }
}

class LazyMap2<T1, T2, L>(val calculator: (T1, T2) -> L) {
    var map: Map<Pair<T1, T2>, L> = mapOf()

    operator fun get(i: T1, j: T2): L =
            if ((i to j) in map) map[i to j]!!
            else calculator(i, j).apply { map += (i to j) to this }
}

class LazyMap3<T1, T2, T3, L>(val calculator: (T1, T2, T3) -> L) {
    var map: Map<Triple<T1, T2, T3>, L> = mapOf()

    operator fun get(i: T1, j: T2, k: T3): L =
            if (Triple(i, j, k) in map) map[Triple(i, j, k)]!!
            else calculator(i, j, k).apply { map += Triple(i, j, k) to this }
}

typealias LazyList<T> = LazyMap<Int, T>

fun <L> lazyListOf(function: (Int) -> L): LazyList<L> = LazyMap(function)

fun <T, L> lazyMapOf(function: (T) -> L): LazyMap<T, L> = LazyMap(function)

fun <T1, T2, L> lazyMapOf(function: (T1, T2) -> L) = LazyMap2(function)

fun <T1, T2, T3, L> lazyMapOf(function: (T1, T2, T3) -> L) = LazyMap3(function)