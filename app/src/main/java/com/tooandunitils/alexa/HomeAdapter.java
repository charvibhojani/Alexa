package com.tooandunitils.alexa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.Myh> {

    ArrayList<ItemCategory> itemCategories;
    Context context;
    Myclick myclick;

    public HomeAdapter(ArrayList<ItemCategory> itemCategories, Context context, Myclick myclick) {

        this.itemCategories = itemCategories;
        this.context = context;
        this.myclick = myclick;
    }

    @NonNull
    @Override
    public Myh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_home_new, parent, false);

        return new Myh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myh holder, int position) {

        Glide.with(context).load(itemCategories.get(position).getImageResource()).into(holder.image1);

        holder.ly.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                myclick.getmypos(position);
            }

        });
    }

    @Override
    public int getItemCount() {
        return itemCategories.size();
    }

    public class Myh extends RecyclerView.ViewHolder {

        LinearLayout ly;
        ImageView image1;

        public Myh(@NonNull View itemView) {
            super(itemView);

            ly = itemView.findViewById(R.id.ly);
            image1 = itemView.findViewById(R.id.image1);

        }
    }

    public interface Myclick {


        public void getmypos(int pos);
    }
}
