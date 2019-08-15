package com.example.tarot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import Model.Tarot;

public class GridViewCustomAdapter extends BaseAdapter {
    private List<Tarot> listTarot;
    private LayoutInflater layoutInflater;
    private Context context;

    public GridViewCustomAdapter(List<Tarot> listTarot, Context context) {
        this.listTarot = listTarot;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listTarot == null ? 0 : listTarot.size();
    }

    @Override
    public Object getItem(int position) {
        return listTarot.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(Integer.toString(listTarot.get(position).getTarotIDImage()));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getViewImageTextCustom(position, convertView, parent);
    }

    private View getViewImageTextCustom(int position, View convertView, ViewGroup parent) {
        ViewImageTextHolder viewImageTextHolder;
        if (convertView == null) {
            convertView =
                    layoutInflater
                            .inflate(R.layout.item_grid_view_custom_image_and_text, parent, false);
            viewImageTextHolder = new ViewImageTextHolder();
            viewImageTextHolder.tarot_name = convertView.findViewById(
                    R.id.tarot_name);
            viewImageTextHolder.tarot_date = convertView.findViewById(
                    R.id.tarot_date);
            viewImageTextHolder.tarot_image = convertView.findViewById(
                    R.id.tarot_image);
            convertView.setTag(viewImageTextHolder);
        } else {
            viewImageTextHolder = (ViewImageTextHolder) convertView.getTag();
        }
        Tarot tarot = listTarot.get(position);
        String tarotName = tarot.getTarotName();
        String tarotDate = tarot.getTarotDate();

        viewImageTextHolder.tarot_name.setText(tarotName);
        viewImageTextHolder.tarot_date.setText(tarotDate);
        viewImageTextHolder.tarot_image.setImageResource(tarot.getTarotIDImage());
        return convertView;
    }
    private class ViewImageTextHolder {
        private TextView tarot_name;
        private TextView tarot_date;
        private ImageView tarot_image;
    }
}
