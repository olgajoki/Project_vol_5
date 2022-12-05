package com.example.project_vol_5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class scaleActivity extends AppCompatActivity {

    private Button move;

    SeekBar seekBar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);

        Intent scale= getIntent();

        seekBar2=(SeekBar)findViewById(R.id.seekBar2);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(getApplicationContext(),"Pain level: "+progress, Toast.LENGTH_SHORT).show();
                if (progress == 1){
                    Toast.makeText(getApplicationContext(),"mild"+progress, Toast.LENGTH_SHORT).show();
                }else if (progress == 2){
                    Toast.makeText(getApplicationContext(),"mild"+progress, Toast.LENGTH_SHORT).show();
                }else if (progress == 3){
                    Toast.makeText(getApplicationContext(),"mild"+progress, Toast.LENGTH_SHORT).show();
                }else if (progress == 4){
                    Toast.makeText(getApplicationContext(),"medium"+progress, Toast.LENGTH_SHORT).show();
                }else if (progress == 5){
                    Toast.makeText(getApplicationContext(),"medium2"+progress, Toast.LENGTH_SHORT).show();
                }else if (progress == 6){
                    Toast.makeText(getApplicationContext(),"meidum3"+progress, Toast.LENGTH_SHORT).show();
                }else if (progress == 7){
                    Toast.makeText(getApplicationContext(),"bearable"+progress, Toast.LENGTH_SHORT).show();
                }else if (progress == 8){
                    Toast.makeText(getApplicationContext(),"ouch"+progress, Toast.LENGTH_SHORT).show();
                }else if (progress == 9){
                    Toast.makeText(getApplicationContext(),"toomuch"+progress, Toast.LENGTH_SHORT).show();
                }else if (progress == 10){
                    Toast.makeText(getApplicationContext(),"helpppppp"+progress, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        move=findViewById(R.id.Move);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(scaleActivity.this, painArea.class );
                startActivity(intent);
            }
        });


    }

}



