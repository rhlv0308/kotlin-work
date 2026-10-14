// Task 7.7.2: phone book simulator

const val CSV_FILENAME = "phone.csv"

fun main() {

    // Implement the main program here
    // (You can add other functions to this file if you wish)
    val db = createDatabase()
    db.load(CSV_FILENAME)
    while(true){
        println("input name:")
        val name = readln()
        if (name == ""){
            break
        }
        if (name in db){
            println(db[name])
        }
        else {
            println("not exist, input the number please")
            var newNumber = readln()
            db[name]=newNumber
            db.save(CSV_FILENAME)
        }
        
    }
   

}
