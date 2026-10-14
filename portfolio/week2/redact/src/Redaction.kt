// COMP2850 Portfolio: Week 2
// Function to redact sensitive information in a string

fun redact(file:String,context:String,change: Char='X'):String{

    var repeatTimes = context.length
    
    val replacement = (change.toString().repeat(repeatTimes))
    return  file.replace(context,replacement)

}
