package com.example.tarot;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;

import java.io.IOException;
import java.io.InputStream;

import Model.Card;

public class ResultCardActivity extends AppCompatActivity {

    private ImageView backButton;
    private ImageView shareButton;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    ScrollView childScroll;
    TextView nameCard;

    ShareDialog shareDialog;
    ShareLinkContent shareLinkContent;
    Intent intent;
    Card card;

    InputStream inputStream;
    AssetManager assetManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_card);

        backButton = (ImageView) findViewById(R.id.back_button);
        shareButton = (ImageView) findViewById(R.id.share_button);
//        childScroll = findViewById(R.id.childScroll);
        nameCard = findViewById(R.id.nameCard);

        assetManager = getAssets();

        shareDialog = new ShareDialog(ResultCardActivity.this);
        intent = getIntent();
        card = (Card) intent.getSerializableExtra("Card");

        nameCard.setText(card.getNameCard());

        recyclerView = findViewById(R.id.recycler_menu);
        recyclerView.setHasFixedSize(true);

        recyclerViewAdapter = new RecyclerViewAdapter(card, getApplicationContext());
        layoutManager = new LinearLayoutManager(getApplicationContext());
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultCardActivity.this,MainActivity.class);
                intent.putExtra("darut","1");
                startActivity(intent);
                finish();
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //API FB
//                if(ShareDialog.canShow(ShareLinkContent.class)){
//                    shareLinkContent = new ShareLinkContent.Builder()
//                            .setContentTitle("Cho Dinh")
//                            .setContentDescription("An Cut")
//                            .setContentUrl(Uri.parse("https://youtube.com"))
//                            .build();
//                }
//                shareDialog.show(shareLinkContent);
                try {
                    inputStream = assetManager.open(card.getImageCard());
                    Bitmap image = BitmapFactory.decodeStream(inputStream);
                    SharePhoto photo = new SharePhoto.Builder()
                            .setBitmap(image)
                            .build();
                    SharePhotoContent content = new SharePhotoContent.Builder()
                            .addPhoto(photo)
                            .build();
                    shareDialog.show(content);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
