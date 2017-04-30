package sweet

private fun risk() {
    val d = 1..6
    (d * d * d * d * d).sumByWithDec { a1, a2, a3, d1, d2 ->
        val (maxA1, maxA2) = listOf(a1, a2, a3).sortedDescending()
        val (maxD1, maxD2) = listOf(d1, d2).sortedDescending()
        fun toNum(a: Int, d: Int) = if (a > d) 1 else 0
        toNum(maxA1, maxD1) + toNum(maxA2, maxD2)
    }.let {
        println(it)
        println(it.toDouble() / (6 * 6 * 6 * 6 * 6 * 2))
    }
}