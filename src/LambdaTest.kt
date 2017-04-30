import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun main(args: Array<String>) {
    var a = 0
    val adder = { a++ }
    val minus = { a-- }
    adder()
    adder()
    minus()
    print(a)
}

val ml by mutableLazy { 1 }

fun <T> mutableLazy(initializer: () -> T): ReadWriteProperty<Any?, T> = MutableLazy<T>(initializer)

private class MutableLazy<T>(val initializer: () -> T) : ReadWriteProperty<Any?, T> {

    private var value: T? = null
    private var initialized = false

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        if (!initialized) {
            value = initializer()
        }
        return value as T
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = value
        initialized = true
    }
}

interface Player {
    fun playGame()
}

interface GameMaker { // 1
    fun developGame()
}

class WitcherPlayer(val enemy: String) : Player {
    override fun playGame() {
        println("Killin $enemy")
    }
}

class WitcherCreator(val gameName: String) : GameMaker {
    override fun developGame() {
        println("Makin $gameName")
    }
}

class WitcherPassionate() :
        Player by WitcherPlayer("monsters"),
        GameMaker by WitcherCreator("Witcher 3") {

    fun fulfillYourDestination() {
        playGame()
        developGame()
    }
}

var someProperty: String by Delegates.notNull()
