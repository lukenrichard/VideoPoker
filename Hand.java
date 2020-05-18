import java.util.*;

// The Hand Class holds all of the information for the Hand object, which represents the player hand.
public class Hand {

    // Initialize the Hand object with attribute handContents, an array of size 5
    // that holds Card objects.
    Card[] handContents = new Card[5];

    // The addCards method will set the handContents array equal to the first 5 Card
    // objects in the Deck object.
    public void addCards(Deck deck) {
        for (int i = 0; i < 5; i++) {
            handContents[i] = deck.deckContents[i];
        }
    }

    // The displayHand method will display the player's hand, mainly the cardLetter
    // and the suit of the card.
    public void displayHand() {
        System.out.println("Your hand is:");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + ". " + handContents[i].cardLetter + " of " + handContents[i].suit);
        }
    }

    // The duplicateCheck method will ensure that the player does not receive two
    // identical Card objects in their hand.
    public void duplicateCheck(Deck deck) {

        // Initialize Set...
        Set<Card> duplicateSet = new HashSet<Card>();
        for (int i = 0; i < 5; i++) {

            // If the Set is unable to add a Card object, then it is a duplicate and needs
            // to be replaced with a card that is not in the player's hand.
            if (duplicateSet.add(handContents[i]) == false) {

                // Go through the Deck object from the other end to avoid collision.
                for (int j = 51; j > 0; j--) {

                    // If the new card is not a duplicate in the player's hand, then it will be
                    // added to the Set and the player's hand.
                    if (duplicateSet.add(deck.deckContents[j])) {
                        handContents[i] = deck.deckContents[j];
                        break;
                    }
                }
            }
            ;
        }

    }

    // The replaceCards method will take the player input and replace the chosen
    // cards with new ones from the deck.
    public void replaceCards(Deck deck, String[] numberChoices) {

        // If player wants no change, return.
        if (Integer.parseInt(numberChoices[0]) == 0) {
            return;
        }
        // For each Card object that will be replaced...
        for (int i = 0; i < numberChoices.length; i++) {

            // Set the Card object in the hand.handContents array equal to a new card from
            // the deck Object.
            int numberChoice = Integer.parseInt(numberChoices[i]) - 1;
            this.handContents[numberChoice] = deck.deckContents[numberChoice];
        }
    }
}