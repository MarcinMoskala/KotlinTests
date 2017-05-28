import org.testng.annotations.Test

fun <T, L> List<T>.leftJoin(other: List<L>, pairBy: (T, L) -> Boolean): List<Pair<T, L?>> =
        mapNotNull { l1 -> other.firstOrNull { l2 -> pairBy(l1, l2) }.let { l2 -> l1 to l2 } }

fun <T, L, M : Any> List<T>.leftJoin(other: List<L>, pairBy: (T, L) -> Boolean, howToPair: (T, L?) -> M?): List<M> =
        leftJoin(other, pairBy).mapNotNull { howToPair(it.first, it.second) }

fun <T, L, M> List<T>.join(other: List<L>, pairBy: (T, L) -> Boolean, howToPair: (T, L) -> M): List<M> =
        flatMap { l1 -> other.filter { l2 -> pairBy(l1, l2) }.map { l2 -> howToPair(l1, l2) } }

private fun tryFewTimes(times: Int = 3, f: () -> Unit) {
    try {
        f()
    } catch(e: Error) {
        if (times > 0) {
            Thread.sleep(500)
            tryFewTimes(times - 1, f)
        } else {
            throw e
        }
    }

}

class DefaultMapTest {
    @Test
    fun mapWithDefaultTest() {
        assert((mapOf(1 to 1).withDefault { 1 } + (2 to 10))[3] == 1)
    }
}

class Student(
        val name: String,
        val surname: String,
        val passing: Boolean,
        val grade: Double
)

fun main(args: Array<String>) {
    val students = listOf(Student("A", "B", true, 22.3))

students.filter { it.passing }
        .also { println(it) }
        .sortedBy { it.grade }
            .take(10)
}