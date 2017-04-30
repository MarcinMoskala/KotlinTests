import java.lang.Math.max

val nextStep: (Int) -> Int = memorise { floorsLeft ->
    if (floorsLeft <= 2) 1
    else (1..floorsLeft).toList().minBy { maxThrows(floorsLeft, it) }!!
}

fun maxThrows(floorsLeft: Int, nextFloor: Int): Int =
        if (floorsLeft <= 1) floorsLeft - 1
        else {
            val newFloorsNumIfNotCrashed = floorsLeft - nextFloor
            val floorsIfCrashed = nextFloor
            max(floorsIfCrashed, maxThrows(newFloorsNumIfNotCrashed) + 1)
        }

val maxThrows: (Int) -> Int = memorise { floorsLeft -> maxThrows(floorsLeft, nextStep(floorsLeft)) }

fun main(args: Array<String>) {
    println(maxThrows(1000))
    var floors = 1000
    var toThrow = 0
    while (floors > 1) {
        val next = nextStep(floors)
        toThrow += next
        print("$toThrow, ")
        floors -= next
    }
}

