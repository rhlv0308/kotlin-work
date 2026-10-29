// Task 12.9: demo program for class implementing Static Factory Method

import kotlinx.datetime.LocalDate

fun main(){
    //Person("XXX" ,LocalDate(1990, 12, 24))
    val p1 = Person.create("XXX" ,LocalDate(1990, 12, 24))
    val p2 = Person.create("XXX" ,LocalDate(1990, 12, 24))
}