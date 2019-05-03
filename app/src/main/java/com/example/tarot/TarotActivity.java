package com.example.tarot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import Model.Tarot;

public class TarotActivity extends AppCompatActivity {

    ArrayList<Tarot> listTarot;
    GridView gridViewTarot;
    GridViewCustomAdapter gridViewCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarot);

        gridViewTarot = findViewById(R.id.gridview_tarot);

        creatData();

        gridViewCustomAdapter = new GridViewCustomAdapter(listTarot, getApplicationContext());
        gridViewTarot.setAdapter(gridViewCustomAdapter);

        gridViewTarot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Tarot tarot = listTarot.get(position);
                Intent intent = new Intent(TarotActivity.this, TarotResultActivity.class);
                intent.putExtra("Tarot", tarot);
                startActivity(intent);
            }
        });
    }

    private void creatData(){
        listTarot = new ArrayList<>();
        listTarot.add(new Tarot(R.drawable.bachduong,"Bạch Dương", "(21/03-19/04)",
                "MajorArcana/4_The Emperor_0.png", "Hoangdao/bachduong_zodiac.txt",
                "MajorArcana/16_TheTower_0.png", "Hoangdao/bachduong_star.txt",
                "The Emperor", "The Tower"));
        listTarot.add(new Tarot(R.drawable.kimnguu,"Kim Ngưu", "(20/04-20/05)",
                "MajorArcana/5_TheHierophant_0.png", "Hoangdao/kimnguu_zodiac.txt",
                "MajorArcana/3_TheEmpress_0.png", "Hoangdao/kimnguu_star.txt",
                "The Hierophant", "The Empress"));
        listTarot.add(new Tarot(R.drawable.songtu,"Song Tử", "(21/05-21/06)",
                "MajorArcana/6_TheLovers_0.png", "Hoangdao/songtu_zodiac.txt",
                "MajorArcana/1_TheMagician_0.png", "Hoangdao/songtu_star.txt",
                "The Lovers", "The Magician"));
        listTarot.add(new Tarot(R.drawable.cugiai,"Cự Giải", "(22/06-22/07)",
                "MajorArcana/7_TheChariot_0.png", "Hoangdao/cugiai_zodiac.txt",
                "MajorArcana/2_TheHighPriestess_0.png", "Hoangdao/cugiai_star.txt",
                "The Chariot", "The High Priestess"));
        listTarot.add(new Tarot(R.drawable.sutu,"Sư Tử", "(23/07-22/08)",
                "MajorArcana/8_Strength_0.png", "Hoangdao/sutu_zodiac.txt",
                "MajorArcana/19_TheSun_0.png", "Hoangdao/sutu_star.txt",
                "Strength", "The Sun"));
        listTarot.add(new Tarot(R.drawable.xunu,"Xử Nữ", "(23/08-22/09)",
                "MajorArcana/9_TheHermit_0.png", "Hoangdao/xunu_zodiac.txt",
                "MajorArcana/1_TheMagician_0.png", "Hoangdao/xunu_star.txt",
                "The Hermit", "The Magician"));
        listTarot.add(new Tarot(R.drawable.thienbinh,"Thiên Bình", "(23/09-23/10)",
                "MajorArcana/11_Justice_0.png", "Hoangdao/thienbinh_zodiac.txt",
                "MajorArcana/3_TheEmpress_0.png", "Hoangdao/thienbinh_star.txt",
                "Justice", "The Empress"));
        listTarot.add(new Tarot(R.drawable.bocap,"Bọ Cạp", "(24/10-22/11)",
                "MajorArcana/13_Death_0.png", "Hoangdao/bocap_zodiac.txt",
                "MajorArcana/11_Justice_0.png", "Hoangdao/bocap_star.txt",
                "Death", "Justice"));
        listTarot.add(new Tarot(R.drawable.nhanma,"Nhân Mã", "(23/11-21/12)",
                "MajorArcana/14_Temperance_0.png", "Hoangdao/nhanma_zodiac.txt",
                "MajorArcana/10_TheWheelOfFortune_0.png", "Hoangdao/nhanma_star.txt",
                "Temperance", "The Wheel Of Fortune"));
        listTarot.add(new Tarot(R.drawable.maket,"Ma Kết", "(22/12-19/01)",
                "MajorArcana/15_TheDevil_0.png", "Hoangdao/maket_zodiac.txt",
                "MajorArcana/21_TheWorld_0.png", "Hoangdao/maket_star.txt",
                "The Devil", "The World"));
        listTarot.add(new Tarot(R.drawable.baobinh,"Bảo Bình", "(20/01-18/02)",
                "MajorArcana/17_TheStar_0.png", "Hoangdao/baobinh_zodiac.txt",
                "MajorArcana/0_TheFool_0.png", "Hoangdao/baobinh_star.txt",
                "The Star", "The Fool"));
        listTarot.add(new Tarot(R.drawable.songngu,"Song Ngư", "(19/02-20/03)",
                "MajorArcana/18_TheMoon_0.png", "Hoangdao/songngu_zodiac.txt",
                "MajorArcana/12_TheHangedMan_0.png", "Hoangdao/songngu_star.txt",
                "The Moon", "The Hanged Man"));
    }
}
