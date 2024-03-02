package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int flag = 0;
    int count = 0;
    private TextView btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private MaterialButton restartBtn;
    private TextView scoreBoardX, scoreBoardO, winnerId;
    private int scoreX = 0;
    private int scoreO = 0;
    private RelativeLayout winLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        restartBtn = findViewById(R.id.restartBtn);
        scoreBoardX = findViewById(R.id.scoreX);
        scoreBoardO = findViewById(R.id.scoreO);
        winLayout = findViewById(R.id.winLayout);
        winnerId = findViewById(R.id.winnerId);

        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                winLayout.setVisibility(View.GONE);
                RestartGame();
                count = 0;

                Random random = new Random();
                flag = random.nextInt(2);
            }
        });

    }

    public void check(View view) {
        TextView currentItem = (TextView) view;

        if (currentItem.getText().toString().equals("")) {

            count++;
            if (flag == 0) {
                currentItem.setText("X");
                flag = 1;
            } else {
                currentItem.setText("O");
                flag = 0;
            }


            //*
            if (count > 4) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                //CONDITION******
                //horizontal
                if (!b1.equals("") && b1.equals(b2) && b2.equals(b3)) {
                    Winner(b1);

                } else if (!b4.equals("") && b4.equals(b5) && b5.equals(b6)) {
                    Winner(b4);

                } else if (!b7.equals("") && b7.equals(b8) && b8.equals(b9)) {
                    Winner(b7);
                }

                //vertical
                else if (!b1.equals("") && b1.equals(b4) && b4.equals(b7)) {
                    Winner(b1);

                } else if (!b2.equals("") && b2.equals(b5) && b5.equals(b8)) {
                    Winner(b2);

                } else if (!b3.equals("") && b3.equals(b6) && b6.equals(b9)) {
                    Winner(b3);
                }

                //cross
                else if (!b1.equals("") && b1.equals(b5) && b5.equals(b9)) {
                    Winner(b1);

                } else if (!b3.equals("") && b3.equals(b5) && b5.equals(b7)) {
                    Winner(b3);

                } else if (count == 9) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            winLayout.setVisibility(View.VISIBLE);
                            winnerId.setText("DRAW!");
                            RestartGame();
                        }
                    }, 1000);
                }

            }
        }

    }

    private void Winner(String winner) {
        if (winner.equals("X")) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ++scoreX;
                    scoreBoardX.setText("Score X : " + scoreX);
                    scoreBoardO.setText("Score O : " + scoreO);
                    winLayout.setVisibility(View.VISIBLE);
                    winnerId.setText("WINNER " + winner);
                    RestartGame();
                }
            }, 1000);


        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ++scoreO;
                    scoreBoardX.setText("Score X : " + scoreX);
                    scoreBoardO.setText("Score O : " + scoreO);
                    winLayout.setVisibility(View.VISIBLE);
                    winnerId.setText("WINNER " + winner);
                    RestartGame();
                }
            }, 1000);
        }
    }

    private void RestartGame() {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
    }


}