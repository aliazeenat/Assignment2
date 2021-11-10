package com.example.makharijalhuruf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Activity2 extends AppCompatActivity {

    private TextView score,question;
    private RadioGroup radiogroup;
    private RadioButton one,two,three;
    private Button next;

    int totalQuestions;
    int qCounter=0;
    int points;


    ColorStateList color;
    boolean answered;

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

        color= one.getTextColors();


        addmcqs();
        totalQuestions= mcqList.size();
        showNext();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered==false){
                    if(one.isChecked() || two.isChecked() || three.isChecked()){
                        checkAnswer();
                    }else{
                        Toast.makeText(Activity2.this, "Select an option", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    showNext();
                }
            }
        });
    }

    private void checkAnswer() {
        answered=true;
        RadioButton opSelected= findViewById(radiogroup.getCheckedRadioButtonId());
        int answerNo= radiogroup.indexOfChild(opSelected) + 1;
        if(answerNo==currentQuestion.getAnswer()){
            points++;
            score.setText("Score: " +points);
        }
        one.setTextColor(Color.RED);
        two.setTextColor(Color.RED);
        three.setTextColor(Color.RED);
        switch (currentQuestion.getAnswer()){
            case 1:
                one.setTextColor(Color.GREEN);
                break;
            case 2:
                two.setTextColor(Color.GREEN);
                break;
            case 3:
                three.setTextColor(Color.GREEN);
                break;
        }
        if(qCounter < totalQuestions){
            next.setText("Next");
        }else{
            next.setText("Finish");
        }
    }

    private void showNext() {

        radiogroup.clearCheck();;
        one.setTextColor(color);
        two.setTextColor(color);
        three.setTextColor(color);

        if(qCounter<totalQuestions){
            currentQuestion = mcqList.get(qCounter);
            question.setText(currentQuestion.getQues());
            one.setText(currentQuestion.getOption1());
            two.setText(currentQuestion.getOption2());
            three.setText(currentQuestion.getOption3());

            qCounter++;
            next.setText("Submit");
            answered=false;

        }else{
            finish();
        }
    }

    private void addmcqs() {
        mcqList.add(new mcq("ا","Halqiyah-End of Throat","Halqiyah-Middle of Throat","Halqiyah-Start of the Throat",1));
        mcqList.add(new mcq("ہ","Halqiyah-End of Throat","Halqiyah-Middle of Throat","Halqiyah-Start of the Throat",1));
        mcqList.add(new mcq("ع","Halqiyah-End of Throat","Halqiyah-Middle of Throat","Halqiyah-Start of the Throat",2));
        mcqList.add(new mcq("ح","Halqiyah-End of Throat","Halqiyah-Middle of Throat","Halqiyah-Start of the Throat",2));
        mcqList.add(new mcq("غ","Halqiyah-End of Throat","Halqiyah-Middle of Throat","Halqiyah-Start of the Throat",3));
        mcqList.add(new mcq("خ","Halqiyah-End of Throat","Halqiyah-Middle of Throat","Halqiyah-Start of the Throat",3));
        mcqList.add(new mcq("ق","Halqiyah-End of Throat","Lahatiyah-Base of Tongue which is near Uvula\n" +
                "\n" +
                "touching the mouth roof","Lahatiyah-Portion of Tongue near its base\n" +
                "touching the roof of mouth",2));
        mcqList.add(new mcq("ک","Halqiyah-Middle of Throat","Lahatiyah-Base of Tongue which is near Uvula\n" +
                "\n" +
                "touching the mouth roof","Lahatiyah-Portion of Tongue near its base\n" +
                "touching the roof of mouth",2));
        mcqList.add(new mcq("ج","","","",2));
        mcqList.add(new mcq("ش","","","",2));
        mcqList.add(new mcq("ی","","","",2));
        mcqList.add(new mcq("ض","","","",2));
        mcqList.add(new mcq("ل","","","",2));
        mcqList.add(new mcq("ن","","","",2));
        mcqList.add(new mcq("ر","","","",2));
        mcqList.add(new mcq("ت","","","",2));
        mcqList.add(new mcq("د","","","",2));
        mcqList.add(new mcq("ط","","","",2));
        mcqList.add(new mcq("ظ","","","",2));
        mcqList.add(new mcq("ذ","","","",2));
        mcqList.add(new mcq("ث","","","",2));
        mcqList.add(new mcq("ص","","","",2));
        mcqList.add(new mcq("ز","","","",2));
        mcqList.add(new mcq("س","","","",2));
        mcqList.add(new mcq("م","","","",2));
        mcqList.add(new mcq("ن","","","",2));
        mcqList.add(new mcq("ف","","","",2));
        mcqList.add(new mcq("ب","","","",2));
        mcqList.add(new mcq("م","","","",2));
        mcqList.add(new mcq("و","","","",2));
        mcqList.add(new mcq("باَ","","","",2));
        mcqList.add(new mcq("بوُ","","","",2));
        mcqList.add(new mcq("بیِ","","","",2));

    }
}