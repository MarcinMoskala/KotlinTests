import org.testng.Assert
import org.testng.annotations.Test
import kotlin.concurrent.thread

fun sum(a: Int, b: Int): Int = foldRange(a, b, 0, { i, j -> i + j })

fun prod(a: Int, b: Int): Int = foldRange(a, b, 1, { i, j -> i * j })

private tailrec fun foldRange(
        a: Int,
        b: Int,
        accumulator: Int,
        operation: (Int, Int) -> Int
): Int = when {
    a > b -> accumulator
    else -> foldRange(a + 1, b, operation(a, accumulator), operation)
}

val fib: (Int) -> Int = memorise<Int, Int> { a ->
    if (a <= 2) 1
    else (::fib).get()(a - 1) + (::fib).get()(a - 2)
}

fun <V, T> memorise(f: (V) -> T): (V) -> T {
    val map = mutableMapOf<V, T>()
    return { map.getOrPut(it) { f(it) } }
}

class TestTest {
    @Test
    fun simpleSumTests() {
        Assert.assertEquals(sum(1, 2), 3)
        Assert.assertEquals(sum(0, 2), 3)
        Assert.assertEquals(sum(0, 1), 1)
        Assert.assertEquals(sum(1, 3), 6)
        Assert.assertEquals(sum(0, 0), 0)
    }

    @Test
    fun simpleProdTests() {
        Assert.assertEquals(prod(1, 2), 2)
        Assert.assertEquals(prod(0, 2), 0)
        Assert.assertEquals(prod(0, 1), 0)
        Assert.assertEquals(prod(1, 3), 6)
        Assert.assertEquals(prod(1, 4), 24)
        Assert.assertEquals(prod(3, 4), 12)
        Assert.assertEquals(prod(0, 0), 0)
    }

    @Test
    fun stackOverflow() {
        Assert.assertEquals(prod(1, 999999999), 0)
    }
}