package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LeaderboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_leaderboard);
        Intent intent = getIntent();
        String playerName = intent.getStringExtra("playerName");
        int score = intent.getIntExtra("score", 0);

        TextView tvName1 = findViewById(R.id.tv_leaderboard_name1);
        TextView tvScore1 = findViewById(R.id.tv_leaderboard_score1);

        TextView tvName2 = findViewById(R.id.tv_leaderboard_name2);
        TextView tvScore2 = findViewById(R.id.tv_leaderboard_score2);

        TextView tvName3 = findViewById(R.id.tv_leaderboard_name3);
        TextView tvScore3 = findViewById(R.id.tv_leaderboard_score3);

        TextView tvName4 = findViewById(R.id.tv_leaderboard_name4);
        TextView tvScore4 = findViewById(R.id.tv_leaderboard_score4);

        TextView tvName5 = findViewById(R.id.tv_leaderboard_name5);
        TextView tvScore5 = findViewById(R.id.tv_leaderboard_score5);

        tvName1.setText(playerName);
        tvScore1.setText(String.valueOf(score));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


}