// Task 4.2: use of if and ranges

fun main() {
    // Add your code here
    println("""PIZZA MENU

(a) Margherita
(b) Quattro Stagioni
(c) Seafood
(d) Hawaiian
""")

    print("Choose your pizza (a-d): ")
    val choice = readln().lowercase()

    if ((choice.length == 1) && (choice[0] in 'a'..'d'))
        println("Order accepted")
    else println("Invalid choice!")

}
