package com.example.project_vol_5;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class DateActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    TextView startTV, endTV;
    Button startButton, endButton;
    private int startDay, startMonth, startYear, startHour, startMinute;
    private int endDay, endMonth, endYear, endHour, endMinute;

    private int startMyDay, startMyMonth, startMyYear, startMyHour, startMyMinute;
    private int endMyDay, endMyMonth, endMyYear, endMyHour, endMyMinute;

    private boolean startBoolean;
    private boolean endBoolean;

    private String daysLength, hoursLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        startTV = findViewById(R.id.startTextView);
        endTV = findViewById(R.id.endTextView);

        startButton = findViewById(R.id.startButton);
        endButton = findViewById(R.id.endButton);

        //start button opens calendar with year, month and date for the start date
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBoolean = true;
                Calendar startCalendar = Calendar.getInstance();
                startYear = startCalendar.get(Calendar.YEAR);
                startMonth = startCalendar.get(Calendar.MONTH);
                startDay = startCalendar.get(Calendar.DATE);
                DatePickerDialog startDatePickerDialog = new DatePickerDialog(DateActivity.this, DateActivity.this, startYear, startMonth, startDay);
                startDatePickerDialog.show();

            }
        });
        //end button opens calendar with year, month and date for the end date
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endBoolean = true;
                Calendar endCalendar = Calendar.getInstance();
                endYear = endCalendar.get(Calendar.YEAR);
                endMonth = endCalendar.get(Calendar.MONTH);
                endDay = endCalendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog endDatePickerDialog = new DatePickerDialog(DateActivity.this, DateActivity.this, endYear, endMonth, endDay);
                endDatePickerDialog.show();


            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        //if start button has been clicked, calendar changes to time view.
        if(startBoolean){

            startMyYear = year;
            startMyDay = dayOfMonth;
            startMyMonth = month + 1;
            Calendar startC = Calendar.getInstance();
            startHour = startC.get(Calendar.HOUR);
            startMinute = startC.get(Calendar.MINUTE);
            TimePickerDialog startTimePickerDialog = new TimePickerDialog(DateActivity.this, DateActivity.this, startHour, startMinute, DateFormat.is24HourFormat(this));
            startTimePickerDialog.show();

        }
        //if end button has been clicked, calendar changes to time view.
        else if(endBoolean) {

            endMyYear = year;
            //end year is bigger than start year
            if(endMyYear > startMyYear) {
                endMyMonth = month + 1;
                endMyDay = dayOfMonth;

                Calendar endC = Calendar.getInstance();
                endHour = endC.get(Calendar.HOUR);
                endMinute = endC.get(Calendar.MINUTE);
                TimePickerDialog endTimePickerDialog = new TimePickerDialog(DateActivity.this, DateActivity.this, endHour, endMinute, DateFormat.is24HourFormat(this));
                endTimePickerDialog.show();

            }
            //end year is same as start year
            else if(endMyYear == startMyYear) {
                endMyMonth = month + 1;

                if(endMyMonth >= startMyMonth) {

                    endMyDay = dayOfMonth;

                    if (endMyDay >= startMyDay) {

                        Calendar endC = Calendar.getInstance();
                        endHour = endC.get(Calendar.HOUR);
                        endMinute = endC.get(Calendar.MINUTE);
                        TimePickerDialog endTimePickerDialog = new TimePickerDialog(DateActivity.this, DateActivity.this, endHour, endMinute, DateFormat.is24HourFormat(this));
                        endTimePickerDialog.show();

                    }
                }
            }

        }

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        //String yearsLength = Integer.toString((endMyYear - startMyYear));
        //String monthsLength = Integer.toString((endMyMonth - startMyMonth));
        //String minutesLength = Integer.toString((endMyMinute - startMyMinute));


        //setting the length of days and hours correctly
        if(endMyDay < startMyDay){
            daysLength = Integer.toString((startMyDay- endMyDay));
        }
        else{
            daysLength = Integer.toString((endMyDay - startMyDay));
        }
        if(endMyHour < startMyHour){
            hoursLength = Integer.toString((startMyHour- endMyHour));
        }
        else{
            hoursLength = Integer.toString((endMyHour - startMyHour));
        }

        //if date and time have been chosen, info appears for start date
        if(startBoolean) {

            startBoolean = false;
            startMyHour = hourOfDay;
            startMyMinute = minute;
            startTV.setText("Year: " + startMyYear + " " + "Month: " + startMyMonth + " " + "Day: " + startMyDay + " " + "Hour: " + startMyHour + " " + "Minute: " + startMyMinute);
        }
        //if date and time have been chosen, info appears for end date

        else if(endBoolean) {

            endMyHour = hourOfDay;
            endMyMinute = minute;
            endTV.setText("Year: " + endMyYear + " " + "Month: " + endMyMonth + " " + "Day: " + endMyDay + " " + "Hour: " + endMyHour + " " + "Minute: " + endMyMinute);
        }


    }

    //sending length of migraine for the conclusion activity
    public void nextButtonPressed(View view){
        Intent scale = new Intent(this, scaleActivity.class);

     //   Integer dayLength = Integer.parseInt(daysLength);
     /*   if(dayLength < 0){
            factors.putExtra("Length of days", daysLength);
            Log.d("TAG", "dayslength on " + daysLength);

        }

        else{
            factors.putExtra("Length of hours", hoursLength);
            Log.d("TAG", "hourslength on " + hoursLength);

        }
    */

        startActivity(scale);

    }

}