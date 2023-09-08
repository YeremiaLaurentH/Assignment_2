package com.example.assigment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView scoreTV;
    Button btn_count;
    EditText nameET;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreTV = findViewById(R.id.score);
        btn_count = findViewById(R.id.btn_count);
        nameET = findViewById(R.id.nameET);

        btn_count.setOnClickListener(this);

        if (savedInstanceState != null) {
            String count = savedInstanceState.getString("count");
            if (scoreTV != null)
                scoreTV.setText(count);
        }
    }

    @Override
    public void onClick(View view) {
        String currentScore = scoreTV.getText().toString();
        int currentScoreInt = Integer.valueOf(currentScore);
        score = currentScoreInt + 1;
        scoreTV.setText(String.valueOf(score));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("count", String.valueOf(scoreTV.getText()));
    }
}