fun main() {
    val col = readln()
    val list = Rainbow.values()
    var contains = false
    for (i in list) {
        if (i.name == col.uppercase()) {
            contains = true
        }
    }
    println(contains)
}

enum class Rainbow {
    RED,
    ORANGE,
    YELLOW,
    GREEN,
    BLUE,
    INDIGO,
    VIOLET
}