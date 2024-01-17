package com.tooandunitils.alexa;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Locale;

public class ListAdapter extends BaseAdapter {

//    ArrayList<ItemClass> itemClasses;
    Context context;

    TextToSpeech textToSpeech;

    String [] item2;

    public ListAdapter(String [] Item, Context context) {
        this.item2 = Item;
        this.context = context;

        textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.US);
                }
            }
        });
    }

    @Override
    public int getCount() {
        return item2.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.custom_list, parent, false);
        }

        TextView text = convertView.findViewById(R.id.text);
        ImageView img = convertView.findViewById(R.id.img);

        String data = item2[position];
        text.setText(data);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        return convertView;
    }


//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        View view1 = LayoutInflater.from(context).inflate(R.layout.custom_list, parent, false);
//
//        TextView text = view1.findViewById(R.id.text);
//
//        text.setText(itemClasses.get(position).getText());
//
//        return view1;
//    }
}
