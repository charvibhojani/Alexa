package com.tooandunitils.alexa;

import android.app.Application;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class SharedPreference extends Application {

    static SharedPreferences sharedPreferences;
    static SharedPreferences.Editor editor;

    static SQLiteDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();

        sharedPreferences = getSharedPreferences("my", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        db = openOrCreateDatabase("my.db", MODE_PRIVATE, null);

        db.execSQL("create table if not exists VoiceCommand(commands text)");

    }

    public static void setCategory(String id) {
        editor.putString("id", id).commit();
    }

    public static String getCategory() {
        return sharedPreferences.getString("id", "");

    }
}