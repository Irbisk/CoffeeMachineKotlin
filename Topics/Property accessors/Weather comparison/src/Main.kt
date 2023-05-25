import kotlin.math.min

class City(val name: String) {
    var degrees: Int = 0
        set(value) {
            if (value < -92 || value > 57) {
                when(name) {
                    "Moscow" -> field = 5
                    "Hanoi" -> field = 20
                    "Dubai" -> field = 30
                }
            } else field = value
        }
}        

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    //implement comparing here
    val coldest = min(firstCity.degrees, min(secondCity.degrees, thirdCity.degrees))
    val list = mutableListOf<String>()
    if (firstCity.degrees == coldest) {
        list.add(firstCity.name)
    }
    if (secondCity.degrees == coldest) {
        list.add(secondCity.name)
    }
    if (thirdCity.degrees == coldest) {
        list.add(thirdCity.name)
    }
    if (list.size == 1) {
        println(list[0])
    } else {
        println("neither")
    }
}