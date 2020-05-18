import java.util.Random;

// The Deck Object holds all of the information for the entire deck of Card objects that this game uses.
public class Deck {

    // The Deck Object is initialized with the attribute deckContents, an array of
    // size 52 that holds Card objects.
    Card[] deckContents = new Card[52];

    // Constructor method that creates all of the Card objects that the Deck will
    // hold in its deckContents attribute.
    public Deck() {

        // Make a card of each value 2-A and each suit: Diamonds, Spades, Hearts, and
        // Clubs. Then, fill the deckContents array with pointers to these newly made
        // Card objects.
        for (int i = 0; i < 13; i++) {
            String cardLetter = valueToLetter(i + 2);
            Card diamondCard = new Card(i + 2, cardLetter, "Diamonds");
            Card spadeCard = new Card(i + 2, cardLetter, "Spades");
            Card heartCard = new Card(i + 2, cardLetter, "Hearts");
            Card clubCard = new Card(i + 2, cardLetter, "Clubs");

            this.deckContents[4 * i] = diamondCard;
            this.deckContents[4 * i + 1] = spadeCard;
            this.deckContents[4 * i + 2] = heartCard;
            this.deckContents[4 * i + 3] = clubCard;
        }
    }

    // The valueToLetter method is private because it only needs to be accessed from
    // within this class. It changes the cardLetter value to its appropriate
    // character if the numberValue
    // corresponds with a face card, such as J, Q, K, or A.
    private String valueToLetter(int cardValue) {
        if (cardValue == 11) {
            return "J";
        }
        if (cardValue == 12) {
            return "Q";
        }
        if (cardValue == 13) {
            return "K";
        }
        if (cardValue == 14) {
            return "A";
        }
        return Integer.toString(cardValue);
    }

    // The shuffle method randomly shuffles the order of Card objects in the
    // deckContents array.
    public void shuffle() {
        int index;
        Card tempCard;
        Random random = new Random();

        // Replace a random card with another card for each spot in the deckContents
        // array.
        for (int i = this.deckContents.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            tempCard = this.deckContents[index];
            this.deckContents[index] = this.deckContents[i];
            this.deckContents[i] = tempCard;
        }

    }
}