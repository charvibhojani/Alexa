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

public class Family extends Activity {

    TextToSpeech textToSpeech;
    ListView listView;
    ImageView back;

//    String[] s = {"Alexa, Send a hug", "Alexa, call my Daddy", "Alexa, drop a message on family whatsapp group", "Alexa, play a multiplayer game", "Alexa, start a trivia game for 5 members", "Alexa, play a movie for the whole family", "Alexa, show photo memories with grandmother", "Alexa, create a shared shopping list for [family/friends]", "Alexa, remind me to call [family member/friend's name] on their birthday", "Alexa,  remind me to wish [family member/friend's name] a happy anniversary"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fam_activity);

        listView = findViewById(R.id.listView);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Family.this, Home.class);
                startActivity(intent);
                finish();
            }
        });

        String[] Item = new String[]{"Alexa, Send a hug", "Alexa, call my Daddy", "Alexa, drop a message on family whatsapp group", "Alexa, play a multiplayer game", "Alexa, start a trivia game for 5 members", "Alexa, play a movie for the whole family", "Alexa, show photo memories with grandmother", "Alexa, create a shared shopping list for [family/friends]", "Alexa, remind me to call [family member/friend's name] on their birthday", "Alexa,  remind me to wish [family member/friend's name] a happy anniversary"};

        ListAdapter listAdapter = new ListAdapter(Item, Family.this);
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
