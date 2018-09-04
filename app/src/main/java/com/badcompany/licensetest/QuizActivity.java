package com.badcompany.licensetest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Donatas on 26/08/2018.
 */

public class QuizActivity extends Activity {
    List<Question> questionsList = new ArrayList<>();
    Button AnswerA, AnswerB, AnswerC, AnswerD;
    ImageView imageView;
    TextView questionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_quiz);
        AnswerA = (Button)findViewById(R.id.btn_quizA);
        AnswerB = (Button)findViewById(R.id.btn_quizB);
        AnswerC = (Button)findViewById(R.id.btn_quizC);
        AnswerD = (Button)findViewById(R.id.btn_quizD);
        questionText = (TextView)findViewById(R.id.question);
        imageView = (ImageView)findViewById(R.id.photo);
        DatabaseHelper helper = new DatabaseHelper(this);
        questionsList = helper.getAllQuestions();

        int i = 1;

        questionText.setText(questionsList.get(i).getQuestion());
        AnswerA.setText(questionsList.get(i).getAnswera());
        AnswerB.setText(questionsList.get(i).getAnswerb());
        AnswerC.setText(questionsList.get(i).getAnswerc());
        AnswerD.setText(questionsList.get(i).getAnswerd());

    }
}