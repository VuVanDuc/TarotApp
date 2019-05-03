package com.example.tarot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.sql.Date;

import Model.Card;
import Model.HistoryCard;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "SQLite";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Tarot";
    private static final String TABLE_CARD_HISTORY = "historycard";
    private static final String COLUMN_NOTE_ID ="Note_Id";
    private static final String COLUMN_NOTE_TITLE ="Note_Title";
    private static final String COLUMN_NOTE_CONTENT = "Note_Content";

    private Context context;

    private static MyDatabaseHelper myDB = null;

    public MyDatabaseHelper(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    public static MyDatabaseHelper getInstance(Context context){
        if(myDB == null){
            myDB = new MyDatabaseHelper(context);
        }
        return myDB;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE historycard (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "idCard TEXT," +
                "text TEXT," +
                "imageCard TEXT," +
                "nameCard TEXT," +
                "viewDate TEXT," +
                "FOREIGN KEY(idCard) REFERENCES card(idCard));";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "MyDatabaseHelper.onUpgrade ... ");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CARD_HISTORY);
        onCreate(db);
    }

    public boolean addHistoryCard(HistoryCard historyCard) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues value = new ContentValues();
            value.put("idCard",historyCard.getIdCard());
            value.put("text", historyCard.getCard().getText());
            value.put("imageCard", historyCard.getCard().getImageCard());
            value.put("nameCard", historyCard.getCard().getNameCard());
            value.put("viewDate", historyCard.getViewDate().toString());
            db.insert("historycard", null, value);
            return true;
        } catch(Exception e) {
        }
        return false;
    }

    public ArrayList<HistoryCard> getAllHistoryCard() {
        ArrayList<HistoryCard> listHistoryCard = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String sql = "SELECT * FROM historycard;";
            Cursor result = db.rawQuery(sql, null);
            if (result.moveToFirst()) {
                do {
                    HistoryCard historyCard = new HistoryCard();
//                    historyCard.setId(result.getInt(0));
                    historyCard.setIdCard(result.getString(1));
                    Card card = new Card();
                    card.setText(result.getString(2));
                    card.setImageCard(result.getString(3));
                    card.setNameCard(result.getString(4));
                    historyCard.setCard(card);
                    java.util.Date date = new java.util.Date(result.getString(5));
                    historyCard.setViewDate(date);
                    listHistoryCard.add(historyCard);
                } while (result.moveToNext());
            }
//            while(result.moveToNext()) {
//                HistoryCard historyCard = new HistoryCard();
//                historyCard.setId(result.getInt(0));
//                historyCard.setIdCard(result.getString(1));
//                historyCard.getCard().setText(result.getString(2));
//                historyCard.getCard().setImageCard(result.getString(3));
//                historyCard.getCard().setNameCard(result.getString(4));
//                historyCard.setViewDate(Date.valueOf(result.getString(5)));
//                listHistoryCard.add(historyCard);
//            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return listHistoryCard;
    }
}
