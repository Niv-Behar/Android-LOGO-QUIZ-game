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

public class NbaActivity extends AppCompatActivity {
    Person person;
    Button nUpBtn;
    Button bUpBtn;
    Button aUpBtn;
    Button dDownBtn;
    Button nDownBtn;
    Button wDownBtn;
    Button iDownBtn;
    Button sDownBtn;
    Button aDownBtn;
    Button jDownBtn;
    Button mDownBtn;
    Button xDownBtn;
    Button bDownBtn;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.main_page){
            Intent intent = new Intent(NbaActivity.this, HomeActivity.class);
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(NbaActivity.this, InstructionActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nba_main);

        nUpBtn = findViewById(R.id.nUp_btn);
        bUpBtn = findViewById(R.id.bUp_btn);
        aUpBtn = findViewById(R.id.aUp_btn);
        dDownBtn = findViewById(R.id.dDown_btn);
        nDownBtn = findViewById(R.id.nDown_btn);
        wDownBtn = findViewById(R.id.wDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);
        sDownBtn = findViewById(R.id.sDown_btn);
        aDownBtn = findViewById(R.id.aDown_btn);
        jDownBtn = findViewById(R.id.jDown_btn);
        mDownBtn = findViewById(R.id.mDown_btn);
        xDownBtn = findViewById(R.id.xDown_btn);
        bDownBtn = findViewById(R.id.bDown_btn);
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
                if (person.getArr()>=40) {
                    nUpBtn.setText("N");
                    bUpBtn.setText("B");
                    aUpBtn.setText("A");
                    nUpBtn.setEnabled(false);
                    bUpBtn.setEnabled(false);
                    aUpBtn.setEnabled(false);
                    dDownBtn.setEnabled(false);
                    nDownBtn.setEnabled(false);
                    wDownBtn.setEnabled(false);
                    iDownBtn.setEnabled(false);
                    sDownBtn.setEnabled(false);
                    aDownBtn.setEnabled(false);
                    jDownBtn.setEnabled(false);
                    mDownBtn.setEnabled(false);
                    xDownBtn.setEnabled(false);
                    bDownBtn.setEnabled(false);
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
                                    Intent intant = new Intent(NbaActivity.this, LevelOneActivity.class);
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
                        Intent intent = new Intent(NbaActivity.this, LevelOneActivity.class);
                        startActivity(intent);
                        Animatoo.animateSlideRight(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });
        nUpBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "D") {
                    nUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "N") {
                    nUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "W") {
                    nUpBtn.setText("");
                    wDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "I") {
                    nUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "S") {
                    nUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "A") {
                    nUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "J") {
                    nUpBtn.setText("");
                    jDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "M") {
                    nUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "X") {
                    nUpBtn.setText("");
                    xDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "B") {
                    nUpBtn.setText("");
                    bDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        bUpBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (bUpBtn.getText().toString() == "D") {
                    bUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "N") {
                    bUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "W") {
                    bUpBtn.setText("");
                    wDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "I") {
                    bUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "S") {
                    bUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "A") {
                    bUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "J") {
                    bUpBtn.setText("");
                    jDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "M") {
                    bUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "X") {
                    bUpBtn.setText("");
                    xDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "B") {
                    bUpBtn.setText("");
                    bDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        aUpBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (aUpBtn.getText().toString() == "D") {
                    aUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "N") {
                    aUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "W") {
                    aUpBtn.setText("");
                    wDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "I") {
                    aUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "S") {
                    aUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "A") {
                    aUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "J") {
                    aUpBtn.setText("");
                    jDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "M") {
                    aUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "X") {
                    aUpBtn.setText("");
                    xDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "B") {
                    aUpBtn.setText("");
                    bDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        dDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && bUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+bUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("NBA")){
                        setWin();                    }
                    else{
                        Toast.makeText(NbaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && bUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+bUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("NBA")){
                        setWin();                    }
                    else{
                        Toast.makeText(NbaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        wDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("W");
                    wDownBtn.setVisibility(View.INVISIBLE);
                } else if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("W");
                    wDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("W");
                    wDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && bUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+bUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("NBA")){
                        setWin();                    }
                    else{
                        Toast.makeText(NbaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && bUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+bUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("NBA")){
                        setWin();                    }
                    else{
                        Toast.makeText(NbaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        sDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && bUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+bUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("NBA")){
                        setWin();                    }
                    else{
                        Toast.makeText(NbaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && bUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+bUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("NBA")){
                        setWin();                    }
                    else{
                        Toast.makeText(NbaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        jDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("J");
                    jDownBtn.setVisibility(View.INVISIBLE);
                } else if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("J");
                    jDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("J");
                    jDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && bUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+bUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("NBA")){
                        setWin();                    }
                    else{
                        Toast.makeText(NbaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && bUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+bUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("NBA")){
                        setWin();                    }
                    else{
                        Toast.makeText(NbaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("X");
                    xDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("X");
                    xDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && bUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+bUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("NBA")){
                        setWin();                    }
                    else{
                        Toast.makeText(NbaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        bDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("B");
                    bDownBtn.setVisibility(View.INVISIBLE);
                } else if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("B");
                    bDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("B");
                    bDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && bUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+bUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("NBA")){
                        setWin();                    }
                    else{
                        Toast.makeText(NbaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
        bUpBtn = findViewById(R.id.bUp_btn);
        aUpBtn = findViewById(R.id.aUp_btn);
        dDownBtn = findViewById(R.id.dDown_btn);
        nDownBtn = findViewById(R.id.nDown_btn);
        wDownBtn = findViewById(R.id.wDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);
        sDownBtn = findViewById(R.id.sDown_btn);
        aDownBtn = findViewById(R.id.aDown_btn);
        jDownBtn = findViewById(R.id.jDown_btn);
        mDownBtn = findViewById(R.id.mDown_btn);
        xDownBtn = findViewById(R.id.xDown_btn);
        bDownBtn = findViewById(R.id.bDown_btn);
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
        nDownBtn.setVisibility(View.VISIBLE);
        bDownBtn.setVisibility(View.VISIBLE);
        aDownBtn.setVisibility(View.VISIBLE);
        nUpBtn.setEnabled(false);
        bUpBtn.setEnabled(false);
        aUpBtn.setEnabled(false);
        dDownBtn.setEnabled(false);
        nDownBtn.setEnabled(false);
        wDownBtn.setEnabled(false);
        iDownBtn.setEnabled(false);
        sDownBtn.setEnabled(false);
        aDownBtn.setEnabled(false);
        jDownBtn.setEnabled(false);
        mDownBtn.setEnabled(false);
        xDownBtn.setEnabled(false);
        bDownBtn.setEnabled(false);

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
                        Intent intant =new Intent(NbaActivity.this,LevelOneActivity.class);
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

