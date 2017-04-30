import java.util.*

//import org.junit.Test

data class BinaryTree<T
: Comparable<T>>(
        var data: T,
        var left: BinaryTree<T>? = null,
        var right: BinaryTree<T>? = null)

tailrec fun <T : Comparable<T>> inOrder(node: BinaryTree<T>?) {
    if (node == null) {
        return
    }
    inOrder(node.left)
    System.out.printf("%s ", node.data)
    inOrder(node.right)
}

fun <T : Comparable<T>> printInOrderClassic(node: BinaryTree<T>?) {
    val nodes = Stack<BinaryTree<T>>()
    var current: BinaryTree<T>? = node
    while (!nodes.isEmpty() || current != null) {
        if (current != null) {
            nodes.push(current)
            current = current.left
        } else {
            System.out.printf("%s ", nodes.pop().data)
            current = nodes.pop().right
        }
    }
}

tailrec fun <T : Comparable<T>> contains(node: BinaryTree<T>?, elem: T): Boolean = when {
    node == null -> false
    node.data == elem -> true
    elem < node.data -> contains(node.left, elem)
    else -> contains(node.right, elem)
}

fun <T : Comparable<T>> containsClassic(node: BinaryTree<T>?, elem: T): Boolean {
    var current: BinaryTree<T>? = node
    while (current != null) {
        if (current.data == elem)
            return true

        if (current.data > elem)
            current = current.left
        else
            current = current.right
    }
    return false
}

fun <T : Comparable<T>> sizeOf(node: BinaryTree<T>?): Int = when {
    node == null -> 0
    else -> 1 + sizeOf(node.left) + sizeOf(node.right)
}

//fun <T : Comparable<T>> sizeOfClassic(node: BinaryTree<T>?, elem: T): Int {
//    var current: BinaryTree<T>? = node
//    while (current != null) {
//        if (current == elem)
//            return true
//
//        if (current.data < elem)
//            current = current.left
//        else
//            current = current.right
//    }
//    return false
//}

fun <T : Comparable<T>> add(node: BinaryTree<T>?, elem: T): BinaryTree<T> = when {
    node == null -> BinaryTree(elem)
    elem < node.data -> BinaryTree(node.data, add(node.left, elem), node.right)
    else -> BinaryTree(node.data, node.left, add(node.right, elem))
}

fun <T : Comparable<T>> addClassic(node: BinaryTree<T>?, elem: T) {
    var current: BinaryTree<T>? = node
    while (true) {
        if (current!!.data > elem) {
            if (current.left == null) {
                current.left = BinaryTree(elem)
                return
            } else {
                current = current.left
            }
        } else {
            if (current.right == null) {
                current.right = BinaryTree(elem)
                return
            } else {
                current = current.right
            }
        }
    }
}

fun measureTime(f: () -> Unit) {
    val startTime = System.currentTimeMillis()
    f()
    val endTime = System.currentTimeMillis()
    println("It took " + (endTime - startTime))
}

class BinaryTreeTest {

//    @Test
    fun testAdd() {
        var a = BinaryTree(5)
        val b = BinaryTree(5)

        val r = Random()
        val numbers = Array(1000) { r.nextInt(1000000) }

        numbers.forEach {
            a = add(a, it)
            addClassic(b, it)
            assert(a == b)
        }
    }

//    @Test
    fun testAddEquility() {
        var a = BinaryTree(5)
        val b = BinaryTree(5)

        val r = Random()
        val numbers = Array(1000) { r.nextInt(1000000) }

        numbers.forEach {
            a = add(a, it)
            addClassic(b, it)
            assert(a == b)
        }
    }

//    @Test
    fun testNotContains() {
        val a = BinaryTree(1)
        var b = BinaryTree(1)

        val r = Random()
        val numbers = Array(10000) { r.nextInt(10000) }

        val notIn = (0..10000).toList() - numbers.asList()

        numbers.forEach { addClassic(a, it) }
        numbers.forEach { b = add(b, it) }

        numbers.forEach {
            assert(contains(a, it), { "It does now contains $it in $a" })
        }
        numbers.forEach {
            assert(contains(b, it), { "It does now contains $it in $b" })
        }
        notIn.forEach {
            assert(!contains(a, it), { "It contains $it in $a" })
        }
        notIn.forEach {
            assert(!contains(b, it), { "It contains $it in $b" })
        }
    }
}

var l: (Int) -> Int = l@ { i: Int -> return@l i * 2 }

//fun sweet.LazyMap.sweet.main(args: Array<String>) {
//    var sweet.getA = BinaryTree(1)
//    var sweet.getB = BinaryTree(1)
//
//    val r = Random()
//    val numbers = Array(1000000) { r.nextInt(100000) }
//
//    val notIn = (0..100000).toList() - numbers.toList()
//
//    measureTime {
//        numbers.forEach { addClassic(sweet.getA, num) }
//    }
//    measureTime {
//        numbers.forEach { sweet.getB = add(sweet.getB, num) }
//    }
//
//    measureTime {
//        println(sizeOf(sweet.getA))
//        println(sizeOf(sweet.getB))
//    }
////    measureTime {
////        println(sizeOfClassic(sweet.getA))
////        println(sizeOfClassic(sweet.getB))
////    }
//
//    measureTime {
//        println(numbers.all { containsClassic(sweet.getA, num) })
//        println(notIn.none { containsClassic(sweet.getA, num) })
//        println(numbers.all { containsClassic(sweet.getB, num) })
//        println(notIn.none { containsClassic(sweet.getB, num) })
//    }
//    measureTime {
//        println(numbers.all { contains(sweet.getA, num) })
//        println(notIn.none { contains(sweet.getA, num) })
//        println(numbers.all { contains(sweet.getB, num) })
//        println(notIn.none { contains(sweet.getB, num) })
//    }
//
//    notIn.forEach {
//        assert(!contains(sweet.getA, num), { "It contains $num in $sweet.getA" })
//    }
//
//
////    val sweet.getA = listOf(1, 2)
////    (sweet.getA as AbstractList<Int>).set(0, 3)
////    println(sweet.getA)
////
////    val sweet.getB = listOf(7, 2, 5, 3)
////    (sweet.getB as AbstractList<Int>).sort()
////    println(sweet.getB)
//
//    println(sweet.getA == sweet.getB)
//}
