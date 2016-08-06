package com.lifeistech.android.calculationfortraining;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Random;


public class AddActivity extends AppCompatActivity implements View.OnClickListener {
    final int TIME_LIMIT = 10000;
    int number1;
    int number2;
    int Answer;
    int clearCount;
    int timer;


    TextView number1TextView;
    TextView number2TextView;
    TextView clearTextView;
    TextView timerTextView;
    Button[] buttons;

    Random r = new Random();
    CountDown countDown;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        buttons = new Button[31];
        buttons[0] = (Button) findViewById(R.id.button0);
        buttons[1] = (Button) findViewById(R.id.button1);
        buttons[2] = (Button) findViewById(R.id.button2);
        buttons[3] = (Button) findViewById(R.id.button3);
        buttons[4] = (Button) findViewById(R.id.button4);
        buttons[5] = (Button) findViewById(R.id.button5);
        buttons[6] = (Button) findViewById(R.id.button6);
        buttons[7] = (Button) findViewById(R.id.button7);
        buttons[8] = (Button) findViewById(R.id.button8);
        buttons[9] = (Button) findViewById(R.id.button9);
        buttons[10] = (Button) findViewById(R.id.button10);
        buttons[11] = (Button) findViewById(R.id.button11);
        buttons[12] = (Button) findViewById(R.id.button12);
        buttons[13] = (Button) findViewById(R.id.button13);
        buttons[14] = (Button) findViewById(R.id.button14);
        buttons[15] = (Button) findViewById(R.id.button15);
        buttons[16] = (Button) findViewById(R.id.button16);
        buttons[17] = (Button) findViewById(R.id.button17);
        buttons[18] = (Button) findViewById(R.id.button18);
        buttons[19] = (Button) findViewById(R.id.button19);
        buttons[20] = (Button) findViewById(R.id.button20);
        buttons[21] = (Button) findViewById(R.id.button21);
        buttons[22] = (Button) findViewById(R.id.button22);
        buttons[23] = (Button) findViewById(R.id.button23);
        buttons[24] = (Button) findViewById(R.id.button24);
        buttons[25] = (Button) findViewById(R.id.button25);
        buttons[26] = (Button) findViewById(R.id.button26);
        buttons[27] = (Button) findViewById(R.id.button27);
        buttons[28] = (Button) findViewById(R.id.button28);
        buttons[29] = (Button) findViewById(R.id.button29);
        buttons[30] = (Button) findViewById(R.id.button30);

        for(int i = 0; i < buttons.length; i++) {
            buttons[i].setTag(String.valueOf(i));
            buttons[i].setOnClickListener(this);
        }

        number1TextView = (TextView) findViewById(R.id.number1);
        number2TextView = (TextView) findViewById(R.id.number2);
        clearTextView = (TextView) findViewById(R.id.clear_textview);
        timerTextView = (TextView) findViewById(R.id.timer);



        createNumber();
        createTimer();
        countDown.start();

    }

    // 問題を作るメソッド
    protected void createNumber() {
        number1 = r.nextInt(21);
        number2 = r.nextInt(10);
        shownumbers();
        clearbuutons();
    }

    void shownumbers() {
        number1TextView.setText(String.valueOf(number1));
        number2TextView.setText(String.valueOf(number2));
        clearTextView.setText(String.valueOf(clearCount));
        timerTextView.setText(String.valueOf(countDown));
    }

    void clearbuutons(){
        for(int i = 0; i < buttons.length; i++) {
            buttons[i].setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public void onClick(View view) {
        int number = Integer.valueOf(view.getTag().toString());
        Answer = number1 + number2;
        if (Answer == number) {
            //カウントする
            clearCount++;
            clearTextView.setText(String.valueOf(clearCount));
            //次のランダムの数字を発生・表示させる
            createNumber();
        } else {
            //色を変更する
            view.setBackgroundColor(Color.RED);
        }
    }


    //カウントダウン
    private void createTimer() {
        //ミリ秒で設定する 1秒なら1000。
        countDown = new CountDown(TIME_LIMIT, 10); // <- (設定する合計時間, 何秒おきに数えるか)
        countDown.setOnFinishListener(new CountDown.OnFinishListener() {
            @Override
            public void onFinish() {
                Intent intent = new Intent(getApplicationContext(), FinishActivity.class);
                intent.putExtra("score", clearCount);
                startActivity(intent);

            }
        });

        countDown.setOnTickListener(new CountDown.OnTickListener() {
            @Override
            public void onTick(long l) {
                Log.d("timer", ((l / 1000) + "." + (l / 100)  + (l / 10) ));

                SimpleDateFormat sdf = new SimpleDateFormat("ss:SS");

                String time = sdf.format(l);
                timerTextView.setText(time);
            }
        });
    }
}
