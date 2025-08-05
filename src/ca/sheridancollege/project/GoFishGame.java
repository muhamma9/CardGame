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
	private Collection<Array<Player>> players;

	/**
	 * the players of the game
	 */
	public GoFishGame() {
		// TODO - implement GoFishGame.GoFishGame
		throw new UnsupportedOperationException();
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