package com.example.tarot;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import Model.Card;
import Model.History;

public class HistoryActivity extends AppCompatActivity {

    private LinearLayout homnay;
    private LinearLayout lichsu;
    private LinearLayout tarotcunghoangdao;

    GridView gridViewHistory;
    GridViewCadHistoryAdapter gridViewCadHistoryAdapter;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        homnay = (LinearLayout) findViewById(R.id.homnay_history);
        lichsu = (LinearLayout)findViewById(R.id.lichsu_history);
        tarotcunghoangdao = (LinearLayout)findViewById(R.id.tarothoangdao_history);

        gridViewHistory = findViewById(R.id.gridview_history);
        gridViewCadHistoryAdapter = new GridViewCadHistoryAdapter(getListCardHistory(), getApplicationContext());
        gridViewHistory.setAdapter(gridViewCadHistoryAdapter);

        homnay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoryActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        lichsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        tarotcunghoangdao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoryActivity.this,TarotActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<Card> getListCardHistory(){
        ArrayList<Card> list = new ArrayList<>();
        sharedPreferences = getSharedPreferences("CardHistory", MODE_PRIVATE);
        int sl = sharedPreferences.getInt("soluong", -1);
        Toast.makeText(HistoryActivity.this, sl, Toast.LENGTH_SHORT).show();
        for(int i = 0; i<=sl; i++){
            String Text = sharedPreferences.getString("Text"+sl, "null");
            String ImageCard = sharedPreferences.getString("ImageCard"+sl, "null");
            String IdCard = sharedPreferences.getString("IdCard " + sl, "null");
            String NameCard = sharedPreferences.getString("NameCard", "null");
            Card card = new Card();
            card.setIdCard(IdCard);
            card.setText(Text);
            card.setImageCard(ImageCard);
            card.setNameCard(NameCard);
            list.add(card);

        }
        return list;
    }
}
