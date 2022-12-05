package com.example.project_vol_5;


import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String firstName;
    private String lastName;
    private String dob;
    private boolean login;
    //private TextView lastNameTextView;
    //private TextView firstNameTextView;
    //private TextView dobTextView;
    private TextView welcomeBackTextView;
    private TextView initialsTextView;
    private EditText firstNameTextField, lastNameTextField, dobTextField;
    SharedPreferences prefs;
    private CheckBox stayLoggedInButton;
    private Button saveButton;
    private Button continueButton;
    Context context;
    private String initials;
    //public final static String EXTRA_INITIALS = "com.example.Project_MobTS.FIRSTNAME";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.prefs = getSharedPreferences("headaches", context.MODE_PRIVATE);
        this.firstName = prefs.getString("Firstname", "Etunimi");
        this.lastName = prefs.getString("Lastname", "Sukunimi");
        this.dob = prefs.getString("DOB", "dd.mm.yyyy");
        this.login = prefs.getBoolean("SignIn", false);
        this.initials = prefs.getString("Initials", "Initials");
        this.initialsTextView = findViewById(R.id.initialsTextView);
        this.lastNameTextField = findViewById(R.id.lastNameTextEdit);
        this.firstNameTextField = findViewById(R.id.firstNameTextEdit);
        this.dobTextField = findViewById(R.id.dobTextEdit);
        this.stayLoggedInButton = (CheckBox) findViewById(R.id.loginCheckBox);
        this.saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(this::saveButtonClicked);
        this.continueButton = findViewById(R.id.continueButton);
        continueButton.setOnClickListener(this::continueClicked);
        this.welcomeBackTextView = findViewById(R.id.welcomeBackTextView);
        if(login==false){
            initialsTextView.setText("");
            firstNameTextField.setHint("Firstname");
            lastNameTextField.setHint("Lastname");
            updateWelcomeText();
        }
        else{
            stayLoggedInButton.setChecked(true);
            initialsTextView.setText(initials);
            firstNameTextField.setText(firstName);
            lastNameTextField.setText(lastName);
            updateWelcomeText();

        }
      /*  if ((firstName !=null) && (lastName !=null)){
            getInitials();
            firstNameTextField.setHint(firstName);
            lastNameTextField.setHint(lastName);
            Log.d(TAG, "myapp_eka_if" + firstName + " " + lastName + " initials " + initials);
            updateInitialsUI();
            updateWelcomeText();

        }
        else {
            welcomeBackTextView.setText("Please fill in your details to access the app.");
        }*/
    }

    @SuppressLint("SetTextI18n")
    public void updateWelcomeText(){
        if(login==true){
        welcomeBackTextView.setText("Welcome back " + firstName + " " + lastName);}
        else{
            welcomeBackTextView.setText("Please enter your details below and save");
        }
    }


public void checkLogin(){
        Log.d(TAG, "myapp_checkLogin1");
        if(stayLoggedInButton.isChecked()){
            login = true;}
        else{
            login = false;
        }
    Log.d(TAG, "myapp_checkLogin2" + login);



}
public void getInitials(){
    firstName = firstNameTextField.getText().toString();
    Log.d(TAG,"myapp_in getInitials firstname)" + firstName);
    lastName = lastNameTextField.getText().toString();
    Log.d(TAG,"myapp_in getInitials lastname)" + lastName);
    initials = firstName.substring(0,1) + lastName.substring(0,1);

}
    public void saveButtonClicked(View view){
        checkLogin();
        prefs.edit().putString("Firstname", String.valueOf(firstNameTextField.getText())).putString("Lastname", String.valueOf(lastNameTextField.getText())).putString("DOB", String.valueOf(dobTextField.getText())).putBoolean("SignIn", login).putString("Initials", initials).apply();
        firstName = firstNameTextField.getText().toString();
        lastName = lastNameTextField.getText().toString();
        initials = firstName.substring(0,1) + lastName.substring(0,1);
        Log.d(TAG, "myappinitials2" + initials);

        Log.d(TAG, "my_app_initials22" + initials);
        updateInitialsUI();
        updateWelcomeText();
    }


    public void continueClicked(View view){
        Log.d(TAG, "myapp_cpntinueClicked");
        prefs.edit().putString("Firstname", String.valueOf(firstNameTextField.getText())).putString("Lastname", String.valueOf(lastNameTextField.getText())).putString("DOB", String.valueOf(dobTextField.getText())).putBoolean("SignIn", login).putString("Initials", initials).apply();
        firstName = firstNameTextField.getText().toString();
        lastName = lastNameTextField.getText().toString();
        initials = firstName.substring(0,1) + lastName.substring(0,1);
        Log.d(TAG, "myappinitials" + initials);
        Intent intent = new Intent(this, StartActivity.class);
        Log.d(TAG, "myapphitMe() called");
        //intent.putExtra(EXTRA_INITIALS, initials);
        startActivity(intent);

        //updateUI();
    }


    private void updateInitialsUI(){
        Log.d(TAG, "myapp_updateUI" + initials);
        ///Log.d(TAG, "UpdateUI");
        firstNameTextField.setHint(firstName);
        lastNameTextField.setHint(lastName);
        initialsTextView.setText(initials);
    }

}