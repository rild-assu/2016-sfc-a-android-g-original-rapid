package com.lifeistech.android.calculationfortraining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }


    public void clickaddten(View v) {
        //画面の移動（インテント）
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }


    public void clicksubten(View v) {
        //画面の移動（インテント）
        Intent intent = new Intent(this, SubActivity.class);
        startActivity(intent);
    }


    public void clickmulten(View v) {
        //画面の移動（インテント）
        Intent intent = new Intent(this, MulActivity.class);
        startActivity(intent);
    }
}







