package Model;

import java.io.Serializable;

public class Tarot implements Serializable {
    private int TarotIDImage;
    private String TarotName;
    private String TarotDate;
    private String ImageTarot1;
    private String DetailTarot1;
    private String ImageTarot2;
    private String DetailTarot2;
    private String ImageName1;
    private String ImageName2;

    public Tarot(int tarotIDImage, String tarotName, String tarotDate, String imageTarot1, String detailTarot1, String imageTarot2, String detailTarot2, String imageName1, String imageName2) {
        TarotIDImage = tarotIDImage;
        TarotName = tarotName;
        TarotDate = tarotDate;
        ImageTarot1 = imageTarot1;
        DetailTarot1 = detailTarot1;
        ImageTarot2 = imageTarot2;
        DetailTarot2 = detailTarot2;
        ImageName1 = imageName1;
        ImageName2 = imageName2;
    }

    public Tarot(int tarotIDImage, String tarotName, String tarotDate, String imageTarot1, String detailTarot1, String imageTarot2, String detailTarot2) {
        TarotIDImage = tarotIDImage;
        TarotName = tarotName;
        TarotDate = tarotDate;
        ImageTarot1 = imageTarot1;
        DetailTarot1 = detailTarot1;
        ImageTarot2 = imageTarot2;
        DetailTarot2 = detailTarot2;
    }

    public int getTarotIDImage() {
        return TarotIDImage;
    }

    public void setTarotIDImage(int tarotIDImage) {
        TarotIDImage = tarotIDImage;
    }

    public String getTarotName() {
        return TarotName;
    }

    public void setTarotName(String tarotName) {
        TarotName = tarotName;
    }

    public String getImageName1() {
        return ImageName1;
    }

    public void setImageName1(String imageName1) {
        ImageName1 = imageName1;
    }

    public String getImageName2() {
        return ImageName2;
    }

    public void setImageName2(String imageName2) {
        ImageName2 = imageName2;
    }

    public String getTarotDate() {
        return TarotDate;
    }

    public void setTarotDate(String tarotDate) {
        TarotDate = tarotDate;
    }

    public String getImageTarot1() {
        return ImageTarot1;
    }

    public void setImageTarot1(String imageTarot1) {
        ImageTarot1 = imageTarot1;
    }

    public String getDetailTarot1() {
        return DetailTarot1;
    }

    public void setDetailTarot1(String detailTarot1) {
        DetailTarot1 = detailTarot1;
    }

    public String getImageTarot2() {
        return ImageTarot2;
    }

    public void setImageTarot2(String imageTarot2) {
        ImageTarot2 = imageTarot2;
    }

    public String getDetailTarot2() {
        return DetailTarot2;
    }

    public void setDetailTarot2(String detailTarot2) {
        DetailTarot2 = detailTarot2;
    }
}
