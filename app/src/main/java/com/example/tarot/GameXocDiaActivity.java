package com.example.tarot;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameXocDiaActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton btnMobat, btnChoitiep;
    private ImageView imgXocdia, imgCongChan, imgCongLe, imgKetqua,imgPlaymusic,imgStopmusic;
    private TextView txtThongbao, txtVang, txtCuocLe, txtCuocChan;
    private boolean CheckSoc = false;
    private int demchan = 0;
    private int demle = 0;
    private int lientuc = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        try {
            getSupportActionBar().hide(); // hide the title bar
        }
        catch (NullPointerException e){

        }
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_game_xoc_dia);

        AnhXa();
        MediaPlayer mediaPlayer = MediaPlayer.create(GameXocDiaActivity.this, R.raw.welcome);
        mediaPlayer.start();
        final Animation animvibrate = AnimationUtils.loadAnimation(this, R.anim.vibrate);
        imgXocdia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animvibrate);
                CheckSoc = true;
            }
        });
        imgCongChan.setOnClickListener(this);
        imgCongLe.setOnClickListener(this);
        imgPlaymusic.setOnClickListener(this);
        imgStopmusic.setOnClickListener(this);

        btnMobat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheckSoc) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btnMobat.setImageResource(R.drawable.onclick);
                        }
                    }, 200);
                    btnMobat.setImageResource(R.drawable.mobat);

                    Random random = new Random();
                    int x = random.nextInt(4) + 1;
                    switch (x) {
                        case 1:
                            imgXocdia.setImageResource(R.drawable.kqle1);
                            ketqua(x);
                            break;
                        case 2:
                            imgXocdia.setImageResource(R.drawable.kqchan1);
                            ketqua(x);
                            break;
                        case 3:
                            imgXocdia.setImageResource(R.drawable.kqle2);
                            ketqua(x);
                            break;
                        case 4:
                            imgXocdia.setImageResource(R.drawable.tutu);
                            ketqua(x);
                            break;
                    }
                    CheckSoc = false;
                    txtThongbao.setText("");
                } else {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    }, 200);
                }
                txtThongbao.setText("");
            }
        });
        btnChoitiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgXocdia.setImageResource(R.drawable.bat);
            }
        });

    }

    private void AnhXa() {
        btnMobat = findViewById(R.id.btnMoBat);
        btnChoitiep = findViewById(R.id.btnTiep);

        imgXocdia = findViewById(R.id.imgBat);
        imgCongChan = findViewById(R.id.imgCongChan);
        imgCongLe = findViewById(R.id.imgCongLe);
        imgPlaymusic=findViewById(R.id.imgPlayMusic);
        imgStopmusic=findViewById(R.id.imgStopmusic);

        txtThongbao = findViewById(R.id.txtThongbao);
        txtVang = findViewById(R.id.txtTien);
        imgKetqua = findViewById(R.id.imgKetqua);
        txtCuocChan = findViewById(R.id.txtCuocChan);
        txtCuocLe = findViewById(R.id.txtCuocLe);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgCongChan:
                String s = txtCuocChan.getText().toString();
                String vang = txtVang.getText().toString();
                int cuocchan = Integer.parseInt(s);
                int tiencon = Integer.parseInt(vang);
                cuocchan = cuocchan + 100;
                tiencon = tiencon - 100;
                txtVang.setText(String.valueOf(tiencon));
                txtCuocChan.setText(String.valueOf(cuocchan));
                break;
            case R.id.imgCongLe:
                String s1 = txtCuocLe.getText().toString();
                String vang2 = txtVang.getText().toString();
                int cuocle = Integer.parseInt(s1);
                int tiencon2 = Integer.parseInt(vang2);
                cuocle = cuocle + 100;
                tiencon2 = tiencon2 - 100;
                txtVang.setText(String.valueOf(tiencon2));
                txtCuocLe.setText(String.valueOf(cuocle));
                break;
            case R.id.imgPlayMusic:
                Intent intent= new Intent(GameXocDiaActivity.this,MyService.class);
                intent.setAction("PlayMusic");
                startService(intent);
                break;
            case R.id.imgStopmusic:
                Intent intent2= new Intent(GameXocDiaActivity.this,MyService.class);
                intent2.setAction("StopMusic");
                startService(intent2);
                break;
        }
    }

    public void ketqua(int x) {
        String s = txtCuocChan.getText().toString();
        String vang = txtVang.getText().toString();
        int cuocchan = Integer.parseInt(s);
        String s1 = txtCuocLe.getText().toString();
        String vang2 = txtVang.getText().toString();
        int cuocle = Integer.parseInt(s1);
        int tiencon = Integer.parseInt(vang);
        int tiencon2 = tiencon;
        if (tiencon > 0) {
            if (x == 1) {
                tiencon = tiencon + cuocle * 2;
                imgKetqua.setImageResource(R.drawable.kqle);
            } else if (x == 2) {
                tiencon = tiencon + cuocchan * 2;
                imgKetqua.setImageResource(R.drawable.kqchan);
            } else if (x == 3) {
                tiencon = tiencon + cuocle * 2;
                imgKetqua.setImageResource(R.drawable.kqle);
            } else if (x == 4) {
                tiencon = tiencon + cuocchan * 4;
                imgKetqua.setImageResource(R.drawable.kqtutu);
            }
            if (tiencon > tiencon2) {
                lientuc++;
                if (lientuc == 1) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(GameXocDiaActivity.this, R.raw.first_blood_lol_sound_748194);
                    mediaPlayer.start();
                } else if (lientuc == 2) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(GameXocDiaActivity.this, R.raw.doublekill);
                    mediaPlayer.start();
                } else if (lientuc == 3) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(GameXocDiaActivity.this, R.raw.tripplekill);
                    mediaPlayer.start();
                } else if (lientuc == 4) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(GameXocDiaActivity.this, R.raw.quarta);
                    mediaPlayer.start();
                } else if (lientuc == 5) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(GameXocDiaActivity.this, R.raw.penta);
                    mediaPlayer.start();
                }

            } else {
                if (lientuc > 0) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(GameXocDiaActivity.this, R.raw.shutdown);
                    mediaPlayer.start();
                    lientuc = 0;
                }
                else if ( lientuc==0)
                {
                    MediaPlayer mediaPlayer = MediaPlayer.create(GameXocDiaActivity.this, R.raw.lola);
                    mediaPlayer.start();
                }

            }
            txtVang.setText(String.valueOf(tiencon));
            txtCuocChan.setText(String.valueOf(0));
            txtCuocLe.setText(String.valueOf(0));
        } else {
            txtThongbao.setText("Hết tiền rồi anh ê");
        }
    }

}
