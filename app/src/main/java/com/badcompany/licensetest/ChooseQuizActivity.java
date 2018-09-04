package com.badcompany.licensetest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by Donatas on 26/08/2018.
 */


public class ChooseQuizActivity extends Activity {
    private Button btn_exam, btn_quiz, btn_quiz_two, btn_quiz_4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_choose_quiz);

        btn_exam = (Button) findViewById(R.id.chz_quiz_1);
        btn_quiz = (Button) findViewById(R.id.chz_quiz_3);
        btn_quiz_two = (Button) findViewById(R.id.chz_quiz_2);
        btn_quiz_4 = (Button) findViewById(R.id.chz_quiz_4);

        btn_exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    btn_exam.setEnabled(false);
                    Intent intent = new Intent(getApplicationContext(), ExamActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btn_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    btn_quiz.setEnabled(false);
                    Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btn_quiz_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    btn_quiz_two.setEnabled(false);
                    Intent intent = new Intent(getApplicationContext(),QuizTwoActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btn_quiz_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    btn_quiz_4.setEnabled(false);
                    Intent intent = new Intent(getApplicationContext(), QuizByCatActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });




    }
}
