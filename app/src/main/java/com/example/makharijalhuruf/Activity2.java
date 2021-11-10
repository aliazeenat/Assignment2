package com.example.makharijalhuruf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Activity2 extends AppCompatActivity {

    private TextView score,question;
    private RadioGroup radiogroup;
    private RadioButton one,two,three;
    private Button next;

    int totalQuestions;
    int qCounter=0;

    private mcq currentQuestion;

    private List<mcq> mcqList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        mcqList = new ArrayList<>();
        question = findViewById(R.id.question);
        score = findViewById(R.id.score);
        radiogroup= findViewById(R.id.group);
        one= findViewById(R.id.option1);
        two= findViewById(R.id.option2);
        three= findViewById(R.id.option3);
        next= findViewById(R.id.next);

        addmcqs();
        totalQuestions= mcqList.size();
        showNext();
    }

    private void showNext() {
        if(qCounter<totalQuestions){
            currentQuestion = mcqList.get(qCounter);
            question.setText(currentQuestion.getQues());
            one.setText(currentQuestion.getOption1());
            two.setText(currentQuestion.getOption2());
            three.setText(currentQuestion.getOption3());

            qCounter++;
        }else{
            finish();
        }
    }

    private void addmcqs() {
        mcqList.add(new mcq("","","","",2));
        mcqList.add(new mcq("","","","",2));
        mcqList.add(new mcq("","","","",2));
        mcqList.add(new mcq("","","","",2));
        mcqList.add(new mcq("","","","",2));
        mcqList.add(new mcq("","","","",2));
        mcqList.add(new mcq("","","","",2));
        mcqList.add(new mcq("","","","",2));
        mcqList.add(new mcq("","","","",2));
        mcqList.add(new mcq("","","","",2));
        mcqList.add(new mcq("","","","",2));
        mcqList.add(new mcq("","","","",2));
        mcqList.add(new mcq("","","","",2));
        mcqList.add(new mcq("","","","",2));
        mcqList.add(new mcq("","","","",2));
        mcqList.add(new mcq("","","","",2));
        mcqList.add(new mcq("","","","",2));



    }
}