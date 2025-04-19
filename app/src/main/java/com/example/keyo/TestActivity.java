package com.example.keyo;

import static com.example.keyo.R.drawable.clock;
import static com.example.keyo.R.drawable.pensil;
import static com.example.keyo.R.drawable.pero;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TestActivity extends AppCompatActivity {

    String questionText, SpeakText;
    int questWrite, questNumber, orientQ, vosprQ, spiakQ;
    TextView Otvet, name, subname, textQuest;
    ConstraintLayout mic, check, cross, edit;
    ImageView imageView;
    CardView cardd;
    TextToSpeech tts;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        textQuest = findViewById(R.id.TextQuest);
        Otvet = findViewById(R.id.otvet);
        cross = findViewById(R.id.cross);
        check = findViewById(R.id.check);
        mic = findViewById(R.id.mic);
        edit = findViewById(R.id.edit);
        imageView = findViewById(R.id.imageView);
        cardd = findViewById(R.id.cardd);
        name = findViewById(R.id.Name);
        subname = findViewById(R.id.Submane);

        questWrite = 0;
        questNumber = 1;

        edit.setVisibility(View.GONE);
        cross.setVisibility(View.GONE);
        mic.setVisibility(View.GONE);
        imageView.setVisibility(View.GONE);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS) {
                    tts.setLanguage(Locale.getDefault());
                    tts.setSpeechRate(1.0f);
                }
            }
        });
    }

    public void GoMain(View V) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Выйти?");
        builder.setMessage("Вы потеряете прогресс.");
        builder.setPositiveButton("Выйти", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(TestActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
        builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

        AlertDialog alert = builder.create();
        alert.setOnShowListener(arg0 -> {
            alert.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.black));
            alert.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.black));
        });
        builder.show();
    }

    public void goMic(View V) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        startActivityForResult(intent, 10);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null) {
            switch (requestCode) {
                case 10:
                    ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    cross.setVisibility(View.VISIBLE);
                    check.setVisibility(View.VISIBLE);
                    Otvet.setText(text.get(0));
                    mic.setVisibility(View.GONE);
                    switch (text.get(0)) {
                        case "Челябинск":
                            if (questNumber == 1){
                                orientQ += 1;
                                questNumber += 1;
                                questWrite += 1;
                            } else {
                                questNumber += 1;
                            }
                            break;
                        case "Россия":
                            if (questNumber == 2){
                                orientQ += 1;
                                questNumber += 1;
                                questWrite += 1;
                            } else {
                                questNumber += 1;
                            }
                            break;
                        case "2025":
                            if (questNumber == 3){
                                orientQ += 1;
                                questNumber += 1;
                                questWrite += 1;
                            } else {
                                questNumber += 1;
                            }
                            break;


                        case "арбуз":
                            if (questNumber == 4){
                                vosprQ += 1;
                                questNumber += 1;
                                questWrite += 1;
                            } else {
                                questNumber += 1;
                            }
                            break;
                        case "дверь":
                            if (questNumber == 5){
                                vosprQ += 1;
                                questNumber += 1;
                                questWrite += 1;
                            } else {
                                questNumber += 1;
                            }
                            break;
                        case "роза":
                            if (questNumber == 6){
                                vosprQ += 1;
                                questNumber += 1;
                                questWrite += 1;
                            } else {
                                questNumber += 1;
                            }
                            break;

                        case "часы":
                            if (questNumber == 7){
                                spiakQ += 1;
                                questNumber += 1;
                                questWrite += 1;
                            } else {
                                questNumber += 1;
                            }
                            break;
                        case "карандаш":
                            if (questNumber == 8){
                                spiakQ += 1;
                                questNumber += 1;
                                questWrite += 1;
                            } else {
                                questNumber += 1;
                            }
                            break;
                        case "перо":
                            if (questNumber == 9){
                                spiakQ += 1;
                                questNumber += 1;
                                questWrite += 1;
                            } else {
                                questNumber += 1;
                            }
                            break;
                        default:
                            questNumber += 1;
                    }
            }
            }
        }

        public void GoCross(View V){
            cross.setVisibility(View.GONE);
            check.setVisibility(View.GONE);
            mic.setVisibility(View.VISIBLE);
            Otvet.setText("");
            questNumber -= 1;
        }

        @SuppressLint("SetTextI18n")
        public void GoArrow(View V){
            switch (questNumber){
                case 1:
                    if (!name.getText().toString().equals("") && !subname.getText().toString().equals("")){
                        questionText = "В каком городе вы находитесь?";
                        SpeakText = "В каком городе вы находитесь?";
                        edit.setVisibility(View.VISIBLE);
                        name.setVisibility(View.GONE);
                        subname.setVisibility(View.GONE);
                    } else{
                        Toast.makeText(this, "Введите имя.", Toast.LENGTH_SHORT).show();
                        questionText = "Введите имя";
                        check.setVisibility(View.VISIBLE);
                        mic.setVisibility(View.GONE);
                    }
                    break;
                case 2:
                    questionText = "В какой стране вы находитесь?";
                    SpeakText = "В какой стране вы находитесь?";
                    break;
                case 3:
                    questionText = "Какой сейчас год?";
                    SpeakText = "Какой сейчас год?";
                    break;
                case 4:
                    questionText = "Повторите слова, по очереди.";
                    SpeakText = "Повторите слова Арбуз, Дверь, Роза, по очереди.";
                    textQuest.setTextSize(30);
                    break;
                case 5:
                    questionText = "Следущее слово.";
                    SpeakText = "Следущее слово.";
                    textQuest.setTextSize(30);
                    break;
                case 6:
                    questionText = "Последнее слово.";
                    SpeakText = "Последнее слово.";
                    textQuest.setTextSize(30);
                    break;
                case 7:
                    questionText = "Что изображено на картинке?";
                    SpeakText = "Что изображено на картинке?";
                    textQuest.setVisibility(View.GONE);
                    imageView.setVisibility(View.VISIBLE);
                    imageView.setImageResource(clock);
                    break;
                case 8:
                    questionText = "Что изображено на картинке?";
                    SpeakText = "Что изображено на картинке?";
                    imageView.setImageResource(pensil);
                    break;
                case 9:
                    questionText = "Что изображено на картинке?";
                    SpeakText = "Что изображено на картинке?";
                    imageView.setImageResource(pero);
                    break;
                case 10:
                    SpeakText = "";
                    Intent intent = new Intent(this, ResultActivity.class);
                    intent.putExtra("orientation", orientQ);
                    intent.putExtra("reproduction", vosprQ);
                    intent.putExtra("speak", spiakQ);
                    intent.putExtra("name", name.getText().toString());
                    intent.putExtra("subname", subname.getText().toString());
                    startActivity(intent);
                    finish();
                    break;
            }
            textQuest.setText(questionText);
            if (!name.getText().toString().equals("") && !subname.getText().toString().equals("")){
                cross.setVisibility(View.GONE);
                check.setVisibility(View.GONE);
                mic.setVisibility(View.VISIBLE);
                Otvet.setText("");
            }

            tts.speak(SpeakText, TextToSpeech.QUEUE_ADD, null);
        }
}