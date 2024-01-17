package com.tooandunitils.alexa;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Birds extends Activity {

    TextToSpeech textToSpeech;
    ListView listView;
    String[] s = {"Alexa, play bird songs", "Alexa, what sound does a [bird species] make?", "Alexa, describe the appearance of [bird species]", "Alexa, what are some common bird calls?", "Alexa, give me an interesting fact about birds", "Alexa, tell me a bird-related trivia", "Alexa, what is the national bird of [country]?", "Alexa, how many bird species are there in the world?", "Alexa, identify this bird", "Alexa,  what bird has [specific characteristics]?"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bird_activity);

        listView = findViewById(R.id.listView);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if (status == TextToSpeech.SUCCESS) {
                    int tts = textToSpeech.setLanguage(Locale.UK);
                }

            }
        });

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, s);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {

                    textToSpeech.speak(s[0], TextToSpeech.QUEUE_FLUSH, null);

                }
                if (position == 1) {
                    textToSpeech.speak(s[1], TextToSpeech.QUEUE_FLUSH, null);

                }
                if (position == 2) {
                    textToSpeech.speak(s[2], TextToSpeech.QUEUE_FLUSH, null);

                }
                if (position == 3) {
                    textToSpeech.speak(s[3], TextToSpeech.QUEUE_FLUSH, null);

                }
                if (position == 4) {
                    textToSpeech.speak(s[4], TextToSpeech.QUEUE_FLUSH, null);

                }
                if (position == 5) {
                    textToSpeech.speak(s[5], TextToSpeech.QUEUE_FLUSH, null);

                }
                if (position == 6) {
                    textToSpeech.speak(s[6], TextToSpeech.QUEUE_FLUSH, null);

                }
                if (position == 7) {
                    textToSpeech.speak(s[7], TextToSpeech.QUEUE_FLUSH, null);

                }
                if (position == 8) {
                    textToSpeech.speak(s[8], TextToSpeech.QUEUE_FLUSH, null);

                }
                if (position == 9) {
                    textToSpeech.speak(s[9], TextToSpeech.QUEUE_FLUSH, null);

                }
            }
        });
    }
}
