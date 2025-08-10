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
        StringBuilder sb = new StringBuilder();

        sb.append("--- CURRENT GAME STATE ---\n");
        sb.append("Timestamp: ").append(java.time.LocalDateTime.now().toString()).append("\n\n");

        // Section for Player Hand Sizes
        sb.append("Player Hand Sizes:\n");
        sb.append("--------------------\n");
        if (playerHandSize.isEmpty()) {
            sb.append("No players in the game.\n");
        } else {
            for (Map.Entry<Player, Integer> entry : this.playerHandSize.entrySet()) {
                sb.append(entry.getKey().toString()) // Player's name
                  .append(": ")
                  .append(entry.getValue()) // Hand size
                  .append(" cards\n");
            }
        }
        
        sb.append("\n"); // Add a blank line for spacing

        // Section for Won Sets
        sb.append("Won Sets:\n");
        sb.append("--------------------\n");
        if (this.wonSets == null) {
            sb.append("Won sets information is not available.\n");
        } else {
            // We can reuse the excellent toString() method we wrote for WonSets
            sb.append(this.wonSets.toString());
        }
        
        sb.append("--------------------------\n");

        return sb.toString();
    }
}