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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PumaActivity extends AppCompatActivity {
    Person person;
    Button pUpBtn;
    Button uUpBtn;
    Button mUpBtn;
    Button aUpBtn;
    Button tDownBtn;
    Button mDownBtn;
    Button zDownBtn;
    Button gDownBtn;
    Button pDownBtn;
    Button nDownBtn;
    Button rDownBtn;
    Button aDownBtn;
    Button vDownBtn;
    Button uDownBtn;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.main_page){
            Intent intent = new Intent(PumaActivity.this, HomeActivity.class);
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(PumaActivity.this, InstructionActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puma_main);

        pUpBtn = findViewById(R.id.pUp_btn);
        uUpBtn = findViewById(R.id.uUp_btn);
        mUpBtn = findViewById(R.id.mUp_btn);
        aUpBtn = findViewById(R.id.aUp_btn);
        tDownBtn = findViewById(R.id.tDown_btn);
        mDownBtn = findViewById(R.id.mDown_btn);
        zDownBtn = findViewById(R.id.zDown_btn);
        gDownBtn = findViewById(R.id.gDown_btn);
        pDownBtn = findViewById(R.id.pDown_btn);
        nDownBtn = findViewById(R.id.nDown_btn);
        rDownBtn = findViewById(R.id.rDown_btn);
        aDownBtn = findViewById(R.id.aDown_btn);
        vDownBtn = findViewById(R.id.vDown_btn);
        uDownBtn = findViewById(R.id.uDown_btn);
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
                if (person.getArr()>=75) {
                    pUpBtn.setText("P");
                    uUpBtn.setText("U");
                    mUpBtn.setText("M");
                    aUpBtn.setText("A");
                    pUpBtn.setEnabled(false);
                    uUpBtn.setEnabled(false);
                    mUpBtn.setEnabled(false);
                    aUpBtn.setEnabled(false);
                    tDownBtn.setEnabled(false);
                    mDownBtn.setEnabled(false);
                    zDownBtn.setEnabled(false);
                    gDownBtn.setEnabled(false);
                    pDownBtn.setEnabled(false);
                    nDownBtn.setEnabled(false);
                    rDownBtn.setEnabled(false);
                    aDownBtn.setEnabled(false);
                    vDownBtn.setEnabled(false);
                    uDownBtn.setEnabled(false);
                    TextView textView = findViewById(R.id.compplete);
                    textView.setVisibility(View.VISIBLE);
                    Button button = findViewById(R.id.next);
                    button.setVisibility(View.VISIBLE);
                    button.setEnabled(true);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(final View v) {
                            Animation animation = AnimationUtils.loadAnimation(v.getContext(), R.anim.btn);
                            animation.setDuration(300);
                            Bounce bounce = new Bounce(0.5, 20);
                            animation.setInterpolator(bounce);
                            v.startAnimation(animation);
                            animation.setAnimationListener(new Animation.AnimationListener() {
                                @Override
                                public void onAnimationStart(Animation animation) {
                                    MediaPlayer back_btn = MediaPlayer.create(v.getContext(), R.raw.slide);
                                    back_btn.start();
                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {
                                    Intent intant = new Intent(PumaActivity.this, LevelOneActivity.class);
                                    startActivity(intant);
                                    Animatoo.animateFade(v.getContext());
                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {

                                }
                            });
                        }
                    });
                }
            }
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
                        Intent intent = new Intent(PumaActivity.this, LevelOneActivity.class);
                        startActivity(intent);
                        Animatoo.animateSlideRight(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });
        pUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (pUpBtn.getText().toString() == "T") {
                    pUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "M") {
                    pUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "Z") {
                    pUpBtn.setText("");
                    zDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "G") {
                    pUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "P") {
                    pUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "N") {
                    pUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "R") {
                    pUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "A") {
                    pUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "V") {
                    pUpBtn.setText("");
                    vDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "U") {
                    pUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        uUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (uUpBtn.getText().toString() == "T") {
                    uUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (uUpBtn.getText().toString() == "M") {
                    uUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (uUpBtn.getText().toString() == "Z") {
                    uUpBtn.setText("");
                    zDownBtn.setVisibility(View.VISIBLE);
                } else if (uUpBtn.getText().toString() == "G") {
                    uUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (uUpBtn.getText().toString() == "P") {
                    uUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (uUpBtn.getText().toString() == "N") {
                    uUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (uUpBtn.getText().toString() == "R") {
                    uUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (uUpBtn.getText().toString() == "A") {
                    uUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (uUpBtn.getText().toString() == "V") {
                    uUpBtn.setText("");
                    vDownBtn.setVisibility(View.VISIBLE);
                } else if (uUpBtn.getText().toString() == "U") {
                    uUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        mUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (mUpBtn.getText().toString() == "T") {
                    mUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "M") {
                    mUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "Z") {
                    mUpBtn.setText("");
                    zDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "G") {
                    mUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "P") {
                    mUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "N") {
                    mUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "R") {
                    mUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "A") {
                    mUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "V") {
                    mUpBtn.setText("");
                    vDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "U") {
                    mUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        aUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (aUpBtn.getText().toString() == "T") {
                    aUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "M") {
                    aUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "Z") {
                    aUpBtn.setText("");
                    zDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "G") {
                    aUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "P") {
                    aUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "N") {
                    aUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "R") {
                    aUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "A") {
                    aUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "V") {
                    aUpBtn.setText("");
                    vDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "U") {
                    aUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        tDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (uUpBtn.getText().toString() == "") {
                    uUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                }
                if(pUpBtn.getText().toString() != "" && uUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((pUpBtn.getText().toString()+uUpBtn.getText().toString()+mUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("PUMA")){
                        setWin();                     }
                    else{
                        Toast.makeText(PumaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        mDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (uUpBtn.getText().toString() == "") {
                    uUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                }
                if(pUpBtn.getText().toString() != "" && uUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((pUpBtn.getText().toString()+uUpBtn.getText().toString()+mUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("PUMA")){
                        setWin();                     }
                    else{
                        Toast.makeText(PumaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        zDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("Z");
                    zDownBtn.setVisibility(View.INVISIBLE);
                } else if (uUpBtn.getText().toString() == "") {
                    uUpBtn.setText("Z");
                    zDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("Z");
                    zDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("Z");
                    zDownBtn.setVisibility(View.INVISIBLE);
                }
                if(pUpBtn.getText().toString() != "" && uUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((pUpBtn.getText().toString()+uUpBtn.getText().toString()+mUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("PUMA")){
                        setWin();                     }
                    else{
                        Toast.makeText(PumaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        gDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                } else if (uUpBtn.getText().toString() == "") {
                    uUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                }
                if(pUpBtn.getText().toString() != "" && uUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((pUpBtn.getText().toString()+uUpBtn.getText().toString()+mUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("PUMA")){
                        setWin();                     }
                    else{
                        Toast.makeText(PumaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        pDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                } else if (uUpBtn.getText().toString() == "") {
                    uUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                }
                if(pUpBtn.getText().toString() != "" && uUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((pUpBtn.getText().toString()+uUpBtn.getText().toString()+mUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("PUMA")){
                        setWin();                     }
                    else{
                        Toast.makeText(PumaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        nDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (uUpBtn.getText().toString() == "") {
                    uUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                }
                if(pUpBtn.getText().toString() != "" && uUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((pUpBtn.getText().toString()+uUpBtn.getText().toString()+mUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("PUMA")){
                        setWin();                     }
                    else{
                        Toast.makeText(PumaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        rDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (uUpBtn.getText().toString() == "") {
                    uUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                }
                if(pUpBtn.getText().toString() != "" && uUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((pUpBtn.getText().toString()+uUpBtn.getText().toString()+mUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("PUMA")){
                        setWin();                     }
                    else{
                        Toast.makeText(PumaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        aDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (uUpBtn.getText().toString() == "") {
                    uUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                }
                if(pUpBtn.getText().toString() != "" && uUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((pUpBtn.getText().toString()+uUpBtn.getText().toString()+mUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("PUMA")){
                        setWin();                     }
                    else{
                        Toast.makeText(PumaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        vDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("V");
                    vDownBtn.setVisibility(View.INVISIBLE);
                } else if (uUpBtn.getText().toString() == "") {
                    uUpBtn.setText("V");
                    vDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("V");
                    vDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("V");
                    vDownBtn.setVisibility(View.INVISIBLE);
                }
                if(pUpBtn.getText().toString() != "" && uUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((pUpBtn.getText().toString()+uUpBtn.getText().toString()+mUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("PUMA")){
                        setWin();                     }
                    else{
                        Toast.makeText(PumaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        uDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                } else if (uUpBtn.getText().toString() == "") {
                    uUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                }
                if(pUpBtn.getText().toString() != "" && uUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((pUpBtn.getText().toString()+uUpBtn.getText().toString()+mUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("PUMA")){
                        setWin();                     }
                    else{
                        Toast.makeText(PumaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

    }
    public void setWin(){
        MediaPlayer correct = MediaPlayer.create(getApplicationContext(), R.raw.correct);
        correct.start();
        pUpBtn = findViewById(R.id.pUp_btn);
        uUpBtn = findViewById(R.id.uUp_btn);
        mUpBtn = findViewById(R.id.mUp_btn);
        aUpBtn = findViewById(R.id.aUp_btn);
        tDownBtn = findViewById(R.id.tDown_btn);
        mDownBtn = findViewById(R.id.mDown_btn);
        zDownBtn = findViewById(R.id.zDown_btn);
        gDownBtn = findViewById(R.id.gDown_btn);
        pDownBtn = findViewById(R.id.pDown_btn);
        nDownBtn = findViewById(R.id.nDown_btn);
        rDownBtn = findViewById(R.id.rDown_btn);
        aDownBtn = findViewById(R.id.aDown_btn);
        vDownBtn = findViewById(R.id.vDown_btn);
        uDownBtn = findViewById(R.id.uDown_btn);
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
                person.setScore(person.getArr()+15);
            }
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileOutputStream fos = openFileOutput("person", MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(person);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pDownBtn.setVisibility(View.VISIBLE);
        uDownBtn.setVisibility(View.VISIBLE);
        mDownBtn.setVisibility(View.VISIBLE);
        aDownBtn.setVisibility(View.VISIBLE);
        pUpBtn.setEnabled(false);
        uUpBtn.setEnabled(false);
        mUpBtn.setEnabled(false);
        aUpBtn.setEnabled(false);
        tDownBtn.setEnabled(false);
        mDownBtn.setEnabled(false);
        zDownBtn.setEnabled(false);
        gDownBtn.setEnabled(false);
        pDownBtn.setEnabled(false);
        nDownBtn.setEnabled(false);
        rDownBtn.setEnabled(false);
        aDownBtn.setEnabled(false);
        vDownBtn.setEnabled(false);
        uDownBtn.setEnabled(false);

        TextView textView=findViewById(R.id.compplete);
        textView.setVisibility(View.VISIBLE);
        Button button=findViewById(R.id.next);
        button.setVisibility(View.VISIBLE);
        button.setEnabled(true);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Animation animation= AnimationUtils.loadAnimation(v.getContext(),R.anim.btn);
                animation.setDuration(300);
                Bounce bounce=new Bounce(0.5,20);
                animation.setInterpolator(bounce);
                v.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer back_btn= MediaPlayer.create(v.getContext(),R.raw.slide);
                        back_btn.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intant =new Intent(PumaActivity.this,LevelOneActivity.class);
                        startActivity(intant);
                        Animatoo.animateFade(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
    }
}
