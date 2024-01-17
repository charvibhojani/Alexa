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

public class Animals extends Activity {

    TextToSpeech textToSpeech;
    ListView listView;
    String[] s = {"Alexa, tell me about Lion", "Alexa, what is the lifespan of Peacock?", "Alexa, what is the average weight of elephant?", "Alexa, what sound does a rabbit make?", "Alexa, play the sound of a tiger", "Alexa, give me an interesting fact about mouse", "Alexa, tell me a funny animal fact", "Alexa, what is a unique behavior of giraffe", "Alexa,  start an animal trivia game", "Alexa, ask me an animal question"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_activity);

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
