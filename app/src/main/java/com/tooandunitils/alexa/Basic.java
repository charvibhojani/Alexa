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

import java.util.ArrayList;
import java.util.Locale;

public class Basic extends Activity {

    TextToSpeech textToSpeech;
    ImageView back;
    ListView listView;
//    String[] s = {"Alexa, Help", "Alexa, Mute", "Alexa, Unmute", "Alexa, Stop", "Alexa, Volume Up", "Alexa, Volume Down", "Alexa, Set Volume to 5", "Alexa, Go to Sleep", "Alexa, Play set Volume to 10", "Alexa, open Zomato"};

//    ArrayList<ItemClass> itemClasses = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_activity);

        listView = findViewById(R.id.listView);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Basic.this, Home.class);
                startActivity(intent);
                finish();
            }
        });

        String[] Item = new String[]{"Alexa, Help", "Alexa, Mute", "Alexa, Unmute", "Alexa, Stop", "Alexa, Volume Up", "Alexa, Volume Down", "Alexa, Set Volume to 5", "Alexa, Go to Sleep", "Alexa, Play set Volume to 10", "Alexa, open Zomato"};

        ListAdapter listAdapter = new ListAdapter(Item, Basic.this);
        listView.setAdapter(listAdapter);

    }
}