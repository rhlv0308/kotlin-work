// COMP2850 Portfolio: Week 4
// Triangle class

import kotlin.math.sqrt
 
class Triangle (val sideA:Double, val sideB:Double, val sideC:Double ){

    private val a = sideA
    private val b = sideB    
    private val c = sideC

    init{
        require (a < b + c  &&  b < a + c  &&  c < a + b){"invalid Triangle!"}
    }
    val perimeter get() = a + b + c
    
    val semiPerimeter get() = 0.5 * (a + b + c)
    
    private val s = semiPerimeter
     
    val area get() = sqrt(s * (s - a) * (s - b) * (s - c))
    
    override fun toString() = "Triangle(${sideA}, ${sideB}, ${sideC})"

}