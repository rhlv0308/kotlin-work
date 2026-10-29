// Task 12.8.1: demo program for Day enum class


fun main(){
    println("Input day")
    val date = readln()
        try{
        println(Day.valueOf(date))
        }
        catch (e: IllegalArgumentException) {
            println("Please use one of: ${Day.entries}")

            }
}