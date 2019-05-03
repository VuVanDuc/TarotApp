package Model;

import java.io.Serializable;

public class Card implements Serializable {
    private String idCard;
    private int idTypeCard;
    private int orientCard;
    private String nameCard;
    private String imageCard;
    private String text;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getIdTypeCard() {
        return idTypeCard;
    }

    public int getOrientCard() {
        return orientCard;
    }

    public void setOrientCard(int orientCard) {
        this.orientCard = orientCard;
    }
    public void setIdTypeCard(int idTypeCard) {
        this.idTypeCard = idTypeCard;
    }

    public String getNameCard() {
        return nameCard;
    }

    public void setNameCard(String nameCard) {
        this.nameCard = nameCard;
    }

    public String getImageCard() {
        return imageCard;
    }

    public void setImageCard(String imageCard) {
        this.imageCard = imageCard;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}