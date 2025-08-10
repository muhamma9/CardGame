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
            this.players = new ArrayList<Player>();
            // create deck
            this.deck = new Deck();
            // shuffle deck
            deck.shuffle();
            // create players
            for(int i=0;i<numOfPlayers;i++){
                Scanner in = new Scanner(System.in);
                System.out.print("Enter the name for Player "+(i+1)+":");
                String pName=in.nextLine();
                players.add(new Player(pName));
                
                
                
            }
            // determine number of cards per player (7 cards for 2-3 players otherwise 5 cards) 
            int handSize = 0;
            if(numOfPlayers>3){
                handSize = 5;
                
            }else{
                handSize = 7;
            }
            // deal cards to the players
            for(Player player: players){
                for(int i=0;i<handSize;i++){
                    player.addCard(this.deck.dealCard());
                }
            }
            // deal the remaining cards to groupOfCards
            WonSets wonSets = new WonSets(players);
            GameState gameState = new GameState(players,wonSets);
            
            
            //play turns
            while(wonSets.amountSetsWon()<12){
                
            }
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