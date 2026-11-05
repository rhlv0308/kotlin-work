
package comp2850.banking


const val MAX_OVERDRAFT = 100

class StudentAccount(holder:String):BankAccount(holder){
	var overdraft = 0
		set(value){
			require(value in 0 .. MAX_OVERDRAFT)
			field = value
		}
	override fun withdraw(amount:Int){
		require(amount>0){"Withdrawal amount must be greater than 0"}
		require(balance - amount >= -overdraft){"Insufficient funds for withdrawal"}
		balance = balance - amount
	}
	fun withdrawalsAllowed():Boolean{
		return balance - 1 >= -overdraft
	}
	override fun toString()= "Account for $holder, balance = $balance (overdraft = $overdraft)"
}