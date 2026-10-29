// Task 12.4.1: main program
 
fun main() {
    val c =  Point(1.0,2.0)
    val r =  3.0
    val outside = Point(9.0, 2.0) 
    val circle = Circle(c,r)
    println(circle.area())
    println(circle.perimeter())
    println(circle.contains(outside))

}