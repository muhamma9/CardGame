package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WonSets {

    private Map<Player, List<Rank>> playerWonSets;

    public WonSets(List<Player> playerList) {
        this.playerWonSets = new HashMap<>();
        for (Player player : playerList) {
            // Create a new, empty ArrayList for each player.
            playerWonSets.put(player, new ArrayList<>());
        }
    }
    
    public int amountSetsWon(){
        int total = 0;
        for (Map.Entry<Player, List<Rank>> entry : this.playerWonSets.entrySet()){
            total+=entry.getValue().size();
        }
        return total;
    }
    
    public int amountPlayerSetsWon(Player player){
        return this.playerWonSets.get(player).size();
    }

    /**
     *
     * @param player
     * @param rank
     */
    public void addWonSet(Player player, Rank rank) {
        this.playerWonSets.get(player).add(rank);
    }

    public String toString() {
        String sb="";
    for (Map.Entry<Player, List<Rank>> entry : this.playerWonSets.entrySet()) {
        Player player = entry.getKey();
        List<Rank> wonRanks = entry.getValue();
        sb+=player.toString();
        sb+=": ";
        sb+=wonRanks.toString();
        
        // Add a newline character to separate each player's entry
        sb+="\n";
    }
    return sb;
    }
    
    public Player getWinner() {
        Player winner = null;
        int maxSets = -1;

        for (Map.Entry<Player, List<Rank>> entry : playerWonSets.entrySet()) {
            if (entry.getValue().size() > maxSets) {
                maxSets = entry.getValue().size();
                winner = entry.getKey();
            }
        }
        return winner;
    }

}
