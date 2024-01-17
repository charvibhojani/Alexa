package com.tooandunitils.alexa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.Myh> {

    Context context;
    ArrayList<FavItem> favItems;
    FavDB favDB;
    TextToSpeech textToSpeech;
    SQLiteDatabase db;

    public FavAdapter(Context context, ArrayList<FavItem> favItems) {
        this.context = context;
        this.favItems = favItems;
        favDB = new FavDB(context);

        Collections.sort(favItems, new Comparator<FavItem>() {
            @Override
            public int compare(FavItem item1, FavItem item2) {
                return item1.getText().compareTo(item2.getText());
            }
        });

        favDB = new FavDB(context);

        db = favDB.getReadableDatabase();

        textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                try {
                    textToSpeech.setLanguage(Locale.US);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @NonNull
    @Override
    public FavAdapter.Myh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.fav_activity, parent, false);

        return new Myh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavAdapter.Myh holder, int position) {

        holder.favl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textToRead = favItems.get(position).getText();
                if (textToRead != null && !textToRead.isEmpty()) {
//                    Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
                    textToSpeech.speak(textToRead, TextToSpeech.QUEUE_FLUSH, null, null);
                } else {
                    Toast.makeText(context, "Fail", Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = favItems.get(position).getText();

                boolean success = favDB.deleteCategory_fav(context, text);

                if (success) {
                    favItems.remove(holder.getAdapterPosition());
                    notifyDataSetChanged();
                } else {
                    Log.e("TAG", "onClick: " + success );
                    Toast.makeText(context, "Category deletion failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        favDB.readdata();

        holder.text.setText(favItems.get(position).getText());

    }

    @Override
    public int getItemCount() {
        return favItems.size();
    }

    public class Myh extends RecyclerView.ViewHolder {

        TextView text;
        ImageView img, btn_delete;
        FrameLayout favl;

        public Myh(@NonNull View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.text);
            img = itemView.findViewById(R.id.img);
            btn_delete = itemView.findViewById(R.id.btn_delete);
            favl = itemView.findViewById(R.id.favl);

        }
    }
}
