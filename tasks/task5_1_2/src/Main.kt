// Task 5.1.2: main program

import kotlin.system.exitProcess

fun main(args:Array<String>){
     
    if (args.size != 1){
        print("Error,input one number")
        exitProcess(1)
        }
        
    val a =args[0].toInt()
    rollDie(a)

}