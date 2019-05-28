package com.example.tarot;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import Model.Card;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    private Card data;
    private Context context;

    public RecyclerViewAdapter(Card data, Context context) {
        this.data = data;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerViewAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.card_detail, viewGroup, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.RecyclerViewHolder recyclerViewHolder, int i) {
        recyclerViewHolder.content_card.setText(data.getText());
        try {
            InputStream inputStream = context.getAssets().open(data.getImageCard());
            Bitmap image = BitmapFactory.decodeStream(inputStream);
            recyclerViewHolder.card_image.setImageBitmap(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView card_image;
        TextView content_card;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            card_image = itemView.findViewById(R.id.card_image);
            content_card = itemView.findViewById(R.id.content_card);
        }
    }
}
