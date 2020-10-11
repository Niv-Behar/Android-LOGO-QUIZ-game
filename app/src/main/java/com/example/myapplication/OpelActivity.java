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

public class OpelActivity extends AppCompatActivity {
    Person person;
    Button oUpBtn;
    Button pUpBtn;
    Button eUpBtn;
    Button lUpBtn;
    Button rDownBtn;
    Button oDownBtn;
    Button hDownBtn;
    Button bDownBtn;
    Button lDownBtn;
    Button pDownBtn;
    Button jDownBtn;
    Button mDownBtn;
    Button eDownBtn;
    Button uDownBtn;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.main_page){
            Intent intent = new Intent(OpelActivity.this, HomeActivity.class);
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(OpelActivity.this, InstructionActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opel_main);

        oUpBtn = findViewById(R.id.oUp_btn);
        pUpBtn = findViewById(R.id.pUp_btn);
        eUpBtn = findViewById(R.id.eUp_btn);
        lUpBtn = findViewById(R.id.lUp_btn);
        rDownBtn = findViewById(R.id.rDown_btn);
        oDownBtn = findViewById(R.id.oDown_btn);
        hDownBtn = findViewById(R.id.hDown_btn);
        bDownBtn = findViewById(R.id.bDown_btn);
        lDownBtn = findViewById(R.id.lDown_btn);
        pDownBtn = findViewById(R.id.pDown_btn);
        jDownBtn = findViewById(R.id.jDown_btn);
        mDownBtn = findViewById(R.id.mDown_btn);
        eDownBtn = findViewById(R.id.eDown_btn);
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
                if (person.getArr2()>=80) {
                    oUpBtn.setText("O");
                    pUpBtn.setText("P");
                    eUpBtn.setText("E");
                    lUpBtn.setText("L");
                    oUpBtn.setEnabled(false);
                    pUpBtn.setEnabled(false);
                    eUpBtn.setEnabled(false);
                    lUpBtn.setEnabled(false);
                    rDownBtn.setEnabled(false);
                    oDownBtn.setEnabled(false);
                    hDownBtn.setEnabled(false);
                    bDownBtn.setEnabled(false);
                    lDownBtn.setEnabled(false);
                    pDownBtn.setEnabled(false);
                    jDownBtn.setEnabled(false);
                    mDownBtn.setEnabled(false);
                    eDownBtn.setEnabled(false);
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
                                    Intent intant = new Intent(OpelActivity.this, LevelTwoActivity.class);
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
                        Intent intent = new Intent(OpelActivity.this, LevelTwoActivity.class);
                        startActivity(intent);
                        Animatoo.animateSlideRight(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });
        oUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (oUpBtn.getText().toString() == "R") {
                    oUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "O") {
                    oUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "H") {
                    oUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "B") {
                    oUpBtn.setText("");
                    bDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "L") {
                    oUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "P") {
                    oUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "J") {
                    oUpBtn.setText("");
                    jDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "M") {
                    oUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "E") {
                    oUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "U") {
                    oUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        pUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (pUpBtn.getText().toString() == "R") {
                    pUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "O") {
                    pUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "H") {
                    pUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "B") {
                    pUpBtn.setText("");
                    bDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "L") {
                    pUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "P") {
                    pUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "J") {
                    pUpBtn.setText("");
                    jDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "M") {
                    pUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "E") {
                    pUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (pUpBtn.getText().toString() == "U") {
                    pUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        eUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (eUpBtn.getText().toString() == "R") {
                    eUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "O") {
                    eUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "H") {
                    eUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "B") {
                    eUpBtn.setText("");
                    bDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "L") {
                    eUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "P") {
                    eUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "J") {
                    eUpBtn.setText("");
                    jDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "M") {
                    eUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "E") {
                    eUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "U") {
                    eUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        lUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (lUpBtn.getText().toString() == "R") {
                    lUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "O") {
                    lUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "H") {
                    lUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "B") {
                    lUpBtn.setText("");
                    bDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "L") {
                    lUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "P") {
                    lUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "J") {
                    lUpBtn.setText("");
                    jDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "M") {
                    lUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "E") {
                    lUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "U") {
                    lUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        rDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                }
                if(oUpBtn.getText().toString() != "" && pUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((oUpBtn.getText().toString()+pUpBtn.getText().toString()+eUpBtn.getText().toString()+lUpBtn.getText().toString()).equals("OPEL")){
                        setWin();                     }
                    else{
                        Toast.makeText(OpelActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        oDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                }
                if(oUpBtn.getText().toString() != "" && pUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((oUpBtn.getText().toString()+pUpBtn.getText().toString()+eUpBtn.getText().toString()+lUpBtn.getText().toString()).equals("OPEL")){
                        setWin();                     }
                    else{
                        Toast.makeText(OpelActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        hDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                }
                if(oUpBtn.getText().toString() != "" && pUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((oUpBtn.getText().toString()+pUpBtn.getText().toString()+eUpBtn.getText().toString()+lUpBtn.getText().toString()).equals("OPEL")){
                        setWin();                     }
                    else{
                        Toast.makeText(OpelActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        bDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("B");
                    bDownBtn.setVisibility(View.INVISIBLE);
                } else if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("B");
                    bDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("B");
                    bDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("B");
                    bDownBtn.setVisibility(View.INVISIBLE);
                }
                if(oUpBtn.getText().toString() != "" && pUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((oUpBtn.getText().toString()+pUpBtn.getText().toString()+eUpBtn.getText().toString()+lUpBtn.getText().toString()).equals("OPEL")){
                        setWin();                     }
                    else{
                        Toast.makeText(OpelActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        lDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                }
                if(oUpBtn.getText().toString() != "" && pUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((oUpBtn.getText().toString()+pUpBtn.getText().toString()+eUpBtn.getText().toString()+lUpBtn.getText().toString()).equals("OPEL")){
                        setWin();                     }
                    else{
                        Toast.makeText(OpelActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        pDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                } else if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                }
                if(oUpBtn.getText().toString() != "" && pUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((oUpBtn.getText().toString()+pUpBtn.getText().toString()+eUpBtn.getText().toString()+lUpBtn.getText().toString()).equals("OPEL")){
                        setWin();                     }
                    else{
                        Toast.makeText(OpelActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        jDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("J");
                    jDownBtn.setVisibility(View.INVISIBLE);
                } else if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("J");
                    jDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("J");
                    jDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("J");
                    jDownBtn.setVisibility(View.INVISIBLE);
                }
                if(oUpBtn.getText().toString() != "" && pUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((oUpBtn.getText().toString()+pUpBtn.getText().toString()+eUpBtn.getText().toString()+lUpBtn.getText().toString()).equals("OPEL")){
                        setWin();                     }
                    else{
                        Toast.makeText(OpelActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        mDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                }
                if(oUpBtn.getText().toString() != "" && pUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((oUpBtn.getText().toString()+pUpBtn.getText().toString()+eUpBtn.getText().toString()+lUpBtn.getText().toString()).equals("OPEL")){
                        setWin();                     }
                    else{
                        Toast.makeText(OpelActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        eDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                }
                if(oUpBtn.getText().toString() != "" && pUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((oUpBtn.getText().toString()+pUpBtn.getText().toString()+eUpBtn.getText().toString()+lUpBtn.getText().toString()).equals("OPEL")){
                        setWin();                     }
                    else{
                        Toast.makeText(OpelActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        uDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                } else if (pUpBtn.getText().toString() == "") {
                    pUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                }
                if(oUpBtn.getText().toString() != "" && pUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((oUpBtn.getText().toString()+pUpBtn.getText().toString()+eUpBtn.getText().toString()+lUpBtn.getText().toString()).equals("OPEL")){
                        setWin();                     }
                    else{
                        Toast.makeText(OpelActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
        oUpBtn = findViewById(R.id.oUp_btn);
        pUpBtn = findViewById(R.id.pUp_btn);
        eUpBtn = findViewById(R.id.eUp_btn);
        lUpBtn = findViewById(R.id.lUp_btn);
        rDownBtn = findViewById(R.id.rDown_btn);
        oDownBtn = findViewById(R.id.oDown_btn);
        hDownBtn = findViewById(R.id.hDown_btn);
        bDownBtn = findViewById(R.id.bDown_btn);
        lDownBtn = findViewById(R.id.lDown_btn);
        pDownBtn = findViewById(R.id.pDown_btn);
        jDownBtn = findViewById(R.id.jDown_btn);
        mDownBtn = findViewById(R.id.mDown_btn);
        eDownBtn = findViewById(R.id.eDown_btn);
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
                person.setScore1(person.getArr1()+20);
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
        oDownBtn.setVisibility(View.VISIBLE);
        pDownBtn.setVisibility(View.VISIBLE);
        eDownBtn.setVisibility(View.VISIBLE);
        lDownBtn.setVisibility(View.VISIBLE);
        oUpBtn.setEnabled(false);
        pUpBtn.setEnabled(false);
        eUpBtn.setEnabled(false);
        lUpBtn.setEnabled(false);
        rDownBtn.setEnabled(false);
        oDownBtn.setEnabled(false);
        hDownBtn.setEnabled(false);
        bDownBtn.setEnabled(false);
        lDownBtn.setEnabled(false);
        pDownBtn.setEnabled(false);
        jDownBtn.setEnabled(false);
        mDownBtn.setEnabled(false);
        eDownBtn.setEnabled(false);
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
                        Intent intant =new Intent(OpelActivity.this,LevelTwoActivity.class);
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
