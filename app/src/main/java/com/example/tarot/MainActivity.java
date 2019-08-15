package com.example.tarot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnXocDia, btnTarot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnXocDia = findViewById(R.id.btnXocDia);
        btnTarot = findViewById(R.id.btnTarot);

        btnTarot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameTarotActivity.class);
                startActivity(intent);
            }
        });

        btnXocDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameXocDiaActivity.class);
                startActivity(intent);
            }
        });
    }
}
