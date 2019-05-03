package dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Date;
import java.util.ArrayList;

import dao.HistoryCardDao;
import Model.HistoryCard;

public class HistoryCardDaoImpl extends SQLiteOpenHelper implements HistoryCardDao {

    private final static String DATABASE_NAME = "tarot";
    private final static int DATABASE_VERSION = 1;

    public HistoryCardDaoImpl(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public ArrayList<HistoryCard> getAllHistoryCard() {
        ArrayList<HistoryCard> listHistoryCard = new ArrayList<>();
        try {
            SQLiteDatabase db = getReadableDatabase();
            String sql = "SELECT * FROM historycard";
            Cursor result = db.rawQuery(sql, null);
            while(result.moveToNext()) {
                HistoryCard historyCard = new HistoryCard();
                historyCard.setId(result.getInt(0));
                historyCard.setIdCard(result.getString(1));
                historyCard.setViewDate(Date.valueOf(result.getString(2)));
                listHistoryCard.add(historyCard);
            }
        } catch(Exception e) {
        }
        return listHistoryCard;
    }

    @Override
    public boolean addHistoryCard(HistoryCard historyCard) {
        try {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues value = new ContentValues();
            value.put("idCard",historyCard.getIdCard());
            value.put("viewDate", historyCard.getViewDate().toString());
            db.insert("historycard", null, value);
            return true;
        } catch(Exception e) {
        }
        return false;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE historycard (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "idCard TEXT," +
                "viewDate TEXT," +
                "FOREIGN KEY(idCard) REFERENCES card(idCard));";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
