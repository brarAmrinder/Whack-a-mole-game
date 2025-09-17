package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;
import android.os.CountDownTimer;


public class GameActivity extends AppCompatActivity {
    private TextView tvTimer, tvScore;
    private CountDownTimer countDownTimer;
    private int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);

        // link TextViews from layout
        tvTimer = findViewById(R.id.tv_timer_text);
        tvScore = findViewById(R.id.tv_score_text);

        // start 30-second countdown timer
        startTimer();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void startTimer() {
        countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText("Timer: " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                tvTimer.setText("Timer: 0");

                // go to PlayerActivity when timer ends
                Intent intent = new Intent(GameActivity.this, PlayerActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();
    }

}