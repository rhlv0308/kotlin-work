// Task 7.7.2: database-handling functions

import kotlin.io.path.Path
import kotlin.io.path.forEachLine
import kotlin.io.path.writer

typealias Database = MutableMap<String,String>

fun createDatabase() = mutableMapOf<String,String>()

fun Database.load(filename: String) {
    // Add code here to read names and numbers from the file
    // and insert them as keys and values into the map
    val filePath = Path(filename)
    filePath.forEachLine{

        val name = it.substringBefore(',')
        val number = it.substringAfter(',')  
        this[name] = number
    }
}

fun Database.save(filename: String) {
    Path(filename).writer().use {
        
        for ((name, number) in this) { 
            it.write("$name,$number\n")   //  it 是写字工具

         }  
    }
}
