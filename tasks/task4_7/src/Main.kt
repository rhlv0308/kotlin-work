// Task 4.7: finding the longest line in a file

import kotlin.io.path.Path
import kotlin.io.path.forEachLine
import kotlin.io.path.useLines
import kotlin.system.exitProcess

fun main(args: Array<String>){
    if (args.size != 1){
        println("Error: file path required")
        exitProcess(1)
    }

     
    else {
        val filePath = Path(args[0])
        var currentLine = 0
        var maxLength = 0
        var maxLine = 0

        filePath.useLines{
            for (line in it){
                currentLine += 1
                if (maxLength < line.length){
                maxLine = currentLine
                maxLength = line.length
                }                        
            }
        println("Line $maxLine is the longest (length = $maxLength)")

        }
    }


    
}