package com.example.project_vol_5;

import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Ache<triggers> extends AppCompatActivity {
    private String firstName;
    private String lastName;
    private int acheNumber;
    private String date;
    private double duration;
    private int acheMeasure;
    private ArrayList meds;
    private ArrayList triggers;
    private ArrayList symptoms;
    private String dob;
    private boolean login;
    private String initials;

    SharedPreferences prefs;

    public Ache() {
        this.firstName = prefs.getString("Firstname", "Etunimi");
        this.lastName = prefs.getString("Lastname", "Sukunimi");
        this.dob = prefs.getString("DOB", "dd.mm.yyyy");
        this.login = prefs.getBoolean("SignIn", false);
        this.initials = prefs.getString("Initials", "Initials");
    }
}


