package sweet

fun <A1, A2, A3, A4, A5> List<Tuple5<A1, A2, A3, A4, A5>>.countWithDec(f: (A1, A2, A3, A4, A5) -> Boolean): Int = this.count { f(it.a1, it.a2, it.a3, it.a4, it.a5) }

fun <A1, A2, A3, A4, A5> List<Tuple5<A1, A2, A3, A4, A5>>.sumByWithDec(f: (A1, A2, A3, A4, A5) -> Int): Int = this.sumBy { f(it.a1, it.a2, it.a3, it.a4, it.a5) }
