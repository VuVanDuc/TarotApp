package com.example.tarot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import Model.History;
import Model.HistoryCard;

public class HistoryActivity extends AppCompatActivity {

    private LinearLayout homnay;
    private LinearLayout lichsu;
    private LinearLayout tarotcunghoangdao;
    private ImageView backButtonHistory;

    GridView gridViewHistory;
    GridViewCadHistoryAdapter gridViewCadHistoryAdapter;
    ArrayList<HistoryCard> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        homnay = (LinearLayout) findViewById(R.id.homnay_history);
        lichsu = (LinearLayout)findViewById(R.id.lichsu_history);
        tarotcunghoangdao = (LinearLayout)findViewById(R.id.tarothoangdao_history);
        backButtonHistory = findViewById(R.id.back_button_history);

        gridViewHistory = findViewById(R.id.gridview_history);
        getListCardHistory();
        gridViewCadHistoryAdapter = new GridViewCadHistoryAdapter(list, getApplicationContext());
        gridViewHistory.setAdapter(gridViewCadHistoryAdapter);

        gridViewHistory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HistoryCard historyCard = list.get(position);
                Intent intent = new Intent(HistoryActivity.this, ResultCardActivity.class);
                intent.putExtra("Card", historyCard.getCard());
                startActivity(intent);
            }
        });

        backButtonHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        homnay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoryActivity.this, GameTarotActivity.class);
                startActivity(intent);
                finish();
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
                finish();
            }
        });
    }

    private void getListCardHistory(){
        MyDatabaseHelper db = MyDatabaseHelper.getInstance(getApplicationContext());
        list = db.getAllHistoryCard();
//        Toast.makeText(HistoryActivity.this, list.size() + "", Toast.LENGTH_LONG).show();
    }
}
