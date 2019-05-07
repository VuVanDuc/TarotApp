package com.example.tarot;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Date;
import java.util.Random;

import Model.Card;
import Model.HistoryCard;

public class MainActivity extends AppCompatActivity {

    private ImageView lungbai;
    private TextView trangthai1, trangthai2;
    private LinearLayout homnay;
    private LinearLayout lichsu;
    private LinearLayout tarotcunghoangdao;
    private int darut = 0;

    Random random;
    InputStream inputStream;
    AssetManager assetManager;
    Bitmap bitmap;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    MyDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lungbai = (ImageView)findViewById(R.id.card_back);
        trangthai1 = (TextView)findViewById(R.id.trangthai1);
        trangthai2 = (TextView)findViewById(R.id.trangthai2);
        homnay = (LinearLayout) findViewById(R.id.homnay);
        lichsu = (LinearLayout)findViewById(R.id.lichsu);
        tarotcunghoangdao = (LinearLayout)findViewById(R.id.tarothoangdao);

        random = new Random();
        assetManager = getAssets();
        sharedPreferences = getSharedPreferences("CardHistory", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        db = MyDatabaseHelper.getInstance(getApplicationContext());

        //sự kiện khi click vào hình bài
        //chuyển đến trang kết quả: gồm hình ảnh+content
        String trangthai = getIntent().getStringExtra("darut");
        if(trangthai!=null){
            darut = Integer.parseInt(trangthai);
            if(darut==1){
                //  RESOURCE LÀ LINH ĐỘNG TÙY THEO CARD, gọi hàm getImage() của card
                lungbai.setBackgroundResource(R.drawable.card_template);
                //
                trangthai1.setText("Hôm nay bạn đã rút bài.");
                trangthai2.setText(" Hãy nhấn vào lá bài để xem lại!");
            }
        }

        //
        lungbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Bai cua ban la!", Toast.LENGTH_SHORT).show();
                if(darut==0){
                    int i = random.nextInt(21);
                    String des = new String();
                    Card card = new Card();
                    switch (i){
                        case 0: {
                            // La The Fool
                            try {
                                inputStream = assetManager.open("MajorArcana/0_TheFool_0.txt");
                                int size = inputStream.available();
                                byte[] buffer = new byte[size];
                                inputStream.read(buffer);
                                inputStream.close();
                                des = new String(buffer);
                                inputStream = assetManager.open("MajorArcana/0_TheFool_0.png");
                                bitmap = BitmapFactory.decodeStream(inputStream);
                                lungbai.setImageBitmap(bitmap);
                                card.setText(des);
                                card.setImageCard("MajorArcana/0_TheFool_0.png");
                                card.setNameCard("The Fool");
                                card.setIdCard("0");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 1:{
                            // La The Magician
                            try {
                                inputStream = assetManager.open("MajorArcana/1_TheMagician_0.txt");
                                int size = inputStream.available();
                                byte[] buffer = new byte[size];
                                inputStream.read(buffer);
                                inputStream.close();
                                des = new String(buffer);
                                inputStream = assetManager.open("MajorArcana/1_TheMagician_0.png");
                                bitmap = BitmapFactory.decodeStream(inputStream);
                                lungbai.setImageBitmap(bitmap);
                                card.setText(des);
                                card.setImageCard("MajorArcana/1_TheMagician_0.png");
                                card.setNameCard("The Magician");
                                card.setIdCard("1");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 2:{
                            // La The High Priestess
                            try {
                                inputStream = assetManager.open("MajorArcana/2_TheHighPriestess_0.txt");
                                int size = inputStream.available();
                                byte[] buffer = new byte[size];
                                inputStream.read(buffer);
                                inputStream.close();
                                des = new String(buffer);
                                inputStream = assetManager.open("MajorArcana/2_TheHighPriestess_0.png");
                                bitmap = BitmapFactory.decodeStream(inputStream);
                                lungbai.setImageBitmap(bitmap);
                                card.setText(des);
                                card.setImageCard("MajorArcana/2_TheHighPriestess_0.png");
                                card.setNameCard("The High Priestess");
                                card.setIdCard("2");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 3:{
                            // La The Empress
                            try {
                                inputStream = assetManager.open("MajorArcana/3_TheEmpress_0.txt");
                                int size = inputStream.available();
                                byte[] buffer = new byte[size];
                                inputStream.read(buffer);
                                inputStream.close();
                                des = new String(buffer);
                                inputStream = assetManager.open("MajorArcana/3_TheEmpress_0.png");
                                bitmap = BitmapFactory.decodeStream(inputStream);
                                lungbai.setImageBitmap(bitmap);
                                card.setText(des);
                                card.setImageCard("MajorArcana/3_TheEmpress_0.png");
                                card.setNameCard("The Empress");
                                card.setIdCard("3");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 4:{
                            // La The Emperor
                            try {
                                inputStream = assetManager.open("MajorArcana/4_The Emperor_0.txt");
                                int size = inputStream.available();
                                byte[] buffer = new byte[size];
                                inputStream.read(buffer);
                                inputStream.close();
                                des = new String(buffer);
                                inputStream = assetManager.open("MajorArcana/4_The Emperor_0.png");
                                bitmap = BitmapFactory.decodeStream(inputStream);
                                lungbai.setImageBitmap(bitmap);
                                card.setText(des);
                                card.setImageCard("MajorArcana/4_The Emperor_0.png");
                                card.setNameCard("The Emperor");
                                card.setIdCard("4");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 5:{
                            // La The Hierophant
                            try {
                                inputStream = assetManager.open("MajorArcana/5_TheHierophant_0.txt");
                                int size = inputStream.available();
                                byte[] buffer = new byte[size];
                                inputStream.read(buffer);
                                inputStream.close();
                                des = new String(buffer);
                                inputStream = assetManager.open("MajorArcana/5_TheHierophant_0.png");
                                bitmap = BitmapFactory.decodeStream(inputStream);
                                lungbai.setImageBitmap(bitmap);
                                card.setText(des);
                                card.setImageCard("MajorArcana/5_TheHierophant_0.png");
                                card.setNameCard("The Hierophant");
                                card.setIdCard("5");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 6:{
                            // La The Lovers
                            try {
                                inputStream = assetManager.open("MajorArcana/6_TheLovers_0.txt");
                                int size = inputStream.available();
                                byte[] buffer = new byte[size];
                                inputStream.read(buffer);
                                inputStream.close();
                                des = new String(buffer);
                                inputStream = assetManager.open("MajorArcana/6_TheLovers_0.png");
                                bitmap = BitmapFactory.decodeStream(inputStream);
                                lungbai.setImageBitmap(bitmap);
                                card.setText(des);
                                card.setImageCard("MajorArcana/6_TheLovers_0.png");
                                card.setNameCard("The Lovers");
                                card.setIdCard("6");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 7:{
                            // La The Chariot
                            try {
                                inputStream = assetManager.open("MajorArcana/7_TheChariot_0.txt");
                                int size = inputStream.available();
                                byte[] buffer = new byte[size];
                                inputStream.read(buffer);
                                inputStream.close();
                                des = new String(buffer);
                                inputStream = assetManager.open("MajorArcana/7_TheChariot_0.png");
                                bitmap = BitmapFactory.decodeStream(inputStream);
                                lungbai.setImageBitmap(bitmap);
                                card.setText(des);
                                card.setImageCard("MajorArcana/7_TheChariot_0.png");
                                card.setNameCard("The Chariot");
                                card.setIdCard("7");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 8:{
                            // La Strength
                            try {
                                inputStream = assetManager.open("MajorArcana/8_Strength_0.txt");
                                int size = inputStream.available();
                                byte[] buffer = new byte[size];
                                inputStream.read(buffer);
                                inputStream.close();
                                des = new String(buffer);
                                inputStream = assetManager.open("MajorArcana/8_Strength_0.png");
                                bitmap = BitmapFactory.decodeStream(inputStream);
                                lungbai.setImageBitmap(bitmap);
                                card.setText(des);
                                card.setImageCard("MajorArcana/8_Strength_0.png");
                                card.setNameCard("Strength");
                                card.setIdCard("8");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 9:{
                            // La The Hermit
                            try {
                                inputStream = assetManager.open("MajorArcana/9_TheHermit_0.txt");
                                int size = inputStream.available();
                                byte[] buffer = new byte[size];
                                inputStream.read(buffer);
                                inputStream.close();
                                des = new String(buffer);
                                inputStream = assetManager.open("MajorArcana/9_TheHermit_0.png");
                                bitmap = BitmapFactory.decodeStream(inputStream);
                                lungbai.setImageBitmap(bitmap);
                                card.setText(des);
                                card.setImageCard("MajorArcana/9_TheHermit_0.png");
                                card.setNameCard("The Hermit");
                                card.setIdCard("9");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 10:{
                            // La The Wheel Of Fortune
                            try {
                                inputStream = assetManager.open("MajorArcana/10_TheWheelOfFortune_0.txt");
                                int size = inputStream.available();
                                byte[] buffer = new byte[size];
                                inputStream.read(buffer);
                                inputStream.close();
                                des = new String(buffer);
                                inputStream = assetManager.open("MajorArcana/10_TheWheelOfFortune_0.png");
                                bitmap = BitmapFactory.decodeStream(inputStream);
                                lungbai.setImageBitmap(bitmap);
                                card.setText(des);
                                card.setImageCard("MajorArcana/10_TheWheelOfFortune_0.png");
                                card.setNameCard("The Wheel Of Fortune");
                                card.setIdCard("10");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 11:{
                            // La Justice
                            try {
                                inputStream = assetManager.open("MajorArcana/11_Justice_0.txt");
                                int size = inputStream.available();
                                byte[] buffer = new byte[size];
                                inputStream.read(buffer);
                                inputStream.close();
                                des = new String(buffer);
                                inputStream = assetManager.open("MajorArcana/11_Justice_0.png");
                                bitmap = BitmapFactory.decodeStream(inputStream);
                                lungbai.setImageBitmap(bitmap);
                                card.setText(des);
                                card.setImageCard("MajorArcana/11_Justice_0.png");
                                card.setNameCard("Justice");
                                card.setIdCard("11");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 12:{
                            // La The Hanged Man
                            try {
                                inputStream = assetManager.open("MajorArcana/12_TheHangedMan_0.txt");
                                int size = inputStream.available();
                                byte[] buffer = new byte[size];
                                inputStream.read(buffer);
                                inputStream.close();
                                des = new String(buffer);
                                inputStream = assetManager.open("MajorArcana/12_TheHangedMan_0.png");
                                bitmap = BitmapFactory.decodeStream(inputStream);
                                lungbai.setImageBitmap(bitmap);
                                card.setText(des);
                                card.setImageCard("MajorArcana/12_TheHangedMan_0.png");
                                card.setNameCard("The Hanged Man");
                                card.setIdCard("12");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 13:{
                            // La Death
                            try {
                                inputStream = assetManager.open("MajorArcana/13_Death_0.txt");
                                int size = inputStream.available();
                                byte[] buffer = new byte[size];
                                inputStream.read(buffer);
                                inputStream.close();
                                des = new String(buffer);
                                inputStream = assetManager.open("MajorArcana/13_Death_0.png");
                                bitmap = BitmapFactory.decodeStream(inputStream);
                                lungbai.setImageBitmap(bitmap);
                                card.setText(des);
                                card.setImageCard("MajorArcana/13_Death_0.png");
                                card.setNameCard("Death");
                                card.setIdCard("13");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 14:{
                            // La Temperance
                            try {
                                inputStream = assetManager.open("MajorArcana/14_Temperance_0.txt");
                                int size = inputStream.available();
                                byte[] buffer = new byte[size];
                                inputStream.read(buffer);
                                inputStream.close();
                                des = new String(buffer);
                                inputStream = assetManager.open("MajorArcana/14_Temperance_0.png");
                                bitmap = BitmapFactory.decodeStream(inputStream);
                                lungbai.setImageBitmap(bitmap);
                                card.setText(des);
                                card.setImageCard("MajorArcana/14_Temperance_0.png");
                                card.setNameCard("Temperance");
                                card.setIdCard("14");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 15:{
                            // La The Devil
                            try {
                                inputStream = assetManager.open("MajorArcana/15_TheDevil_0.txt");
                                int size = inputStream.available();
                                byte[] buffer = new byte[size];
                                inputStream.read(buffer);
                                inputStream.close();
                                des = new String(buffer);
                                inputStream = assetManager.open("MajorArcana/15_TheDevil_0.png");
                                bitmap = BitmapFactory.decodeStream(inputStream);
                                lungbai.setImageBitmap(bitmap);
                                card.setText(des);
                                card.setImageCard("MajorArcana/15_TheDevil_0.png");
                                card.setNameCard("The Devil");
                                card.setIdCard("15");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 16:{
                            // La The Tower
                            try {
                                inputStream = assetManager.open("MajorArcana/16_TheTower_0.txt");
                                int size = inputStream.available();
                                byte[] buffer = new byte[size];
                                inputStream.read(buffer);
                                inputStream.close();
                                des = new String(buffer);
                                inputStream = assetManager.open("MajorArcana/16_TheTower_0.png");
                                bitmap = BitmapFactory.decodeStream(inputStream);
                                lungbai.setImageBitmap(bitmap);
                                card.setText(des);
                                card.setImageCard("MajorArcana/16_TheTower_0.png");
                                card.setNameCard("The Tower");
                                card.setIdCard("16");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 17:{
                            // La The Star
                            try {
                                inputStream = assetManager.open("MajorArcana/17_TheStar_0.txt");
                                int size = inputStream.available();
                                byte[] buffer = new byte[size];
                                inputStream.read(buffer);
                                inputStream.close();
                                des = new String(buffer);
                                inputStream = assetManager.open("MajorArcana/17_TheStar_0.png");
                                bitmap = BitmapFactory.decodeStream(inputStream);
                                lungbai.setImageBitmap(bitmap);
                                card.setText(des);
                                card.setImageCard("MajorArcana/17_TheStar_0.png");
                                card.setNameCard("The Star");
                                card.setIdCard("17");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 18:{
                            // La The Moon
                            try {
                                inputStream = assetManager.open("MajorArcana/18_TheMoon_0.txt");
                                int size = inputStream.available();
                                byte[] buffer = new byte[size];
                                inputStream.read(buffer);
                                inputStream.close();
                                des = new String(buffer);
                                inputStream = assetManager.open("MajorArcana/18_TheMoon_0.png");
                                bitmap = BitmapFactory.decodeStream(inputStream);
                                lungbai.setImageBitmap(bitmap);
                                card.setText(des);
                                card.setImageCard("MajorArcana/18_TheMoon_0.png");
                                card.setNameCard("The Moon");
                                card.setIdCard("18");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 19:{
                            // La The Sun
                            try {
                                inputStream = assetManager.open("MajorArcana/19_TheSun_0.txt");
                                int size = inputStream.available();
                                byte[] buffer = new byte[size];
                                inputStream.read(buffer);
                                inputStream.close();
                                des = new String(buffer);
                                inputStream = assetManager.open("MajorArcana/19_TheSun_0.png");
                                bitmap = BitmapFactory.decodeStream(inputStream);
                                lungbai.setImageBitmap(bitmap);
                                card.setText(des);
                                card.setImageCard("MajorArcana/19_TheSun_0.png");
                                card.setNameCard("The Sun");
                                card.setIdCard("19");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 20:{
                            // La Judgement
                            try {
                                inputStream = assetManager.open("MajorArcana/20_Judgement_0.txt");
                                int size = inputStream.available();
                                byte[] buffer = new byte[size];
                                inputStream.read(buffer);
                                inputStream.close();
                                des = new String(buffer);
                                inputStream = assetManager.open("MajorArcana/20_Judgement_0.png");
                                bitmap = BitmapFactory.decodeStream(inputStream);
                                lungbai.setImageBitmap(bitmap);
                                card.setText(des);
                                card.setImageCard("MajorArcana/20_Judgement_0.png");
                                card.setNameCard("Judgement");
                                card.setIdCard("20");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case 21:{
                            // La The World
                            try {
                                inputStream = assetManager.open("MajorArcana/21_TheWorld_0.txt");
                                int size = inputStream.available();
                                byte[] buffer = new byte[size];
                                inputStream.read(buffer);
                                inputStream.close();
                                des = new String(buffer);
                                inputStream = assetManager.open("MajorArcana/21_TheWorld_0.png");
                                bitmap = BitmapFactory.decodeStream(inputStream);
                                lungbai.setImageBitmap(bitmap);
                                card.setText(des);
                                card.setImageCard("MajorArcana/21_TheWorld_0.png");
                                card.setNameCard("The World");
                                card.setIdCard("21");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                    }
                    //xu ly de lay card=>getImage() va getDetail()
                    //setBackgound cho image
                    //xu ly chon la bai, chuyen sang trang ket qua
//                    lungbai.setBackgroundResource(R.drawable.card_template);
//                    int sl = sharedPreferences.getInt("soluong", -1);
//                    sl++;
//                    editor.putInt("soluong", sl);
//                    editor.putString("Text" + sl, card.getText());
//                    editor.putString("ImageCard"+sl, card.getImageCard());
//                    editor.putString("IdCard " + sl, card.getIdCard());
//                    editor.putString("NameCard"+sl, card.getNameCard());
                    HistoryCard historyCard = new HistoryCard();
                    historyCard.setCard(card);
                    historyCard.setIdCard(card.getIdCard());
                    Date date = new Date("03/05/2019");
                    historyCard.setViewDate(date);
                    if(db.addHistoryCard(historyCard)){
//                      Toast.makeText(MainActivity.this, "sdfsdfd", Toast.LENGTH_LONG).show();
                    }
                    trangthai1.setText("Hôm nay bạn đã rút bài.");
                    trangthai2.setText(" Hãy nhấn vào lá bài để xem lại!");
                    Intent intent = new Intent(MainActivity.this, ResultCardActivity.class);
                    //gui CardID
                    intent.putExtra("Card", card);
                    startActivity(intent);
                    //finish();
                }
                else{
                    //chuyen sang trang ket qua
                    Intent intent = new Intent(MainActivity.this, ResultCardActivity.class);
                    //gui CardID
                    //intent.putExtra("CardID",card.getCardID());
                    startActivity(intent);
                }

            }
        });

        //sự kiện cho hôm nay
        homnay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set text trạng thái + ảnh lá bài đã được rút

            }
        });

        //sự kiện cho lịch sử
        lichsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chuyển sang trang lịch sử đẻ chọn bài muốn xem
                Intent intent = new Intent(MainActivity.this, HistoryActivity.class);;
                startActivity(intent);

            }
        });
        //sự kiện cho tarot hoàng đạo
        tarotcunghoangdao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //chuyển sang trang hoàng đạo chọn cung muốn xem
                Intent intent = new Intent(MainActivity.this,TarotActivity.class);;
                startActivity(intent);

            }
        });
    }
}
