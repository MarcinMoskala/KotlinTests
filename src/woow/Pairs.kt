package woow

fun main(args: Array<String>) {
    val capitolToCountry = listOf("Washington" to "United States of America", "Warsaw" to "Poland", "Lisbona" to "Portugal", "London" to "Great Britan")

    for ((capitol, country) in capitolToCountry) {
        println("Capitol of $country it $capitol")
    }

//Kotlin 1.1
//    capitolToCountry.forEach { (capitol, country) -> println("Capitol of $country it $capitol") }
}