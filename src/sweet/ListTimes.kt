package sweet

infix operator fun <T, L> Iterable<T>.times(other: Iterable<L>): List<Pair<T, L>> = flatMap { i -> other.map { j -> i to j } }

@JvmName("pairToTriple")
infix operator fun <T1, T2, L> List<Pair<T1, T2>>.times(other: Iterable<L>): List<Triple<T1, T2, L>> = flatMap { i -> other.map { j -> Triple(i.first, i.second, j) } }

@JvmName("tripleToTuple4")
infix operator fun <T1, T2, T3, L> List<Triple<T1, T2, T3>>.times(other: Iterable<L>): List<Tuple4<T1, T2, T3, L>> = flatMap { i -> other.map { j -> Tuple4(i.first, i.second, i.third, j) } }

@JvmName("tuple4ToTuple5")
infix operator fun <T1, T2, T3, T4, L> List<Tuple4<T1, T2, T3, T4>>.times(other: Iterable<L>): List<Tuple5<T1, T2, T3, T4, L>> = flatMap { i -> other.map { j -> Tuple5(i.a1, i.a2, i.a3, i.a4, j) } }

@JvmName("tuple5ToTuple6")
infix operator fun <T1, T2, T3, T4, T5, L> List<Tuple5<T1, T2, T3, T4, T5>>.times(other: Iterable<L>): List<Tuple6<T1, T2, T3, T4, T5, L>> = flatMap { i -> other.map { j -> Tuple6(i.a1, i.a2, i.a3, i.a4, i.a5, j) } }

data class Tuple4<A1, A2, A3, A4>(val a1: A1, val a2: A2, val a3: A3, val a4: A4)
data class Tuple5<A1, A2, A3, A4, A5>(val a1: A1, val a2: A2, val a3: A3, val a4: A4, val a5: A5)
data class Tuple6<A1, A2, A3, A4, A5, A6>(val a1: A1, val a2: A2, val a3: A3, val a4: A4, val a5: A5, val a6: A6)
