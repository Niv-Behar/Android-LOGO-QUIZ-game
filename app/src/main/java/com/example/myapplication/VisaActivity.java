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

public class VisaActivity extends AppCompatActivity {
    Person person;
    Button vUpBtn;
    Button iUpBtn;
    Button sUpBtn;
    Button aUpBtn;
    Button eDownBtn;
    Button mDownBtn;
    Button iDownBtn;
    Button gDownBtn;
    Button sDownBtn;
    Button nDownBtn;
    Button vDownBtn;
    Button aDownBtn;
    Button kDownBtn;
    Button uDownBtn;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.main_page){
            Intent intent = new Intent(VisaActivity.this, HomeActivity.class);
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(VisaActivity.this, InstructionActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visa_main);

        vUpBtn = findViewById(R.id.vUp_btn);
        iUpBtn = findViewById(R.id.iUp_btn);
        sUpBtn = findViewById(R.id.sUp_btn);
        aUpBtn = findViewById(R.id.aUp_btn);
        eDownBtn = findViewById(R.id.eDown_btn);
        mDownBtn = findViewById(R.id.mDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);
        gDownBtn = findViewById(R.id.gDown_btn);
        sDownBtn = findViewById(R.id.sDown_btn);
        nDownBtn = findViewById(R.id.nDown_btn);
        vDownBtn = findViewById(R.id.vDown_btn);
        aDownBtn = findViewById(R.id.aDown_btn);
        kDownBtn = findViewById(R.id.kDown_btn);
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
                if (person.getArr2()>=40) {
                    vUpBtn.setText("V");
                    iUpBtn.setText("I");
                    sUpBtn.setText("S");
                    aUpBtn.setText("A");
                    vUpBtn.setEnabled(false);
                    iUpBtn.setEnabled(false);
                    sUpBtn.setEnabled(false);
                    aUpBtn.setEnabled(false);
                   eDownBtn.setEnabled(false);
                   mDownBtn.setEnabled(false);
                   iDownBtn.setEnabled(false);
                   gDownBtn.setEnabled(false);
                   sDownBtn.setEnabled(false);
                   nDownBtn.setEnabled(false);
                   vDownBtn.setEnabled(false);
                   aDownBtn.setEnabled(false);
                   kDownBtn.setEnabled(false);
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
                                    Intent intant = new Intent(VisaActivity.this, LevelThreeActivity.class);
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
                        Intent intent = new Intent(VisaActivity.this, LevelThreeActivity.class);
                        startActivity(intent);
                        Animatoo.animateSlideRight(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });
        vUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (vUpBtn.getText().toString() == "E") {
                    vUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (vUpBtn.getText().toString() == "M") {
                    vUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (vUpBtn.getText().toString() == "I") {
                    vUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (vUpBtn.getText().toString() == "G") {
                    vUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (vUpBtn.getText().toString() == "S") {
                    vUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (vUpBtn.getText().toString() == "N") {
                    vUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (vUpBtn.getText().toString() == "V") {
                    vUpBtn.setText("");
                    vDownBtn.setVisibility(View.VISIBLE);
                } else if (vUpBtn.getText().toString() == "A") {
                    vUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (vUpBtn.getText().toString() == "K") {
                    vUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (vUpBtn.getText().toString() == "U") {
                    vUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        iUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (iUpBtn.getText().toString() == "E") {
                    iUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "M") {
                    iUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "I") {
                    iUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "G") {
                    iUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "S") {
                    iUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "N") {
                    iUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "V") {
                    iUpBtn.setText("");
                    vDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "A") {
                    iUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "K") {
                    iUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "U") {
                    iUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        sUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (sUpBtn.getText().toString() == "E") {
                    sUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "M") {
                    sUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "I") {
                    sUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "G") {
                    sUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "S") {
                    sUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "N") {
                    sUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "V") {
                    sUpBtn.setText("");
                    vDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "A") {
                    sUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "K") {
                    sUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "U") {
                    sUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        aUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (aUpBtn.getText().toString() == "E") {
                    aUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "M") {
                    aUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "I") {
                    aUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "G") {
                    aUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "S") {
                    aUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "N") {
                    aUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "V") {
                    aUpBtn.setText("");
                    vDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "A") {
                    aUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "K") {
                    aUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "U") {
                    aUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        eDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vUpBtn.getText().toString() == "") {
                    vUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                }
                if(vUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((vUpBtn.getText().toString()+iUpBtn.getText().toString()+sUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("VISA")){
                        setWin();                     }
                    else{
                        Toast.makeText(VisaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        mDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vUpBtn.getText().toString() == "") {
                    vUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                }
                if(vUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((vUpBtn.getText().toString()+iUpBtn.getText().toString()+sUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("VISA")){
                        setWin();                     }
                    else{
                        Toast.makeText(VisaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        iDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vUpBtn.getText().toString() == "") {
                    vUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                }
                if(vUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((vUpBtn.getText().toString()+iUpBtn.getText().toString()+sUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("VISA")){
                        setWin();                     }
                    else{
                        Toast.makeText(VisaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        gDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vUpBtn.getText().toString() == "") {
                    vUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                }
                if(vUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((vUpBtn.getText().toString()+iUpBtn.getText().toString()+sUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("VISA")){
                        setWin();                     }
                    else{
                        Toast.makeText(VisaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        sDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vUpBtn.getText().toString() == "") {
                    vUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                }
                if(vUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((vUpBtn.getText().toString()+iUpBtn.getText().toString()+sUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("VISA")){
                        setWin();                     }
                    else{
                        Toast.makeText(VisaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        nDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vUpBtn.getText().toString() == "") {
                    vUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                }
                if(vUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((vUpBtn.getText().toString()+iUpBtn.getText().toString()+sUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("VISA")){
                        setWin();                     }
                    else{
                        Toast.makeText(VisaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        vDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vUpBtn.getText().toString() == "") {
                    vUpBtn.setText("V");
                    vDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("V");
                    vDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("V");
                    vDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("V");
                    vDownBtn.setVisibility(View.INVISIBLE);
                }
                if(vUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((vUpBtn.getText().toString()+iUpBtn.getText().toString()+sUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("VISA")){
                        setWin();                     }
                    else{
                        Toast.makeText(VisaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        aDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vUpBtn.getText().toString() == "") {
                    vUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                }
                if(vUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((vUpBtn.getText().toString()+iUpBtn.getText().toString()+sUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("VISA")){
                        setWin();                     }
                    else{
                        Toast.makeText(VisaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        kDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vUpBtn.getText().toString() == "") {
                    vUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                }
                if(vUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((vUpBtn.getText().toString()+iUpBtn.getText().toString()+sUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("VISA")){
                        setWin();                     }
                    else{
                        Toast.makeText(VisaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        uDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vUpBtn.getText().toString() == "") {
                    vUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                }
                if(vUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((vUpBtn.getText().toString()+iUpBtn.getText().toString()+sUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("VISA")){
                        setWin();                     }
                    else{
                        Toast.makeText(VisaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
        vUpBtn = findViewById(R.id.vUp_btn);
        iUpBtn = findViewById(R.id.iUp_btn);
        sUpBtn = findViewById(R.id.sUp_btn);
        aUpBtn = findViewById(R.id.aUp_btn);
        eDownBtn = findViewById(R.id.eDown_btn);
        mDownBtn = findViewById(R.id.mDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);
        gDownBtn = findViewById(R.id.gDown_btn);
        sDownBtn = findViewById(R.id.sDown_btn);
        nDownBtn = findViewById(R.id.nDown_btn);
        vDownBtn = findViewById(R.id.vDown_btn);
        aDownBtn = findViewById(R.id.aDown_btn);
        kDownBtn = findViewById(R.id.kDown_btn);
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
        vDownBtn.setVisibility(View.VISIBLE);
        iDownBtn.setVisibility(View.VISIBLE);
        sDownBtn.setVisibility(View.VISIBLE);
        aDownBtn.setVisibility(View.VISIBLE);
        vUpBtn.setEnabled(false);
        iUpBtn.setEnabled(false);
        sUpBtn.setEnabled(false);
        aUpBtn.setEnabled(false);
        eDownBtn.setEnabled(false);
        mDownBtn.setEnabled(false);
        iDownBtn.setEnabled(false);
        gDownBtn.setEnabled(false);
        sDownBtn.setEnabled(false);
        nDownBtn.setEnabled(false);
        vDownBtn.setEnabled(false);
        aDownBtn.setEnabled(false);
        kDownBtn.setEnabled(false);
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
                        Intent intant =new Intent(VisaActivity.this,LevelThreeActivity.class);
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

