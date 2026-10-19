// Task 5.1.1: anagrams() function

infix fun String.anagramOf(second: String):Boolean{
    if(this.length != second.length){
        return false
    }
    val firstChars = this.lowercase().toList().sorted()
    val secondChars = second.lowercase().toList().sorted()
    return firstChars == secondChars

}

