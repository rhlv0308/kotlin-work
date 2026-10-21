// Task 7.7.1: statistics functions

fun median(data: List<Float>):Float{
    require(data.size>0){"empty input!"}
    val sorted = data.sorted()
    if (data.size %2!=0){
        val median = (data.size + 1)/2 - 1
        return sorted[median]
    }
    else {
        val median1 = (data.size / 2)
        val median2 = median1 - 1
        val result = (sorted[median1] + sorted[median2] )/2
        return (result)
    }
}


fun displayStats(data: List<Float>) {
    println(data.max())
    println(data.min())
    println(data.average())
    println(median(data))

}