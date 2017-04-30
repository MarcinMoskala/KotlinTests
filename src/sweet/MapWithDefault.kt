package sweet

import org.testng.Assert
import org.testng.annotations.Test

class MapWithDefault<K, V>(private val m: Map<K, V>, val default: V) : Map<K, V> by m {

    override operator fun get(key: K): V? = m[key] ?: default

    operator fun plus(other: Map<*, *>) = MapWithDefault(m + other, default)

    operator fun plus(other: MapWithDefault<K, V>) = MapWithDefault(m + other.m, other.default)

    operator fun plus(newElem: Pair<K, V>) = MapWithDefault(m + newElem, default)
}

fun <K, V> Map<K, V>.withSmartDefault(default: V): MapWithDefault<K, V> = MapWithDefault(this, default)

class WithDefaultTests {

    val someMap = mapOf(1 to 1, 2 to 2)
    val otherMap = mapOf(3 to 3, 4 to 4)

    @Test
    fun `Simple usage`() {
        Assert.assertEquals(someMap.withSmartDefault(3)[100], 3)
    }

    @Test
    fun `MapWithDefault after plus operation with element is returning MapWithDefault with the same default`() {
        Assert.assertEquals(someMap.withSmartDefault(3).plus(5 to 5)[100], 3)
    }

    @Test
    fun `MapWithDefault after plus operation with map is returning MapWithDefault with the same default`() {
        val otherMap = mapOf(3 to 3, 4 to 4)
        Assert.assertEquals(someMap.withSmartDefault(3).plus(otherMap)[100], 3)
    }

    @Test
    fun `Sum of two MapWithDefault is returning map as in normal sum operation with default from second map`() {
        val sumOfTwoMapWithDefault = someMap.withSmartDefault(1) + otherMap.withSmartDefault(3)
        val expectation = someMap + otherMap + mapOf(5 to 3, 6 to 3, 100 to 3)
        for ((key, valueExpected) in expectation)
            Assert.assertEquals(sumOfTwoMapWithDefault[key], valueExpected)
    }
}