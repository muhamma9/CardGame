package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

public class Deck {

	private List<Card> deckOfCards;
        
        
        // In the constructor the 52 cards will be generated based on suit and rank.
	public Deck() {
            deckOfCards = new ArrayList<>();
            for(int s=0; s<Suit.values().length; s++){
                for(int r=0; r<Rank.values().length; r++){
                    if(Rank.values()[r]!=Rank.JOKER){
                    Card card = new Card(Rank.values()[r], Suit.values()[s]);
                    deckOfCards.add(card);}
                }
            }
	}
        
        public void shuffle(){            
            for(int i=0; i<100; i++){
                int firstCard = (int)(Math.random()*52);
                int secondCard = (int)(Math.random()*52);
                Card temp = deckOfCards.get(firstCard);
                deckOfCards.set(firstCard, deckOfCards.get(secondCard));
                deckOfCards.set(secondCard, temp);
            }
        }

	public Card dealCard() {
            Card card = deckOfCards.getFirst();
            deckOfCards.removeFirst();
            return card;
	}

	public boolean isEmpty() {
		return deckOfCards.isEmpty();
	}


}