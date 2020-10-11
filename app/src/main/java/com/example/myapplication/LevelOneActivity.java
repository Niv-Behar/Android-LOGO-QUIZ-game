package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;

public class LevelOneActivity extends AppCompatActivity {
    Person person;
    Button filaBtn;
    Button hondaBtn;
    Button nbaBtn;
    Button gmailBtn;
    Button bmwBtn;
    Button pumaBtn;
    Button lacosteBtn;
    Button chromeBtn;
    private int score;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_one_main);

        filaBtn    = findViewById(R.id.fila_btn);
        hondaBtn   = findViewById(R.id.honda_btn);
        nbaBtn     = findViewById(R.id.nba_btn);
        gmailBtn   = findViewById(R.id.gmail_btn);
        bmwBtn     = findViewById(R.id.bmw_btn);
        pumaBtn    = findViewById(R.id.puma_btn);
        lacosteBtn = findViewById(R.id.lacoste_btn);
        chromeBtn  = findViewById(R.id.chrome_btn);

        Button button = findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Animation animation = AnimationUtils.loadAnimation(v.getContext(), R.anim.bck);
                animation.setDuration(150);
                v.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer back_btn = MediaPlayer.create(v.getContext(), R.raw.back_button);
                        back_btn.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(LevelOneActivity.this, MainActivity.class);
                        finish();
                        startActivity(intent);
                        Animatoo.animateSlideRight(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });
        filaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Animation animation = AnimationUtils.loadAnimation(v.getContext(), R.anim.fab);
                v.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer back_btn = MediaPlayer.create(v.getContext(), R.raw.step);
                        back_btn.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(LevelOneActivity.this, FilaActivity.class);
                        finish();
                        startActivity(intent);
                        Animatoo.animateInAndOut(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        hondaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Animation animation = AnimationUtils.loadAnimation(v.getContext(), R.anim.fab);
                v.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer back_btn = MediaPlayer.create(v.getContext(), R.raw.step);
                        back_btn.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(LevelOneActivity.this, HondaActivity.class);
                        finish();
                        startActivity(intent);
                        Animatoo.animateInAndOut(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        nbaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Animation animation = AnimationUtils.loadAnimation(v.getContext(), R.anim.fab);
                v.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer back_btn = MediaPlayer.create(v.getContext(), R.raw.step);
                        back_btn.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(LevelOneActivity.this, NbaActivity.class);
                        finish();
                        startActivity(intent);
                        Animatoo.animateInAndOut(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        gmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Animation animation = AnimationUtils.loadAnimation(v.getContext(), R.anim.fab);
                v.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer back_btn = MediaPlayer.create(v.getContext(), R.raw.step);
                        back_btn.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(LevelOneActivity.this, GmailActivity.class);
                        finish();
                        startActivity(intent);
                        Animatoo.animateInAndOut(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        bmwBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Animation animation = AnimationUtils.loadAnimation(v.getContext(), R.anim.fab);
                v.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer back_btn = MediaPlayer.create(v.getContext(), R.raw.step);
                        back_btn.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(LevelOneActivity.this, BmwActivity.class);
                        finish();
                        startActivity(intent);
                        Animatoo.animateInAndOut(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        pumaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Animation animation = AnimationUtils.loadAnimation(v.getContext(), R.anim.fab);
                v.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer back_btn = MediaPlayer.create(v.getContext(), R.raw.step);
                        back_btn.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(LevelOneActivity.this, PumaActivity.class);
                        finish();
                        startActivity(intent);
                        Animatoo.animateInAndOut(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        lacosteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Animation animation = AnimationUtils.loadAnimation(v.getContext(), R.anim.fab);
                v.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer back_btn = MediaPlayer.create(v.getContext(), R.raw.step);
                        back_btn.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(LevelOneActivity.this, LacosteActivity.class);
                        finish();
                        startActivity(intent);
                        Animatoo.animateInAndOut(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        chromeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Animation animation = AnimationUtils.loadAnimation(v.getContext(), R.anim.fab);
                v.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer back_btn = MediaPlayer.create(v.getContext(), R.raw.step);
                        back_btn.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(LevelOneActivity.this, ChromeActivity.class);
                        finish();
                        startActivity(intent);
                        Animatoo.animateInAndOut(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        FileInputStream fis = null;
        try {
            fis = openFileInput("person");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(fis!=null) {
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
            person = null;
            try {
                person = (Person) ois.readObject();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
            if(person!=null) {
                setScore(person.getArr());
            }
            else setScore(0);
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.main_page){
            Intent intent = new Intent(LevelOneActivity.this, HomeActivity.class);
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(LevelOneActivity.this, InstructionActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setScore(int num) {
        filaBtn    = findViewById(R.id.fila_btn);
        hondaBtn   = findViewById(R.id.honda_btn);
        nbaBtn     = findViewById(R.id.nba_btn);
        gmailBtn   = findViewById(R.id.gmail_btn);
        bmwBtn     = findViewById(R.id.bmw_btn);
        pumaBtn    = findViewById(R.id.puma_btn);
        lacosteBtn = findViewById(R.id.lacoste_btn);
        chromeBtn  = findViewById(R.id.chrome_btn);

        score = num;
        if(person.getArr()==0){
            if (!person.getTutorial()) {
                person.setTutorial(true);
                Intent intent=new Intent(LevelOneActivity.this,TutorialActivity.class);
                startActivity(intent);
            }
            filaBtn.setBackgroundResource(R.drawable.fila);
            hondaBtn.setBackgroundResource(R.drawable.locked);
            nbaBtn.setBackgroundResource(R.drawable.locked);
            gmailBtn.setBackgroundResource(R.drawable.locked);
            bmwBtn.setBackgroundResource(R.drawable.locked);
            pumaBtn.setBackgroundResource(R.drawable.locked);
            lacosteBtn.setBackgroundResource(R.drawable.locked);
            chromeBtn.setBackgroundResource(R.drawable.locked);
            hondaBtn.setEnabled(false);
            nbaBtn.setEnabled(false);
            gmailBtn.setEnabled(false);
            bmwBtn.setEnabled(false);
            pumaBtn.setEnabled(false);
            lacosteBtn.setEnabled(false);
            chromeBtn.setEnabled(false);
        }
        if(person.getArr()==10){
            filaBtn.setBackgroundResource(R.drawable.fila_check);
            hondaBtn.setBackgroundResource(R.drawable.honda);
            nbaBtn.setBackgroundResource(R.drawable.locked);
            gmailBtn.setBackgroundResource(R.drawable.locked);
            bmwBtn.setBackgroundResource(R.drawable.locked);
            pumaBtn.setBackgroundResource(R.drawable.locked);
            lacosteBtn.setBackgroundResource(R.drawable.locked);
            chromeBtn.setBackgroundResource(R.drawable.locked);
            nbaBtn.setEnabled(false);
            gmailBtn.setEnabled(false);
            bmwBtn.setEnabled(false);
            pumaBtn.setEnabled(false);
            lacosteBtn.setEnabled(false);
            chromeBtn.setEnabled(false);
        }
        else if(person.getArr()==20){
            filaBtn.setBackgroundResource(R.drawable.fila_check);
            hondaBtn.setBackgroundResource(R.drawable.honda_check);
            nbaBtn.setBackgroundResource(R.drawable.locked);
            gmailBtn.setBackgroundResource(R.drawable.gmail);
            bmwBtn.setBackgroundResource(R.drawable.locked);
            pumaBtn.setBackgroundResource(R.drawable.locked);
            lacosteBtn.setBackgroundResource(R.drawable.locked);
            chromeBtn.setBackgroundResource(R.drawable.locked);
            nbaBtn.setEnabled(false);
            bmwBtn.setEnabled(false);
            pumaBtn.setEnabled(false);
            lacosteBtn.setEnabled(false);
            chromeBtn.setEnabled(false);
        }
        else if(person.getArr()==30){
            filaBtn.setBackgroundResource(R.drawable.fila_check);
            hondaBtn.setBackgroundResource(R.drawable.honda_check);
            nbaBtn.setBackgroundResource(R.drawable.nba);
            gmailBtn.setBackgroundResource(R.drawable.gmail_check);
            bmwBtn.setBackgroundResource(R.drawable.locked);
            pumaBtn.setBackgroundResource(R.drawable.locked);
            lacosteBtn.setBackgroundResource(R.drawable.locked);
            chromeBtn.setBackgroundResource(R.drawable.locked);
            bmwBtn.setEnabled(false);
            pumaBtn.setEnabled(false);
            lacosteBtn.setEnabled(false);
            chromeBtn.setEnabled(false);
        }
        else if(person.getArr()==40){
            filaBtn.setBackgroundResource(R.drawable.fila_check);
            hondaBtn.setBackgroundResource(R.drawable.honda_check);
            nbaBtn.setBackgroundResource(R.drawable.nba_check);
            gmailBtn.setBackgroundResource(R.drawable.gmail_check);
            bmwBtn.setBackgroundResource(R.drawable.locked);
            pumaBtn.setBackgroundResource(R.drawable.locked);
            lacosteBtn.setBackgroundResource(R.drawable.lacoste);
            chromeBtn.setBackgroundResource(R.drawable.locked);
            pumaBtn.setEnabled(false);
            bmwBtn.setEnabled(false);
            chromeBtn.setEnabled(false);
        }
        else if(person.getArr()==50){
            filaBtn.setBackgroundResource(R.drawable.fila_check);
            hondaBtn.setBackgroundResource(R.drawable.honda_check);
            nbaBtn.setBackgroundResource(R.drawable.nba_check);
            gmailBtn.setBackgroundResource(R.drawable.gmail_check);
            bmwBtn.setBackgroundResource(R.drawable.bmw);
            pumaBtn.setBackgroundResource(R.drawable.locked);
            lacosteBtn.setBackgroundResource(R.drawable.lacoste_check);
            chromeBtn.setBackgroundResource(R.drawable.locked);
            pumaBtn.setEnabled(false);
            chromeBtn.setEnabled(false);
        }
        else if(person.getArr()==60){
            filaBtn.setBackgroundResource(R.drawable.fila_check);
            hondaBtn.setBackgroundResource(R.drawable.honda_check);
            nbaBtn.setBackgroundResource(R.drawable.nba_check);
            gmailBtn.setBackgroundResource(R.drawable.gmail_check);
            bmwBtn.setBackgroundResource(R.drawable.bmw_check);
            pumaBtn.setBackgroundResource(R.drawable.puma);
            lacosteBtn.setBackgroundResource(R.drawable.lacoste_check);
            chromeBtn.setBackgroundResource(R.drawable.locked);
            chromeBtn.setEnabled(false);
        }
        else if(person.getArr()==75){
            filaBtn.setBackgroundResource(R.drawable.fila_check);
            hondaBtn.setBackgroundResource(R.drawable.honda_check);
            nbaBtn.setBackgroundResource(R.drawable.nba_check);
            gmailBtn.setBackgroundResource(R.drawable.gmail_check);
            bmwBtn.setBackgroundResource(R.drawable.bmw_check);
            pumaBtn.setBackgroundResource(R.drawable.puma_check);
            lacosteBtn.setBackgroundResource(R.drawable.lacoste_check);
            chromeBtn.setBackgroundResource(R.drawable.chrome);
        }
        else if(person.getArr()>=95){
            filaBtn.setBackgroundResource(R.drawable.fila_check);
            hondaBtn.setBackgroundResource(R.drawable.honda_check);
            nbaBtn.setBackgroundResource(R.drawable.nba_check);
            gmailBtn.setBackgroundResource(R.drawable.gmail_check);
            bmwBtn.setBackgroundResource(R.drawable.bmw_check);
            pumaBtn.setBackgroundResource(R.drawable.puma_check);
            lacosteBtn.setBackgroundResource(R.drawable.lacoste_check);
            chromeBtn.setBackgroundResource(R.drawable.chrome_check);
        }
    }

}
