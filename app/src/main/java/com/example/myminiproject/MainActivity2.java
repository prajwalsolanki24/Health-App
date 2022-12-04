package com.example.myminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {


    private TextView bmiView;
    private TextView bmrView;
    private Button reCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bmiView = findViewById(R.id.resultBMI);
        bmrView = findViewById(R.id.resultBMR);
        reCalculate = findViewById(R.id.recalculate);

        double bmi = getIntent().getDoubleExtra( "bmi", 0.0);
        bmiView.setText( String.format("Bmi = %.2f",bmi));

        double bmr = getIntent().getDoubleExtra( "bmr", 0.0);
        bmrView.setText( String.format("Bmr = %.2f",bmr));

        reCalculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
