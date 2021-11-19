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

public class Activity4 extends AppCompatActivity {

    private ImageButton share;
    private TextView point;
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            score = extras.getInt("key");

        }

        share = findViewById(R.id.sharee);
        point = findViewById(R.id.points);

        point.setText("\n Total Score: 5 \n Obtained Score: "+score);
        String marks= Integer.toString(score);
        String totalMarks=" Total Marks: 5 ";

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i= new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                String shareBody="RESULT\n"+totalMarks + "\n Obtained Marks: "+ marks;
                String Subject="Result\n";
                i.putExtra(Intent.EXTRA_SUBJECT,Subject);
                i.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(i,"Share using..."));
            }
        });
    }


}