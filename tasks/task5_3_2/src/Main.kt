// Task 5.3.2: main program

import kotlin.system.exitProcess
 
fun main (args: Array<String>){

val a = args[0].substringBefore('d').toInt()
val b = args[0].substringAfter('d').toInt()

rollDice(number = a,sides = b)
 
}