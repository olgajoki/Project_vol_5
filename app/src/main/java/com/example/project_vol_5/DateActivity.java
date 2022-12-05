package com.example.project_vol_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DateActivity extends AppCompatActivity {
    TextView initialsTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        //this.initialsTV = findViewById(R.id.initialsTextView2);
        Intent intent = getIntent();


        //initialsTV.setText(initials);
    }
}