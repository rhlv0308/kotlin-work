// Task 12.8.2: program to manipulate playing cards

fun main(){
    val deck = mutableListOf<Card>()
    for ( s in Suit.entries ){
        for ( r in Rank.entries ){
            val currentCard = Card(r,s)
            deck.add(currentCard)
        }
    }
    deck.shuffle()
    for (c in deck){
        println(c.fullName)
    }
}