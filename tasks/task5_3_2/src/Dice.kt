// Task 5.3.2: rollDice() function
 
import kotlin.random.Random

fun rollDice(number: Int = 1, sides: Int = 6) {
    if (sides in setOf(4, 6, 8, 10, 12, 20)) {
        var finalResult = 0
        repeat(number){
            println("Rolling a d$sides...")
            val result = Random.nextInt(1, sides + 1)
            println("You rolled $result")
            finalResult += result
        }
        print(finalResult)
    }
    else {
        println("Error: cannot have a $sides-sided die")
    }
}