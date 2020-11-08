package com.example.fragmentactivity;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    private Context context;
    private ArrayList<Data> models;



    public Adapter(Context context, ArrayList<Data> models){
        this.context = context;
        this.models = models;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView title;
        TextView bodyInfo;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.title);
            bodyInfo = itemView.findViewById(R.id.bodyInfo);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).
                inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position ) {
        ((ViewHolder) holder).title.setText(models.get(position).getTitle());
        ((ViewHolder) holder).bodyInfo.setText(models.get(position).getBodyInfo());
        Glide.with(context)
                .load(models.get(position).getImage())
                .into( ((ViewHolder) holder).imageView);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}



