package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_player);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void onclickSubmit(View v){
        EditText Name=findViewById(R.id.et_playername);
        String playerName=Name.getText().toString();
        RadioGroup Avator=findViewById(R.id.rg_avator);
        int selectedId = Avator.getCheckedRadioButtonId();

        /*hows error message if there's no input
        * */

        if (playerName.isEmpty()) {
            Name.setError("Please enter your name");
            return;
        }

        if (selectedId == -1) {   // nothing selected
            Toast.makeText(this, "Please select an avatar colour", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton selectedButton = findViewById(selectedId);
        String selectedColor = selectedButton.getText().toString();



        int score= getIntent().getIntExtra("score",0);

        Intent intent= new Intent(this, LeaderboardActivity.class);
        intent.putExtra("playerName",playerName);
        intent.putExtra("score",score);
        intent.putExtra("Avatar", selectedId);
        finish();
        startActivity(intent);
    }
}