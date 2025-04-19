package com.example.keyo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DoctorActivity extends AppCompatActivity {

    EditText kod;
    ConstraintLayout line;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        kod = findViewById(R.id.kod);
        line = findViewById(R.id.Line);
    }

    public void GoMain(View V){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void GoPasient(View V){
        if (kod.getText().toString().equals("1100")){
            Intent intent = new Intent(this, PasientActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            Toast.makeText(DoctorActivity.this, "Код не верен.", Toast.LENGTH_SHORT).show();
        }
    }
}