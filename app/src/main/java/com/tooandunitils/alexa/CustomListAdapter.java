package com.tooandunitils.alexa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.speech.tts.TextToSpeech;
import android.telecom.Connection;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

public class CustomListAdapter extends RecyclerView.Adapter<CustomListAdapter.Myh> {

    ArrayList<CustomShowItem> customShowItems;
    ArrayList<CustomItem> customItems;
    Context context;
    private final FavDB favDB;
    SQLiteDatabase db;
    String text;
    private final PreferenceHelper preferenceHelper;
    TextToSpeech textToSpeech;
    Myclick myclick;

    public CustomListAdapter(ArrayList<CustomItem> customItems, Context context, Myclick myclick) {
        this.customItems = customItems;
        this.context = context;
        this.myclick = myclick;

        Collections.sort(customItems, new Comparator<CustomItem>() {
            @Override
            public int compare(CustomItem item1, CustomItem item2) {
                return item1.getText().compareTo(item2.getText());
            }
        });

        favDB = new FavDB(context);

        db = favDB.getWritableDatabase();

        preferenceHelper = new PreferenceHelper(context);

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
    public CustomListAdapter.Myh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_value_new, parent, false);

        return new Myh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomListAdapter.Myh holder, int position) {

        holder.text.setText(customItems.get(position).getText());

        favDB.readdata_custom();

        CustomItem customItem = customItems.get(position);

        holder.text.setText(customItem.getText());

        if (customItem.isFavorite() || favDB.isFavorite(customItem.getText())) {
            holder.fav.setImageResource(R.drawable.likee);
        } else {
            holder.fav.setImageResource(R.drawable.like_1);
        }

        holder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (preferenceHelper.getLikedItems().contains(customItem.getText())) {
                    holder.fav.setImageResource(R.drawable.like_1);
                    preferenceHelper.removeLikedItem(customItem.getText());
                    favDB.removeData(customItem.getText());
                } else {
                    holder.fav.setImageResource(R.drawable.likee);
                    preferenceHelper.addLikedItem(customItem.getText());
                    favDB.insertdata(customItem.getText());
                }
            }
        });

        holder.lv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myclick.getmypos(position);

            }
        });

        holder.fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textToRead = customItems.get(position).getText();
                if (textToRead != null && !textToRead.isEmpty()) {
//                    Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
                    textToSpeech.speak(textToRead, TextToSpeech.QUEUE_FLUSH, null, null);
                } else {
                    Toast.makeText(context, "Fail", Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = customItems.get(position).getText();
                boolean success = favDB.deleteCategory_custom(context, text);

                if (success) {
                    customItems.remove(holder.getAdapterPosition());
                    notifyDataSetChanged();
                    myclick.getmypos(position);
                } else {
                    Log.e("TAG", "onClick: " + success);
                    Toast.makeText(context, "Category deletion failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return customItems.size();
    }

    public class Myh extends RecyclerView.ViewHolder {

        ImageView fav, img, delete;
        FrameLayout fl;
        RelativeLayout lv;
        TextView text;

        public Myh(@NonNull View itemView) {
            super(itemView);

            fav = itemView.findViewById(R.id.fav);
            img = itemView.findViewById(R.id.img);
            fl = itemView.findViewById(R.id.fl);
            text = itemView.findViewById(R.id.text);
            lv = itemView.findViewById(R.id.lv);
            delete = itemView.findViewById(R.id.delete);

        }
    }

    public interface Myclick {

        void getmypos(int pos);

    }
}