package com.lifeistech.android.calculationfortraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinishActivity extends AppCompatActivity {
    int score = 0;
    TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        scoreTextView = (TextView) findViewById(R.id.score);

        score = getIntent().getIntExtra("score", 0);
        shownumbers();
    }

    public void clickchoose(View v){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }


    public void clickhome(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    void shownumbers() {
        scoreTextView.setText(String.valueOf(score));
    }

}
