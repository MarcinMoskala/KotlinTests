package sweet

inline fun <T> suppose(f: () -> T) = f()

fun kaka(c: Int): Int = suppose {
    val a = 1
    val b = 20
    a + b + c
}