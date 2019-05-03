package dao;

import java.util.ArrayList;

import Model.HistoryCard;

public interface HistoryCardDao {
    public ArrayList<HistoryCard> getAllHistoryCard();
    public boolean addHistoryCard(HistoryCard historyCard);
}
