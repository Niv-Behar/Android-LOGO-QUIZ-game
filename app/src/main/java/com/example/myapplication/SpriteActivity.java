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

public class SpriteActivity extends AppCompatActivity {
    Person person;
    Button sUpBtn;
    Button pUpBtn;
    Button rUpBtn;
    Button iUpBtn;
    Button tUpBtn;
    Button eUpBtn;
    Button mDownBtn;
    Button aDownBtn;
    Button rDownBtn;
    Button iDownBtn;
    Button cDownBtn;
    Button pDownBtn;
    Button sDownBtn;
    Button fDownBtn;
    Button eDownBtn;
    Button tDownBtn;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.main_page){
            Intent intent = new Intent(SpriteActivity.this, HomeActivity.class);
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(SpriteActivity.this, InstructionActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sprite_main);

        sUpBtn = findViewById(R.id.sUp_btn);
        pUpBtn = findViewById(R.id.pUp_btn);
        rUpBtn = findViewById(R.id.rUp_btn);
        iUpBtn = findViewById(R.id.iUp_btn);
        tUpBtn = findViewById(R.id.tUp_btn);
        eUpBtn = findViewById(R.id.eUp_btn);
        mDownBtn = findViewById(R.id.mDown_btn);
        aDownBtn = findViewById(R.id.aDown_btn);
        rDownBtn = findViewById(R.id.rDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);
        cDownBtn = findViewById(R.id.cDown_btn);
        pDownBtn = findViewById(R.id.pDown_btn);
        sDownBtn = findViewById(R.id.sDown_btn);
        fDownBtn = findViewById(R.id.fDown_btn);
        eDownBtn = findViewById(R.id.eDown_btn);
        tDownBtn = findViewById(R.id.tDown_btn);
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
                if (person.getArr2()>=30) {
                    sUpBtn.setText("S");
                    pUpBtn.setText("P");
                    rUpBtn.setText("R");
                    iUpBtn.setText("I");
                    tUpBtn.setText("T");
                    eUpBtn.setText("E");
                    sUpBtn.setEnabled(false);
                    pUpBtn.setEnabled(false);
                    rUpBtn.setEnabled(false);
                    iUpBtn.setEnabled(false);
                    tUpBtn.setEnabled(false);
                    eUpBtn.setEnabled(false);
                    mDownBtn.setEnabled(false);
                    aDownBtn.setEnabled(false);
                    rDownBtn.setEnabled(false);
                    iDownBtn.setEnabled(false);
                    cDownBtn.setEnabled(false);
                    pDownBtn.setEnabled(false);
                    sDownBtn.setEnabled(false);
                    fDownBtn.setEnabled(false);
                    eDownBtn.setEnabled(false);
                    tDownBtn.setEnabled(false);
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
                                    Intent intant = new Intent(SpriteActivity.this, LevelThreeActivity.class);
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
                        Intent intent = new Intent(SpriteActivity.this, LevelThreeActivity.class);
                        startActivity(intent);
                        Animatoo.animateSlideRight(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });
        sUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (sUpBtn.getText().toString() == "M") {
                    sUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "A") {
                    sUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "R") {
                    sUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "I") {
                    sUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "C") {
                    sUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "P") {
                    sUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "S") {
                    sUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "F") {
                    sUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "E") {
                    sUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "T") {
                    sUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        pUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (pUpBtn.getText().toString() == "M") {
                    pUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "A") {
                    pUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "R") {
                    pUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "I") {
                    pUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "C") {
                    pUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "P") {
                    pUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "S") {
                    pUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "F") {
                    pUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "E") {
                    pUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "T") {
                    pUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        rUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (rUpBtn.getText().toString() == "M") {
                    rUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "A") {
                    rUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "R") {
                    rUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "I") {
                    rUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "C") {
                    rUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "P") {
                    rUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "S") {
                    rUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "F") {
                    rUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "E") {
                    rUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "T") {
                    rUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        iUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (iUpBtn.getText().toString() == "M") {
                    iUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "A") {
                    iUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "R") {
                    iUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "I") {
                    iUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "C") {
                    iUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "P") {
                    iUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "S") {
                    iUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "F") {
                    iUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "E") {
                    iUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "T") {
                    iUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        tUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (tUpBtn.getText().toString() == "M") {
                    tUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "A") {
                    tUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "R") {
                    tUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "I") {
                    tUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "C") {
                    tUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "P") {
                    tUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "S") {
                    tUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "F") {
                    tUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "E") {
                    tUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "T") {
                    tUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        eUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (eUpBtn.getText().toString() == "M") {
                    eUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "A") {
                    eUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "R") {
                    eUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "I") {
                    eUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "C") {
                    eUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "P") {
                    eUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "S") {
                    eUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "F") {
                    eUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "E") {
                    eUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "T") {
                    eUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        mDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                }
                if(sUpBtn.getText().toString() != "" && pUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((sUpBtn.getText().toString()+pUpBtn.getText().toString()+rUpBtn.getText().toString()+iUpBtn.getText().toString()+tUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("SPRITE")){
                        setWin();                     }
                    else{
                        Toast.makeText(SpriteActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        aDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                }
                if(sUpBtn.getText().toString() != "" && pUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((sUpBtn.getText().toString()+pUpBtn.getText().toString()+rUpBtn.getText().toString()+iUpBtn.getText().toString()+tUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("SPRITE")){
                        setWin();                     }
                    else{
                        Toast.makeText(SpriteActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        rDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                }
                if(sUpBtn.getText().toString() != "" && pUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((sUpBtn.getText().toString()+pUpBtn.getText().toString()+rUpBtn.getText().toString()+iUpBtn.getText().toString()+tUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("SPRITE")){
                        setWin();                     }
                    else{
                        Toast.makeText(SpriteActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        iDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                }
                if(sUpBtn.getText().toString() != "" && pUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((sUpBtn.getText().toString()+pUpBtn.getText().toString()+rUpBtn.getText().toString()+iUpBtn.getText().toString()+tUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("SPRITE")){
                        setWin();                     }
                    else{
                        Toast.makeText(SpriteActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        cDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                }
                if(sUpBtn.getText().toString() != "" && pUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((sUpBtn.getText().toString()+pUpBtn.getText().toString()+rUpBtn.getText().toString()+iUpBtn.getText().toString()+tUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("SPRITE")){
                        setWin();                     }
                    else{
                        Toast.makeText(SpriteActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        pDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                } else if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                }
                if(sUpBtn.getText().toString() != "" && pUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((sUpBtn.getText().toString()+pUpBtn.getText().toString()+rUpBtn.getText().toString()+iUpBtn.getText().toString()+tUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("SPRITE")){
                        setWin();                     }
                    else{
                        Toast.makeText(SpriteActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        sDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                }
                if(sUpBtn.getText().toString() != "" && pUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((sUpBtn.getText().toString()+pUpBtn.getText().toString()+rUpBtn.getText().toString()+iUpBtn.getText().toString()+tUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("SPRITE")){
                        setWin();                     }
                    else{
                        Toast.makeText(SpriteActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        fDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                }
                if(sUpBtn.getText().toString() != "" && pUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((sUpBtn.getText().toString()+pUpBtn.getText().toString()+rUpBtn.getText().toString()+iUpBtn.getText().toString()+tUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("SPRITE")){
                        setWin();                     }
                    else{
                        Toast.makeText(SpriteActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        eDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                }
                if(sUpBtn.getText().toString() != "" && pUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((sUpBtn.getText().toString()+pUpBtn.getText().toString()+rUpBtn.getText().toString()+iUpBtn.getText().toString()+tUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("SPRITE")){
                        setWin();                     }
                    else{
                        Toast.makeText(SpriteActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        tDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                }
                if(sUpBtn.getText().toString() != "" && pUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((sUpBtn.getText().toString()+pUpBtn.getText().toString()+rUpBtn.getText().toString()+iUpBtn.getText().toString()+tUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("SPRITE")){
                        setWin();                     }
                    else{
                        Toast.makeText(SpriteActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
        sUpBtn = findViewById(R.id.sUp_btn);
        pUpBtn = findViewById(R.id.pUp_btn);
        rUpBtn = findViewById(R.id.rUp_btn);
        iUpBtn = findViewById(R.id.iUp_btn);
        tUpBtn = findViewById(R.id.tUp_btn);
        eUpBtn = findViewById(R.id.eUp_btn);
        mDownBtn = findViewById(R.id.mDown_btn);
        aDownBtn = findViewById(R.id.aDown_btn);
        rDownBtn = findViewById(R.id.rDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);
        cDownBtn = findViewById(R.id.cDown_btn);
        pDownBtn = findViewById(R.id.pDown_btn);
        sDownBtn = findViewById(R.id.sDown_btn);
        fDownBtn = findViewById(R.id.fDown_btn);
        eDownBtn = findViewById(R.id.eDown_btn);
        tDownBtn = findViewById(R.id.tDown_btn);
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
                person.setScore2(person.getArr2()+10);
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
        sDownBtn.setVisibility(View.VISIBLE);
        pDownBtn.setVisibility(View.VISIBLE);
        rDownBtn.setVisibility(View.VISIBLE);
        iDownBtn.setVisibility(View.VISIBLE);
        tDownBtn.setVisibility(View.VISIBLE);
        eDownBtn.setVisibility(View.VISIBLE);
        sUpBtn.setEnabled(false);
        pUpBtn.setEnabled(false);
        rUpBtn.setEnabled(false);
        iUpBtn.setEnabled(false);
        tUpBtn.setEnabled(false);
        eUpBtn.setEnabled(false);
        mDownBtn.setEnabled(false);
        aDownBtn.setEnabled(false);
        rDownBtn.setEnabled(false);
        iDownBtn.setEnabled(false);
        cDownBtn.setEnabled(false);
        pDownBtn.setEnabled(false);
        sDownBtn.setEnabled(false);
        fDownBtn.setEnabled(false);
        eDownBtn.setEnabled(false);
        tDownBtn.setEnabled(false);

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
                        Intent intant =new Intent(SpriteActivity.this,LevelThreeActivity.class);
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
