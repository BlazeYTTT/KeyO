package com.example.keyo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ResultActivity extends AppCompatActivity {
    TextView orientationTXT, speakTXT, reproductionTXT, OrientColor, ReprodactColor, SpeakColor, recom1, recom2, recom3, recom4, recom5, recom6, recom7, recom8, recom9, recom10;
    String orientationQ, speakQ, reproductionQ, Name, Subname;


    @SuppressLint({"MissingInflatedId", "SetTextI18n", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        orientationTXT = findViewById(R.id.orientationTXT);
        reproductionTXT = findViewById(R.id.reproductionTXT);
        speakTXT = findViewById(R.id.speakTXT);
        OrientColor = findViewById(R.id.OrientColor);
        ReprodactColor = findViewById(R.id.ReprodactColor);
        SpeakColor = findViewById(R.id.SpeakColor);
        recom1 = findViewById(R.id.recom1);
        recom2 = findViewById(R.id.recom2);
        recom3 = findViewById(R.id.recom3);
        recom4 = findViewById(R.id.recom4);
        recom5 = findViewById(R.id.recom5);
        recom6 = findViewById(R.id.recom6);
        recom7 = findViewById(R.id.recom7);
        recom8 = findViewById(R.id.recom8);
        recom9 = findViewById(R.id.recom9);
        recom10 = findViewById(R.id.recom10);

        recom1.setVisibility(View.GONE);
        recom2.setVisibility(View.GONE);
        recom3.setVisibility(View.GONE);
        recom4.setVisibility(View.GONE);
        recom5.setVisibility(View.GONE);
        recom6.setVisibility(View.GONE);
        recom7.setVisibility(View.GONE);
        recom8.setVisibility(View.GONE);
        recom9.setVisibility(View.GONE);
        recom10.setVisibility(View.GONE);


        Bundle arguments = getIntent().getExtras();
        orientationQ = arguments.get("orientation").toString();
        reproductionQ = arguments.get("reproduction").toString();
        Name = arguments.get("name").toString();
        Subname = arguments.get("subname").toString();
        speakQ = arguments.get("speak").toString();

        insertData();

        orientationTXT.setText(orientationQ + "Б");
        if (!Objects.equals(orientationQ, "3")){
            orientationTXT.setTextColor(getResources().getColor(R.color.rad, null));
            OrientColor.setTextColor(getResources().getColor(R.color.rad, null));
            recom1.setVisibility(View.VISIBLE);
            recom2.setVisibility(View.VISIBLE);
            recom3.setVisibility(View.VISIBLE);
            recom1.setText("Занятия ЛФК");
            recom2.setText("Применение витаминного комплекса");
            recom3.setText("Выполнение умственных упражнений");

            if (!Objects.equals(reproductionQ, "3")){
                reproductionTXT.setTextColor(getResources().getColor(R.color.rad, null));
                ReprodactColor.setTextColor(getResources().getColor(R.color.rad, null));
                recom4.setVisibility(View.VISIBLE);
                recom5.setVisibility(View.VISIBLE);
                recom6.setVisibility(View.VISIBLE);
                recom7.setVisibility(View.VISIBLE);
                recom4.setText("Физические упражнения");
                recom5.setText("Освоение новых навыков");
                recom6.setText("Читать");
                recom7.setText("Развивать мелкую моторику");
            }

            if (!Objects.equals(speakQ, "3")){
                speakTXT.setTextColor(getResources().getColor(R.color.rad, null));
                SpeakColor.setTextColor(getResources().getColor(R.color.rad, null));
                recom4.setVisibility(View.VISIBLE);
                recom5.setVisibility(View.VISIBLE);
                recom6.setVisibility(View.VISIBLE);
                recom7.setVisibility(View.VISIBLE);
                recom4.setText("Физические упражнения");
                recom5.setText("Освоение новых навыков");
                recom6.setText("Читать");
                recom7.setText("Развивать мелкую моторику");
            }
        }

        reproductionTXT.setText(reproductionQ + "Б");
        if (!Objects.equals(reproductionQ, "3") && Objects.equals(orientationQ, "3") ){
            reproductionTXT.setTextColor(getResources().getColor(R.color.rad, null));
            ReprodactColor.setTextColor(getResources().getColor(R.color.rad, null));
            recom1.setVisibility(View.VISIBLE);
            recom2.setVisibility(View.VISIBLE);
            recom3.setVisibility(View.VISIBLE);
            recom4.setVisibility(View.VISIBLE);
            recom5.setVisibility(View.VISIBLE);
            recom1.setText("Физические упражнения");
            recom2.setText("Освоение новых навыков");
            recom3.setText("Выполнение умственных упражнений");
            recom4.setText("Читать");
            recom5.setText("Развивать мелкую моторику");
        }

        speakTXT.setText(speakQ + "Б");
        if (!Objects.equals(speakQ, "3") && Objects.equals(orientationQ, "3")){
            speakTXT.setTextColor(getResources().getColor(R.color.rad, null));
            SpeakColor.setTextColor(getResources().getColor(R.color.rad, null));
            recom1.setVisibility(View.VISIBLE);
            recom2.setVisibility(View.VISIBLE);
            recom3.setVisibility(View.VISIBLE);
            recom4.setVisibility(View.VISIBLE);
            recom5.setVisibility(View.VISIBLE);
            recom1.setText("Физические упражнения");
            recom2.setText("Освоение новых навыков");
            recom3.setText("Выполнение умственных упражнений");
            recom4.setText("Читать");
            recom5.setText("Развивать мелкую моторику");
        }

        if (speakQ.equals("3") && reproductionQ.equals("3") && orientationQ.equals("3")){
            recom1.setVisibility(View.VISIBLE);
            recom1.setText("Вам не назначено упражнений.");
        }

    }

    public void GoMain(View V) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void  insertData(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", Name.toString());
        map.put("subname", Subname.toString());
        map.put("orientationq", orientationQ.toString());
        map.put("reproductionq", reproductionQ.toString());
        map.put("speakq", speakQ.toString());

        FirebaseDatabase.getInstance().getReference().child("mmse").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });
    }
}