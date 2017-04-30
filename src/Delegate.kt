
import kotlin.reflect.KProperty

private val `a$delegate` = { 1 }
val a: Int get() = `a$delegate`.getValue(null, ::a)
private val `b$delegate` = { 1 }
val b: Int get() = `b$delegate`.getValue(null, ::b)
private val `c$delegate` = { 1 }
val c: Int get() = `c$delegate`.getValue(null, ::c)

inline operator fun <R> (() -> R).getValue(
        thisRef: Any?,
        property: KProperty<*>
): R = invoke()

val property by SomeDelegate()

class SomeDelegate {
    operator fun getValue(nothing: Nothing?, property: KProperty<*>) = 1
}