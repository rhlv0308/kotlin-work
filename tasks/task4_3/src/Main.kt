// Task 4.3: grade calculation using a when expression

import kotlin.math.roundToInt
import kotlin.system.exitProcess
 
fun main(args: Array<String>){
    if (args.size == 3){
        val average = ((args[0].toDouble()+args[1].toDouble()+args[2].toDouble())/3).roundToInt()
        when (average) {
            in 0..39 -> println("Fail")
            in 40..69 -> println("Pass")
            in 70..100 -> println("Distinction")
            else -> println("?")     
            } 
        println(average)
    }
        
    else {println("Error")
        exitProcess(1)  
    }
} 
