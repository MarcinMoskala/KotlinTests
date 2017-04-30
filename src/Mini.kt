import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class NextElementDelegate<T>(val f: (Int)->T){

    var i = 0

    operator fun getValue(thisRef: Any?, property: KProperty<*>) = f(i++)
}


val nextId by NextElementDelegate { it }
val nextStreamElement by NextElementDelegate { list[it] }

fun main(args: Array<String>) {
    nextId
    nextStreamElement
}