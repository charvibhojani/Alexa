package com.tooandunitils.alexa;

import android.content.ClipData;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Locale;

public class ValueAdapter extends RecyclerView.Adapter<ValueAdapter.Myh> {

    ArrayList<ValueItem> valueItems;
    Context context;
    Myclick myclick;
    FavDB favDB;
    TextToSpeech textToSpeech;
    private PreferenceHelper preferenceHelper;

    public ValueAdapter(ArrayList<ValueItem> valueItems, Context context, Myclick myclick) {

        this.valueItems = valueItems;
        this.context = context;
        this.myclick = myclick;
        favDB = new FavDB(context);

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
    public ValueAdapter.Myh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.activity_custom_text, parent, false);

        return new Myh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myh holder, int position) {
        ValueItem valueItem = valueItems.get(position);

        holder.text.setText(valueItem.getText());

        if (valueItem.isFavorite() || favDB.isFavorite(valueItem.getText())) {
            holder.fav.setImageResource(R.drawable.likee);
        } else {
            holder.fav.setImageResource(R.drawable.like_1);
        }

        holder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (preferenceHelper.getLikedItems().contains(valueItem.getText())) {
                    holder.fav.setImageResource(R.drawable.like_1);
                    preferenceHelper.removeLikedItem(valueItem.getText());
                    favDB.removeData(valueItem.getText());
                } else {
                    holder.fav.setImageResource(R.drawable.likee);
                    preferenceHelper.addLikedItem(valueItem.getText());
                    favDB.insertdata(valueItem.getText());
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

                String textToRead = valueItems.get(position).getText();
                if (textToRead != null && !textToRead.isEmpty()) {
//                    Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
                    textToSpeech.speak(textToRead, TextToSpeech.QUEUE_FLUSH, null, null);
                } else {
                    Toast.makeText(context, "Fail", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return valueItems.size();
    }

    public class Myh extends RecyclerView.ViewHolder {
        RelativeLayout lv;
        TextView text;
        ImageView fav;
        FrameLayout fl;

        public Myh(@NonNull View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.text);
            lv = itemView.findViewById(R.id.lv);
            fav = itemView.findViewById(R.id.fav);
            fl = itemView.findViewById(R.id.fl);

        }
    }

    public interface Myclick {

        public void getmypos(int pos);

    }
}
