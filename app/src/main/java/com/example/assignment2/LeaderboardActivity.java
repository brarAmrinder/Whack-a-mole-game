package com.example.assignment2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

/**
 * LeaderboardActivity displays the top players,
 * showing their avatar, name, and score.
 */
public class LeaderboardActivity extends AppCompatActivity {


    private ImageView[] avatarViews;
    private TextView[] nameViews;
    private TextView[] scoreViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_leaderboard);

        /**
        Bind the five leaderboard row views to arrays so they
          can be updated in a simple loop. */
        avatarViews = new ImageView[] {
                findViewById(R.id.iv_leaderboard_avatar1),
                findViewById(R.id.iv_leaderboard_avatar2),
                findViewById(R.id.iv_leaderboard_avatar3),
                findViewById(R.id.iv_leaderboard_avatar4),
                findViewById(R.id.iv_leaderboard_avatar5)
        };

        nameViews = new TextView[] {
                findViewById(R.id.tv_leaderboard_name1),
                findViewById(R.id.tv_leaderboard_name2),
                findViewById(R.id.tv_leaderboard_name3),
                findViewById(R.id.tv_leaderboard_name4),
                findViewById(R.id.tv_leaderboard_name5)
        };

        scoreViews = new TextView[] {
                findViewById(R.id.tv_leaderboard_score1),
                findViewById(R.id.tv_leaderboard_score2),
                findViewById(R.id.tv_leaderboard_score3),
                findViewById(R.id.tv_leaderboard_score4),
                findViewById(R.id.tv_leaderboard_score5)
        };

        /**
       Retrieve leaderboard data and display it in the rows.*/
        Leaderboard leaderboard = Leaderboard.getInstance();
        ArrayList<Player> players = leaderboard.getLeaderboard();


        for (int i = 0; i < 5; i++) {
            if (i < players.size()) {
                Player player = players.get(i);
                avatarViews[i].setImageResource(player.getPlayerAvatar());
                nameViews[i].setText(player.getPlayerName());
                scoreViews[i].setText(String.valueOf(player.getPlayerScore()));
            } else {
                // Empty slot
                avatarViews[i].setImageDrawable(null);
                nameViews[i].setText("");
                scoreViews[i].setText("");
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
