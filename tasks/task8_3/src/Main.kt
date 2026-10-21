// Task 8.3: weather station temperature analysis program

import kotlin.system.exitProcess

fun main(args: Array<String>) {
    // Add your code here
    if ( args.size != 1){
        println("error!")
        exitProcess(1)
    }
    val data = fetchData(args[0])
    val coldest = data.minBy{it.second}
    val hottest = data.maxBy{it.second}
    val ave = averageTemp(data).toDouble()
    println("coldest:$coldest , hottest:$hottest")
    println("ave:%.2f".format(ave))

    //ave in one line
    val ave2 = data.map {it.second}.average()
    println("ave:%.2f".format(ave2))

}
