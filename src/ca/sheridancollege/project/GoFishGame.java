package ca.sheridancollege.project;

import java.util.*;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 * 
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public abstract class GoFishGame {

	/**
	 * the title of the game
	 */
	private List<Player> players;
        private Deck deck;

	/**
	 * the players of the game
	 */
	public GoFishGame(int numOfPlayers) {
            // create deck
            // shuffle deck
            // create players
            // determine number of cards per player (7 cards for 2-3 players otherwise 5 cards) 
            // deal cards to the players
            // deal the remaining cards to groupOfCards
            
            
            //play turns
                // player turn
                // check game state
            
            //declare winner
                
	}

	/**
	 * Play the game. This might be one method or many method calls depending on your game.
	 */
	public abstract void play();

	/**
	 * When the game is over, use this method to declare and display a winning player.
	 */
	public abstract void declareWinner();

}