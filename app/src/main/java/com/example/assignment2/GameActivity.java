package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.ImageView;
import android.widget.TextView;
import android.os.CountDownTimer;

import java.util.ArrayList;

/**
 * GameActivity handles the main gameplay screen.
 * Responsibilities include:
 * - Displaying the timer and score
 * - Managing mole ImageViews and their click events
 * - Starting the game logic through GameLogic class
 * - Navigating to PlayerActivity when the game ends
 */
public class GameActivity extends AppCompatActivity {
    private TextView tvTimer, tvScore;
    private GameLogic gameLogic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);

        // Initialize timer and score TextViews
        tvTimer = findViewById(R.id.tv_timer_text);
        tvScore = findViewById(R.id.tv_score_text);

        // Initialize the 3x3 grid of mole ImageViews
        ArrayList<ImageView> moleViews = new ArrayList<>();
        moleViews.add(findViewById(R.id.iv_without_mole_01));
        moleViews.add(findViewById(R.id.iv_without_mole_02));
        moleViews.add(findViewById(R.id.iv_without_mole_03));
        moleViews.add(findViewById(R.id.iv_without_mole_04));
        moleViews.add(findViewById(R.id.iv_without_mole_05));
        moleViews.add(findViewById(R.id.iv_without_mole_06));
        moleViews.add(findViewById(R.id.iv_without_mole_07));
        moleViews.add(findViewById(R.id.iv_without_mole_08));
        moleViews.add(findViewById(R.id.iv_without_mole_09));

        // Initialize game logic with the mole views, score, and timer
        gameLogic = new GameLogic(this, moleViews, tvScore, tvTimer);

        // Set a listener for game over event to navigate to PlayerActivity
        gameLogic.setGameOverListener(finalScore -> {
            Intent intent = new Intent(GameActivity.this, PlayerActivity.class);
            intent.putExtra("score", finalScore);
            startActivity(intent);
            finish();
        });

        // Set click listeners for all ImageViews
        for (int i = 0; i < moleViews.size(); i++) {
            final int index = i;
            moleViews.get(i).setOnClickListener(v -> gameLogic.hitMole(index));
        }

        //start the game
        gameLogic.startGame();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }


    }

