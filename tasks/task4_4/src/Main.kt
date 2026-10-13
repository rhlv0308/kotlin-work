// Task 4.4: temperature conversion using a while loop

import kotlin.system.exitProcess

import com.github.ajalt.mordant.rendering.AnsiLevel
import com.github.ajalt.mordant.rendering.TextAlign
import com.github.ajalt.mordant.rendering.TextColors.*
import com.github.ajalt.mordant.table.table
import com.github.ajalt.mordant.terminal.Terminal

fun main(args: Array<String>) {
    // Add your code here
    if (args.size == 3){
    val startTemp = args[0].toDouble()
    val maxTemp = args[1].toDouble()
    val increment = args[2].toDouble()
    var celsius = startTemp

        while (celsius<=maxTemp){    
            val fahrenheit = celsius*9/5+32
            println("%5.1f %5.1f".format(celsius, fahrenheit))
            celsius += increment
        }
    }

    else {
        println("Error, input missing!")
        exitProcess(1)
    }
}
