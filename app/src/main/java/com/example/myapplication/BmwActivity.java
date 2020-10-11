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

public class BmwActivity extends AppCompatActivity {
    Person person;
    Button bUpBtn;
    Button mUpBtn ;
    Button wUpBtn;
    Animation setAnim;
    TextView levelTwoOpenTv;
    Button bDownBtn;
    Button cDownBtn;
    Button xDownBtn;
    Button sDownBtn ;
    Button eDownBtn;
    Button kDownBtn;
    Button tDownBtn;
    Button pDownBtn ;
    Button wDownBtn;
    Button mDownBtn;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.main_page){
            Intent intent = new Intent(BmwActivity.this, HomeActivity.class);
            finish();
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(BmwActivity.this, InstructionActivity.class);
            finish();
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmw_main);

        bUpBtn = findViewById(R.id.bUp_btn);
        mUpBtn = findViewById(R.id.mUp_btn);
        wUpBtn = findViewById(R.id.wUp_btn);

        bDownBtn = findViewById(R.id.bDown_btn);
        cDownBtn = findViewById(R.id.cDown_btn);
        xDownBtn = findViewById(R.id.xDown_btn);
        sDownBtn = findViewById(R.id.sDown_btn);
        eDownBtn = findViewById(R.id.eDown_btn);
        kDownBtn = findViewById(R.id.kDown_btn);
        tDownBtn = findViewById(R.id.tDown_btn);
        pDownBtn = findViewById(R.id.pDown_btn);
        wDownBtn = findViewById(R.id.wDown_btn);
        mDownBtn = findViewById(R.id.mDown_btn);
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
                if (person.getArr()>=60) {
                    bUpBtn.setText("B");
                    mUpBtn.setText("M");
                    wUpBtn.setText("W");
                    bUpBtn.setEnabled(false);
                    mUpBtn.setEnabled(false);
                    wUpBtn.setEnabled(false);
                    bDownBtn.setEnabled(false);
                    cDownBtn.setEnabled(false);
                    xDownBtn.setEnabled(false);
                    sDownBtn.setEnabled(false);
                    eDownBtn.setEnabled(false);
                    kDownBtn.setEnabled(false);
                    tDownBtn.setEnabled(false);
                    pDownBtn.setEnabled(false);
                    wDownBtn.setEnabled(false);
                    mDownBtn.setEnabled(false);
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
                                    Intent intant = new Intent(BmwActivity.this, LevelOneActivity.class);
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
                        Intent intent = new Intent(BmwActivity.this, LevelOneActivity.class);
                        startActivity(intent);
                        Animatoo.animateSlideRight(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });
        bUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (bUpBtn.getText().toString() == "B") {
                    bUpBtn.setText("");
                    bDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "C") {
                    bUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "X") {
                    bUpBtn.setText("");
                    xDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "S") {
                    bUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "E") {
                    bUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "K") {
                    bUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "T") {
                    bUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "P") {
                    bUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "W") {
                    bUpBtn.setText("");
                    wDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "M") {
                    bUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        mUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (mUpBtn.getText().toString() == "B") {
                    mUpBtn.setText("");
                    bDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "C") {
                    mUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "X") {
                    mUpBtn.setText("");
                    xDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "S") {
                    mUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "E") {
                    mUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "K") {
                    mUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "T") {
                    mUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "P") {
                    mUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "W") {
                    mUpBtn.setText("");
                    wDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "M") {
                    mUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        wUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (wUpBtn.getText().toString() == "B") {
                    wUpBtn.setText("");
                    bDownBtn.setVisibility(View.VISIBLE);
                } else if (wUpBtn.getText().toString() == "C") {
                    wUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (wUpBtn.getText().toString() == "X") {
                    wUpBtn.setText("");
                    xDownBtn.setVisibility(View.VISIBLE);
                } else if (wUpBtn.getText().toString() == "S") {
                    wUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                } else if (wUpBtn.getText().toString() == "E") {
                    wUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (wUpBtn.getText().toString() == "K") {
                    wUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (wUpBtn.getText().toString() == "T") {
                    wUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (wUpBtn.getText().toString() == "P") {
                    wUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (wUpBtn.getText().toString() == "W") {
                    wUpBtn.setText("");
                    wDownBtn.setVisibility(View.VISIBLE);
                } else if (wUpBtn.getText().toString() == "M") {
                    wUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        bDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("B");
                    bDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("B");
                    bDownBtn.setVisibility(View.INVISIBLE);
                } else if (wUpBtn.getText().toString() == "") {
                    wUpBtn.setText("B");
                    bDownBtn.setVisibility(View.INVISIBLE);
                }
                if(bUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && wUpBtn.getText().toString() != ""){
                    if((bUpBtn.getText().toString()+mUpBtn.getText().toString()+wUpBtn.getText().toString()).equals("BMW")){
                        setWin();
                    }
                    else{
                        Toast.makeText(BmwActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        cDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (wUpBtn.getText().toString() == "") {
                    wUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                }
                if(bUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && wUpBtn.getText().toString() != ""){
                    if((bUpBtn.getText().toString()+mUpBtn.getText().toString()+wUpBtn.getText().toString()).equals("BMW")){
                        setWin();                    }
                    else{
                        Toast.makeText(BmwActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        xDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("X");
                    xDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("X");
                    xDownBtn.setVisibility(View.INVISIBLE);
                } else if (wUpBtn.getText().toString() == "") {
                    wUpBtn.setText("X");
                    xDownBtn.setVisibility(View.INVISIBLE);
                }
                if(bUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && wUpBtn.getText().toString() != ""){
                    if((bUpBtn.getText().toString()+mUpBtn.getText().toString()+wUpBtn.getText().toString()).equals("BMW")){
                        setWin();                    }
                    else{
                        Toast.makeText(BmwActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        sDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (wUpBtn.getText().toString() == "") {
                    wUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                }
                if(bUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && wUpBtn.getText().toString() != ""){
                    if((bUpBtn.getText().toString()+mUpBtn.getText().toString()+wUpBtn.getText().toString()).equals("BMW")){
                        setWin();                    }
                    else{
                        Toast.makeText(BmwActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        eDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (wUpBtn.getText().toString() == "") {
                    wUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                }
                if(bUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && wUpBtn.getText().toString() != ""){
                    if((bUpBtn.getText().toString()+mUpBtn.getText().toString()+wUpBtn.getText().toString()).equals("BMW")){
                        setWin();                    }
                    else{
                        Toast.makeText(BmwActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        kDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                } else if (wUpBtn.getText().toString() == "") {
                    wUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                }
                if(bUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && wUpBtn.getText().toString() != ""){
                    if((bUpBtn.getText().toString()+mUpBtn.getText().toString()+wUpBtn.getText().toString()).equals("BMW")){
                        setWin();                    }
                    else{
                        Toast.makeText(BmwActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        tDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (wUpBtn.getText().toString() == "") {
                    wUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                }
                if(bUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && wUpBtn.getText().toString() != ""){
                    if((bUpBtn.getText().toString()+mUpBtn.getText().toString()+wUpBtn.getText().toString()).equals("BMW")){
                        setWin();                    }
                    else{
                        Toast.makeText(BmwActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        pDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                } else if (wUpBtn.getText().toString() == "") {
                    wUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                }
                if(bUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && wUpBtn.getText().toString() != ""){
                    if((bUpBtn.getText().toString()+mUpBtn.getText().toString()+wUpBtn.getText().toString()).equals("BMW")){
                        setWin();                    }
                    else{
                        Toast.makeText(BmwActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        wDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("W");
                    wDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("W");
                    wDownBtn.setVisibility(View.INVISIBLE);
                } else if (wUpBtn.getText().toString() == "") {
                    wUpBtn.setText("W");
                    wDownBtn.setVisibility(View.INVISIBLE);
                }
                if(bUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && wUpBtn.getText().toString() != ""){
                    if((bUpBtn.getText().toString()+mUpBtn.getText().toString()+wUpBtn.getText().toString()).equals("BMW")){
                        setWin();
                    }
                    else{
                        Toast.makeText(BmwActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        mDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (wUpBtn.getText().toString() == "") {
                    wUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                }
                if(bUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && wUpBtn.getText().toString() != ""){
                    if((bUpBtn.getText().toString()+mUpBtn.getText().toString()+wUpBtn.getText().toString()).equals("BMW")){
                        setWin();                    }
                    else{
                        Toast.makeText(BmwActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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


        levelTwoOpenTv = findViewById(R.id.level_two_open_tv);
        setAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        bUpBtn = findViewById(R.id.bUp_btn);
        mUpBtn = findViewById(R.id.mUp_btn);
        wUpBtn = findViewById(R.id.wUp_btn);

        bDownBtn = findViewById(R.id.bDown_btn);
        cDownBtn = findViewById(R.id.cDown_btn);
        xDownBtn = findViewById(R.id.xDown_btn);
        sDownBtn = findViewById(R.id.sDown_btn);
        eDownBtn = findViewById(R.id.eDown_btn);
        kDownBtn = findViewById(R.id.kDown_btn);
        tDownBtn = findViewById(R.id.tDown_btn);
        pDownBtn = findViewById(R.id.pDown_btn);
        wDownBtn = findViewById(R.id.wDown_btn);
        mDownBtn = findViewById(R.id.mDown_btn);
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
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
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
        bDownBtn.setVisibility(View.VISIBLE);
        mDownBtn.setVisibility(View.VISIBLE);
        wDownBtn.setVisibility(View.VISIBLE);
        bUpBtn.setEnabled(false);
        mUpBtn.setEnabled(false);
        wUpBtn.setEnabled(false);
        bDownBtn.setEnabled(false);
        cDownBtn.setEnabled(false);
        xDownBtn.setEnabled(false);
        sDownBtn.setEnabled(false);
        eDownBtn.setEnabled(false);
        kDownBtn.setEnabled(false);
        tDownBtn.setEnabled(false);
        pDownBtn.setEnabled(false);
        wDownBtn.setEnabled(false);
        mDownBtn.setEnabled(false);

        TextView textView=findViewById(R.id.compplete);
        textView.setVisibility(View.VISIBLE);
        levelTwoOpenTv.setVisibility(View.VISIBLE);
        levelTwoOpenTv.setAnimation(setAnim);
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
                        Intent intant =new Intent(BmwActivity.this,LevelOneActivity.class);
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
