package woow

fun main(args: Array<String>) {
for (i in 1..10) {
    print(i)
}
// 12345678910

println()

for (i in 1..10 step 2) {
    print(i)
}
// 13579

println()

for (c in 'A'..'Z') {
    print(c)
}
// ABCDEFGHIJKLMNOPQRSTUVWXYZ

println()

for (c in "Some text") {
    print("$c.")
}
// S.o.m.e. .t.e.x.t.

println()

println("Some text".toList().joinToString(separator = "."))
// S.o.m.e. .t.e.x.t
}