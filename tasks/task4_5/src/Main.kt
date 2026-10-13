// Task 4.5: summing odd integers with a for loop

import kotlin.system.exitProcess

fun main(args: Array<String>) {
    // Add your code here
    if (args.size == 1){
    val maxNumber = args[0].toInt() 
        var sum = 0L
        for (n in 1..maxNumber step 2){
            sum += n   
        }

    println(sum)
    }

    else {
        print("Error!")
        exitProcess(1)
    }
}
