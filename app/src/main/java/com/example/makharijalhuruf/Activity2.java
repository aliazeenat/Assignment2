package com.example.makharijalhuruf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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

        radiogroup.clearCheck();
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
            Intent i = new Intent(Activity2.this, Activity4.class);
            i.putExtra("key",points);
            startActivity(i);
        }
    }

    private void addmcqs() {

        Random r = new Random();
        int i = r.nextInt(7 - 1) + 1;

        if(i==1){
            mcqList.add(new mcq("ا","Halqiyah-End of Throat","Halqiyah-Middle of Throat","Halqiyah-Start of the Throat",1));
            mcqList.add(new mcq("ق","Halqiyah-End of Throat","Lahatiyah-Base of Tongue which is near Uvula\n" +
                    "\n" +
                    "touching the mouth roof","Lahatiyah-Portion of Tongue near its base\n" +
                    "touching the roof of mouth",2));
            mcqList.add(new mcq("ر","Tarfiyah-Rounded tip of the tongue touching the base of the frontal 8 teeth","Tarfiyah-Rounded tip of the tongue touching the base of the frontal 6 teeth","Tarfiyah-Rounded tip of the tongue and some portion near it touching the base of the frontal 4 teeth",3));
            mcqList.add(new mcq("بیِ","Mouth empty space while speaking words","Halqiyah-End of Throat","Halqiyah-Start of the Throat",1));
            mcqList.add(new mcq("ص","Shajariyah-Haafiyah-(Tongue touching the center of the mouth roof)","Lisaveyah-Tip of the tongue touching the tip of the frontal 2 teeth","Lisaveyah-Tip of the tongue comes between the front top and bottom teeth",3));
        }

        else if(i==2){
            mcqList.add(new mcq("ہ","Halqiyah-End of Throat","Halqiyah-Middle of Throat","Halqiyah-Start of the Throat",1));
            mcqList.add(new mcq("ک","Halqiyah-Middle of Throat","Lahatiyah-Base of Tongue which is near Uvula\n" +
                    "\n" +
                    "touching the mouth roof","Lahatiyah-Portion of Tongue near its base\n" +
                    "touching the roof of mouth",2));
            mcqList.add(new mcq("ض","Shajariyah-Haafiyah-(Tongue touching the center of the mouth roof)","Shajariyah-Haafiyah-(One side of the tongue touching the molar teeth)","Lahatiyah-(Base of Tongue which is near Uvula touching the mouth roof)",2));
            mcqList.add(new mcq("ل","Tarfiyah-Rounded tip of the tongue touching the base of the frontal 8 teeth","Tarfiyah-Rounded tip of the tongue touching the base of the frontal 6 teeth","Tarfiyah-Rounded tip of the tongue and some portion near it touching the base of the frontal 4 teeth",1));
            mcqList.add(new mcq("ب","Tip of the two upper jaw teeth touches the inner part of the lower lip","Inner part of the both lips touch each other","Outer part of both lips touch each other",2));
        }
        else if(i==3){
            mcqList.add(new mcq("خ","Halqiyah-End of Throat","Halqiyah-Middle of Throat","Halqiyah-Start of the Throat",3));
            mcqList.add(new mcq("ج","Shajariyah-Haafiyah-(Tongue touching the center of the mouth roof)","Shajariyah-Haafiyah-(One side of the tongue touching the molar teeth)","Lahatiyah-(Base of Tongue which is near Uvula touching the mouth roof)",1));
            mcqList.add(new mcq("ت","Tarfiyah-Rounded tip of the tongue touching the base of the frontal 6 teeth","Nit-eeyah(Tip of the tongue touching the base of the front 2 teeth)","Tarfiyah-Rounded tip of the tongue and some portion near it touching the base of the frontal 4 teeth",2));
            mcqList.add(new mcq("ظ","Lisaveyah-Tip of the tongue touching the tip of the frontal 2 teeth","Nit-eeyah(Tip of the tongue touching the base of the front 2 teeth)","Halqiyah-End of Throat",1));
            mcqList.add(new mcq("ن","Ghunna-While pronouncing the ending sound of  م  or ن , bring the vibration to the nose","Lisaveyah-Tip of the tongue touching the tip of the frontal 2 teeth","Halqiyah-Start of the Throat",1));
        }

       else if(i==4){
            mcqList.add(new mcq("غ","Halqiyah-End of Throat","Halqiyah-Middle of Throat","Halqiyah-Start of the Throat",3));
            mcqList.add(new mcq("ش","Shajariyah-Haafiyah-(Tongue touching the center of the mouth roof)","Shajariyah-Haafiyah-(One side of the tongue touching the molar teeth)","Lahatiyah-(Base of Tongue which is near Uvula touching the mouth roof)",1));
            mcqList.add(new mcq("ن","Tarfiyah-Rounded tip of the tongue touching the base of the frontal 8 teeth","Tarfiyah-Rounded tip of the tongue touching the base of the frontal 6 teeth","Tarfiyah-Rounded tip of the tongue and some portion near it touching the base of the frontal 4 teeth",2));
            mcqList.add(new mcq("ذ","Lisaveyah-Tip of the tongue touching the tip of the frontal 2 teeth","Nit-eeyah(Tip of the tongue touching the base of the front 2 teeth)","Halqiyah-End of Throat",1));
            mcqList.add(new mcq("بوُ","Mouth empty space while speaking words","Halqiyah-End of Throat","Halqiyah-Start of the Throat",1));

        }

       else if(i==5){
            mcqList.add(new mcq("ح","Halqiyah-End of Throat","Halqiyah-Middle of Throat","Halqiyah-Start of the Throat",2));
            mcqList.add(new mcq("ی","Shajariyah-Haafiyah-(Tongue touching the center of the mouth roof)","Shajariyah-Haafiyah-(One side of the tongue touching the molar teeth)","Lahatiyah-(Base of Tongue which is near Uvula touching the mouth roof)",1));
            mcqList.add(new mcq("و","Tip of the two upper jaw teeth touches the inner part of the lower lip","Inner part of the both lips touch each other","Rounding both lips and not closing the mouth",3));
            mcqList.add(new mcq("باَ","Mouth empty space while speaking word","Halqiyah-End of Throat","Halqiyah-Start of the Throat",1));
            mcqList.add(new mcq("ف","Tip of the two upper jaw teeth touches the inner part of the lower lip","Inner part of the both lips touch each other","Outer part of both lips touch each other",1));
        }

       else if(i==6){
            mcqList.add(new mcq("ع","Halqiyah-End of Throat","Halqiyah-Middle of Throat","Halqiyah-Start of the Throat",2));
            mcqList.add(new mcq("ث","Lisaveyah-Tip of the tongue touching the tip of the frontal 2 teeth","Nit-eeyah(Tip of the tongue touching the base of the front 2 teeth)","Halqiyah-End of Throat",1));
            mcqList.add(new mcq("س","Shajariyah-Haafiyah-(Tongue touching the center of the mouth roof)","Lisaveyah-Tip of the tongue touching the tip of the frontal 2 teeth","Lisaveyah-Tip of the tongue comes between the front top and bottom teeth",3));
            mcqList.add(new mcq("م","Tip of the two upper jaw teeth touches the inner part of the lower lip","Inner part of the both lips touch each other","Outer part of both lips touch each other",3));
            mcqList.add(new mcq("ز","Shajariyah-Haafiyah-(Tongue touching the center of the mouth roof)","Lisaveyah-Tip of the tongue touching the tip of the frontal 2 teeth","Lisaveyah-Tip of the tongue comes between the front top and bottom teeth",3));

        }

    }
}