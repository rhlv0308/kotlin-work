// Task 12.1: program that uses a Point object


fun main(){
//val p = Point()
//println(p.x)
//println(p.y)
//p.x = 1.0
//println(p.x)
val a = Point(3.0, 4.0)
val b = Point(1.0, 2.0)
println("(${a.x},${a.y})")
println("(${b.x},${b.y})")
//println(b)
println(a.distance())
println(a.distanceTo(Point(4.5,7.0)))
println(b.distance())
println(b.distanceTo(Point(4.5,7.0)))
}