package ca.sheridancollege.project;

import java.util.*;

public class Hand {

	private List<Card> handOfCards;


        // The hand originally starts off empty, no need to add a count. 
        public Hand() {}
        

	public boolean isEmpty() {
		return handOfCards.isEmpty();
	}
        
        
        public List<Card> findCardsByRank(Rank rank){
            List<Card> foundCards = new ArrayList<Card>();
            for(Card card: handOfCards){
                if(card.getCardRank()==rank){
                    foundCards.add(card);
                }
            }
            
            removeRank(rank);
            
            return foundCards;
        }
        
        
        
        public boolean findSet(Rank rank){
            int count=0;
            for(Card card: handOfCards){
                if(card.getCardRank()==rank){
                    count++;
                }
            }
            return count==4;
        }
        
        public void removeRank(Rank rank){
            for(Card card: handOfCards){
                if(card.getCardRank() == rank){
                    removeCard(card);
                }
            }            
        }


	/**
	 * 
	 * @param inputCard
	 */
	public Card removeCard(Card inputCard) {
            
                if(handOfCards.contains(inputCard))
                    handOfCards.remove(inputCard);
                
                return inputCard;
	}

	/**
	 * 
	 * @param inputCard
	 */
	public void addCard(Card inputCard) {
            handOfCards.add(inputCard);
	}
        
        
        public void addCards(List<Card> inputCards){
            for(Card card: inputCards){
                addCard(card);
            }
        }

	public int getHandSize() {
            return handOfCards.size();
	}

}