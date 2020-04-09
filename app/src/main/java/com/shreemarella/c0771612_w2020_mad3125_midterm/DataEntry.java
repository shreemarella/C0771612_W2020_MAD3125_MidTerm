package com.shreemarella.c0771612_w2020_mad3125_midterm;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class DataEntry extends AppCompatActivity
{
    private TextView FirstName;
    private TextView LastName;
    private TextView  txtDate;
    private TextView Age;
    private Spinner Gender;
    private String[] GenderArray;
    private TextView SINNumber;
    private TextView TaxDate;
    private TextView GrossPay;
    private TextView RRSP;

    private Button Register;
    private Button Clear;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);

        FirstName = findViewById(R.id.first_name);
        LastName = findViewById(R.id.last_name);
        txtDate = findViewById(R.id.txtDate);
        TaxDate = findViewById(R.id.taxdate);
        Age = findViewById(R.id.age);
        Gender = findViewById(R.id.gender);
        SINNumber = findViewById(R.id.sinNumber);
        GrossPay = findViewById(R.id.Grossincome);
        RRSP = findViewById(R.id.RRSP);
        Register =findViewById(R.id.register);
        Clear = findViewById(R.id.btnClear);


        final Calendar myCalendar = Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpledateformat = new SimpleDateFormat(" EEEE ,dd-mm-yyyy hh:mm:ss a");
        String dateTime = simpledateformat.format(calendar.getTime());
        TaxDate.setText("Tax Filing Date: " + dateTime);

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "MM-dd-yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                txtDate.setText(sdf.format(myCalendar.getTime()));
                if (calculateAge(myCalendar.getTimeInMillis()) > 18) {
                    Age.setText("Age: " + Integer.toString(calculateAge(myCalendar.getTimeInMillis())));
                    Age.setTextColor(Color.BLACK);
                    Age.setTypeface(null, Typeface.NORMAL);


                } else {
                    Age.setText(" Not eligible to file tax for  this  year!");
                    Age.setTextColor(Color.RED);
                    Age.setTypeface(null, Typeface.BOLD);


                }


            }

        };

        txtDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                new DatePickerDialog(DataEntry.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }

        });




    }
}
