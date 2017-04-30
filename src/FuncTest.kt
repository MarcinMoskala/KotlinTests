//import org.junit.Test
import java.util.*

class FuncTest {

//    @Test
    fun testAdd() {
        listOf(1,2,3,4,5).fold(1, { i1, i2 -> i1 * i2 }).let { println(it) }
        listOf(1,2,3,4,5).reduceRight { i1, i2 -> i1 * i2 }.let { println(it) }
    }
}
