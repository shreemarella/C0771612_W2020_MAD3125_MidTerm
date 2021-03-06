package com.shreemarella.c0771612_w2020_mad3125_midterm;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiresApi(api = Build.VERSION_CODES.N)

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);

        FirstName = findViewById(R.id.FirstName);
        LastName = findViewById(R.id.LastName);
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
                    Age.setText(" Not eligible to file tax");
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

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if ((isValidSin(SINNumber.getText().toString())) == false) {
                    SINNumber.setError("Not Valid SIN");
                }else if (FirstName.getText().toString().matches("")){
                    FirstName.setError("Enter Your First Name");

                }else if (LastName.getText().toString().matches("")){
                    LastName.setError("Enter Your Last Name");

                }else if (GrossPay.getText().toString().matches("")){
                    GrossPay.setError("Enter Your Last Name");

                }else if (RRSP.getText().toString().matches("")){
                    RRSP.setError("Enter Last Name");
                } else {
                    String value1 = GrossPay.getText().toString();
                    Double GrossValue = Double.parseDouble(value1);
                    String value2 = RRSP.getText().toString();
                    Double RRSPvalue = Double.parseDouble(value2);

                    SINNumber.setText(SINNumber.getText().toString());
                    Intent mintent = new Intent(DataEntry.this, DisplayScreen.class);
                    CRACustomer C1 = new CRACustomer(TaxDate.getText().toString(),SINNumber.getText().toString(),FirstName.getText().toString(), LastName.getText().toString(), txtDate.getText().toString(), Age.getText().toString(), Gender.getSelectedItem().toString(), GrossValue, RRSPvalue);
                    mintent.putExtra("object",C1);
                    startActivity(mintent);
                }
            }
        });


        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirstName.setText("");
                LastName.setText("");
                SINNumber.setText("");
                txtDate.setText("");
                GrossPay.setText("");
                RRSP.setText("");
                Age.setText("Age");

            }
        });


    }


    int calculateAge ( long date){
        java.util.Calendar dob = java.util.Calendar.getInstance();
        dob.setTimeInMillis(date);
        java.util.Calendar today = java.util.Calendar.getInstance();
        int age = today.get(java.util.Calendar.YEAR) - dob.get(java.util.Calendar.YEAR);
        if (today.get(java.util.Calendar.DAY_OF_MONTH) < dob.get(java.util.Calendar.DAY_OF_MONTH)) {
            age--;
        }
        return age;
    }

    private boolean isValidSin(String sinnumber) {
        String sinValidation = "\\d{9}";
        Pattern pattern = Pattern.compile(sinValidation);
        Matcher matcher = pattern.matcher(sinnumber);
        return matcher.matches();
    }





}

