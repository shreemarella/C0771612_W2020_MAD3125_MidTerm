package com.shreemarella.c0771612_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        CRACustomer c2 = (CRACustomer) extras.getParcelable("object");

        Double gross = c2.getGrossIncome();
        Double RRSP_C0 = c2.getRRSP();
//        Double TOTALTAXINCOME = (gross-(calcualteCPP(gross)+calculateEI(gross)+calculateMaxRrsp(gross)));
//        CPP.setText(String.format("%.2f", calcualteCPP(gross)));
//        EI.setText(String.format("%.2f",calculateEI(gross)));

    }

    private Double calcualteCPP(Double gross) {
        Double x;
        Double y;
        if (gross < 57400) {
            x = 57400 - gross;
            y = 57400 - x;
            x = y * 0.051;

        } else {
            x = gross - 57400;
            y = gross - x;
            x = y * 0.051;
        }

        return x;
    }
    private Double calculateEI(Double gross){
        Double x;

        if(gross >= 53100) {

            x = 860.22;
        }else{

            x = gross *0.0162;

        }

        return x;
    }

        }
