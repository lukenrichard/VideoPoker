import java.util.*;

public class Hand {
    Card[] handContents = new Card[5];

    public void addCards(Deck deck){
        for (int i = 0; i < 5; i++){
            handContents[i] = deck.deckContents[i];
        }
    }

    public void displayHand(){
        for (int i = 0; i < 5; i++){
            System.out.println(handContents[i].cardLetter + " " + handContents[i].suit);
        }
    }

    public void duplicateCheck(){
        Set<Card> testSet = new HashSet<Card>();
        for (int i = 0; i < 5; i++){
            if (testSet.add(handContents[i]) == false){
                System.out.println("Oops");
            };
        }
        
    }

    public void replaceCards(Deck deck, int a){
        this.handContents[a - 1] = deck.deckContents[a - 1];
    }
    
    public void replaceCards(Deck deck, int a, int b){
        this.handContents[a - 1] = deck.deckContents[a - 1];
        this.handContents[b - 1] = deck.deckContents[b - 1];
    }

    public void replaceCards(Deck deck, int a, int b, int c){
        this.handContents[a - 1] = deck.deckContents[a - 1];
        this.handContents[b - 1] = deck.deckContents[b - 1];
        this.handContents[c - 1] = deck.deckContents[c - 1];
    }

    public void replaceCards(Deck deck, int a, int b, int c, int d){
        this.handContents[a - 1] = deck.deckContents[a - 1];
        this.handContents[b - 1] = deck.deckContents[b - 1];
        this.handContents[c - 1] = deck.deckContents[c - 1];
        this.handContents[d - 1] = deck.deckContents[d - 1];
    }

    public void replaceCards(Deck deck, int a, int b, int c, int d, int e){
        this.handContents[a - 1] = deck.deckContents[a - 1];
        this.handContents[b - 1] = deck.deckContents[b - 1];
        this.handContents[c - 1] = deck.deckContents[c - 1];
        this.handContents[d - 1] = deck.deckContents[d - 1];
        this.handContents[e - 1] = deck.deckContents[e - 1];
    }
}