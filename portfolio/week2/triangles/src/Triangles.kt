// COMP2850 Portfolio: Week 2
// Functions for working with triangle geometry

import kotlin.math.sqrt

typealias Triangle = Triple<Double,Double,Double>

// Add isValidTriangle() and triangleArea() functions here

fun isValidTriangle(t:Triangle):Boolean{
    val(a,b,c) = t
    if(a < b + c  &&  b < a + c  &&  c < a + b){
        return true
    }

   else{
    return false
   }
}
fun triangleArea(t:Triangle):Double{
    val(a,b,c) = t
    val s = 0.5 * (a + b + c)
    return sqrt(s * (s - a) * (s - b) * (s - c))
}
