package machine

fun main() {
    val coffeeMachine = CoffeeMachine()
    while (true) {
        coffeeMachine.getMessage()
        val input = readln()
        if (input == "exit" && coffeeMachine.state == 0) {
            break
        } else {
            coffeeMachine.handleInput(input)
        }
    }
}
