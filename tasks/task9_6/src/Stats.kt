// Task 9.6: variance() function


fun variance(args: List<Double>):Double{
    require (args.size > 1) { "not enough args"}
    val mean = args.average()                          
    val sumSquaredDev = args.map { it - mean }.sumOf { it * it }           
    return sumSquaredDev / (args.size - 1)
}