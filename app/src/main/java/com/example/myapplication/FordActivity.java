package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
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

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class FordActivity extends AppCompatActivity {
    Person person;
    Button fUpBtn;
    Button oUpBtn;
    Button rUpBtn;
    Button dUpBtn;
    Button fDownBtn;
    Button nDownBtn;
    Button iDownBtn;
    Button sDownBtn;
    Button zDownBtn;
    Button dDownBtn;
    Button gDownBtn;
    Button mDownBtn;
    Button oDownBtn;
    Button rDownBtn;
    Animation setAnim;
    TextView finish;
    KonfettiView viewKonfetti;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.main_page){
            Intent intent = new Intent(FordActivity.this, HomeActivity.class);
            finish();
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(FordActivity.this, InstructionActivity.class);
            finish();
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ford_main);

        fUpBtn = findViewById(R.id.fUp_btn);
        oUpBtn = findViewById(R.id.oUp_btn);
        rUpBtn = findViewById(R.id.rUp_btn);
        dUpBtn = findViewById(R.id.dUp_btn);
        fDownBtn = findViewById(R.id.fDown_btn);
        nDownBtn = findViewById(R.id.nDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);
        sDownBtn = findViewById(R.id.sDown_btn);
        zDownBtn = findViewById(R.id.zDown_btn);
        dDownBtn = findViewById(R.id.dDown_btn);
        gDownBtn = findViewById(R.id.gDown_btn);
        mDownBtn = findViewById(R.id.mDown_btn);
        oDownBtn = findViewById(R.id.oDown_btn);
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
                if (person.getArr2()>=110) {
                    fUpBtn.setText("F");
                    oUpBtn.setText("O");
                    rUpBtn.setText("R");
                    dUpBtn.setText("D");
                    fUpBtn.setEnabled(false);
                    oUpBtn.setEnabled(false);
                    rUpBtn.setEnabled(false);
                    dUpBtn.setEnabled(false);
                    fDownBtn.setEnabled(false);
                    nDownBtn.setEnabled(false);
                    iDownBtn.setEnabled(false);
                    sDownBtn.setEnabled(false);
                    zDownBtn.setEnabled(false);
                    dDownBtn.setEnabled(false);
                    gDownBtn.setEnabled(false);
                    mDownBtn.setEnabled(false);
                    oDownBtn.setEnabled(false);
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
                                    Intent intant = new Intent(FordActivity.this, LevelThreeActivity.class);
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
                        Intent intent = new Intent(FordActivity.this, LevelThreeActivity.class);
                        startActivity(intent);
                        Animatoo.animateSlideRight(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });
        fUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "F") {
                    fUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "N") {
                    fUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "I") {
                    fUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "S") {
                    fUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "Z") {
                    fUpBtn.setText("");
                    zDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "D") {
                    fUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "G") {
                    fUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "M") {
                    fUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "O") {
                    fUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "R") {
                    fUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        oUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (oUpBtn.getText().toString() == "F") {
                    oUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "N") {
                    oUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "I") {
                    oUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "S") {
                    oUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "Z") {
                    oUpBtn.setText("");
                    zDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "D") {
                    oUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "G") {
                    oUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "M") {
                    oUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "O") {
                    oUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "R") {
                    oUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        rUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (rUpBtn.getText().toString() == "F") {
                    rUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
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
                } else if (rUpBtn.getText().toString() == "D") {
                    rUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "G") {
                    rUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "M") {
                    rUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "O") {
                    rUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "R") {
                    rUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        dUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (dUpBtn.getText().toString() == "F") {
                    dUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "N") {
                    dUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "I") {
                    dUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "S") {
                    dUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "Z") {
                    dUpBtn.setText("");
                    zDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "D") {
                    dUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "G") {
                    dUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "M") {
                    dUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "O") {
                    dUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "R") {
                    dUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        fDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+oUpBtn.getText().toString()+rUpBtn.getText().toString()+dUpBtn.getText().toString()).equals("FORD")){
                        setWin();                    }
                    else{
                        Toast.makeText(FordActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        nDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+oUpBtn.getText().toString()+rUpBtn.getText().toString()+dUpBtn.getText().toString()).equals("FORD")){
                        setWin();                    }
                    else{
                        Toast.makeText(FordActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        iDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+oUpBtn.getText().toString()+rUpBtn.getText().toString()+dUpBtn.getText().toString()).equals("FORD")){
                        setWin();                    }
                    else{
                        Toast.makeText(FordActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        sDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+oUpBtn.getText().toString()+rUpBtn.getText().toString()+dUpBtn.getText().toString()).equals("FORD")){
                        setWin();                    }
                    else{
                        Toast.makeText(FordActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        zDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("Z");
                    zDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("Z");
                    zDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("Z");
                    zDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("Z");
                    zDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+oUpBtn.getText().toString()+rUpBtn.getText().toString()+dUpBtn.getText().toString()).equals("FORD")){
                        setWin();                    }
                    else{
                        Toast.makeText(FordActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        dDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+oUpBtn.getText().toString()+rUpBtn.getText().toString()+dUpBtn.getText().toString()).equals("FORD")){
                        setWin();                    }
                    else{
                        Toast.makeText(FordActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        gDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+oUpBtn.getText().toString()+rUpBtn.getText().toString()+dUpBtn.getText().toString()).equals("FORD")){
                        setWin();                    }
                    else{
                        Toast.makeText(FordActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        mDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+oUpBtn.getText().toString()+rUpBtn.getText().toString()+dUpBtn.getText().toString()).equals("FORD")){
                        setWin();                    }
                    else{
                        Toast.makeText(FordActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        oDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+oUpBtn.getText().toString()+rUpBtn.getText().toString()+dUpBtn.getText().toString()).equals("FORD")){
                        setWin();                    }
                    else{
                        Toast.makeText(FordActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        rDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+oUpBtn.getText().toString()+rUpBtn.getText().toString()+dUpBtn.getText().toString()).equals("FORD")){
                        setWin();                    }
                    else{
                        Toast.makeText(FordActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
        fUpBtn = findViewById(R.id.fUp_btn);
        oUpBtn = findViewById(R.id.oUp_btn);
        rUpBtn = findViewById(R.id.rUp_btn);
        dUpBtn = findViewById(R.id.dUp_btn);
        fDownBtn = findViewById(R.id.fDown_btn);
        nDownBtn = findViewById(R.id.nDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);
        sDownBtn = findViewById(R.id.sDown_btn);
        zDownBtn = findViewById(R.id.zDown_btn);
        dDownBtn = findViewById(R.id.dDown_btn);
        gDownBtn = findViewById(R.id.gDown_btn);
        mDownBtn = findViewById(R.id.mDown_btn);
        oDownBtn = findViewById(R.id.oDown_btn);
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
                person.setScore2(person.getArr2()+30);            }
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
        fDownBtn.setVisibility(View.VISIBLE);
        oDownBtn.setVisibility(View.VISIBLE);
        rDownBtn.setVisibility(View.VISIBLE);
        dDownBtn.setVisibility(View.VISIBLE);
        fUpBtn.setEnabled(false);
        oUpBtn.setEnabled(false);
        rUpBtn.setEnabled(false);
        dUpBtn.setEnabled(false);
        fDownBtn.setEnabled(false);
        nDownBtn.setEnabled(false);
        iDownBtn.setEnabled(false);
        sDownBtn.setEnabled(false);
        zDownBtn.setEnabled(false);
        dDownBtn.setEnabled(false);
        gDownBtn.setEnabled(false);
        mDownBtn.setEnabled(false);
        oDownBtn.setEnabled(false);
        rDownBtn.setEnabled(false);

        finish = findViewById(R.id.finish_game_tv);
        setAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);
        finish.setVisibility(View.VISIBLE);
        finish.setAnimation(setAnim);
        viewKonfetti = findViewById(R.id.viewKonfetti);
        viewKonfetti.build()
                .addColors(Color.rgb(255, 165, 0), Color.GREEN, Color.MAGENTA)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 5f)
                .setFadeOutEnabled(true)
                .setTimeToLive(2000L)
                .addShapes(Shape.Square.INSTANCE, Shape.Circle.INSTANCE)
                .addSizes(new Size(12, 5))
                .setPosition(-50f, viewKonfetti.getWidth() + 50f, -50f, -50f)
                .streamFor(300, 5000L);
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
                        Intent intant =new Intent(FordActivity.this,LevelThreeActivity.class);
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
