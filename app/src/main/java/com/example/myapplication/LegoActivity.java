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

public class LegoActivity extends AppCompatActivity {
    Person person;
    Button lUpBtn;
    Button eUpBtn;
    Button gUpBtn;
    Button oUpBtn;
    Button dDownBtn;
    Button lDownBtn;
    Button hDownBtn;
    Button bDownBtn;
    Button eDownBtn;
    Button sDownBtn;
    Button gDownBtn;
    Button wDownBtn;
    Button oDownBtn;
    Button uDownBtn;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.main_page){
            Intent intent = new Intent(LegoActivity.this, HomeActivity.class);
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(LegoActivity.this, InstructionActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lego_main);

        lUpBtn = findViewById(R.id.lUp_btn);
        eUpBtn = findViewById(R.id.eUp_btn);
        gUpBtn = findViewById(R.id.gUp_btn);
        oUpBtn = findViewById(R.id.oUp_btn);
        dDownBtn = findViewById(R.id.dDown_btn);
        lDownBtn = findViewById(R.id.lDown_btn);
        hDownBtn = findViewById(R.id.hDown_btn);
        bDownBtn = findViewById(R.id.bDown_btn);
        eDownBtn = findViewById(R.id.eDown_btn);
        sDownBtn = findViewById(R.id.sDown_btn);
        gDownBtn = findViewById(R.id.gDown_btn);
        wDownBtn = findViewById(R.id.wDown_btn);
        oDownBtn = findViewById(R.id.oDown_btn);
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
                if (person.getArr1()>=10) {
                    lUpBtn.setText("L");
                    eUpBtn.setText("E");
                    gUpBtn.setText("G");
                    oUpBtn.setText("O");
                    lUpBtn.setEnabled(false);
                    eUpBtn.setEnabled(false);
                    gUpBtn.setEnabled(false);
                    oUpBtn.setEnabled(false);
                    dDownBtn.setEnabled(false);
                    lDownBtn.setEnabled(false);
                    hDownBtn.setEnabled(false);
                    bDownBtn.setEnabled(false);
                    eDownBtn.setEnabled(false);
                    sDownBtn.setEnabled(false);
                    gDownBtn.setEnabled(false);
                    wDownBtn.setEnabled(false);
                    oDownBtn.setEnabled(false);
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
                                    Intent intant = new Intent(LegoActivity.this, LevelTwoActivity.class);
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
                        Intent intent = new Intent(LegoActivity.this, LevelTwoActivity.class);
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
                if (lUpBtn.getText().toString() == "D") {
                    lUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "L") {
                    lUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "H") {
                    lUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "B") {
                    lUpBtn.setText("");
                    bDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "E") {
                    lUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "S") {
                    lUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "G") {
                    lUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "W") {
                    lUpBtn.setText("");
                    wDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "O") {
                    lUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "U") {
                    lUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        eUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (eUpBtn.getText().toString() == "D") {
                    eUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "L") {
                    eUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "H") {
                    eUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "B") {
                    eUpBtn.setText("");
                    bDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "E") {
                    eUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "S") {
                    eUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "G") {
                    eUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "W") {
                    eUpBtn.setText("");
                    wDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "O") {
                    eUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "U") {
                    eUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        gUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (gUpBtn.getText().toString() == "D") {
                    gUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (gUpBtn.getText().toString() == "L") {
                    gUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (gUpBtn.getText().toString() == "H") {
                    gUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (gUpBtn.getText().toString() == "B") {
                    gUpBtn.setText("");
                    bDownBtn.setVisibility(View.VISIBLE);
                } else if (gUpBtn.getText().toString() == "E") {
                    gUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (gUpBtn.getText().toString() == "S") {
                    gUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (gUpBtn.getText().toString() == "G") {
                    gUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (gUpBtn.getText().toString() == "W") {
                    gUpBtn.setText("");
                    wDownBtn.setVisibility(View.VISIBLE);
                } else if (gUpBtn.getText().toString() == "O") {
                    gUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (gUpBtn.getText().toString() == "U") {
                    gUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        oUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (oUpBtn.getText().toString() == "D") {
                    oUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "L") {
                    oUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "H") {
                    oUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "B") {
                    oUpBtn.setText("");
                    bDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "E") {
                    oUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "S") {
                    oUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "G") {
                    oUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "W") {
                    oUpBtn.setText("");
                    wDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "O") {
                    oUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "U") {
                    oUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        dDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (gUpBtn.getText().toString() == "") {
                    gUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                }
                if(lUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && gUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != ""){
                    if((lUpBtn.getText().toString()+eUpBtn.getText().toString()+gUpBtn.getText().toString()+oUpBtn.getText().toString()).equals("LEGO")){
                        setWin();                    }
                    else{
                        Toast.makeText(LegoActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (gUpBtn.getText().toString() == "") {
                    gUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                }
                if(lUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && gUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != ""){
                    if((lUpBtn.getText().toString()+eUpBtn.getText().toString()+gUpBtn.getText().toString()+oUpBtn.getText().toString()).equals("LEGO")){
                        setWin();                    }
                    else{
                        Toast.makeText(LegoActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        hDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (gUpBtn.getText().toString() == "") {
                    gUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                }
                if(lUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && gUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != ""){
                    if((lUpBtn.getText().toString()+eUpBtn.getText().toString()+gUpBtn.getText().toString()+oUpBtn.getText().toString()).equals("LEGO")){
                        setWin();                    }
                    else{
                        Toast.makeText(LegoActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        bDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("B");
                    bDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("B");
                    bDownBtn.setVisibility(View.INVISIBLE);
                } else if (gUpBtn.getText().toString() == "") {
                    gUpBtn.setText("B");
                    bDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("B");
                    bDownBtn.setVisibility(View.INVISIBLE);
                }
                if(lUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && gUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != ""){
                    if((lUpBtn.getText().toString()+eUpBtn.getText().toString()+gUpBtn.getText().toString()+oUpBtn.getText().toString()).equals("LEGO")){
                        setWin();                    }
                    else{
                        Toast.makeText(LegoActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (gUpBtn.getText().toString() == "") {
                    gUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                }
                if(lUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && gUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != ""){
                    if((lUpBtn.getText().toString()+eUpBtn.getText().toString()+gUpBtn.getText().toString()+oUpBtn.getText().toString()).equals("LEGO")){
                        setWin();                    }
                    else{
                        Toast.makeText(LegoActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (gUpBtn.getText().toString() == "") {
                    gUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                }
                if(lUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && gUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != ""){
                    if((lUpBtn.getText().toString()+eUpBtn.getText().toString()+gUpBtn.getText().toString()+oUpBtn.getText().toString()).equals("LEGO")){
                        setWin();                    }
                    else{
                        Toast.makeText(LegoActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        gDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                } else if (gUpBtn.getText().toString() == "") {
                    gUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                }
                if(lUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && gUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != ""){
                    if((lUpBtn.getText().toString()+eUpBtn.getText().toString()+gUpBtn.getText().toString()+oUpBtn.getText().toString()).equals("LEGO")){
                        setWin();                    }
                    else{
                        Toast.makeText(LegoActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        wDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("W");
                    wDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("W");
                    wDownBtn.setVisibility(View.INVISIBLE);
                } else if (gUpBtn.getText().toString() == "") {
                    gUpBtn.setText("W");
                    wDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("W");
                    wDownBtn.setVisibility(View.INVISIBLE);
                }
                if(lUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && gUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != ""){
                    if((lUpBtn.getText().toString()+eUpBtn.getText().toString()+gUpBtn.getText().toString()+oUpBtn.getText().toString()).equals("LEGO")){
                        setWin();                    }
                    else{
                        Toast.makeText(LegoActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        oDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (gUpBtn.getText().toString() == "") {
                    gUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                }
                if(lUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && gUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != ""){
                    if((lUpBtn.getText().toString()+eUpBtn.getText().toString()+gUpBtn.getText().toString()+oUpBtn.getText().toString()).equals("LEGO")){
                        setWin();                    }
                    else{
                        Toast.makeText(LegoActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        uDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                } else if (gUpBtn.getText().toString() == "") {
                    gUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                }
                if(lUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && gUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != ""){
                    if((lUpBtn.getText().toString()+eUpBtn.getText().toString()+gUpBtn.getText().toString()+oUpBtn.getText().toString()).equals("LEGO")){
                        setWin();                    }
                    else{
                        Toast.makeText(LegoActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
        eUpBtn = findViewById(R.id.eUp_btn);
        gUpBtn = findViewById(R.id.gUp_btn);
        oUpBtn = findViewById(R.id.oUp_btn);
        dDownBtn = findViewById(R.id.dDown_btn);
        lDownBtn = findViewById(R.id.lDown_btn);
        hDownBtn = findViewById(R.id.hDown_btn);
        bDownBtn = findViewById(R.id.bDown_btn);
        eDownBtn = findViewById(R.id.eDown_btn);
        sDownBtn = findViewById(R.id.sDown_btn);
        gDownBtn = findViewById(R.id.gDown_btn);
        wDownBtn = findViewById(R.id.wDown_btn);
        oDownBtn = findViewById(R.id.oDown_btn);
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
        lDownBtn.setVisibility(View.VISIBLE);
        eDownBtn.setVisibility(View.VISIBLE);
        gDownBtn.setVisibility(View.VISIBLE);
        oDownBtn.setVisibility(View.VISIBLE);
        lUpBtn.setEnabled(false);
        eUpBtn.setEnabled(false);
        gUpBtn.setEnabled(false);
        oUpBtn.setEnabled(false);
        dDownBtn.setEnabled(false);
        lDownBtn.setEnabled(false);
        hDownBtn.setEnabled(false);
        bDownBtn.setEnabled(false);
        eDownBtn.setEnabled(false);
        sDownBtn.setEnabled(false);
        gDownBtn.setEnabled(false);
        wDownBtn.setEnabled(false);
        oDownBtn.setEnabled(false);
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
                        Intent intant =new Intent(LegoActivity.this,LevelTwoActivity.class);
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
