public class Poker {
    public static void main(String[] args) {
        Deck newDeck = new Deck();
        Hand playerHand = new Hand();
        newDeck.shuffle();
        playerHand.addCards(newDeck);
        playerHand.displayHand();
        newDeck.shuffle();
        playerHand.replaceCards(newDeck, 1, 2);
        playerHand.displayHand();
        playerHand.duplicateCheck();

    }
}