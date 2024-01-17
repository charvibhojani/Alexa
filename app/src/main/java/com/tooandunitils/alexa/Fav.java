package com.tooandunitils.alexa;

import static com.tooandunitils.alexa.SharedPreference.db;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Fav extends Activity implements ValueAdapter.Myclick {

    RecyclerView rv;
    ArrayList<FavItem> favItems = new ArrayList<>();
    FavDB favDB;
    FavAdapter favAdapter;
    ImageView back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fav_list);

        rv = findViewById(R.id.rv);
        back = findViewById(R.id.back);

        favDB = new FavDB(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);

        rv.setHasFixedSize(true);

        data_load();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Fav.this, Home.class);
//                startActivity(intent);
                finish();
            }
        });

    }

    private void data_load() {

        favItems.clear();

        SQLiteDatabase db = favDB.getReadableDatabase();
        Cursor cursor = favDB.readdata();

        try {
            String idIndex = String.valueOf(cursor.getColumnIndexOrThrow("text"));
            favItems = new ArrayList<>();

            while (cursor.moveToNext()) {
                String id = cursor.getString(Integer.parseInt(idIndex));
//                String command = cursor.getString(0);
                FavItem favItem = new FavItem(id, 0);
                favItems.add(favItem);
            }
        } finally {
            if (cursor != null && cursor.isClosed())
                cursor.close();
            db.close();
        }

        favAdapter = new FavAdapter(getApplicationContext(), favItems);
        rv.setAdapter(favAdapter);

    }

    @Override
    public void getmypos(int pos) {

    }
}
