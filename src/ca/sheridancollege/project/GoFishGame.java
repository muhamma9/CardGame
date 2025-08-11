package ca.sheridancollege.project;

import java.util.*;

/**
 * The class that models your game. You should create a more specific child of
 * this class and instantiate the methods given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class GoFishGame {

    /**
     * the title of the game
     */
    private List<Player> players;
    private Deck deck;

    /**
     * the players of the game
     */
    public GoFishGame(int numOfPlayers, Scanner in) {
        this.players = new ArrayList<Player>();
        // create deck
        this.deck = new Deck();
        // shuffle deck
        deck.shuffle();
        // create players
        in.nextLine();
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.print("Enter the name for Player " + (i + 1) + ":");
            String pName = in.nextLine();
            players.add(new Player(pName));

        }
        // determine number of cards per player (7 cards for 2-3 players otherwise 5 cards) 
        int handSize = 0;
        if (numOfPlayers > 3) {
            handSize = 5;

        } else {
            handSize = 7;
        }
        // deal cards to the players
        for (Player player : players) {
            for (int i = 0; i < handSize; i++) {
                player.addCard(this.deck.dealCard());
            }
        }

    }

    public void run(Scanner in) {
        // deal the remaining cards to groupOfCards
        WonSets wonSets = new WonSets(this.players);
        GameState gameState = new GameState(this.players, wonSets);

        int playerIndex = 0;
        //play turns
        System.out.println("Game has begun!");
        while (wonSets.amountSetsWon() < 12) {
            System.out.println(gameState);

            Player currentPlayer = players.get(playerIndex);
            System.out.println(currentPlayer + "'s turn.");
            System.out.println("Your hand: " + currentPlayer.getHand());

            // Player chooses who to ask
            System.out.println("Which player would you like to ask for a card?");
            for (int i = 0; i < players.size(); i++) {
                if (i != playerIndex) {
                    System.out.println((i + 1) + ": " + players.get(i));
                }
            }
            int targetPlayerIndex = in.nextInt() - 1;
            in.nextLine();
            Player targetPlayer = players.get(targetPlayerIndex);

            // Player chooses what rank to ask for
            System.out.println("What rank would you like to ask for?");
            for (int i = 0; i < Rank.values().length; i++) {
                if (Rank.values()[i] != Rank.JOKER) {
                    System.out.println((i + 1) + ": " + Rank.values()[i]);
                }
            }
            int rankIndex = in.nextInt() - 1;
            in.nextLine();
            Rank requestedRank = Rank.values()[rankIndex];

            if (!currentPlayer.askForCard(targetPlayer, requestedRank)) {
                if (!deck.isEmpty()) {
                    Card drawnCard = deck.dealCard();
                    System.out.println(currentPlayer + " drew a " + drawnCard);
                    currentPlayer.addCard(drawnCard);
                } else {
                    System.out.println("The deck is empty.");
                }
            }

            // Check for and award sets
            if (currentPlayer.findWonSet(requestedRank)) {
                wonSets.addWonSet(currentPlayer, requestedRank);
                System.out.println(currentPlayer + " has completed a set of " + requestedRank + "s!");
            }

            playerIndex = (playerIndex + 1) % players.size();
        }

        //declare winner
        Player winner = wonSets.getWinner();
        System.out.println("The winner is " + winner + " with " + wonSets.amountPlayerSetsWon(winner) + " sets!");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int playerCount = 0;

        System.out.println("--- Welcome to Go Fish! ---");
        System.out.print("Please enter the playercount:");
        playerCount = in.nextInt();
 
        GoFishGame gfg = new GoFishGame(playerCount, in);
        gfg.run(in);
        in.close();
        
        

    }
}
