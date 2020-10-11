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

public class NikeActivity extends AppCompatActivity {
    Person person;
    Button nUpBtn;
    Button iUpBtn;
    Button kUpBtn;
    Button eUpBtn;
    Button eDownBtn;
    Button mDownBtn;
    Button iDownBtn;
    Button gDownBtn;
    Button pDownBtn;
    Button nDownBtn;
    Button rDownBtn;
    Button aDownBtn;
    Button kDownBtn;
    Button uDownBtn;
    Animation setAnim;
    TextView levelThreeOpenTv;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.main_page){
            Intent intent = new Intent(NikeActivity.this, HomeActivity.class);
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(NikeActivity.this, InstructionActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nike_main);

        nUpBtn = findViewById(R.id.nUp_btn);
        iUpBtn = findViewById(R.id.iUp_btn);
        kUpBtn = findViewById(R.id.kUp_btn);
        eUpBtn = findViewById(R.id.eUp_btn);
        eDownBtn = findViewById(R.id.eDown_btn);
        mDownBtn = findViewById(R.id.mDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);
        gDownBtn = findViewById(R.id.gDown_btn);
        pDownBtn = findViewById(R.id.pDown_btn);
        nDownBtn = findViewById(R.id.nDown_btn);
        rDownBtn = findViewById(R.id.rDown_btn);
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
                        if (person.getArr2()>=60) {
                    nUpBtn.setText("N");
                    iUpBtn.setText("I");
                    kUpBtn.setText("K");
                    eUpBtn.setText("E");
                    nUpBtn.setEnabled(false);
                    iUpBtn.setEnabled(false);
                    kUpBtn.setEnabled(false);
                    eUpBtn.setEnabled(false);
                    eDownBtn.setEnabled(false);
                    mDownBtn.setEnabled(false);
                    iDownBtn.setEnabled(false);
                    gDownBtn.setEnabled(false);
                    pDownBtn.setEnabled(false);
                    nDownBtn.setEnabled(false);
                    rDownBtn.setEnabled(false);
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
                                    Intent intant = new Intent(NikeActivity.this, LevelTwoActivity.class);
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
                        Intent intent = new Intent(NikeActivity.this, LevelTwoActivity.class);
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
                if (nUpBtn.getText().toString() == "E") {
                    nUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "M") {
                    nUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "I") {
                    nUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "G") {
                    nUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "P") {
                    nUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "N") {
                    nUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "R") {
                    nUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "A") {
                    nUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "K") {
                    nUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "U") {
                    nUpBtn.setText("");
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
                } else if (iUpBtn.getText().toString() == "P") {
                    iUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "N") {
                    iUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "R") {
                    iUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
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

        kUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (kUpBtn.getText().toString() == "E") {
                    kUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "M") {
                    kUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "I") {
                    kUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "G") {
                    kUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "P") {
                    kUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "N") {
                    kUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "R") {
                    kUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "A") {
                    kUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "K") {
                    kUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "U") {
                    kUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        eUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (eUpBtn.getText().toString() == "E") {
                    eUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "M") {
                    eUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "I") {
                    eUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "G") {
                    eUpBtn.setText("");
                    gDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "P") {
                    eUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "N") {
                    eUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "R") {
                    eUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "A") {
                    eUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "K") {
                    eUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "U") {
                    eUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        eDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && kUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+iUpBtn.getText().toString()+kUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("NIKE")){
                        setWin();                    }
                    else{
                        Toast.makeText(NikeActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        mDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && kUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+iUpBtn.getText().toString()+kUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("NIKE")){
                        setWin();                    }
                    else{
                        Toast.makeText(NikeActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && kUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+iUpBtn.getText().toString()+kUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("NIKE")){
                        setWin();                    }
                    else{
                        Toast.makeText(NikeActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        gDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                } else if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("G");
                    gDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && kUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+iUpBtn.getText().toString()+kUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("NIKE")){
                        setWin();                    }
                    else{
                        Toast.makeText(NikeActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        pDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                } else if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && kUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+iUpBtn.getText().toString()+kUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("NIKE")){
                        setWin();                    }
                    else{
                        Toast.makeText(NikeActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        nDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && kUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+iUpBtn.getText().toString()+kUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("NIKE")){
                        setWin();                    }
                    else{
                        Toast.makeText(NikeActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && kUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+iUpBtn.getText().toString()+kUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("NIKE")){
                        setWin();                    }
                    else{
                        Toast.makeText(NikeActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && kUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+iUpBtn.getText().toString()+kUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("NIKE")){
                        setWin();                    }
                    else{
                        Toast.makeText(NikeActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        kDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                } else if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && kUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+iUpBtn.getText().toString()+kUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("NIKE")){
                        setWin();                    }
                    else{
                        Toast.makeText(NikeActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        uDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                } else if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && kUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+iUpBtn.getText().toString()+kUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("NIKE")){
                        setWin();                    }
                    else{
                        Toast.makeText(NikeActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
        iUpBtn = findViewById(R.id.iUp_btn);
        kUpBtn = findViewById(R.id.kUp_btn);
        eUpBtn = findViewById(R.id.eUp_btn);
        eDownBtn = findViewById(R.id.eDown_btn);
        mDownBtn = findViewById(R.id.mDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);
        gDownBtn = findViewById(R.id.gDown_btn);
        pDownBtn = findViewById(R.id.pDown_btn);
        nDownBtn = findViewById(R.id.nDown_btn);
        rDownBtn = findViewById(R.id.rDown_btn);
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
        iDownBtn.setVisibility(View.VISIBLE);
        kDownBtn.setVisibility(View.VISIBLE);
        eDownBtn.setVisibility(View.VISIBLE);
        nUpBtn.setEnabled(false);
        iUpBtn.setEnabled(false);
        kUpBtn.setEnabled(false);
        eUpBtn.setEnabled(false);
        eDownBtn.setEnabled(false);
        mDownBtn.setEnabled(false);
        iDownBtn.setEnabled(false);
        gDownBtn.setEnabled(false);
        pDownBtn.setEnabled(false);
        nDownBtn.setEnabled(false);
        rDownBtn.setEnabled(false);
        aDownBtn.setEnabled(false);
        kDownBtn.setEnabled(false);
        uDownBtn.setEnabled(false);

        levelThreeOpenTv=findViewById(R.id.level_three_open_tv);
        setAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);
        levelThreeOpenTv.setVisibility(View.VISIBLE);
        levelThreeOpenTv.setAnimation(setAnim);
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
                        Intent intant =new Intent(NikeActivity.this,LevelTwoActivity.class);
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
