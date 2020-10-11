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
import java.util.Locale;

public class HondaActivity extends AppCompatActivity {
    Person person;
    Button hUpBtn;
    Button oUpBtn;
    Button nUpBtn;
    Button dUpBtn;
    Button aHeyUpBtn;
    Button hDownBtn;
    Button nDownBtn;
    Button sDownBtn;
    Button tDownBtn;
    Button lDownBtn;
    Button oDownBtn;
    Button dDownBtn;
    Button kDownBtn;
    Button aHeyDownBtn;
    Button rDownBtn;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.main_page){
            Intent intent = new Intent(HondaActivity.this, HomeActivity.class);
            finish();
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(HondaActivity.this, InstructionActivity.class);
            finish();
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.honda_main);

        hUpBtn = findViewById(R.id.hUp_btn);
        oUpBtn = findViewById(R.id.oUp_btn);
        nUpBtn = findViewById(R.id.nUp_btn);
        dUpBtn = findViewById(R.id.dUp_btn);
        aHeyUpBtn = findViewById(R.id.aHeyUp_btn);
        hDownBtn = findViewById(R.id.hDown_btn);
        nDownBtn = findViewById(R.id.nDown_btn);
        sDownBtn = findViewById(R.id.sDown_btn);
        tDownBtn = findViewById(R.id.tDown_btn);
        lDownBtn = findViewById(R.id.lDown_btn);
        oDownBtn = findViewById(R.id.oDown_btn);
        dDownBtn = findViewById(R.id.dDown_btn);
        kDownBtn = findViewById(R.id.kDown_btn);
        aHeyDownBtn = findViewById(R.id.a_hey_Down_btn);
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
                assert ois != null;
                person = (Person) ois.readObject();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
            if(person!=null) {
                if (person.getArr()>=20) {
                    hUpBtn.setText("H");
                    oUpBtn.setText("O");
                    nUpBtn.setText("N");
                    dUpBtn.setText("D");
                    aHeyUpBtn.setText("A");
                    hUpBtn.setEnabled(false);
                    oUpBtn.setEnabled(false);
                    nUpBtn.setEnabled(false);
                    dUpBtn.setEnabled(false);
                    aHeyUpBtn.setEnabled(false);
                    hDownBtn.setEnabled(false);
                    nDownBtn.setEnabled(false);
                    sDownBtn.setEnabled(false);
                    tDownBtn.setEnabled(false);
                    lDownBtn.setEnabled(false);
                    oDownBtn.setEnabled(false);
                    dDownBtn.setEnabled(false);
                    kDownBtn.setEnabled(false);
                    aHeyDownBtn.setEnabled(false);
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
                                    Intent intant = new Intent(HondaActivity.this, LevelOneActivity.class);
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
                        Intent intent = new Intent(HondaActivity.this, LevelOneActivity.class);
                        startActivity(intent);
                        Animatoo.animateSlideRight(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });
        hUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'h' btn
            @Override
            public void onClick(View view) {
                if (hUpBtn.getText().toString() == "H") {
                    hUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "S") {
                    hUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "L") {
                    hUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "D") {
                    hUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "A") {
                    hUpBtn.setText("");
                    aHeyDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "N") {
                    hUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "T") {
                    hUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "O") {
                    hUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "K") {
                    hUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "R") {
                    hUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        oUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'o' btn
            @Override
            public void onClick(View view) {
                if (oUpBtn.getText().toString() == "H") {
                    oUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "S") {
                    oUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "L") {
                    oUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "D") {
                    oUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "A") {
                    oUpBtn.setText("");
                    aHeyDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "N") {
                    oUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "T") {
                    oUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "O") {
                    oUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "K") {
                    oUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "R") {
                    oUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        nUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'n' btn
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "H") {
                    nUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "S") {
                    nUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "L") {
                    nUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "D") {
                    nUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "A") {
                    nUpBtn.setText("");
                    aHeyDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "N") {
                    nUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "T") {
                    nUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "O") {
                    nUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "K") {
                    nUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "R") {
                    nUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        dUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'd' btn
            @Override
            public void onClick(View view) {
                if (dUpBtn.getText().toString() == "H") {
                    dUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "S") {
                    dUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "L") {
                    dUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "D") {
                    dUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "A") {
                    dUpBtn.setText("");
                    aHeyDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "N") {
                    dUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "T") {
                    dUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "O") {
                    dUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "K") {
                    dUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "R") {
                    dUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        aHeyUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'a_hey' btn
            @Override
            public void onClick(View view) {
                if (aHeyUpBtn.getText().toString() == "H") {
                    aHeyUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (aHeyUpBtn.getText().toString() == "S") {
                    aHeyUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (aHeyUpBtn.getText().toString() == "L") {
                    aHeyUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (aHeyUpBtn.getText().toString() == "D") {
                    aHeyUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (aHeyUpBtn.getText().toString() == "A") {
                    aHeyUpBtn.setText("");
                    aHeyDownBtn.setVisibility(View.VISIBLE);
                } else if (aHeyUpBtn.getText().toString() == "N") {
                    aHeyUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (aHeyUpBtn.getText().toString() == "T") {
                    aHeyUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (aHeyUpBtn.getText().toString() == "O") {
                    aHeyUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (aHeyUpBtn.getText().toString() == "K") {
                    aHeyUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (aHeyUpBtn.getText().toString() == "R") {
                    aHeyUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        hDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (aHeyUpBtn.getText().toString() == "") {
                    aHeyUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                }
                if(hUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && nUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != "" && aHeyUpBtn.getText().toString() != ""){
                    if((hUpBtn.getText().toString()+oUpBtn.getText().toString()+nUpBtn.getText().toString()+dUpBtn.getText().toString()+aHeyUpBtn.getText().toString()).equals("HONDA")){
                        setWin();                    }
                    else{
                        Toast.makeText(HondaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        sDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (aHeyUpBtn.getText().toString() == "") {
                    aHeyUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                }
                if(hUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && nUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != "" && aHeyUpBtn.getText().toString() != ""){
                    if((hUpBtn.getText().toString()+oUpBtn.getText().toString()+nUpBtn.getText().toString()+dUpBtn.getText().toString()+aHeyUpBtn.getText().toString()).equals("HONDA")){
                        setWin();
                    }
                    else{
                        Toast.makeText(HondaActivity.this, getString(R.string.correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();}
                }
            }
        });

        lDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (aHeyUpBtn.getText().toString() == "") {
                    aHeyUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                }
                if(hUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && nUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != "" && aHeyUpBtn.getText().toString() != ""){
                    if((hUpBtn.getText().toString()+oUpBtn.getText().toString()+nUpBtn.getText().toString()+dUpBtn.getText().toString()+aHeyUpBtn.getText().toString()).equals("HONDA")){
                        setWin();                    }
                    else{
                        Toast.makeText(HondaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        dDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (aHeyUpBtn.getText().toString() == "") {
                    aHeyUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                }
                if(hUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && nUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != "" && aHeyUpBtn.getText().toString() != ""){
                    if((hUpBtn.getText().toString()+oUpBtn.getText().toString()+nUpBtn.getText().toString()+dUpBtn.getText().toString()+aHeyUpBtn.getText().toString()).equals("HONDA")){
                        setWin();                    }
                    else{
                        Toast.makeText(HondaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        aHeyDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("A");
                    aHeyDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("A");
                    aHeyDownBtn.setVisibility(View.INVISIBLE);
                } else if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("A");
                    aHeyDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("A");
                    aHeyDownBtn.setVisibility(View.INVISIBLE);
                } else if (aHeyUpBtn.getText().toString() == "") {
                    aHeyUpBtn.setText("A");
                    aHeyDownBtn.setVisibility(View.INVISIBLE);
                }
                if(hUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && nUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != "" && aHeyUpBtn.getText().toString() != ""){
                    if((hUpBtn.getText().toString()+oUpBtn.getText().toString()+nUpBtn.getText().toString()+dUpBtn.getText().toString()+aHeyUpBtn.getText().toString()).equals("HONDA")){
                        setWin();                    }
                    else{
                        Toast.makeText(HondaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        nDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (aHeyUpBtn.getText().toString() == "") {
                    aHeyUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                }
                if(hUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && nUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != "" && aHeyUpBtn.getText().toString() != ""){
                    if((hUpBtn.getText().toString()+oUpBtn.getText().toString()+nUpBtn.getText().toString()+dUpBtn.getText().toString()+aHeyUpBtn.getText().toString()).equals("HONDA")){
                        setWin();                    }
                    else{
                        Toast.makeText(HondaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        tDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (aHeyUpBtn.getText().toString() == "") {
                    aHeyUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                }
                if(hUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && nUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != "" && aHeyUpBtn.getText().toString() != ""){
                    if((hUpBtn.getText().toString()+oUpBtn.getText().toString()+nUpBtn.getText().toString()+dUpBtn.getText().toString()+aHeyUpBtn.getText().toString()).equals("HONDA")){
                        setWin();                    }
                    else{
                        Toast.makeText(HondaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        oDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (aHeyUpBtn.getText().toString() == "") {
                    aHeyUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                }
                if(hUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && nUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != "" && aHeyUpBtn.getText().toString() != ""){
                    if((hUpBtn.getText().toString()+oUpBtn.getText().toString()+nUpBtn.getText().toString()+dUpBtn.getText().toString()+aHeyUpBtn.getText().toString()).equals("HONDA")){
                        setWin();                    }
                    else{
                        Toast.makeText(HondaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        kDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                } else if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                } else if (aHeyUpBtn.getText().toString() == "") {
                    aHeyUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                }
                if(hUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && nUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != "" && aHeyUpBtn.getText().toString() != ""){
                    if((hUpBtn.getText().toString()+oUpBtn.getText().toString()+nUpBtn.getText().toString()+dUpBtn.getText().toString()+aHeyUpBtn.getText().toString()).equals("HONDA")){
                        setWin();                    }
                    else{
                        Toast.makeText(HondaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        rDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (aHeyUpBtn.getText().toString() == "") {
                    aHeyUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                }
                if(hUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && nUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != "" && aHeyUpBtn.getText().toString() != ""){
                    if((hUpBtn.getText().toString()+oUpBtn.getText().toString()+nUpBtn.getText().toString()+dUpBtn.getText().toString()+aHeyUpBtn.getText().toString()).equals("HONDA")){
                        setWin();                    }
                    else{
                        Toast.makeText(HondaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
        hUpBtn = findViewById(R.id.hUp_btn);
        oUpBtn = findViewById(R.id.oUp_btn);
        nUpBtn = findViewById(R.id.nUp_btn);
        dUpBtn = findViewById(R.id.dUp_btn);
        aHeyUpBtn = findViewById(R.id.aHeyUp_btn);
        hDownBtn = findViewById(R.id.hDown_btn);
        nDownBtn = findViewById(R.id.nDown_btn);
        sDownBtn = findViewById(R.id.sDown_btn);
        tDownBtn = findViewById(R.id.tDown_btn);
        lDownBtn = findViewById(R.id.lDown_btn);
        oDownBtn = findViewById(R.id.oDown_btn);
        dDownBtn = findViewById(R.id.dDown_btn);
        kDownBtn = findViewById(R.id.kDown_btn);
        aHeyDownBtn = findViewById(R.id.a_hey_Down_btn);
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
        hDownBtn.setVisibility(View.VISIBLE);
        oDownBtn.setVisibility(View.VISIBLE);
        nDownBtn.setVisibility(View.VISIBLE);
        dDownBtn.setVisibility(View.VISIBLE);
        aHeyDownBtn.setVisibility(View.VISIBLE);
        hUpBtn.setEnabled(false);
        oUpBtn.setEnabled(false);
        nUpBtn.setEnabled(false);
        dUpBtn.setEnabled(false);
        aHeyUpBtn.setEnabled(false);
        hDownBtn.setEnabled(false);
        nDownBtn.setEnabled(false);
        sDownBtn.setEnabled(false);
        tDownBtn.setEnabled(false);
        lDownBtn.setEnabled(false);
        oDownBtn.setEnabled(false);
        dDownBtn.setEnabled(false);
        kDownBtn.setEnabled(false);
        aHeyDownBtn.setEnabled(false);
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
                        Intent intant =new Intent(HondaActivity.this,LevelOneActivity.class);
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
