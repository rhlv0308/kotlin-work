// Task 5.2.1: main program
 
fun main(args: Array<String>){
    val radius = args[0].toDouble()
    val area = circleArea(radius)
    val perimeter = circlePerimeter(radius)

    println("%.4f".format(area))
     println("%.4f".format(perimeter))
}