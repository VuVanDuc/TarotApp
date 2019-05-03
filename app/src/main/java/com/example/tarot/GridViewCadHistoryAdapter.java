package com.example.tarot;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import Model.Card;
import Model.Tarot;

public class GridViewCadHistoryAdapter extends BaseAdapter {
    List<Card> listCard;
    private LayoutInflater layoutInflater;
    Context context;

    public GridViewCadHistoryAdapter(List<Card> listCard, Context context) {
        this.listCard = listCard;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return listCard == null ? 0 : listCard.size();
    }

    @Override
    public Object getItem(int position) {
        return listCard.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(listCard.get(position).getIdCard());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GridViewCadHistoryAdapter.ViewImageTextHolder viewImageTextHolder;
        if (convertView == null) {
            convertView =
                    layoutInflater
                            .inflate(R.layout.card_item_history, parent, false);
            viewImageTextHolder = new GridViewCadHistoryAdapter.ViewImageTextHolder();
            viewImageTextHolder.date_history = convertView.findViewById(
                    R.id.date_history);
            viewImageTextHolder.card_history_image = convertView.findViewById(
                    R.id.card_history_image);
            convertView.setTag(viewImageTextHolder);
        } else {
            viewImageTextHolder = (GridViewCadHistoryAdapter.ViewImageTextHolder) convertView.getTag();
        }
        Card card = listCard.get(position);

        viewImageTextHolder.date_history.setText("03/05/2019");
        try{
            InputStream inputStream = context.getAssets().open(card.getImageCard());
            Bitmap image = BitmapFactory.decodeStream(inputStream);
            viewImageTextHolder.card_history_image.setImageBitmap(image);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return convertView;
    }

    private class ViewImageTextHolder {
        private TextView date_history;
        private ImageView card_history_image;
    }
}
