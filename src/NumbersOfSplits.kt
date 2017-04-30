// P(n, k) - number of splits of n identical elements to k groups
fun P(elements: Int, parts: Int): Int = when {
    parts == 0 -> if (elements == 0) 1 else 0
    parts == 1 || parts == elements -> 1
    parts > elements -> 0
    else -> (1..parts).sumBy { i -> P(elements - parts, i) }
}

// P(n, k) - number of splits of n identical elements to k groups
fun pP(elements: Int, parts: Int): String = when {
    parts == 0 -> if (elements == 0) "P(0, 0) == 1" else "P(n, 0) == 0"
    parts == 1 -> "P(n, 1) == 1"
    parts == elements -> "P(n, n) == 1"
    parts > elements -> "P(n < k) == 0"
    else -> (1..parts).map { i -> "P($elements, $i) == (${pP(elements - parts, i)}" }.joinToString(separator = " + ", transform = { "($it)" })
}

// S(n, k) - number of splits of n different elements to k groups
fun S(elements: Int, parts: Int): Int = when {
    parts == 0 -> if (elements == 0) 1 else 0
    parts == 1 || parts == elements -> 1
    parts > elements -> 0
    else -> S(elements - 1, parts - 1) + parts * S(elements - 1, parts)
}

fun main(args: Array<String>) {
    println(P(11, 3))
}