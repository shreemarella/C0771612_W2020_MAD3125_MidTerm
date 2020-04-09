package com.shreemarella.c0771612_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DisplayScreen extends AppCompatActivity
{

    private TextView TotalTaxPaid;
    private TextView fullname;
    private TextView BirthDate;
    private TextView Age;
    private TextView Date;
    private TextView Gender;
    private TextView sinnumber;
    private TextView GrossIncome;
    private TextView CPP;
    private TextView EI;
    private TextView CFRSSP;
    private TextView RRSP;
    private TextView TotalTaxableIncome;
    private TextView ProvincialTax;
    private TextView FederalTax;
    
    public static final String CRA_Customer = "CRA Customer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_screen);
    }
}
