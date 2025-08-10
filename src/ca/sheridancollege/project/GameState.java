package ca.sheridancollege.project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameState {

    private Map<Player, Integer> playerHandSize;
    private WonSets wonSets;

    /**
     * Constructs a snapshot of the current game state.
     * @param players The list of players currently in the game.
     * @param wonSets The current WonSets object for the game.
     */
    public GameState(List<Player> players, WonSets wonSets) {
        this.playerHandSize = new HashMap<>();
        for (Player player : players) {
            this.playerHandSize.put(player, player.getHandSize());
        }

        this.wonSets = wonSets;
    }

    /**
     * Generates a string representation of the entire game state,
     * including hand sizes and all won sets.
     */
    @Override
    public String toString() {
        String gs = "";

        gs+="--- CURRENT GAME STATE ---\n";
        gs+="Timestamp: "+java.time.LocalDateTime.now().toString()+"\n\n";

        // Section for Player Hand Sizes
        gs+="Player Hand Sizes:\n";
        gs+="--------------------\n";
        if (playerHandSize.isEmpty()) {
            gs+="No players in the game.\n";
        } else {
            for (Map.Entry<Player, Integer> entry : this.playerHandSize.entrySet()) {
                gs+=entry.getKey().toString() // Player's name
                  +": "
                  +entry.getValue() // Hand size
                  +" cards\n";
            }
        }
        
        gs+="\n"; // Add a blank line for spacing

        // Section for Won Sets
        gs+="Won Sets:\n";
        gs+="--------------------\n";
        if (this.wonSets == null) {
            gs+="Won sets information is not available.\n";
        } else {
            // We can reuse the excellent toString() method we wrote for WonSets
            gs+=this.wonSets.toString();
        }
        
        gs+="--------------------------\n";

        return gs;
    }
}