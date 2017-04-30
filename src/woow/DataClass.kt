package woow

data class Person(val name: String, val surname: String, val age: Int)

fun main(args: Array<String>) {
    val person = Person("Marcin", "Moskala", 24)
    println("Person is: $person") //

    val user2 = person.copy(age = 25)
    println("Old person is still: $person, but the new one is $user2")

    val (name, surname, age) = person
    println("Name is $name, surname $surname, and age $age")

    val users = listOf(person, user2)
    for((name, surname, age) in users) {
        println("Name is $name, surname $surname, and age $age")
    }

    println(person == person.copy() )
    println(person == Person("Marcin", "Moskala", 24))
}

val now: Long
    get() = System.currentTimeMillis()