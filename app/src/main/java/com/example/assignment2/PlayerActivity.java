package com.example.assignment2;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.assignment2.R;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * PlayerActivity
 * This activity allows the player to:
 *  - Enter their name
 *  - Select an avatar from a RadioGroup
 *  - Submit data to update the leaderboard
 */
public class PlayerActivity extends AppCompatActivity {

    /** UI references */
    private TextView tv_playerscore;
    private EditText et_playername;
    private RadioGroup rg_avatar;
    private int finalScore;
    private Leaderboard leaderboardInstance;
    int avatarResId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_player);

        /** Initialize views */
        tv_playerscore = findViewById(R.id.tv_playerscore);
        et_playername = findViewById(R.id.et_playername);
        rg_avatar = findViewById(R.id.rg_avator);

        /** Get the final score from the previous activity */
        finalScore = getIntent().getIntExtra("score", 0);
        tv_playerscore.setText("Score: " + finalScore);

        leaderboardInstance = Leaderboard.getInstance();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;



        });
    }

    /**
     * Called when the Submit button is clicked.
     * Validates input, creates a Player, updates leaderboard, and navigates to LeaderboardActivity.
     */
    public void onclickSubmit(View v){

        String playerName=et_playername.getText().toString();
        int selectedId = rg_avatar.getCheckedRadioButtonId();

        /** shows error message if there's no input
        */

        if (playerName.isEmpty()) {
            et_playername.setError("Please enter your name");
            return;
        }

        if (selectedId == -1) {
            Toast.makeText(this, "Please select an avatar colour", Toast.LENGTH_SHORT).show();
            return;
        }



        if (selectedId == R.id.radio_grey) {
            avatarResId = R.drawable.img_grey_mole;
        }
        else if (selectedId == R.id.radio_blue) {
            avatarResId = R.drawable.img_blue_mole;
        }
        else if (selectedId == R.id.radio_orange) {
            avatarResId = R.drawable.img_orange_mole;
        }
        else if (selectedId == R.id.radio_green) {
            avatarResId = R.drawable.img_green_mole;
        }
        else if (selectedId == R.id.radio_purple) {
            avatarResId = R.drawable.img_purple_mole;
        }
        else if (selectedId == R.id.radio_pink) {
            avatarResId = R.drawable.img_pink_mole;
        }
        else {
            avatarResId = R.drawable.img_grey_mole;
        }
        /** Create Player object */
        Player player = new Player(playerName, avatarResId, finalScore);
        leaderboardInstance.updateLeaderboard(player);



        /** Navigate to Leaderboard page */

        Intent intent= new Intent(this, LeaderboardActivity.class);
        startActivity(intent);
        finish();
    }
}