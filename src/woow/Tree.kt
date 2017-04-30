package woow

import woow.Tree.*

sealed class Tree {
    class Node(val v: Int, val l: Tree = Empty, val r: Tree = Empty): Tree()
    object Empty: Tree()
}

fun sum(t: Tree): Int = when(t) {
    is Node -> t.v + sum(t.l) + sum(t.r)
    is Empty -> 0
}

fun main(args: Array<String>) {
    val tree = Node(10, Node(5), Node(12, Node(1), Node(8, Node(5), Node(9))))
    print(sum(tree))
}