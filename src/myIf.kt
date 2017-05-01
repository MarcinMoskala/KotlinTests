class ReturnFromCondition(val satisfied: Boolean) {

    infix fun myElse(f: ()->Unit): ReturnFromCondition {
        if(!satisfied) { f() }
        return this
    }

    inline fun myElseIf(condition: Boolean, f: ()->Unit): ReturnFromCondition {
        if(!satisfied && condition) { f() }
        return this
    }
}

fun myIf(condition: Boolean, f: ()->Unit): ReturnFromCondition {
    if(condition) {f()}
    return ReturnFromCondition(condition)
}

fun main(args: Array<String>) {
    val a = 1
    myIf(a == 0) {
        print("Zero")
    }.myElseIf(a == 2) {
        print("Two")
    } myElse {
        print(a)
    }
}
