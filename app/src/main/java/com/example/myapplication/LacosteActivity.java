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

public class LacosteActivity extends AppCompatActivity {
    Person person;
    Button lUpBtn;
    Button aUpBtn;
    Button cUpBtn;
    Button oUpBtn;
    Button sUpBtn;
    Button tUpBtn;
    Button eUpBtn;
    Button oDownBtn;
    Button yDownBtn;
    Button tDownBtn;
    Button cDownBtn;
    Button eDownBtn;
    Button dDownBtn;
    Button lDownBtn;
    Button aDownBtn;
    Button nDownBtn;
    Button sDownBtn;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.main_page){
            Intent intent = new Intent(LacosteActivity.this, HomeActivity.class);
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(LacosteActivity.this, InstructionActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lacoste_main);

        lUpBtn = findViewById(R.id.lUp_btn);
        aUpBtn = findViewById(R.id.aUp_btn);
        cUpBtn = findViewById(R.id.cUp_btn);
        oUpBtn = findViewById(R.id.oUp_btn);
        sUpBtn = findViewById(R.id.sUp_btn);
        tUpBtn = findViewById(R.id.tUp_btn);
        eUpBtn = findViewById(R.id.eUp_btn);
        oDownBtn = findViewById(R.id.oDown_btn);
        yDownBtn = findViewById(R.id.yDown_btn);
        tDownBtn = findViewById(R.id.tDown_btn);
        cDownBtn = findViewById(R.id.cDown_btn);
        eDownBtn = findViewById(R.id.eDown_btn);
        dDownBtn = findViewById(R.id.dDown_btn);
        lDownBtn = findViewById(R.id.lDown_btn);
        aDownBtn = findViewById(R.id.aDown_btn);
        nDownBtn = findViewById(R.id.nDown_btn);
        sDownBtn = findViewById(R.id.sDown_btn);
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
                if (person.getArr()>=50) {
                    lUpBtn.setText("L");
                    aUpBtn.setText("A");
                    cUpBtn.setText("C");
                    oUpBtn.setText("O");
                    sUpBtn.setText("S");
                    tUpBtn.setText("T");
                    eUpBtn.setText("E");
                    lUpBtn.setEnabled(false);
                    aUpBtn.setEnabled(false);
                    cUpBtn.setEnabled(false);
                    oUpBtn.setEnabled(false);
                    sUpBtn.setEnabled(false);
                    tUpBtn.setEnabled(false);
                    eUpBtn.setEnabled(false);
                    oDownBtn.setEnabled(false);
                    yDownBtn.setEnabled(false);
                    tDownBtn.setEnabled(false);
                    cDownBtn.setEnabled(false);
                    eDownBtn.setEnabled(false);
                    dDownBtn.setEnabled(false);
                    lDownBtn.setEnabled(false);
                    aDownBtn.setEnabled(false);
                    nDownBtn.setEnabled(false);
                    sDownBtn.setEnabled(false);
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
                                    Intent intant = new Intent(LacosteActivity.this, LevelOneActivity.class);
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
                        Intent intent = new Intent(LacosteActivity.this, LevelOneActivity.class);
                        startActivity(intent);
                        Animatoo.animateSlideRight(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });
        lUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (lUpBtn.getText().toString() == "O") {
                    lUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "Y") {
                    lUpBtn.setText("");
                    yDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "T") {
                    lUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "C") {
                    lUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "E") {
                    lUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "D") {
                    lUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "L") {
                    lUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "A") {
                    lUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "N") {
                    lUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "S") {
                    lUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        aUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (aUpBtn.getText().toString() == "O") {
                    aUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "Y") {
                    aUpBtn.setText("");
                    yDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "T") {
                    aUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "C") {
                    aUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "E") {
                    aUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "D") {
                    aUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "L") {
                    aUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "A") {
                    aUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "N") {
                    aUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "S") {
                    aUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        cUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (cUpBtn.getText().toString() == "O") {
                    cUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "Y") {
                    cUpBtn.setText("");
                    yDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "T") {
                    cUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "C") {
                    cUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "E") {
                    cUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "D") {
                    cUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "L") {
                    cUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "A") {
                    cUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "N") {
                    cUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "S") {
                    cUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        oUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (oUpBtn.getText().toString() == "O") {
                    oUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "Y") {
                    oUpBtn.setText("");
                    yDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "T") {
                    oUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "C") {
                    oUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "E") {
                    oUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "D") {
                    oUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "L") {
                    oUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "A") {
                    oUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "N") {
                    oUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "S") {
                    oUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        sUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (sUpBtn.getText().toString() == "O") {
                    sUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "Y") {
                    sUpBtn.setText("");
                    yDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "T") {
                    sUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "C") {
                    sUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "E") {
                    sUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "D") {
                    sUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "L") {
                    sUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "A") {
                    sUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "N") {
                    sUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (sUpBtn.getText().toString() == "S") {
                    sUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        tUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (tUpBtn.getText().toString() == "O") {
                    tUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "Y") {
                    tUpBtn.setText("");
                    yDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "T") {
                    tUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "C") {
                    tUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "E") {
                    tUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "D") {
                    tUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "L") {
                    tUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "A") {
                    tUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "N") {
                    tUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "S") {
                    tUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        eUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (eUpBtn.getText().toString() == "O") {
                    eUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "Y") {
                    eUpBtn.setText("");
                    yDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "T") {
                    eUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "C") {
                    eUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "E") {
                    eUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "D") {
                    eUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "L") {
                    eUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "A") {
                    eUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "N") {
                    eUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "S") {
                    eUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        oDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                }
                if(lUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((lUpBtn.getText().toString()+aUpBtn.getText().toString()+cUpBtn.getText().toString()+oUpBtn.getText().toString()+sUpBtn.getText().toString()+tUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("LACOSTE")){
                        setWin();                    }
                    else{
                        Toast.makeText(LacosteActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        yDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("Y");
                    yDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("Y");
                    yDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("Y");
                    yDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("Y");
                    yDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("Y");
                    yDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("Y");
                    yDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("Y");
                    yDownBtn.setVisibility(View.INVISIBLE);
                }
                if(lUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((lUpBtn.getText().toString()+aUpBtn.getText().toString()+cUpBtn.getText().toString()+oUpBtn.getText().toString()+sUpBtn.getText().toString()+tUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("LACOSTE")){
                        setWin();                    }
                    else{
                        Toast.makeText(LacosteActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        tDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                }
                if(lUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((lUpBtn.getText().toString()+aUpBtn.getText().toString()+cUpBtn.getText().toString()+oUpBtn.getText().toString()+sUpBtn.getText().toString()+tUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("LACOSTE")){
                        setWin();                    }
                    else{
                        Toast.makeText(LacosteActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        cDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                }
                if(lUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((lUpBtn.getText().toString()+aUpBtn.getText().toString()+cUpBtn.getText().toString()+oUpBtn.getText().toString()+sUpBtn.getText().toString()+tUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("LACOSTE")){
                        setWin();                    }
                    else{
                        Toast.makeText(LacosteActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        eDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                }
                if(lUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((lUpBtn.getText().toString()+aUpBtn.getText().toString()+cUpBtn.getText().toString()+oUpBtn.getText().toString()+sUpBtn.getText().toString()+tUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("LACOSTE")){
                        setWin();                    }
                    else{
                        Toast.makeText(LacosteActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        dDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                }
                if(lUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((lUpBtn.getText().toString()+aUpBtn.getText().toString()+cUpBtn.getText().toString()+oUpBtn.getText().toString()+sUpBtn.getText().toString()+tUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("LACOSTE")){
                        setWin();                    }
                    else{
                        Toast.makeText(LacosteActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        lDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                }
                if(lUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((lUpBtn.getText().toString()+aUpBtn.getText().toString()+cUpBtn.getText().toString()+oUpBtn.getText().toString()+sUpBtn.getText().toString()+tUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("LACOSTE")){
                        setWin();                    }
                    else{
                        Toast.makeText(LacosteActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        aDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                }
                if(lUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((lUpBtn.getText().toString()+aUpBtn.getText().toString()+cUpBtn.getText().toString()+oUpBtn.getText().toString()+sUpBtn.getText().toString()+tUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("LACOSTE")){
                        setWin();                    }
                    else{
                        Toast.makeText(LacosteActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        nDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                }
                if(lUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((lUpBtn.getText().toString()+aUpBtn.getText().toString()+cUpBtn.getText().toString()+oUpBtn.getText().toString()+sUpBtn.getText().toString()+tUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("LACOSTE")){
                        setWin();                    }
                    else{
                        Toast.makeText(LacosteActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        sDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (sUpBtn.getText().toString() == "") {
                    sUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                }
                if(lUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && sUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((lUpBtn.getText().toString()+aUpBtn.getText().toString()+cUpBtn.getText().toString()+oUpBtn.getText().toString()+sUpBtn.getText().toString()+tUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("LACOSTE")){
                        setWin();                    }
                    else{
                        Toast.makeText(LacosteActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
        lUpBtn = findViewById(R.id.lUp_btn);
        aUpBtn = findViewById(R.id.aUp_btn);
        cUpBtn = findViewById(R.id.cUp_btn);
        oUpBtn = findViewById(R.id.oUp_btn);
        sUpBtn = findViewById(R.id.sUp_btn);
        tUpBtn = findViewById(R.id.tUp_btn);
        eUpBtn = findViewById(R.id.eUp_btn);
        oDownBtn = findViewById(R.id.oDown_btn);
        yDownBtn = findViewById(R.id.yDown_btn);
        tDownBtn = findViewById(R.id.tDown_btn);
        cDownBtn = findViewById(R.id.cDown_btn);
        eDownBtn = findViewById(R.id.eDown_btn);
        dDownBtn = findViewById(R.id.dDown_btn);
        lDownBtn = findViewById(R.id.lDown_btn);
        aDownBtn = findViewById(R.id.aDown_btn);
        nDownBtn = findViewById(R.id.nDown_btn);
        sDownBtn = findViewById(R.id.sDown_btn);
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
                person.setScore(person.getArr()+10);
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
        lDownBtn.setVisibility(View.VISIBLE);
        aDownBtn.setVisibility(View.VISIBLE);
        cDownBtn.setVisibility(View.VISIBLE);
        oDownBtn.setVisibility(View.VISIBLE);
        sDownBtn.setVisibility(View.VISIBLE);
        tDownBtn.setVisibility(View.VISIBLE);
        eDownBtn.setVisibility(View.VISIBLE);
        lUpBtn.setEnabled(false);
        aUpBtn.setEnabled(false);
        cUpBtn.setEnabled(false);
        oUpBtn.setEnabled(false);
        sUpBtn.setEnabled(false);
        tUpBtn.setEnabled(false);
        eUpBtn.setEnabled(false);
        oDownBtn.setEnabled(false);
        yDownBtn.setEnabled(false);
        tDownBtn.setEnabled(false);
        cDownBtn.setEnabled(false);
        eDownBtn.setEnabled(false);
        dDownBtn.setEnabled(false);
        lDownBtn.setEnabled(false);
        aDownBtn.setEnabled(false);
        nDownBtn.setEnabled(false);
        sDownBtn.setEnabled(false);
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
                        Intent intant =new Intent(LacosteActivity.this,LevelOneActivity.class);
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

