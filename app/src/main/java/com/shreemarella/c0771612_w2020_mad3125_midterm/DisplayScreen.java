package com.shreemarella.c0771612_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
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
        sinnumber = findViewById(R.id.SiN);
        TotalTaxPaid = findViewById(R.id.TTPe);
        fullname = findViewById(R.id.full_name);
        BirthDate = findViewById(R.id.BirthD);
        Age=findViewById(R.id.age);
        Date=findViewById(R.id.CuDa);
        Gender = findViewById(R.id.GN);
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
        Double TOTALTAXINCOME = (gross-(calcualteCPP(gross)+calculateEI(gross)+calculateMaxRrsp(gross)));
        CPP.setText(String.format("%.2f", calcualteCPP(gross)));
        EI.setText(String.format("%.2f",calculateEI(gross)));

        if(calculateMaxRrsp(gross) > RRSP_C0)
        {
            double x = calculateMaxRrsp(gross) - RRSP_C0;
            CFRSSP.setText(String.format("%.2f",x));
            RRSP.setText(String.format("%.2f",RRSP_C0));
        }
        else if(calculateMaxRrsp(gross) < RRSP_C0)
        {
            double x = calculateMaxRrsp(gross) - RRSP_C0;
            CFRSSP.setText(String.format("%.2f",x));
            CFRSSP.setTextColor(Color.RED);
            RRSP.setText(String.format("%.2f", RRSP_C0));

        }

        TotalTaxableIncome.setText(String.format("%.2f",TOTALTAXINCOME));
//USED FROM THE SLAB
        if( TOTALTAXINCOME >= 220000){
            Double pt = TOTALTAXINCOME*0.1316;
            ProvincialTax.setText(String.format("%.2f",pt));

        }else if (( TOTALTAXINCOME >= 150000) &&( TOTALTAXINCOME <= 220000)){
            Double pt =  TOTALTAXINCOME*0.1216;
            ProvincialTax.setText(String.format("%.2f",pt));
        }else if (( TOTALTAXINCOME >= 87813.01) &&( TOTALTAXINCOME <= 150000)){
            Double pt =  TOTALTAXINCOME*0.1116;
            ProvincialTax.setText(String.format("%.2f",pt));
        }else if (( TOTALTAXINCOME >= 43906.01) &&( TOTALTAXINCOME <= 87813)){
            Double pt =  TOTALTAXINCOME*0.0915;
            ProvincialTax.setText(String.format("%.2f",pt));
        }else if (( TOTALTAXINCOME >= 10582.01) &&( TOTALTAXINCOME <= 43906)){
            Double pt =  TOTALTAXINCOME*0.0505;
            ProvincialTax.setText(String.format("%.2f",pt));
        }else if ( TOTALTAXINCOME <= 10582){
            Double pt =  TOTALTAXINCOME;
            ProvincialTax.setText(String.format("%.2f",pt));
        }

//USED FROM THE SLAB

        if( TOTALTAXINCOME >= 210371.01){
            Double ft =  TOTALTAXINCOME*0.33;
            FederalTax.setText(String.format("%.2f",ft));
        }else if (( TOTALTAXINCOME >= 147667.01) &&( TOTALTAXINCOME <= 210371)){
            Double ft =  TOTALTAXINCOME*0.29;
            FederalTax.setText(String.format("%.2f",ft));
        }else if (( TOTALTAXINCOME >= 95259.01) &&( TOTALTAXINCOME <= 147667)){
            Double ft =  TOTALTAXINCOME*0.26;
            FederalTax.setText(String.format("%.2f",ft));
        }else if (( TOTALTAXINCOME >= 47630.01) &&( TOTALTAXINCOME <= 95259)){
            Double ft =  TOTALTAXINCOME*0.2050;
            FederalTax.setText(String.format("%.2f",ft));
        }else if (( TOTALTAXINCOME >= 12609.01) &&( TOTALTAXINCOME <= 47630)){
            Double ft =  TOTALTAXINCOME*0.15;
            FederalTax.setText(String.format("%.2f",ft));
        }else if ( TOTALTAXINCOME <= 12069){
            Double ft =  TOTALTAXINCOME;
            FederalTax.setText(String.format("%.2f",ft));
        }
//
//        String value1= ProvincialTax.getText().toString();
//        Double Finalprovincial =Double.parseDouble(value1);
//        String value2 = FederalTax.getText().toString();
//        Double Finalfederal = Double.parseDouble(value2);
//
//        Double x = Finalprovincial + Finalfederal;
//        TotalTaxPaid.setText(x.toString());

        sinnumber.setText(c2.getSinNo());
        fullname.setText(c2.getLastName().toUpperCase()+" "+c2.getFirstName());
        BirthDate.setText(c2.getBirthdate());
        Gender.setText(c2.getGender());
        Age.setText(c2.getAge());
        Date.setText(c2.getCurrentDate());
        GrossIncome.setText(c2.getGrossIncome().toString());


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
    private Double calculateMaxRrsp(Double gross){
        Double x;

        x = gross * 0.18;

        return x;


    }


}
