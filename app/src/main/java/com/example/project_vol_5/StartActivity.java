package com.example.project_vol_5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class StartActivity extends MainActivity {
    private ImageButton headAcheButton;
    //public final static String EXTRA_INITIALS = "com.example.Project_MobTS.FIRSTNAME";
    private String initials;
    SharedPreferences prefs;
    private ImageButton statsButton;


    TextView initialsTV;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        this.prefs = getSharedPreferences("headaches", context.MODE_PRIVATE);
        this.initials = prefs.getString("Initials", "Initials");
        this.statsButton = findViewById(R.id.statsButton);
        statsButton.setOnClickListener(this::onClickStats);
        setContentView(R.layout.activity_start);
        this.headAcheButton = findViewById(R.id.recordHeadacheButton);
        headAcheButton.setOnClickListener(this::onRecordHeadAche);
        this.initialsTV = findViewById(R.id.initialsTextView2);
        //initials = intent.getStringExtra(MainActivity.EXTRA_INITIALS);
        initialsTV.setText(initials);
    }

    private void onRecordHeadAche(View view) {
        Intent intent = new Intent(this, DateActivity.class);
        startActivity(intent);
    }

    private void onClickStats(View view) {
        Intent intent = new Intent(this, StatsActivity.class);
        startActivity(intent);
    }


}


