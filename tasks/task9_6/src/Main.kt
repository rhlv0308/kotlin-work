// Task 9.6: application to compute dataset variance

import kotlin.system.exitProcess

fun main(args: Array<String>) {
    // Implement main program here
    try{
        val filename = args[0]
        val data = readData(filename)
        val variance = variance(data) 
        val size = data.size
        println("size:$size")
        println("variance:%.5f".format(variance))
    }
    catch(error:Exception){
        println("Error: ${error.message}")
        exitProcess(1)
        
    }

}
