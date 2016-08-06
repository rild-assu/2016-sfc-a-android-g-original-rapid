package com.lifeistech.android.calculationfortraining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickStart(View v) {
        //画面の移動（インテント）
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }


}



