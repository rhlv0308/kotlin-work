// Task 15.2.3: demo program

fun main() {
    // Write code to demonstrate the classes here
    val p = SavingsAccount("Cael", 1.8)
    p.deposit(1250)
    repeat(5){p.applyInterest()}
    p.withdraw(50)
    println(p.balance)
}
