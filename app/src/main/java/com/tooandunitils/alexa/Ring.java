package com.tooandunitils.alexa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Ring extends Activity {

    TextToSpeech textToSpeech;
    ListView listView;
    ImageView back;

//    String[] s = {"Alexa, show me the [doorbell/camera name]", "Alexa, show my front door", "Alexa, enable ring alerts", "Alexa, disable ring alerts", "Alexa,  notify me when there is motion at [doorbell/camera name]", "Alexa, talk to the [doorbell/camera name]", "Alexa, speak to the person at the [doorbell/camera name]", "Alexa, stop listening", "Alexa, trigger the alarm", "Alexa,  dim the lights"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ring_activity);

        listView = findViewById(R.id.listView);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ring.this, Home.class);
                startActivity(intent);
                finish();
            }
        });

        String[] Item = new String[]{"Alexa, show me the [doorbell/camera name]", "Alexa, show my front door", "Alexa, enable ring alerts", "Alexa, disable ring alerts", "Alexa,  notify me when there is motion at [doorbell/camera name]", "Alexa, talk to the [doorbell/camera name]", "Alexa, speak to the person at the [doorbell/camera name]", "Alexa, stop listening", "Alexa, trigger the alarm", "Alexa, dim the lights"};

        ListAdapter listAdapter = new ListAdapter(Item, Ring.this);
        listView.setAdapter(listAdapter);

//        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
//            @Override
//            public void onInit(int status) {
//
//                if (status == TextToSpeech.SUCCESS) {
//                    int tts = textToSpeech.setLanguage(Locale.UK);
//                }
//
//            }
//        });
//
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, s);
//        listView.setAdapter(arrayAdapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (position == 0) {
//
//                    textToSpeech.speak(s[0], TextToSpeech.QUEUE_FLUSH, null);
//
//                }
//                if (position == 1) {
//                    textToSpeech.speak(s[1], TextToSpeech.QUEUE_FLUSH, null);
//
//                }
//                if (position == 2) {
//                    textToSpeech.speak(s[2], TextToSpeech.QUEUE_FLUSH, null);
//
//                }
//                if (position == 3) {
//                    textToSpeech.speak(s[3], TextToSpeech.QUEUE_FLUSH, null);
//
//                }
//                if (position == 4) {
//                    textToSpeech.speak(s[4], TextToSpeech.QUEUE_FLUSH, null);
//
//                }
//                if (position == 5) {
//                    textToSpeech.speak(s[5], TextToSpeech.QUEUE_FLUSH, null);
//
//                }
//                if (position == 6) {
//                    textToSpeech.speak(s[6], TextToSpeech.QUEUE_FLUSH, null);
//
//                }
//                if (position == 7) {
//                    textToSpeech.speak(s[7], TextToSpeech.QUEUE_FLUSH, null);
//
//                }
//                if (position == 8) {
//                    textToSpeech.speak(s[8], TextToSpeech.QUEUE_FLUSH, null);
//
//                }
//                if (position == 9) {
//                    textToSpeech.speak(s[9], TextToSpeech.QUEUE_FLUSH, null);
//
//                }
//            }
//        });
    }
}
