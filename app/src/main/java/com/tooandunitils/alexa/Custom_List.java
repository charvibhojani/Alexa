package com.tooandunitils.alexa;

import static com.tooandunitils.alexa.FavDB.TABLE_NAME_1;
import static com.tooandunitils.alexa.SharedPreference.db;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Custom_List extends Activity implements CustomListAdapter.Myclick{

    RecyclerView lv1;
    FavDB favDB;
    ArrayList<CustomItem> customItems;
    ImageView back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        lv1 = findViewById(R.id.lv1);
        back = findViewById(R.id.back);

        favDB = new FavDB(this);
        customItems = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        lv1.setLayoutManager(linearLayoutManager);

        data_load();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Custom_List.this, Home.class);
//                startActivity(intent);
//                finish();
                finish();
            }
        });

    }

    private void data_load() {

        if (customItems != null){
            customItems.clear();
        }
        SQLiteDatabase db = favDB.getReadableDatabase();
        Cursor cursor = favDB.readdata_custom();

        try {
            String idIndex = String.valueOf(cursor.getColumnIndexOrThrow("custom_text"));
            customItems = new ArrayList<>();

            while (cursor.moveToNext()){
                String id = cursor.getString(Integer.parseInt(idIndex));

                Log.d("Custom_List", "Retrieved custom text: " + id);

                CustomItem customItem = new CustomItem(id, false );
                customItems.add(customItem);
            }

            Log.d("Custom_List", "Number of rows retrieved: " + cursor.getCount());

        }finally {
            if (cursor != null && cursor.isClosed())
                cursor.close();
            db.close();
        }

        CustomListAdapter customListAdapter = new CustomListAdapter(customItems, Custom_List.this, Custom_List.this);
        lv1.setAdapter(customListAdapter);

    }

    @Override
    public void getmypos(int pos) {

    }
}
