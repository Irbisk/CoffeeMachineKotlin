import java.util.Scanner

fun main() {
    // put your code here
    val scanner = Scanner(System.`in`)
    println(start(scanner.next(), scanner.next()))

}
enum class Country(val currency: String) {
    GERMANY("Euro"),
    MALI("CFA franc"),
    DOMINICA("Eastern Caribbean dollar"),
    CANADA("Canadian dollar"),
    SPAIN("Euro"),
    AUSTRALIA("Australian dollar"),
    BRAZIL("Brazilian real"),
    SENEGAL("CFA franc"),
    FRANCE("Euro"),
    GRENADA("Eastern Caribbean dollar"),
    KIRIBATI("Australian dollar");
}

fun start(country1: String, country2: String): Boolean  {
    var aExists = false
    var bExists = false
    val names = Country.values()
    for (i in names) {
        if (country1.uppercase() == i.name) {
            aExists = true
        }
        if (country2.uppercase() == i.name) {
            bExists = true
        }
    }

    return if (aExists && bExists) {
        isEqual(Country.valueOf(country1.uppercase()), Country.valueOf(country2.uppercase()))
    } else false
}

fun isEqual(country1: Country, country2: Country): Boolean {
    return country1.currency == country2.currency
}