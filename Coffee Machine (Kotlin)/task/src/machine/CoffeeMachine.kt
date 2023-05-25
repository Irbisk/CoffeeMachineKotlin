package machine

import java.util.regex.Pattern.matches

var water = 400
var milk = 540
var beans = 120
var cups = 9
var money = 550


class CoffeeMachine {
    var state = 0
    fun handleInput(input: String) {
        if (state == 0) {
            when(input) {
                "remaining" -> remaining()
                "fill" -> fill()
                "take" -> take()
                "buy" -> {
                    state = 1
                }
            }
        } else {
            when(input) {
                "1" -> buyDrink(1)
                "2" -> buyDrink(2)
                "3" -> buyDrink(3)
            }
            state = 0
        }
    }

    fun getMessage() {
        if (state == 0) {
            println("Write action (buy, fill, take, remaining, exit): ")
        } else {
            println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
        }
    }
}

fun remaining() {
    println("\nThe coffee machine has:\n" +
            "$water ml of water\n" +
            "$milk ml of milk\n" +
            "$beans g of coffee beans\n" +
            "$cups disposable cups\n" +
            "$$money of money\n")
}

fun fill() {
    println("\nWrite how many ml of water you want to add: ")
    water += readln().toInt()
    println("Write how many ml of milk you want to add: ")
    milk += readln().toInt()
    println("Write how many grams of coffee beans you want to add: ")
    beans += readln().toInt()
    println("Write how many disposable cups you want to add: ")
    cups += readln().toInt()
    println()
}

fun take() {
    println("\nI gave you $money\n")
    money = 0
}

fun buyDrink(drink: Int) {
    var waterRequired = 0
    var milkRequired = 0
    var beansRequired = 0
    var cost = 0
    when(drink) {
        1 -> {
            waterRequired = 250
            milkRequired = 0
            beansRequired = 16
            cost = 4
        }
        2 -> {
            waterRequired = 350
            milkRequired = 75
            beansRequired = 20
            cost = 7
        }
        3 -> {
            waterRequired = 200
            milkRequired = 100
            beansRequired = 12
            cost = 6
        }
    }
    if (water - waterRequired < 0) {
        println("Sorry, not enough water!\n")
        return
    }
    if (milk - milkRequired < 0) {
        println("Sorry, not enough milk!\n")
        return
    }
    if (beans - beansRequired < 0) {
        println("Sorry, not enough coffee beans!\n")
        return
    }
    if (cups - 1 < 0) {
        println("Sorry, not enough cups!\n")
        return
    }
    println("I have enough resources, making you a coffee!\n")
    milk -= milkRequired
    water -= waterRequired
    beans -= beansRequired
    money += cost
    cups--
}
