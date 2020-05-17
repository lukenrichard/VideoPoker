import java.util.Random;

public class Deck {
    Card[] deckContents = new Card[52];

    public Deck() {
        for (int i = 0; i < 13; i++) {
            String cardLetter = valueToLetter(i + 2);
            Card diamondCard = new Card(i + 2, cardLetter, "Diamond");
            Card spadeCard = new Card(i + 2, cardLetter, "Spade");
            Card heartCard = new Card(i + 2, cardLetter, "Heart");
            Card clubCard = new Card(i + 2, cardLetter, "Club");

            this.deckContents[4 * i] = diamondCard;
            this.deckContents[4 * i + 1] = spadeCard;
            this.deckContents[4 * i + 2] = heartCard;
            this.deckContents[4 * i + 3] = clubCard;
        }
    }

    public String valueToLetter(int cardValue) {
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

    public void shuffle() {
        int index;
        Card tempCard;
        Random random = new Random();
        for (int i = this.deckContents.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            tempCard = this.deckContents[index];
            this.deckContents[index] = this.deckContents[i];
            this.deckContents[i] = tempCard;
        }

    }
}