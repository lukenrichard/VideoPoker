import java.util.*;

// The Poker Class holds all of the information to run the Video Poker game.
public class Poker {

    // The main method calls the playGame method when the program starts.
    public static void main(String[] args) {
        playGame();
    }

    // The handResults method takes the final hand of the player and catagorizes it
    // based on the 5 card poker hand it corresponds to. It then sends a message to
    // the player
    // with which category their hand fit into.
    public static void handResults(Hand hand) {

        // Initializing boolean values for hand catagories.
        Boolean flushCheck = false;
        Boolean straightCheck = true;
        Boolean twoPairCheck = false;
        Boolean pairCheck = false;
        Boolean fullHouseCheck = false;
        Boolean threeCheck = false;
        Boolean fourCheck = false;

        // Initializing Set, Hashtable, and Array to help catagorize hands. Sort the
        // Array to help make Straights easier to identify.
        Set<String> flushSet = new HashSet<String>();
        Hashtable<String, Integer> pairDict = new Hashtable<String, Integer>();
        int[] straightArray = new int[] { hand.handContents[0].numberValue, hand.handContents[1].numberValue,
                hand.handContents[2].numberValue, hand.handContents[3].numberValue, hand.handContents[4].numberValue };
        Arrays.sort(straightArray);

        // Go through each Card in the hand.handContents...
        for (int i = 0; i < 5; i++) {

            // Add the suit of each card to the flushSet.
            flushSet.add(hand.handContents[i].suit);

            // If the sorted elements in the Array are not in increments of 1, then there is
            // no Straight in the player's hand.
            if (i + 1 < 5 && straightArray[i + 1] != straightArray[i] + 1) {
                straightCheck = false;
            }

            // Make Hashtable for each cardLetter value in hand.handContents, with the
            // cardLetter as key, and the number of times it appears as the value.
            if (!pairDict.containsKey(hand.handContents[i].cardLetter)) {
                pairDict.put(hand.handContents[i].cardLetter, 1);
            } else {
                pairDict.put(hand.handContents[i].cardLetter, pairDict.get(hand.handContents[i].cardLetter) + 1);
            }
        }

        // If the flushSet has only a size of 1, then only one suit exists among all the
        // cards in the player's hand and he has a flush.
        if (flushSet.size() == 1) {
            flushCheck = true;
        }

        // Go through Hashtable of cardLetter values...
        for (String key : pairDict.keySet()) {

            // Key only has importance if it has a value of more than 1.
            if (pairDict.get(key) > 1) {

                // If the value of the key is 2, then a pair exists in the player's hand.
                if (pairDict.get(key) == 2) {

                    // If there is already a pair, then the player's hand now has two pair.
                    if (pairCheck == true) {
                        twoPairCheck = true;
                    }

                    // If there is already three of a kind, then the player's hand now has a full
                    // house.
                    if (threeCheck == true) {
                        fullHouseCheck = true;
                    }

                    // If nothing exists in the player's hand, then they now have a pair.
                    pairCheck = true;
                }

                // If the value of the key is 3, then the player has a three of a kind in their
                // hand.
                if (pairDict.get(key) == 3) {

                    // If there is already a pair, then the player's hand now has a full house.
                    if (pairCheck == true) {
                        fullHouseCheck = true;
                    }

                    // If nothing exists in the player's hand, then they now have three of a kind.
                    threeCheck = true;
                }

                // If the value of the key is 4, then the player has a four of a kind in their
                // hand.
                if (pairDict.get(key) == 4) {
                    fourCheck = true;
                }
            }
        }

        // Below are the messages printed for the player based on the catagory of their
        // hand. They are in order based on the ranking of poker hands and therefore
        // will always give
        // the player the highest poker hand classification available.
        if (flushCheck == true && straightCheck == true) {
            System.out.println("Congratulations! You got a straight flush!");
        } else if (fourCheck == true) {
            System.out.println("Congratulations! You got four of a kind!");
        } else if (fullHouseCheck == true) {
            System.out.println("Congratulations! You got a full house!");
        } else if (flushCheck == true) {
            System.out.println("Congratulations! You got a flush!");
        } else if (straightCheck == true) {
            System.out.println("Congratulations! You got a straight!");
        } else if (threeCheck == true) {
            System.out.println("Congratulations! You got three of a kind!");
        } else if (twoPairCheck == true) {
            System.out.println("Congratulations! You got two pair!");
        } else if (pairCheck == true) {
            System.out.println("Congratulations! You got a pair!");
        } else {
            System.out.println("Sorry, you don't have a pair or better.");
        }
    }

    // The playGame method is in charge of running the game and creating all the
    // objects necessary to run the game.
    public static void playGame() {

        // Instantiate Deck, Hand, and Scanner objects for later use in the game.
        Deck newDeck = new Deck();
        Hand playerHand = new Hand();
        Scanner input = new Scanner(System.in);

        // Shuffle the newly made Deck object.
        newDeck.shuffle();

        // Add 5 cards to the player's hand from the deck and display their hand.
        playerHand.addCards(newDeck);
        playerHand.displayHand();

        // Ask the player which cards they would like to replace out of the hand they
        // have been dealt.
        System.out.println(
                "What cards would you like to replace? Enter the number (1 to 5) for each card with a space inbetween. Enter 0 for no change. (Example: 1 2 4)");

        // Take input, shuffle the deck, and replace the cards they did not want.
        String numberChoices = input.nextLine();
        String[] numberArray = numberChoices.split(" ", 5);
        newDeck.shuffle();
        playerHand.replaceCards(newDeck, numberArray);

        // Check the player's hand to see if they have any duplicate cards, then display
        // their final hand.
        playerHand.duplicateCheck(newDeck);
        playerHand.displayHand();

        // Run their final hand through the handResults method to give them a final
        // classification.
        handResults(playerHand);

        // Ask them if they would like to play again, if so: restart game, if not: exit
        // to terminal.
        System.out.println("Thank you for playing Video Poker! Would you like to play again? (y/n)");
        String playAgain = input.nextLine();
        if (playAgain.equals("y")) {
            playGame();
        } else {
            System.exit(0);
        }
        input.close();
    }
}