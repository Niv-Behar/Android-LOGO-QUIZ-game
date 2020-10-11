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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.WatchEvent;

public class LevelThreeActivity extends AppCompatActivity {
    Person person;
    Button kiaBtn;
    Button hitBtn;
    Button visaBtn;
    Button spriteBtn;
    Button nflBtn;
    Button kinderBtn;
    Button fordBtn;
    Button ikeaBtn;
    int score;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_three_main);

       kiaBtn     = findViewById(R.id.kia_btn);
       hitBtn     = findViewById(R.id.hit_btn);
       visaBtn    = findViewById(R.id.visa_btn);
       spriteBtn  = findViewById(R.id.sprite_btn);
       nflBtn     = findViewById(R.id.nfl_btn);
       kinderBtn  = findViewById(R.id.kinder_btn);
       fordBtn    = findViewById(R.id.ford_btn);
       ikeaBtn    = findViewById(R.id.ikea_btn);

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
                        Intent intent = new Intent(LevelThreeActivity.this, MainActivity.class);
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
        kiaBtn.setOnClickListener(new View.OnClickListener() {
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
                        Intent intent = new Intent(LevelThreeActivity.this, KiaActivity.class);
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

        hitBtn.setOnClickListener(new View.OnClickListener() {
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
                        Intent intent = new Intent(LevelThreeActivity.this, HitActivity.class);
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

        visaBtn.setOnClickListener(new View.OnClickListener() {
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
                        Intent intent = new Intent(LevelThreeActivity.this, VisaActivity.class);
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

        spriteBtn.setOnClickListener(new View.OnClickListener() {
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
                        Intent intent = new Intent(LevelThreeActivity.this, SpriteActivity.class);
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

        nflBtn.setOnClickListener(new View.OnClickListener() {
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
                        Intent intent = new Intent(LevelThreeActivity.this, NflActivity.class);
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

        kinderBtn.setOnClickListener(new View.OnClickListener() {
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
                        Intent intent = new Intent(LevelThreeActivity.this, KinderActivity.class);
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

        fordBtn.setOnClickListener(new View.OnClickListener() {
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
                        Intent intent = new Intent(LevelThreeActivity.this, FordActivity.class);
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

        ikeaBtn.setOnClickListener(new View.OnClickListener() {
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
                        Intent intent = new Intent(LevelThreeActivity.this, IkeaActivity.class);
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
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setScore(int num) {
        kiaBtn     = findViewById(R.id.kia_btn);
        hitBtn     = findViewById(R.id.hit_btn);
        visaBtn    = findViewById(R.id.visa_btn);
        spriteBtn  = findViewById(R.id.sprite_btn);
        nflBtn     = findViewById(R.id.nfl_btn);
        kinderBtn  = findViewById(R.id.kinder_btn);
        fordBtn    = findViewById(R.id.ford_btn);
        ikeaBtn    = findViewById(R.id.ikea_btn);

        score = num;
        if(person.getArr2()==0){
            kiaBtn.setBackgroundResource(R.drawable.kia);
            hitBtn.setBackgroundResource(R.drawable.locked);
            visaBtn.setBackgroundResource(R.drawable.locked);
            spriteBtn.setBackgroundResource(R.drawable.locked);
            nflBtn.setBackgroundResource(R.drawable.locked);
            kinderBtn.setBackgroundResource(R.drawable.locked);
            fordBtn.setBackgroundResource(R.drawable.locked);
            ikeaBtn.setBackgroundResource(R.drawable.locked);
            hitBtn.setEnabled(false);
            visaBtn.setEnabled(false);
            spriteBtn.setEnabled(false);
            nflBtn.setEnabled(false);
            kinderBtn.setEnabled(false);
            fordBtn.setEnabled(false);
            ikeaBtn.setEnabled(false);
        }
        else if(person.getArr2()==10) {
            kiaBtn.setBackgroundResource(R.drawable.kia_check);
            hitBtn.setBackgroundResource(R.drawable.hit);
            visaBtn.setBackgroundResource(R.drawable.locked);
            spriteBtn.setBackgroundResource(R.drawable.locked);
            nflBtn.setBackgroundResource(R.drawable.locked);
            kinderBtn.setBackgroundResource(R.drawable.locked);
            fordBtn.setBackgroundResource(R.drawable.locked);
            ikeaBtn.setBackgroundResource(R.drawable.locked);
            visaBtn.setEnabled(false);
            spriteBtn.setEnabled(false);
            nflBtn.setEnabled(false);
            kinderBtn.setEnabled(false);
            fordBtn.setEnabled(false);
            ikeaBtn.setEnabled(false);
        }
        else if(person.getArr2()==20){
            kiaBtn.setBackgroundResource(R.drawable.kia_check);
            hitBtn.setBackgroundResource(R.drawable.hit_check);
            visaBtn.setBackgroundResource(R.drawable.locked);
            spriteBtn.setBackgroundResource(R.drawable.sprite);
            nflBtn.setBackgroundResource(R.drawable.locked);
            kinderBtn.setBackgroundResource(R.drawable.locked);
            fordBtn.setBackgroundResource(R.drawable.locked);
            ikeaBtn.setBackgroundResource(R.drawable.locked);
            visaBtn.setEnabled(false);
            nflBtn.setEnabled(false);
            kinderBtn.setEnabled(false);
            fordBtn.setEnabled(false);
            ikeaBtn.setEnabled(false);
        }
        else if(person.getArr2()==30){
            kiaBtn.setBackgroundResource(R.drawable.kia_check);
            hitBtn.setBackgroundResource(R.drawable.hit_check);
            visaBtn.setBackgroundResource(R.drawable.visa);
            spriteBtn.setBackgroundResource(R.drawable.sprite_check);
            nflBtn.setBackgroundResource(R.drawable.locked);
            kinderBtn.setBackgroundResource(R.drawable.locked);
            fordBtn.setBackgroundResource(R.drawable.locked);
            ikeaBtn.setBackgroundResource(R.drawable.locked);
            nflBtn.setEnabled(false);
            kinderBtn.setEnabled(false);
            fordBtn.setEnabled(false);
            ikeaBtn.setEnabled(false);
        }
        else if(person.getArr2()==40){
            kiaBtn.setBackgroundResource(R.drawable.kia_check);
            hitBtn.setBackgroundResource(R.drawable.hit_check);
            visaBtn.setBackgroundResource(R.drawable.visa_check);
            spriteBtn.setBackgroundResource(R.drawable.sprite_check);
            nflBtn.setBackgroundResource(R.drawable.nfl);
            kinderBtn.setBackgroundResource(R.drawable.locked);
            fordBtn.setBackgroundResource(R.drawable.locked);
            ikeaBtn.setBackgroundResource(R.drawable.locked);
            kinderBtn.setEnabled(false);
            fordBtn.setEnabled(false);
            ikeaBtn.setEnabled(false);
        }
        else if(person.getArr2()==50){
            kiaBtn.setBackgroundResource(R.drawable.kia_check);
            hitBtn.setBackgroundResource(R.drawable.hit_check);
            visaBtn.setBackgroundResource(R.drawable.visa_check);
            spriteBtn.setBackgroundResource(R.drawable.sprite_check);
            nflBtn.setBackgroundResource(R.drawable.nfl_check);
            kinderBtn.setBackgroundResource(R.drawable.kinder);
            fordBtn.setBackgroundResource(R.drawable.locked);
            ikeaBtn.setBackgroundResource(R.drawable.locked);
            fordBtn.setEnabled(false);
            ikeaBtn.setEnabled(false);
        }
        else if(person.getArr2()==60){
            kiaBtn.setBackgroundResource(R.drawable.kia_check);
            hitBtn.setBackgroundResource(R.drawable.hit_check);
            visaBtn.setBackgroundResource(R.drawable.visa_check);
            spriteBtn.setBackgroundResource(R.drawable.sprite_check);
            nflBtn.setBackgroundResource(R.drawable.nfl_check);
            kinderBtn.setBackgroundResource(R.drawable.kinder_check);
            fordBtn.setBackgroundResource(R.drawable.locked);
            ikeaBtn.setBackgroundResource(R.drawable.ikea);
            fordBtn.setEnabled(false);
        }
        else if(person.getArr2()==80){
            kiaBtn.setBackgroundResource(R.drawable.kia_check);
            hitBtn.setBackgroundResource(R.drawable.hit_check);
            visaBtn.setBackgroundResource(R.drawable.visa_check);
            spriteBtn.setBackgroundResource(R.drawable.sprite_check);
            nflBtn.setBackgroundResource(R.drawable.nfl_check);
            kinderBtn.setBackgroundResource(R.drawable.kinder_check);
            fordBtn.setBackgroundResource(R.drawable.ford);
            ikeaBtn.setBackgroundResource(R.drawable.ikea_check);
        }
        else if(person.getArr2()==110){
            kiaBtn.setBackgroundResource(R.drawable.kia_check);
            hitBtn.setBackgroundResource(R.drawable.hit_check);
            visaBtn.setBackgroundResource(R.drawable.visa_check);
            spriteBtn.setBackgroundResource(R.drawable.sprite_check);
            nflBtn.setBackgroundResource(R.drawable.nfl_check);
            kinderBtn.setBackgroundResource(R.drawable.kinder_check);
            fordBtn.setBackgroundResource(R.drawable.ford_check);
            ikeaBtn.setBackgroundResource(R.drawable.ikea_check); }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.main_page){
            Intent intent = new Intent(LevelThreeActivity.this, HomeActivity.class);
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(LevelThreeActivity.this, InstructionActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


