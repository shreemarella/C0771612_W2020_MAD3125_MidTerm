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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_screen);
        sinnumber = findViewById(R.id.SN);
        TotalTaxPaid = findViewById(R.id.TTPe);
        fullname = findViewById(R.id.full_name);
        BirthDate = findViewById(R.id.BD);
        Age=findViewById(R.id.age);
        Date=findViewById(R.id.CD);
        Gender = findViewById(R.id.G);
        GrossIncome=findViewById(R.id.GI);
        CPP=findViewById(R.id.cp);
        EI=findViewById(R.id.EI);
        RRSP=findViewById(R.id.RP);
        CFRSSP=findViewById(R.id.CRP);
        RRSP=findViewById(R.id.RP);
        TotalTaxableIncome=findViewById(R.id.TI);
        ProvincialTax=findViewById(R.id.PT);
        FederalTax=findViewById(R.id.FT);

    }
}
