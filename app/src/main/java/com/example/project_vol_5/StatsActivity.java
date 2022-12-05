package com.example.project_vol_5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class StatsActivity extends AppCompatActivity {
    TextView initialsTV;
    String initials;
    SharedPreferences prefs;
    Context context;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        Log.d("myapp", "In stats");
        this.prefs = getSharedPreferences("headaches", context.MODE_PRIVATE);
        this.initials = prefs.getString("Initials", "Initials");
        this.initialsTV = findViewById(R.id.initialsTextView);



        initialsTV.setText(initials);
    }
}