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

public class LevelTwoActivity extends AppCompatActivity {
    Person person;
    Button legoBtn;
    Button kfcBtn;
    Button fcbBtn;
    Button marsBtn;
    Button netflixBtn;
    Button nikeBtn;
    Button opelBtn;
    Button mtvBtn;
    int score;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_two_main);

       legoBtn    = findViewById(R.id.lego_btn);
       kfcBtn     = findViewById(R.id.kfc_btn);
       fcbBtn     = findViewById(R.id.fcb_btn);
       marsBtn    = findViewById(R.id.mars_btn);
       netflixBtn = findViewById(R.id.netflix_btn);
       nikeBtn    = findViewById(R.id.nike_btn);
       opelBtn    = findViewById(R.id.opel_btn);
       mtvBtn     = findViewById(R.id.mtv_btn);

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
                        Intent intent = new Intent(LevelTwoActivity.this, MainActivity.class);
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
        legoBtn.setOnClickListener(new View.OnClickListener() {
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
                        Intent intent = new Intent(LevelTwoActivity.this, LegoActivity.class);
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

        kfcBtn.setOnClickListener(new View.OnClickListener() {
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
                        Intent intent = new Intent(LevelTwoActivity.this, KfcActivity.class);
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

        fcbBtn.setOnClickListener(new View.OnClickListener() {
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
                        Intent intent = new Intent(LevelTwoActivity.this, FcbActivity.class);
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

        marsBtn.setOnClickListener(new View.OnClickListener() {
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
                        Intent intent = new Intent(LevelTwoActivity.this, MarsActivity.class);
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

        netflixBtn.setOnClickListener(new View.OnClickListener() {
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
                        Intent intent = new Intent(LevelTwoActivity.this, NetflixActivity.class);
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

        nikeBtn.setOnClickListener(new View.OnClickListener() {
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
                        Intent intent = new Intent(LevelTwoActivity.this, NikeActivity.class);
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

        opelBtn.setOnClickListener(new View.OnClickListener() {
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
                        Intent intent = new Intent(LevelTwoActivity.this, OpelActivity.class);
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

        mtvBtn.setOnClickListener(new View.OnClickListener() {
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
                        Intent intent = new Intent(LevelTwoActivity.this, MtvActivity.class);
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.main_page){
            Intent intent = new Intent(LevelTwoActivity.this, HomeActivity.class);
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(LevelTwoActivity.this, InstructionActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void setScore(int num) {
        legoBtn    = findViewById(R.id.lego_btn);
        kfcBtn     = findViewById(R.id.kfc_btn);
        fcbBtn     = findViewById(R.id.fcb_btn);
        marsBtn    = findViewById(R.id.mars_btn);
        netflixBtn = findViewById(R.id.netflix_btn);
        nikeBtn    = findViewById(R.id.nike_btn);
        opelBtn    = findViewById(R.id.opel_btn);
        mtvBtn     = findViewById(R.id.mtv_btn);

        score = num;
        if(person.getArr1()==0){
            legoBtn.setBackgroundResource(R.drawable.lego);
            kfcBtn.setBackgroundResource(R.drawable.locked);
            fcbBtn.setBackgroundResource(R.drawable.locked);
            marsBtn.setBackgroundResource(R.drawable.locked);
            netflixBtn.setBackgroundResource(R.drawable.locked);
            nikeBtn.setBackgroundResource(R.drawable.locked);
            opelBtn.setBackgroundResource(R.drawable.locked);
            mtvBtn.setBackgroundResource(R.drawable.locked);
            kfcBtn.setEnabled(false);
            fcbBtn.setEnabled(false);
            marsBtn.setEnabled(false);
            netflixBtn.setEnabled(false);
            nikeBtn.setEnabled(false);
            opelBtn.setEnabled(false);
            mtvBtn.setEnabled(false);
        }
        else if(person.getArr1()==10){
            legoBtn.setBackgroundResource(R.drawable.lego_check);
            kfcBtn.setBackgroundResource(R.drawable.kfc);
            fcbBtn.setBackgroundResource(R.drawable.locked);
            marsBtn.setBackgroundResource(R.drawable.locked);
            netflixBtn.setBackgroundResource(R.drawable.locked);
            nikeBtn.setBackgroundResource(R.drawable.locked);
            opelBtn.setBackgroundResource(R.drawable.locked);
            mtvBtn.setBackgroundResource(R.drawable.locked);
            fcbBtn.setEnabled(false);
            marsBtn.setEnabled(false);
            netflixBtn.setEnabled(false);
            nikeBtn.setEnabled(false);
            opelBtn.setEnabled(false);
            mtvBtn.setEnabled(false);
        }
        else if(person.getArr1()==20){
            legoBtn.setBackgroundResource(R.drawable.lego_check);
            kfcBtn.setBackgroundResource(R.drawable.ksp_check);
            fcbBtn.setBackgroundResource(R.drawable.fcb);
            marsBtn.setBackgroundResource(R.drawable.locked);
            netflixBtn.setBackgroundResource(R.drawable.locked);
            nikeBtn.setBackgroundResource(R.drawable.locked);
            opelBtn.setBackgroundResource(R.drawable.locked);
            mtvBtn.setBackgroundResource(R.drawable.locked);
            marsBtn.setEnabled(false);
            netflixBtn.setEnabled(false);
            nikeBtn.setEnabled(false);
            opelBtn.setEnabled(false);
            mtvBtn.setEnabled(false);
        }
        else if(person.getArr1()==30){
            legoBtn.setBackgroundResource(R.drawable.lego_check);
            kfcBtn.setBackgroundResource(R.drawable.ksp_check);
            fcbBtn.setBackgroundResource(R.drawable.fcb_check);
            marsBtn.setBackgroundResource(R.drawable.mars);
            netflixBtn.setBackgroundResource(R.drawable.locked);
            nikeBtn.setBackgroundResource(R.drawable.locked);
            opelBtn.setBackgroundResource(R.drawable.locked);
            mtvBtn.setBackgroundResource(R.drawable.locked);
            netflixBtn.setEnabled(false);
            nikeBtn.setEnabled(false);
            opelBtn.setEnabled(false);
            mtvBtn.setEnabled(false);
        }
        else if(person.getArr1()==40){
            legoBtn.setBackgroundResource(R.drawable.lego_check);
            kfcBtn.setBackgroundResource(R.drawable.ksp_check);
            fcbBtn.setBackgroundResource(R.drawable.fcb_check);
            marsBtn.setBackgroundResource(R.drawable.mars_check);
            netflixBtn.setBackgroundResource(R.drawable.netflix);
            nikeBtn.setBackgroundResource(R.drawable.locked);
            opelBtn.setBackgroundResource(R.drawable.locked);
            mtvBtn.setBackgroundResource(R.drawable.locked);
            nikeBtn.setEnabled(false);
            opelBtn.setEnabled(false);
            mtvBtn.setEnabled(false);
        }
        else if(person.getArr1()==50){
            legoBtn.setBackgroundResource(R.drawable.lego_check);
            kfcBtn.setBackgroundResource(R.drawable.ksp_check);
            fcbBtn.setBackgroundResource(R.drawable.fcb_check);
            marsBtn.setBackgroundResource(R.drawable.mars_check);
            netflixBtn.setBackgroundResource(R.drawable.netflix_check);
            nikeBtn.setBackgroundResource(R.drawable.nike);
            opelBtn.setBackgroundResource(R.drawable.locked);
            mtvBtn.setBackgroundResource(R.drawable.locked);
            opelBtn.setEnabled(false);
            mtvBtn.setEnabled(false);
        }
        else if(person.getArr1()==60){
            legoBtn.setBackgroundResource(R.drawable.lego_check);
            kfcBtn.setBackgroundResource(R.drawable.ksp_check);
            fcbBtn.setBackgroundResource(R.drawable.fcb_check);
            marsBtn.setBackgroundResource(R.drawable.mars_check);
            netflixBtn.setBackgroundResource(R.drawable.netflix_check);
            nikeBtn.setBackgroundResource(R.drawable.nike_check);
            opelBtn.setBackgroundResource(R.drawable.opel);
            mtvBtn.setBackgroundResource(R.drawable.locked);
            mtvBtn.setEnabled(false);
        }
        else if(person.getArr1()==80){
            legoBtn.setBackgroundResource(R.drawable.lego_check);
            kfcBtn.setBackgroundResource(R.drawable.ksp_check);
            fcbBtn.setBackgroundResource(R.drawable.fcb_check);
            marsBtn.setBackgroundResource(R.drawable.mars_check);
            netflixBtn.setBackgroundResource(R.drawable.netflix_check);
            nikeBtn.setBackgroundResource(R.drawable.nike_check);
            opelBtn.setBackgroundResource(R.drawable.opel_check);
            mtvBtn.setBackgroundResource(R.drawable.mtv);
        }
        else if(person.getArr1()==105){
            legoBtn.setBackgroundResource(R.drawable.lego_check);
            kfcBtn.setBackgroundResource(R.drawable.ksp_check);
            fcbBtn.setBackgroundResource(R.drawable.fcb_check);
            marsBtn.setBackgroundResource(R.drawable.mars_check);
            netflixBtn.setBackgroundResource(R.drawable.netflix_check);
            nikeBtn.setBackgroundResource(R.drawable.nike_check);
            opelBtn.setBackgroundResource(R.drawable.opel_check);
            mtvBtn.setBackgroundResource(R.drawable.mtv_check);
        }
    }
}
