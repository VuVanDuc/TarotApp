package com.example.tarot;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import Model.Tarot;

public class TarotResultActivity extends AppCompatActivity {

    Intent intent;
    Tarot tarot;
    TextView tarot_zodiac, tarot_star, tarot_detail1, tarot_detail2, tarot_name;
    ImageView tarot_image1, tarot_image2;
    AssetManager assetManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarot_result);

        intent = getIntent();
        tarot = (Tarot) intent.getSerializableExtra("Tarot");
        assetManager = getAssets();

        tarot_zodiac = findViewById(R.id.tarot_zodiac);
        tarot_star = findViewById(R.id.tarot_star);
        tarot_detail1 = findViewById(R.id.tarot_detail1);
        tarot_detail2 = findViewById(R.id.tarot_detail2);
        tarot_image1 = findViewById(R.id.tarot_image1);
        tarot_image2 = findViewById(R.id.tarot_image2);
        tarot_name = findViewById(R.id.nameCard);

        tarot_zodiac.setText(tarot.getImageName1());
        tarot_star.setText(tarot.getImageName2());
        tarot_name.setText(tarot.getTarotName());

        try {
            InputStream inputStream = assetManager.open(tarot.getImageTarot1());
            Bitmap image = BitmapFactory.decodeStream(inputStream);
            tarot_image1.setImageBitmap(image);
            inputStream.close();
            inputStream = assetManager.open(tarot.getImageTarot2());
            image = BitmapFactory.decodeStream(inputStream);
            tarot_image2.setImageBitmap(image);
            inputStream.close();
            inputStream = assetManager.open(tarot.getDetailTarot1());
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            String detail = new String(buffer);
            tarot_detail1.setText(detail);
            inputStream.close();
            inputStream = assetManager.open(tarot.getDetailTarot2());
            size = inputStream.available();
            buffer = new byte[size];
            inputStream.read(buffer);
            detail = new String(buffer);
            tarot_detail2.setText(detail);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
