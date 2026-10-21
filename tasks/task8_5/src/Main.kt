// Task 8.5: example of using a higher-order function

fun main() {
    // Add your testing code here
    val text = "Hello World 2026"
    val a = text.howMany{it.lowercase() == "a"}
    val space = text.howMany{it == ' '}
    val enter = text.howMany{it == '\n'}

    println("a: $a")
    println("space: $space")
    println("enter: $enter")
}
