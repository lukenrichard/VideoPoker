// The Card class holds all the information to make Card objects, which are important for the game.
public class Card {

    // Each Card object is initialized with a numberValue, cardLetter, and suit
    // attribute.
    int numberValue;
    String cardLetter;
    String suit;

    // Constructor method to set each attribute with the parameters given with the
    // initialization call.
    public Card(int numberValue, String cardLetter, String suit) {
        this.numberValue = numberValue;
        this.cardLetter = cardLetter;
        this.suit = suit;
    }
}