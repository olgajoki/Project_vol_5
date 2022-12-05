package com.example.project_vol_5;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PredisposingFactors extends AppCompatActivity {

    private Button resultsButton;
    private CheckBox stressCB, fatigueCB, alcoholCB, foodCB, noiseCB, physicalCB;
    private String stress, fatigue, alcohol, food, noise, physical;
    private TextView predisposingFactorsTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predisposing_factors);

        this.stressCB = findViewById(R.id.stressCheckBox);
        this.fatigueCB = findViewById(R.id.fatigueCheckBox);
        this.alcoholCB = findViewById(R.id.alcoholCheckBox);
        this.foodCB = findViewById(R.id.foodCheckBox);
        this.noiseCB = findViewById(R.id.noiseCheckBox);
        this.physicalCB = findViewById(R.id.physicalCheckBox);

        Intent factors = getIntent();


    }

    public void resultsButtonPressed(View v){
        //creating shared preferences file to send objects to xml file
        SharedPreferences prefs = getSharedPreferences("headaches", MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = prefs.edit();

        if(stressCB.isChecked()) {

            stress = stressCB.getText().toString();
            prefsEditor.putString("Stress", stress);
            ((SharedPreferences.Editor) prefsEditor).commit();
        }

        if(fatigueCB.isChecked()){

            fatigue = fatigueCB.getText().toString();
            prefsEditor.putString("Fatigue", fatigue);
            ((SharedPreferences.Editor) prefsEditor).commit();

        }

        if(alcoholCB.isChecked()){

            alcohol = alcoholCB.getText().toString();
            prefsEditor.putString("Alcohol", alcohol);
            ((SharedPreferences.Editor) prefsEditor).commit();
        }
        if(foodCB.isChecked()){

            food = foodCB.getText().toString();
            prefsEditor.putString("Food", food);
            ((SharedPreferences.Editor) prefsEditor).commit();
        }
        if(noiseCB.isChecked()){

            noise = noiseCB.getText().toString();
            prefsEditor.putString("Noise", noise);
            ((SharedPreferences.Editor) prefsEditor).commit();
        }
        if(physicalCB.isChecked()){

            physical = physicalCB.getText().toString();
            prefsEditor.putString("Physical", physical);
            ((SharedPreferences.Editor) prefsEditor).commit();
        }
        else{
            prefsEditor.putString("No possible causes for migraine: ", null);
            ((SharedPreferences.Editor) prefsEditor).commit();

        }

        // get shared preferences for values
        SharedPreferences sh = getSharedPreferences("SP", MODE_PRIVATE);
        SharedPreferences.Editor shEdit = sh.edit();

        String stressFactorFromXML = sh.getString("Stress", "");
        String fatigueFactorFromXML = sh.getString("Fatigue", "");
        String alcoholFactorFromXML = sh.getString("Alcohol", "");
        String foodFactorFromXML = sh.getString("Food", "");
        String noiseFactorFromXML = sh.getString("Noise", "");
        String physicalFactorFromXML = sh.getString("Physical", "");


        Log.d("TAG",   stressFactorFromXML+ "\n" + fatigueFactorFromXML);

        // sending data to next activity
        Intent results = new Intent(this, Results.class);
        results.putExtra("Stress", stressFactorFromXML);
        results.putExtra("Fatigue", fatigueFactorFromXML);
        results.putExtra("Alcohol", alcoholFactorFromXML);
        results.putExtra("Food", foodFactorFromXML);
        results.putExtra("Noise", noiseFactorFromXML);
        results.putExtra("Physical", physicalFactorFromXML);


        startActivity(results);



    }
}