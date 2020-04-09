package com.shreemarella.c0771612_w2020_mad3125_midterm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.shreemarella.c0771612_w2020_mad3125_midterm.MainActivity;
import com.shreemarella.c0771612_w2020_mad3125_midterm.R;

public class SplashScreenActivity extends AppCompatActivity
{
    private int SPLASH_TIMING = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent hint = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(hint);
                finish();
            }
        },SPLASH_TIMING);



    }
}
