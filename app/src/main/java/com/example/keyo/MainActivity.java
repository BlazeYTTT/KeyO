package com.example.keyo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GoTest(View V){
        Intent intent = new Intent(this, TestActivityStart.class);
        startActivity(intent);
        finish();
    }
    public void GoDoc(View V){
        Intent intent = new Intent(this, DoctorActivity.class);
        startActivity(intent);
        finish();
    }
}