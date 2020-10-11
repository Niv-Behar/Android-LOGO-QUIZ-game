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

public class GmailActivity extends AppCompatActivity {
    Person person;
    Button gUpBtn;
    Button mUpBtn;
    Button aUpBtn;
    Button iUpBtn;
    Button lUpBtn;
    Button aDownBtn;
    Button mDownBtn;
    Button hDownBtn;
    Button lDownBtn;
    Button oDownBtn;
    Button uDownBtn;
    Button cDownBtn;
    Button qDownBtn;
    Button gDownBtn;
    Button iDownBtn;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.main_page){
            Intent intent = new Intent(GmailActivity.this, HomeActivity.class);
            finish();
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(GmailActivity.this, InstructionActivity.class);
            finish();
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gmail_main);

        gUpBtn = findViewById(R.id.gUp_btn);
        mUpBtn = findViewById(R.id.mUp_btn);
        aUpBtn = findViewById(R.id.aUp_btn);
        iUpBtn = findViewById(R.id.iUp_btn);
        lUpBtn = findViewById(R.id.lUp_btn);

        aDownBtn = findViewById(R.id.aDown_btn);
        mDownBtn = findViewById(R.id.mDown_btn);
        hDownBtn = findViewById(R.id.hDown_btn);
        lDownBtn = findViewById(R.id.lDown_btn);
        oDownBtn = findViewById(R.id.oDown_btn);
        uDownBtn = findViewById(R.id.uDown_btn);
        cDownBtn = findViewById(R.id.cDown_btn);
        qDownBtn = findViewById(R.id.qDown_btn);
        gDownBtn = findViewById(R.id.gDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);

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
                if (person.getArr()>=30) {
                    gUpBtn.setText("G");
                    mUpBtn.setText("M");
                    aUpBtn.setText("A");
                    iUpBtn.setText("I");
                    lUpBtn.setText("L");
                    gUpBtn.setEnabled(false);
                    mUpBtn.setEnabled(false);
                    aUpBtn.setEnabled(false);
                    iUpBtn.setEnabled(false);
                    lUpBtn.setEnabled(false);
                    aDownBtn.setEnabled(false);
                    mDownBtn.setEnabled(false);
                    hDownBtn.setEnabled(false);
                    lDownBtn.setEnabled(false);
                    oDownBtn.setEnabled(false);
                    uDownBtn.setEnabled(false);
                    cDownBtn.setEnabled(false);
                    qDownBtn.setEnabled(false);
                    gDownBtn.setEnabled(false);
                    iDownBtn.setEnabled(false);
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
                                    Intent intant = new Intent(GmailActivity.this, LevelOneActivity.class);
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
                        Intent intent = new Intent(GmailActivity.this, LevelOneActivity.class);
                        startActivity(intent);
                        Animatoo.animateSlideRight(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });
        gUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (gUpBtn.getText().toString() == "A") {
                    gUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (gUpBtn.getText().toString() == "M") {
                    gUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (gUpBtn.getText().toString() == "H") {
                    gUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (gUpBtn.getText().toString() == "L") {
                    gUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (gUpBtn.getText().toString() == "O") {
                    gUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (gUpBtn.getText().toString() == "U") {
                    gUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                } else if (gUpBtn.getText().toString() == "C") {
                    gUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (gUpBtn.getText().toString() == "Q") {
                    gUpBtn.setText("");
                    qDownBtn.setVisibility(View.VISIBLE);
                } else if (gUpBtn.getText().toString() == "G") {
                    gUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (gUpBtn.getText().toString() == "I") {
                    gUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        mUpBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (mUpBtn.getText().toString() == "A") {
                    mUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "M") {
                    mUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "H") {
                    mUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "L") {
                    mUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "O") {
                    mUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "U") {
                    mUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "C") {
                    mUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "Q") {
                    mUpBtn.setText("");
                    qDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "G") {
                    mUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "I") {
                    mUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        aUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (aUpBtn.getText().toString() == "A") {
                    aUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "M") {
                    aUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "H") {
                    aUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "L") {
                    aUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "O") {
                    aUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "U") {
                    aUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "C") {
                    aUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "Q") {
                    aUpBtn.setText("");
                    qDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "G") {
                    aUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "I") {
                    aUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        iUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (iUpBtn.getText().toString() == "A") {
                    iUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "M") {
                    iUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "H") {
                    iUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "L") {
                    iUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "O") {
                    iUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "U") {
                    iUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "C") {
                    iUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "Q") {
                    iUpBtn.setText("");
                    qDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "G") {
                    iUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "I") {
                    iUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        lUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (lUpBtn.getText().toString() == "A") {
                    lUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "M") {
                    lUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "H") {
                    lUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "L") {
                    lUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "O") {
                    lUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "U") {
                    lUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "C") {
                    lUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "Q") {
                    lUpBtn.setText("");
                    qDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "G") {
                    lUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "I") {
                    lUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        aDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gUpBtn.getText().toString() == "") {
                    gUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                }
                if(gUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((gUpBtn.getText().toString()+mUpBtn.getText().toString()+aUpBtn.getText().toString()+iUpBtn.getText().toString() + lUpBtn.getText().toString()).equals("GMAIL")){
                        setWin();                     }
                    else{
                        Toast.makeText(GmailActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        mDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gUpBtn.getText().toString() == "") {
                    gUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                }
                if(gUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((gUpBtn.getText().toString()+mUpBtn.getText().toString()+aUpBtn.getText().toString()+iUpBtn.getText().toString() + lUpBtn.getText().toString()).equals("GMAIL")){
                        setWin();                     }
                    else{
                        Toast.makeText(GmailActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        hDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gUpBtn.getText().toString() == "") {
                    gUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                }
                if(gUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((gUpBtn.getText().toString()+mUpBtn.getText().toString()+aUpBtn.getText().toString()+iUpBtn.getText().toString() + lUpBtn.getText().toString()).equals("GMAIL")){
                        setWin();                     }
                    else{
                        Toast.makeText(GmailActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        lDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gUpBtn.getText().toString() == "") {
                    gUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                }
                if(gUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((gUpBtn.getText().toString()+mUpBtn.getText().toString()+aUpBtn.getText().toString()+iUpBtn.getText().toString() + lUpBtn.getText().toString()).equals("GMAIL")){
                        setWin();                     }
                    else{
                        Toast.makeText(GmailActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        oDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gUpBtn.getText().toString() == "") {
                    gUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                }
                if(gUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((gUpBtn.getText().toString()+mUpBtn.getText().toString()+aUpBtn.getText().toString()+iUpBtn.getText().toString() + lUpBtn.getText().toString()).equals("GMAIL")){
                        setWin();                     }
                    else{
                        Toast.makeText(GmailActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        uDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gUpBtn.getText().toString() == "") {
                    gUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                }
                if(gUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((gUpBtn.getText().toString()+mUpBtn.getText().toString()+aUpBtn.getText().toString()+iUpBtn.getText().toString() + lUpBtn.getText().toString()).equals("GMAIL")){
                        setWin();                     }
                    else{
                        Toast.makeText(GmailActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        cDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gUpBtn.getText().toString() == "") {
                    gUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                }
                if(gUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((gUpBtn.getText().toString()+mUpBtn.getText().toString()+aUpBtn.getText().toString()+iUpBtn.getText().toString() + lUpBtn.getText().toString()).equals("GMAIL")){
                        setWin();                     }
                    else{
                        Toast.makeText(GmailActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        qDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gUpBtn.getText().toString() == "") {
                    gUpBtn.setText("Q");
                    qDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("Q");
                    qDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("Q");
                    qDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("Q");
                    qDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("Q");
                    qDownBtn.setVisibility(View.INVISIBLE);
                }
                if(gUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((gUpBtn.getText().toString()+mUpBtn.getText().toString()+aUpBtn.getText().toString()+iUpBtn.getText().toString() + lUpBtn.getText().toString()).equals("GMAIL")){
                        setWin();                     }
                    else{
                        Toast.makeText(GmailActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        gDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gUpBtn.getText().toString() == "") {
                    gUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                }
                if(gUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((gUpBtn.getText().toString()+mUpBtn.getText().toString()+aUpBtn.getText().toString()+iUpBtn.getText().toString() + lUpBtn.getText().toString()).equals("GMAIL")){
                        setWin();                     }
                    else{
                        Toast.makeText(GmailActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        iDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gUpBtn.getText().toString() == "") {
                    gUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                }
                if(gUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((gUpBtn.getText().toString()+mUpBtn.getText().toString()+aUpBtn.getText().toString()+iUpBtn.getText().toString() + lUpBtn.getText().toString()).equals("GMAIL")){
                        setWin();                     }
                    else{
                        Toast.makeText(GmailActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
        gUpBtn = findViewById(R.id.gUp_btn);
        mUpBtn = findViewById(R.id.mUp_btn);
        aUpBtn = findViewById(R.id.aUp_btn);
        iUpBtn = findViewById(R.id.iUp_btn);
        lUpBtn = findViewById(R.id.lUp_btn);

        aDownBtn = findViewById(R.id.aDown_btn);
        mDownBtn = findViewById(R.id.mDown_btn);
        hDownBtn = findViewById(R.id.hDown_btn);
        lDownBtn = findViewById(R.id.lDown_btn);
        oDownBtn = findViewById(R.id.oDown_btn);
        uDownBtn = findViewById(R.id.uDown_btn);
        cDownBtn = findViewById(R.id.cDown_btn);
        qDownBtn = findViewById(R.id.qDown_btn);
        gDownBtn = findViewById(R.id.gDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);
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
                person.setScore(person.getArr()+10);            }
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
        gDownBtn.setVisibility(View.VISIBLE);
        mDownBtn.setVisibility(View.VISIBLE);
        aDownBtn.setVisibility(View.VISIBLE);
        iDownBtn.setVisibility(View.VISIBLE);
        lDownBtn.setVisibility(View.VISIBLE);
        gUpBtn.setEnabled(false);
        mUpBtn.setEnabled(false);
        aUpBtn.setEnabled(false);
        iUpBtn.setEnabled(false);
        lUpBtn.setEnabled(false);
        aDownBtn.setEnabled(false);
        mDownBtn.setEnabled(false);
        hDownBtn.setEnabled(false);
        lDownBtn.setEnabled(false);
        oDownBtn.setEnabled(false);
        uDownBtn.setEnabled(false);
        cDownBtn.setEnabled(false);
        qDownBtn.setEnabled(false);
        gDownBtn.setEnabled(false);
        iDownBtn.setEnabled(false);

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
                        Intent intant =new Intent(GmailActivity.this,LevelOneActivity.class);
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
