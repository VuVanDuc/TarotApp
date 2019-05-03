package Model;

import java.util.Date;

public class History {
    private Date dateRut;
    private int cardID;

    public History(Date dateRut, int cardID) {
        this.dateRut = dateRut;
        this.cardID = cardID;
    }

    public History() {
    }

    public Date getDateRut() {
        return dateRut;
    }

    public void setDateRut(Date dateRut) {
        this.dateRut = dateRut;
    }

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }
}
