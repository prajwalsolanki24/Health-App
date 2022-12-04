package com.example.myminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private Button checkbutton;
    private EditText ageNum, weightNum, heightNum;
    private RadioGroup rdogrp;
    private String selectedGender = "MALE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkbutton = findViewById(R.id.buttonCalculate);
        ageNum = findViewById(R.id.ageNumber);
        weightNum = findViewById(R.id.weightNumber);
        heightNum = findViewById(R.id.heightNumber);
        rdogrp = findViewById(R.id.radioGroup);
        rdogrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton selectRadioButton = findViewById(i);
                selectedGender = selectRadioButton.getText().toString();
            }
        });

        checkbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ageStr = ageNum.getText().toString();
                double age = Double.parseDouble(ageStr);

                String weightStr = weightNum.getText().toString();
                double weight = Double.parseDouble(weightStr);

                String heightStr = heightNum.getText().toString();
                double height = Double.parseDouble(heightStr);

                double bmi = weight/((height/100)*(height/100));
                double bmr = 0;
                if(selectedGender.equals("FEMALE")){
                    bmr = 88.362 + (13.369 * weight) + (4.799 * height) - (5.677 * age);
                }else{
                    bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
                }

                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("bmi", bmi);
                intent.putExtra("bmr", bmr);
                startActivity(intent);
            }
        });
    }
}
