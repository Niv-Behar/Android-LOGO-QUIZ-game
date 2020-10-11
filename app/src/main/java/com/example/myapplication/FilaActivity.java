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

public class FilaActivity extends AppCompatActivity {
    Person person;
    Button fUpBtn;
    Button iUpBtn;
    Button lUpBtn;
    Button aUpBtn;
    Button lDownBtn;
    Button mDownBtn;
    Button iDownBtn;
    Button pDownBtn;
    Button zDownBtn;
    Button fDownBtn;
    Button sDownBtn;
    Button rDownBtn;
    Button aDownBtn;
    Button cDownBtn;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.main_page){
            Intent intent = new Intent(FilaActivity.this, HomeActivity.class);
            finish();
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(FilaActivity.this, InstructionActivity.class);
            finish();
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fila_main);

        fUpBtn = findViewById(R.id.fUp_btn);
        iUpBtn = findViewById(R.id.iUp_btn);
        lUpBtn = findViewById(R.id.lUp_btn);
        aUpBtn = findViewById(R.id.aHeyUp_btn);
        lDownBtn = findViewById(R.id.lDown_btn);
        mDownBtn = findViewById(R.id.mDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);
        pDownBtn = findViewById(R.id.pDown_btn);
        zDownBtn = findViewById(R.id.zDown_btn);
        fDownBtn = findViewById(R.id.fDown_btn);
        sDownBtn = findViewById(R.id.sDown_btn);
        rDownBtn = findViewById(R.id.rDown_btn);
        aDownBtn = findViewById(R.id.aDown_btn);
        cDownBtn = findViewById(R.id.cDown_btn);

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
                if (person.getArr()>=10) {
                    fUpBtn.setText("F");
                    iUpBtn.setText("I");
                    lUpBtn.setText("L");
                    aUpBtn.setText("A");
                    fUpBtn.setEnabled(false);
                    iUpBtn.setEnabled(false);
                    lUpBtn.setEnabled(false);
                    aUpBtn.setEnabled(false);
                    lDownBtn.setEnabled(false);
                    mDownBtn.setEnabled(false);
                    iDownBtn.setEnabled(false);
                    pDownBtn.setEnabled(false);
                    zDownBtn.setEnabled(false);
                    fDownBtn.setEnabled(false);
                    sDownBtn.setEnabled(false);
                    rDownBtn.setEnabled(false);
                    aDownBtn.setEnabled(false);
                    cDownBtn.setEnabled(false);
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
                                    Intent intant = new Intent(FilaActivity.this, LevelOneActivity.class);
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
                        Intent intent = new Intent(FilaActivity.this, LevelOneActivity.class);
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
                if (fUpBtn.getText().toString() == "L") {
                    fUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "M") {
                    fUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "I") {
                    fUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "P") {
                    fUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "Z") {
                    fUpBtn.setText("");
                    zDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "F") {
                    fUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "S") {
                    fUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "R") {
                    fUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "A") {
                    fUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "C") {
                    fUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        iUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'i' btn
            @Override
            public void onClick(View view) {
                if (iUpBtn.getText().toString() == "L") {
                    iUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "M") {
                    iUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "I") {
                    iUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "P") {
                    iUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "Z") {
                    iUpBtn.setText("");
                    zDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "F") {
                    iUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "S") {
                    iUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "R") {
                    iUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "A") {
                    iUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "C") {
                    iUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        lUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'l' btn
            @Override
            public void onClick(View view) {
                if (lUpBtn.getText().toString() == "L") {
                    lUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "M") {
                    lUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "I") {
                    lUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "P") {
                    lUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "Z") {
                    lUpBtn.setText("");
                    zDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "F") {
                    lUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "S") {
                    lUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "R") {
                    lUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "A") {
                    lUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "C") {
                    lUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        aUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'a_hey' btn
            @Override
            public void onClick(View view) {
                if (aUpBtn.getText().toString() == "L") {
                    aUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "M") {
                    aUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "I") {
                    aUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "P") {
                    aUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "Z") {
                    aUpBtn.setText("");
                    zDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "F") {
                    aUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "S") {
                    aUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "R") {
                    aUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "A") {
                    aUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "C") {
                    aUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        lDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+iUpBtn.getText().toString()+lUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("FILA")){
                        setWin();                     }
                    else{
                        Toast.makeText(FilaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+iUpBtn.getText().toString()+lUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("FILA")){
                        setWin();                     }
                    else{
                        Toast.makeText(FilaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+iUpBtn.getText().toString()+lUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("FILA")){
                        setWin();                     }
                    else{
                        Toast.makeText(FilaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        pDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+iUpBtn.getText().toString()+lUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("FILA")){
                        setWin();                     }
                    else{
                        Toast.makeText(FilaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("Z");
                    zDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("Z");
                    zDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("Z");
                    zDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+iUpBtn.getText().toString()+lUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("FILA")){
                        setWin();                     }
                    else{
                        Toast.makeText(FilaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        fDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+iUpBtn.getText().toString()+lUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("FILA")){
                        setWin();                     }
                    else{
                        Toast.makeText(FilaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+iUpBtn.getText().toString()+lUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("FILA")){
                        setWin();                     }
                    else{
                        Toast.makeText(FilaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+iUpBtn.getText().toString()+lUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("FILA")){
                        setWin();                     }
                    else{
                        Toast.makeText(FilaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        aDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+iUpBtn.getText().toString()+lUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("FILA")){
                        setWin();                     }
                    else{
                        Toast.makeText(FilaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        cDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+iUpBtn.getText().toString()+lUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("FILA")){
                        setWin();                     }
                    else{
                        Toast.makeText(FilaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
        iUpBtn = findViewById(R.id.iUp_btn);
        lUpBtn = findViewById(R.id.lUp_btn);
        aUpBtn = findViewById(R.id.aHeyUp_btn);
        lDownBtn = findViewById(R.id.lDown_btn);
        mDownBtn = findViewById(R.id.mDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);
        pDownBtn = findViewById(R.id.pDown_btn);
        zDownBtn = findViewById(R.id.zDown_btn);
        fDownBtn = findViewById(R.id.fDown_btn);
        sDownBtn = findViewById(R.id.sDown_btn);
        rDownBtn = findViewById(R.id.rDown_btn);
        aDownBtn = findViewById(R.id.aDown_btn);
        cDownBtn = findViewById(R.id.cDown_btn);
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
                person.setScore(10);            }
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
         iDownBtn.setVisibility(View.VISIBLE);
         lDownBtn.setVisibility(View.VISIBLE);
         aDownBtn.setVisibility(View.VISIBLE);
        fUpBtn.setEnabled(false);
        iUpBtn.setEnabled(false);
        lUpBtn.setEnabled(false);
        aUpBtn.setEnabled(false);
        lDownBtn.setEnabled(false);
        mDownBtn.setEnabled(false);
        iDownBtn.setEnabled(false);
        pDownBtn.setEnabled(false);
        zDownBtn.setEnabled(false);
        fDownBtn.setEnabled(false);
        sDownBtn.setEnabled(false);
        rDownBtn.setEnabled(false);
        aDownBtn.setEnabled(false);
        cDownBtn.setEnabled(false);

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
                        Intent intant =new Intent(FilaActivity.this,LevelOneActivity.class);
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

