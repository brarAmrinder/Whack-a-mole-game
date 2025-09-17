package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
/**
 * MainActivity is the entry point of the app.
 * It displays the main menu with options to play the game
 * or view the leaderboard.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Called when the activity is first created.
     * Sets up edge-to-edge display and inflates the layout.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    /**
     * Called when the "Play" button is clicked.
     * Starts the GameActivity.
     */
    public void onClickPlay(View v){
        Intent intent= new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    /**
     * Called when the "Leaderboard" button is clicked.
     * Starts the LeaderboardActivity.
     */
    public void onClickLeaderboard(View v){
        Intent intent= new Intent(this, LeaderboardActivity.class);
        startActivity(intent);
    }

}