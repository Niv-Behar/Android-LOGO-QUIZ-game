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

public class MarsActivity extends AppCompatActivity {
    Person person;
    Button mUpBtn;
    Button aUpBtn;
    Button rUpBtn;
    Button sUpBtn;
    Button lDownBtn;
    Button nDownBtn;
    Button iDownBtn;
    Button sDownBtn;
    Button zDownBtn;
    Button aDownBtn;
    Button gDownBtn;
    Button mDownBtn;
    Button tDownBtn;
    Button rDownBtn;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.main_page){
            Intent intent = new Intent(MarsActivity.this, HomeActivity.class);
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(MarsActivity.this, InstructionActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mars_main);

        mUpBtn = findViewById(R.id.mUp_btn);
        aUpBtn = findViewById(R.id.aUp_btn);
        rUpBtn = findViewById(R.id.rUp_btn);
        sUpBtn = findViewById(R.id.sUp_btn);
        lDownBtn = findViewById(R.id.lDown_btn);
        nDownBtn = findViewById(R.id.nDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);
        sDownBtn = findViewById(R.id.sDown_btn);
        zDownBtn = findViewById(R.id.zDown_btn);
        aDownBtn = findViewById(R.id.aDown_btn);
        gDownBtn = findViewById(R.id.gDown_btn);
        mDownBtn = findViewById(R.id.mDown_btn);
        tDownBtn = findViewById(R.id.tDown_btn);
        rDownBtn = findViewById(R.id.rDown_btn);
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
                if (person.getArr2()>=40) {
                    mUpBtn.setText("N");
                    aUpBtn.setText("A");
                    rUpBtn.setText("R");
                    sUpBtn.setText("S");
                    mUpBtn.setEnabled(false);
                    aUpBtn.setEnabled(false);
                    rUpBtn.setEnabled(false);
                    sUpBtn.setEnabled(false);
                    lDownBtn.setEnabled(false);
                    nDownBtn.setEnabled(false);
                    iDownBtn.setEnabled(false);
                    sDownBtn.setEnabled(false);
                    zDownBtn.setEnabled(false);
                    aDownBtn.setEnabled(false);
                    gDownBtn.setEnabled(false);
                    mDownBtn.setEnabled(false);
                    tDownBtn.setEnabled(false);
                    rDownBtn.setEnabled(false);
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
                                    Intent intant = new Intent(MarsActivity.this, LevelTwoActivity.class);
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
                        Intent intent = new Intent(MarsActivity.this, LevelTwoActivity.class);
                        startActivity(intent);
                        Animatoo.animateSlideRight(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });
        mUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (mUpBtn.getText().toString() == "L") {
                    mUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "N") {
                    mUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "I") {
                    mUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "S") {
                    mUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "Z") {
                    mUpBtn.setText("");
                    zDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "A") {
                    mUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "G") {
                    mUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "M") {
                    mUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "T") {
                    mUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "R") {
                    mUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        aUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (aUpBtn.getText().toString() == "L") {
                    aUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "N") {
                    aUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "I") {
                    aUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "S") {
                    aUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "Z") {
                    aUpBtn.setText("");
                    zDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "A") {
                    aUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "G") {
                    aUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "M") {
                    aUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "T") {
                    aUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "R") {
                    aUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        rUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (rUpBtn.getText().toString() == "L") {
                    rUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "N") {
                    rUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "I") {
                    rUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "S") {
                    rUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "Z") {
                    rUpBtn.setText("");
                    zDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "A") {
                    rUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "G") {
                    rUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "M") {
                    rUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "T") {
                    rUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "R") {
                    rUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        sUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (sUpBtn.getText().toString() == "L") {
                    sUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "N") {
                    sUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "I") {
                    sUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "S") {
                    sUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "Z") {
                    sUpBtn.setText("");
                    zDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "A") {
                    sUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "G") {
                    sUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "M") {
                    sUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "T") {
                    sUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "R") {
                    sUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        lDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                }
                if(mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != ""){
                    if((mUpBtn.getText().toString()+aUpBtn.getText().toString()+rUpBtn.getText().toString()+sUpBtn.getText().toString()).equals("MARS")){
                        setWin();                     }
                    else{
                        Toast.makeText(MarsActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        nDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                }
                if(mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != ""){
                    if((mUpBtn.getText().toString()+aUpBtn.getText().toString()+rUpBtn.getText().toString()+sUpBtn.getText().toString()).equals("MARS")){
                        setWin();                     }
                    else{
                        Toast.makeText(MarsActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        iDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                }
                if(mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != ""){
                    if((mUpBtn.getText().toString()+aUpBtn.getText().toString()+rUpBtn.getText().toString()+sUpBtn.getText().toString()).equals("MARS")){
                        setWin();                     }
                    else{
                        Toast.makeText(MarsActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        sDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                }
                if(mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != ""){
                    if((mUpBtn.getText().toString()+aUpBtn.getText().toString()+rUpBtn.getText().toString()+sUpBtn.getText().toString()).equals("MARS")){
                        setWin();                     }
                    else{
                        Toast.makeText(MarsActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        zDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("Z");
                    zDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("Z");
                    zDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("Z");
                    zDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("Z");
                    zDownBtn.setVisibility(View.INVISIBLE);
                }
                if(mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != ""){
                    if((mUpBtn.getText().toString()+aUpBtn.getText().toString()+rUpBtn.getText().toString()+sUpBtn.getText().toString()).equals("MARS")){
                        setWin();                     }
                    else{
                        Toast.makeText(MarsActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        aDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                }
                if(mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != ""){
                    if((mUpBtn.getText().toString()+aUpBtn.getText().toString()+rUpBtn.getText().toString()+sUpBtn.getText().toString()).equals("MARS")){
                        setWin();                     }
                    else{
                        Toast.makeText(MarsActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        gDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                }
                if(mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != ""){
                    if((mUpBtn.getText().toString()+aUpBtn.getText().toString()+rUpBtn.getText().toString()+sUpBtn.getText().toString()).equals("MARS")){
                        setWin();                     }
                    else{
                        Toast.makeText(MarsActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        mDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                }
                if(mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != ""){
                    if((mUpBtn.getText().toString()+aUpBtn.getText().toString()+rUpBtn.getText().toString()+sUpBtn.getText().toString()).equals("MARS")){
                        setWin();                     }
                    else{
                        Toast.makeText(MarsActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        tDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                }
                if(mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != ""){
                    if((mUpBtn.getText().toString()+aUpBtn.getText().toString()+rUpBtn.getText().toString()+sUpBtn.getText().toString()).equals("MARS")){
                        setWin();                     }
                    else{
                        Toast.makeText(MarsActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        rDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                }
                if(mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != ""){
                    if((mUpBtn.getText().toString()+aUpBtn.getText().toString()+rUpBtn.getText().toString()+sUpBtn.getText().toString()).equals("MARS")){
                        setWin();                     }
                    else{
                        Toast.makeText(MarsActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
        mUpBtn = findViewById(R.id.mUp_btn);
        aUpBtn = findViewById(R.id.aUp_btn);
        rUpBtn = findViewById(R.id.rUp_btn);
        sUpBtn = findViewById(R.id.sUp_btn);
        lDownBtn = findViewById(R.id.lDown_btn);
        nDownBtn = findViewById(R.id.nDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);
        sDownBtn = findViewById(R.id.sDown_btn);
        zDownBtn = findViewById(R.id.zDown_btn);
        aDownBtn = findViewById(R.id.aDown_btn);
        gDownBtn = findViewById(R.id.gDown_btn);
        mDownBtn = findViewById(R.id.mDown_btn);
        tDownBtn = findViewById(R.id.tDown_btn);
        rDownBtn = findViewById(R.id.rDown_btn);
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
                person.setScore1(person.getArr1()+10);
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
        mDownBtn.setVisibility(View.VISIBLE);
        aDownBtn.setVisibility(View.VISIBLE);
        rDownBtn.setVisibility(View.VISIBLE);
        sDownBtn.setVisibility(View.VISIBLE);
        mUpBtn.setEnabled(false);
        aUpBtn.setEnabled(false);
        rUpBtn.setEnabled(false);
        sUpBtn.setEnabled(false);
        lDownBtn.setEnabled(false);
        nDownBtn.setEnabled(false);
        iDownBtn.setEnabled(false);
        sDownBtn.setEnabled(false);
        zDownBtn.setEnabled(false);
        aDownBtn.setEnabled(false);
        gDownBtn.setEnabled(false);
        mDownBtn.setEnabled(false);
        tDownBtn.setEnabled(false);
        rDownBtn.setEnabled(false);

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
                        Intent intant =new Intent(MarsActivity.this,LevelTwoActivity.class);
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

