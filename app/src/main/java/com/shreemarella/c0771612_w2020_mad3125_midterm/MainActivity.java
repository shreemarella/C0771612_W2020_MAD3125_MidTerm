package com.shreemarella.c0771612_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.shreemarella.c0771612_w2020_mad3125_midterm.MainActivity;

public class MainActivity extends AppCompatActivity
{
    private int SPLASH_TIMING = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent hint = new Intent(MainActivity.this, DataEntry.class);
                startActivity(hint);
                finish();
            }
        },SPLASH_TIMING);
    }
}
