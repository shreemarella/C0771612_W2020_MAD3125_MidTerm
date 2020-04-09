package com.shreemarella.c0771612_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

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
        

    }
}
