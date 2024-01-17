package com.tooandunitils.alexa;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class Home extends Activity implements HomeAdapter.Myclick {

    ImageView fav, basic, music, spotify, alarm, calendar, locate, bluetooth, call, show, notify, holiday, smart, eq, fam, recipe, donate, shop, tree, echo, tv, food, settle, skill, ring, robot, animals, bird, settings;

    RecyclerView lv;
    ArrayList<ItemCategory> itemCategories = new ArrayList<>();
    ArrayList<ValueItem> valueItems = new ArrayList<>();
    String category = "";
    ImageView favv, custom;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_list_new);

        lv = findViewById(R.id.lv);
        favv = findViewById(R.id.favv);
        custom = findViewById(R.id.custom);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        lv.setLayoutManager(gridLayoutManager);

        itemCategories.add(new ItemCategory(R.drawable.ic_alarms, "Alarms"));
        itemCategories.add(new ItemCategory(R.drawable.ic_basic, "Basics"));
        itemCategories.add(new ItemCategory(R.drawable.ic_bluetooth, "Bluetooth"));
        itemCategories.add(new ItemCategory(R.drawable.ic_calender, "Calender"));
        itemCategories.add(new ItemCategory(R.drawable.ic_callme, "Call-me"));
        itemCategories.add(new ItemCategory(R.drawable.ic_echo_show, "Echo"));
        itemCategories.add(new ItemCategory(R.drawable.ic_eq_control, "EQ-Control"));
        itemCategories.add(new ItemCategory(R.drawable.ic_family, "Family"));
        itemCategories.add(new ItemCategory(R.drawable.ic_food, "Food"));
        itemCategories.add(new ItemCategory(R.drawable.ic_christmas, "Christmas"));
        itemCategories.add(new ItemCategory(R.drawable.ic_skills, "Skills"));
        itemCategories.add(new ItemCategory(R.drawable.ic_local, "Local"));
        itemCategories.add(new ItemCategory(R.drawable.ic_music, "Music"));
        itemCategories.add(new ItemCategory(R.drawable.ic_notification, "Notifications"));
        itemCategories.add(new ItemCategory(R.drawable.ic_recepie, "Recipe"));
        itemCategories.add(new ItemCategory(R.drawable.ic_remote, "Remote"));
        itemCategories.add(new ItemCategory(R.drawable.ic_ring, "Ring"));
        itemCategories.add(new ItemCategory(R.drawable.ic_robot, "Robot"));
        itemCategories.add(new ItemCategory(R.drawable.ic_settled_score, "Settled-score"));
        itemCategories.add(new ItemCategory(R.drawable.ic_shopping, "Shopping"));
        itemCategories.add(new ItemCategory(R.drawable.ic_show, "Show"));
        itemCategories.add(new ItemCategory(R.drawable.ic_spotifi, "Spotify"));

        HomeAdapter homeAdapter = new HomeAdapter(itemCategories, Home.this, Home.this);
        lv.setAdapter(homeAdapter);

        favv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Fav.class);
                startActivity(intent);
            }
        });

        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Custom_List.class);
                startActivity(intent);
            }
        });
    }

    public void getmypos(int pos) {

        category = itemCategories.get(pos).getName();

        SharedPreference.setCategory(category);

        Intent intent = new Intent(Home.this, ValueActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}