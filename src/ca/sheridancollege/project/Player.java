package ca.sheridancollege.project;

import java.util.List;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 * 
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class Player {

	private Hand playerHand;
	private String name;

	/**
	 * A constructor that allows you to set the player's unique ID
	 * @param name the unique ID to assign to this player.
	 */
	public Player(String name) {
		// TODO - implement Player.Player
                this.name = name;
                this.playerHand = new Hand();
	}

	public void play(){
            
            //ask for card
            //check if set is complete
            //if set is complete, add to won sets
            
        }
        
        public boolean askForCard(Player otherPlayer, Rank rank){
            List<Card> cards = otherPlayer.giveCard(rank);
            playerHand.addCards(cards);
            if(cards.size() == 0){
                System.out.println("Go Fish");
                return false;
            }
            return true;
        }
        
        public boolean findWonSet(Rank rank){
            return playerHand.findSet(rank);
        }
        
        public List<Card> giveCard(Rank rank){
            return playerHand.findCardsByRank(rank);
        }

}