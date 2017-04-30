package woow

fun String.noLongerThen(max: Int): String {
    return this.substring(0, Math.min(max, this.length))
}

fun main(args: Array<String>) {
    println("Joe".noLongerThen(4)) // Joe
    println("James".noLongerThen(4)) // Jame
    println("Ashley".noLongerThen(4)) // Ashl
}