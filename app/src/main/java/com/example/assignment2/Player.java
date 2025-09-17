package com.example.assignment2;

import android.graphics.drawable.Drawable;

/**
 * com.example.assignment2.Player class represents a player in the game.
 * It stores the player's name, avatar image, and current score.
 */
public class Player {

    /**Declaring variables */
    private String playerName;
    private Drawable playerAvatar;
    private int playerScore;

    /**Constructor */
    public Player(String name, Drawable avatar, int score){

        this.playerName=name;
        this.playerAvatar=avatar;
        this.playerScore=score;
    }

    /**Getters*/

    public String getPlayerName(){
        return playerName;
    }

    public Drawable getPlayerAvatar(){
        return playerAvatar;
    }

    public int getPlayerScore(){
        return playerScore;
    }


}
