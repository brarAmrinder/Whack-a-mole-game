package com.example.assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Leaderboard class that stores and manages Player scores.
 */
public class Leaderboard {

    /** declare variables  */
    private static Leaderboard leaderboardInstance;

    private final ArrayList<Player> leaderboard;
 /** Maximum number of players to keep */
    private static final int MAX_LEADERBOARD_SIZE = 5;



    /**Constructor */
    private Leaderboard() {
        leaderboard = new ArrayList<>();
    }

    /**Methods*/

    /** Get the single Leaderboard instance */
    public static Leaderboard getInstance() {
        if (leaderboardInstance == null) {
            leaderboardInstance = new Leaderboard();
        }
        return leaderboardInstance;
    }

    /**
     * Add or update a player in the leaderboard.
     * Keeps the list sorted by highest score and trims to the max size.
     *
     * @param newPlayer The player to insert/update.
     */
    public void updateLeaderboard(Player newPlayer) {
        // Check if this player already exists (by name)
        boolean updated = false;
        for (Player p : leaderboard) {
            if (p.getPlayerName().equals(newPlayer.getPlayerName())) {
                // Keep the higher score
                if (newPlayer.getPlayerScore() > p.getPlayerScore()) {
                    leaderboard.remove(p);
                    leaderboard.add(newPlayer);
                }
                updated = true;
                break;
            }
        }

        if (!updated) {
            leaderboard.add(newPlayer);
        }

        // Sort by score descending
        Collections.sort(leaderboard, new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                return Integer.compare(p2.getPlayerScore(), p1.getPlayerScore());
            }
        });

        // Keep only top N scores
        if (leaderboard.size() > MAX_LEADERBOARD_SIZE) {
            leaderboard.subList(MAX_LEADERBOARD_SIZE, leaderboard.size()).clear();
        }
    }

    /**
     * Get the current leaderboard list.
     * @return a copy of the leaderboard (to prevent outside modification)
     */
    public ArrayList<Player> getLeaderboard() {
        return new ArrayList<>(leaderboard);
    }
}

