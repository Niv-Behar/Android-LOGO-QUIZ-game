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

public class NetflixActivity extends AppCompatActivity {
    Person person;
    Button nUpBtn;
    Button eUpBtn;
    Button tUpBtn;
    Button fUpBtn;
    Button lUpBtn;
    Button iUpBtn;
    Button xUpBtn;
    Button nDownBtn;
    Button aDownBtn;
    Button tDownBtn;
    Button iDownBtn;
    Button eDownBtn;
    Button lDownBtn;
    Button hDownBtn;
    Button fDownBtn;
    Button rDownBtn;
    Button xDownBtn;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.main_page){
            Intent intent = new Intent(NetflixActivity.this, HomeActivity.class);
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(NetflixActivity.this, InstructionActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.netflix_main);


        nUpBtn = findViewById(R.id.nUp_btn);
        eUpBtn = findViewById(R.id.eUp_btn);
        tUpBtn = findViewById(R.id.tUp_btn);
        fUpBtn = findViewById(R.id.fUp_btn);
        lUpBtn = findViewById(R.id.lUp_btn);
        iUpBtn = findViewById(R.id.iUp_btn);
        xUpBtn = findViewById(R.id.xUp_btn);
        nDownBtn = findViewById(R.id.nDown_btn);
        aDownBtn = findViewById(R.id.aDown_btn);
        tDownBtn = findViewById(R.id.tDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);
        eDownBtn = findViewById(R.id.eDown_btn);
        lDownBtn = findViewById(R.id.lDown_btn);
        hDownBtn = findViewById(R.id.hDown_btn);
        fDownBtn = findViewById(R.id.fDown_btn);
        rDownBtn = findViewById(R.id.rDown_btn);
        xDownBtn = findViewById(R.id.xDown_btn);
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
                if (person.getArr2()>=50) {
                    nUpBtn.setText("N");
                    eUpBtn.setText("E");
                    tUpBtn.setText("T");
                    fUpBtn.setText("F");
                    lUpBtn.setText("L");
                    iUpBtn.setText("I");
                    xUpBtn.setText("X");
                    nUpBtn.setEnabled(false);
                    eUpBtn.setEnabled(false);
                    tUpBtn.setEnabled(false);
                    fUpBtn.setEnabled(false);
                    lUpBtn.setEnabled(false);
                    iUpBtn.setEnabled(false);
                    xUpBtn.setEnabled(false);
                    eDownBtn.setEnabled(false);
                    nDownBtn.setEnabled(false);
                    aDownBtn.setEnabled(false);
                    tDownBtn.setEnabled(false);
                    iDownBtn.setEnabled(false);
                    eDownBtn.setEnabled(false);
                    lDownBtn.setEnabled(false);
                    hDownBtn.setEnabled(false);
                    fDownBtn.setEnabled(false);
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
                                    Intent intant = new Intent(NetflixActivity.this, LevelTwoActivity.class);
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
                        Intent intent = new Intent(NetflixActivity.this, LevelTwoActivity.class);
                        startActivity(intent);
                        Animatoo.animateSlideRight(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });
        nUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "N") {
                    nUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "A") {
                    nUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "T") {
                    nUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "I") {
                    nUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "E") {
                    nUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "L") {
                    nUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "H") {
                    nUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "F") {
                    nUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "R") {
                    nUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "X") {
                    nUpBtn.setText("");
                    xDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        eUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (eUpBtn.getText().toString() == "N") {
                    eUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "A") {
                    eUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "T") {
                    eUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "I") {
                    eUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "E") {
                    eUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "L") {
                    eUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "H") {
                    eUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "F") {
                    eUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "R") {
                    eUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "X") {
                    eUpBtn.setText("");
                    xDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        tUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (tUpBtn.getText().toString() == "N") {
                    tUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "A") {
                    tUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "T") {
                    tUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "I") {
                    tUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "E") {
                    tUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "L") {
                    tUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "H") {
                    tUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "F") {
                    tUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "R") {
                    tUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "X") {
                    tUpBtn.setText("");
                    xDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        fUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "N") {
                    fUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "A") {
                    fUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "T") {
                    fUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "I") {
                    fUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "E") {
                    fUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "L") {
                    fUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "H") {
                    fUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "F") {
                    fUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "R") {
                    fUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "X") {
                    fUpBtn.setText("");
                    xDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        lUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (lUpBtn.getText().toString() == "N") {
                    lUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "A") {
                    lUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "T") {
                    lUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "I") {
                    lUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "E") {
                    lUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "L") {
                    lUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "H") {
                    lUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "F") {
                    lUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "R") {
                    lUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "X") {
                    lUpBtn.setText("");
                    xDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        iUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (iUpBtn.getText().toString() == "N") {
                    iUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "A") {
                    iUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "T") {
                    iUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "I") {
                    iUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "E") {
                    iUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "L") {
                    iUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "H") {
                    iUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "F") {
                    iUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "R") {
                    iUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "X") {
                    iUpBtn.setText("");
                    xDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        xUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (xUpBtn.getText().toString() == "N") {
                    xUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (xUpBtn.getText().toString() == "A") {
                    xUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (xUpBtn.getText().toString() == "T") {
                    xUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (xUpBtn.getText().toString() == "I") {
                    xUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (xUpBtn.getText().toString() == "E") {
                    xUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (xUpBtn.getText().toString() == "L") {
                    xUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (xUpBtn.getText().toString() == "H") {
                    xUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (xUpBtn.getText().toString() == "F") {
                    xUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (xUpBtn.getText().toString() == "R") {
                    xUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (xUpBtn.getText().toString() == "X") {
                    xUpBtn.setText("");
                    xDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        nDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (xUpBtn.getText().toString() == "") {
                    xUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && xUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+eUpBtn.getText().toString()+tUpBtn.getText().toString()+fUpBtn.getText().toString()+lUpBtn.getText().toString()+iUpBtn.getText().toString()+xUpBtn.getText().toString()).equals("NETFLIX")){
                        setWin();                    }
                    else{
                        Toast.makeText(NetflixActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        aDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (xUpBtn.getText().toString() == "") {
                    xUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && xUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+eUpBtn.getText().toString()+tUpBtn.getText().toString()+fUpBtn.getText().toString()+lUpBtn.getText().toString()+iUpBtn.getText().toString()+xUpBtn.getText().toString()).equals("NETFLIX")){
                        setWin();                    }
                    else{
                        Toast.makeText(NetflixActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        tDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (xUpBtn.getText().toString() == "") {
                    xUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && xUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+eUpBtn.getText().toString()+tUpBtn.getText().toString()+fUpBtn.getText().toString()+lUpBtn.getText().toString()+iUpBtn.getText().toString()+xUpBtn.getText().toString()).equals("NETFLIX")){
                        setWin();                    }
                    else{
                        Toast.makeText(NetflixActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        iDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (xUpBtn.getText().toString() == "") {
                    xUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && xUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+eUpBtn.getText().toString()+tUpBtn.getText().toString()+fUpBtn.getText().toString()+lUpBtn.getText().toString()+iUpBtn.getText().toString()+xUpBtn.getText().toString()).equals("NETFLIX")){
                        setWin();                    }
                    else{
                        Toast.makeText(NetflixActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        eDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (xUpBtn.getText().toString() == "") {
                    xUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && xUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+eUpBtn.getText().toString()+tUpBtn.getText().toString()+fUpBtn.getText().toString()+lUpBtn.getText().toString()+iUpBtn.getText().toString()+xUpBtn.getText().toString()).equals("NETFLIX")){
                        setWin();                    }
                    else{
                        Toast.makeText(NetflixActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        lDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (xUpBtn.getText().toString() == "") {
                    xUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && xUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+eUpBtn.getText().toString()+tUpBtn.getText().toString()+fUpBtn.getText().toString()+lUpBtn.getText().toString()+iUpBtn.getText().toString()+xUpBtn.getText().toString()).equals("NETFLIX")){
                        setWin();                    }
                    else{
                        Toast.makeText(NetflixActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        hDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (xUpBtn.getText().toString() == "") {
                    xUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && xUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+eUpBtn.getText().toString()+tUpBtn.getText().toString()+fUpBtn.getText().toString()+lUpBtn.getText().toString()+iUpBtn.getText().toString()+xUpBtn.getText().toString()).equals("NETFLIX")){
                        setWin();                    }
                    else{
                        Toast.makeText(NetflixActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        fDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (xUpBtn.getText().toString() == "") {
                    xUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && xUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+eUpBtn.getText().toString()+tUpBtn.getText().toString()+fUpBtn.getText().toString()+lUpBtn.getText().toString()+iUpBtn.getText().toString()+xUpBtn.getText().toString()).equals("NETFLIX")){
                        setWin();                    }
                    else{
                        Toast.makeText(NetflixActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        rDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (xUpBtn.getText().toString() == "") {
                    xUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && xUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+eUpBtn.getText().toString()+tUpBtn.getText().toString()+fUpBtn.getText().toString()+lUpBtn.getText().toString()+iUpBtn.getText().toString()+xUpBtn.getText().toString()).equals("NETFLIX")){
                        setWin();                    }
                    else{
                        Toast.makeText(NetflixActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        xDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("X");
                    xDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("X");
                    xDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("X");
                    xDownBtn.setVisibility(View.INVISIBLE);
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("X");
                    xDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("X");
                    xDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("X");
                    xDownBtn.setVisibility(View.INVISIBLE);
                } else if (xUpBtn.getText().toString() == "") {
                    xUpBtn.setText("X");
                    xDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && xUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+eUpBtn.getText().toString()+tUpBtn.getText().toString()+fUpBtn.getText().toString()+lUpBtn.getText().toString()+iUpBtn.getText().toString()+xUpBtn.getText().toString()).equals("NETFLIX")){
                        setWin();                    }
                    else{
                        Toast.makeText(NetflixActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
        nUpBtn = findViewById(R.id.nUp_btn);
        eUpBtn = findViewById(R.id.eUp_btn);
        tUpBtn = findViewById(R.id.tUp_btn);
        fUpBtn = findViewById(R.id.fUp_btn);
        lUpBtn = findViewById(R.id.lUp_btn);
        iUpBtn = findViewById(R.id.iUp_btn);
        xUpBtn = findViewById(R.id.xUp_btn);
        nDownBtn = findViewById(R.id.nDown_btn);
        aDownBtn = findViewById(R.id.aDown_btn);
        tDownBtn = findViewById(R.id.tDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);
        eDownBtn = findViewById(R.id.eDown_btn);
        lDownBtn = findViewById(R.id.lDown_btn);
        hDownBtn = findViewById(R.id.hDown_btn);
        fDownBtn = findViewById(R.id.fDown_btn);
        rDownBtn = findViewById(R.id.rDown_btn);
        xDownBtn = findViewById(R.id.xDown_btn);
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
        nDownBtn.setVisibility(View.VISIBLE);
        eDownBtn.setVisibility(View.VISIBLE);
        tDownBtn.setVisibility(View.VISIBLE);
        fDownBtn.setVisibility(View.VISIBLE);
        lDownBtn.setVisibility(View.VISIBLE);
        iDownBtn.setVisibility(View.VISIBLE);
        xDownBtn.setVisibility(View.VISIBLE);
        nUpBtn.setEnabled(false);
        eUpBtn.setEnabled(false);
        tUpBtn.setEnabled(false);
        fUpBtn.setEnabled(false);
        lUpBtn.setEnabled(false);
        iUpBtn.setEnabled(false);
        xUpBtn.setEnabled(false);
        eDownBtn.setEnabled(false);
        nDownBtn.setEnabled(false);
        aDownBtn.setEnabled(false);
        tDownBtn.setEnabled(false);
        iDownBtn.setEnabled(false);
        eDownBtn.setEnabled(false);
        lDownBtn.setEnabled(false);
        hDownBtn.setEnabled(false);
        fDownBtn.setEnabled(false);
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
                        Intent intant =new Intent(NetflixActivity.this,LevelTwoActivity.class);
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
