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

public class MtvActivity extends AppCompatActivity {
    Person person;
    Button mUpBtn;
    Button tUpBtn;
    Button vUpBtn;
    Button dDownBtn;
    Button nDownBtn;
    Button wDownBtn;
    Button iDownBtn;
    Button vDownBtn;
    Button aDownBtn;
    Button tDownBtn;
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
            Intent intent = new Intent(MtvActivity.this, HomeActivity.class);
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(MtvActivity.this, InstructionActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mtv_main);

        mUpBtn = findViewById(R.id.mUp_btn);
        tUpBtn = findViewById(R.id.tUp_btn);
        vUpBtn = findViewById(R.id.vUp_btn);
        dDownBtn = findViewById(R.id.dDown_btn);
        nDownBtn = findViewById(R.id.nDown_btn);
        wDownBtn = findViewById(R.id.wDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);
        vDownBtn = findViewById(R.id.vDown_btn);
        aDownBtn = findViewById(R.id.aDown_btn);
        tDownBtn = findViewById(R.id.tDown_btn);
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
                if (person.getArr1()>=105) {
                    mUpBtn.setText("M");
                    tUpBtn.setText("T");
                    vUpBtn.setText("V");
                    mUpBtn.setEnabled(false);
                    tUpBtn.setEnabled(false);
                    vUpBtn.setEnabled(false);
                    dDownBtn.setEnabled(false);
                    nDownBtn.setEnabled(false);
                    wDownBtn.setEnabled(false);
                    iDownBtn.setEnabled(false);
                    vDownBtn.setEnabled(false);
                    aDownBtn.setEnabled(false);
                    tDownBtn.setEnabled(false);
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
                                    Intent intant = new Intent(MtvActivity.this, LevelThreeActivity.class);
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
                        Intent intent = new Intent(MtvActivity.this, LevelTwoActivity.class);
                        startActivity(intent);
                        Animatoo.animateSlideRight(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });
        mUpBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (mUpBtn.getText().toString() == "D") {
                    mUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "N") {
                    mUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "W") {
                    mUpBtn.setText("");
                    wDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "I") {
                    mUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "V") {
                    mUpBtn.setText("");
                    vDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "A") {
                    mUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "T") {
                    mUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "M") {
                    mUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "X") {
                    mUpBtn.setText("");
                    xDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "B") {
                    mUpBtn.setText("");
                    bDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        tUpBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (tUpBtn.getText().toString() == "D") {
                    tUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "N") {
                    tUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "W") {
                    tUpBtn.setText("");
                    wDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "I") {
                    tUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "V") {
                    tUpBtn.setText("");
                    vDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "A") {
                    tUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "T") {
                    tUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "M") {
                    tUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "X") {
                    tUpBtn.setText("");
                    xDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "B") {
                    tUpBtn.setText("");
                    bDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        vUpBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (vUpBtn.getText().toString() == "D") {
                    vUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (vUpBtn.getText().toString() == "N") {
                    vUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (vUpBtn.getText().toString() == "W") {
                    vUpBtn.setText("");
                    wDownBtn.setVisibility(View.VISIBLE);
                } else if (vUpBtn.getText().toString() == "I") {
                    vUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (vUpBtn.getText().toString() == "V") {
                    vUpBtn.setText("");
                    vDownBtn.setVisibility(View.VISIBLE);
                } else if (vUpBtn.getText().toString() == "A") {
                    vUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (vUpBtn.getText().toString() == "T") {
                    vUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (vUpBtn.getText().toString() == "M") {
                    vUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (vUpBtn.getText().toString() == "X") {
                    vUpBtn.setText("");
                    xDownBtn.setVisibility(View.VISIBLE);
                } else if (vUpBtn.getText().toString() == "B") {
                    vUpBtn.setText("");
                    bDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        dDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (vUpBtn.getText().toString() == "") {
                    vUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                }
                if(mUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && vUpBtn.getText().toString() != ""){
                    if((mUpBtn.getText().toString()+tUpBtn.getText().toString()+vUpBtn.getText().toString()).equals("MTV")){
                        setWin();                    }
                    else{
                        Toast.makeText(MtvActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        nDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (vUpBtn.getText().toString() == "") {
                    vUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                }
                if(mUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && vUpBtn.getText().toString() != ""){
                    if((mUpBtn.getText().toString()+tUpBtn.getText().toString()+vUpBtn.getText().toString()).equals("MTV")){
                        setWin();                    }
                    else{
                        Toast.makeText(MtvActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        wDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("W");
                    wDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("W");
                    wDownBtn.setVisibility(View.INVISIBLE);
                } else if (vUpBtn.getText().toString() == "") {
                    vUpBtn.setText("W");
                    wDownBtn.setVisibility(View.INVISIBLE);
                }
                if(mUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && vUpBtn.getText().toString() != ""){
                    if((mUpBtn.getText().toString()+tUpBtn.getText().toString()+vUpBtn.getText().toString()).equals("MTV")){
                        setWin();                    }
                    else{
                        Toast.makeText(MtvActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        iDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (vUpBtn.getText().toString() == "") {
                    vUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                }
                if(mUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && vUpBtn.getText().toString() != ""){
                    if((mUpBtn.getText().toString()+tUpBtn.getText().toString()+vUpBtn.getText().toString()).equals("MTV")){
                        setWin();                    }
                    else{
                        Toast.makeText(MtvActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        vDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("V");
                    vDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("V");
                    vDownBtn.setVisibility(View.INVISIBLE);
                } else if (vUpBtn.getText().toString() == "") {
                    vUpBtn.setText("V");
                    vDownBtn.setVisibility(View.INVISIBLE);
                }
                if(mUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && vUpBtn.getText().toString() != ""){
                    if((mUpBtn.getText().toString()+tUpBtn.getText().toString()+vUpBtn.getText().toString()).equals("MTV")){
                        setWin();                    }
                    else{
                        Toast.makeText(MtvActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        aDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (vUpBtn.getText().toString() == "") {
                    vUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                }
                if(mUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && vUpBtn.getText().toString() != ""){
                    if((mUpBtn.getText().toString()+tUpBtn.getText().toString()+vUpBtn.getText().toString()).equals("MTV")){
                        setWin();                    }
                    else{
                        Toast.makeText(MtvActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        tDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (vUpBtn.getText().toString() == "") {
                    vUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                }
                if(mUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && vUpBtn.getText().toString() != ""){
                    if((mUpBtn.getText().toString()+tUpBtn.getText().toString()+vUpBtn.getText().toString()).equals("MTV")){
                        setWin();                    }
                    else{
                        Toast.makeText(MtvActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        mDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (vUpBtn.getText().toString() == "") {
                    vUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                }
                if(mUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && vUpBtn.getText().toString() != ""){
                    if((mUpBtn.getText().toString()+tUpBtn.getText().toString()+vUpBtn.getText().toString()).equals("MTV")){
                        setWin();                    }
                    else{
                        Toast.makeText(MtvActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        xDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("X");
                    xDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("X");
                    xDownBtn.setVisibility(View.INVISIBLE);
                } else if (vUpBtn.getText().toString() == "") {
                    vUpBtn.setText("X");
                    xDownBtn.setVisibility(View.INVISIBLE);
                }
                if(mUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && vUpBtn.getText().toString() != ""){
                    if((mUpBtn.getText().toString()+tUpBtn.getText().toString()+vUpBtn.getText().toString()).equals("MTV")){
                        setWin();                    }
                    else{
                        Toast.makeText(MtvActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        bDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("B");
                    bDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("B");
                    bDownBtn.setVisibility(View.INVISIBLE);
                } else if (vUpBtn.getText().toString() == "") {
                    vUpBtn.setText("B");
                    bDownBtn.setVisibility(View.INVISIBLE);
                }
                if(mUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != "" && vUpBtn.getText().toString() != ""){
                    if((mUpBtn.getText().toString()+tUpBtn.getText().toString()+vUpBtn.getText().toString()).equals("MTV")){
                        setWin();                    }
                    else{
                        Toast.makeText(MtvActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
        mUpBtn = findViewById(R.id.mUp_btn);
        tUpBtn = findViewById(R.id.tUp_btn);
        vUpBtn = findViewById(R.id.vUp_btn);
        dDownBtn = findViewById(R.id.dDown_btn);
        nDownBtn = findViewById(R.id.nDown_btn);
        wDownBtn = findViewById(R.id.wDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);
        vDownBtn = findViewById(R.id.vDown_btn);
        aDownBtn = findViewById(R.id.aDown_btn);
        tDownBtn = findViewById(R.id.tDown_btn);
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
                person.setScore1(person.getArr1()+25);
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
        mDownBtn.setVisibility(View.VISIBLE);
        tDownBtn.setVisibility(View.VISIBLE);
        vDownBtn.setVisibility(View.VISIBLE);
        mUpBtn.setText("M");
        tUpBtn.setText("T");
        vUpBtn.setText("V");
        mUpBtn.setEnabled(false);
        tUpBtn.setEnabled(false);
        vUpBtn.setEnabled(false);
        dDownBtn.setEnabled(false);
        nDownBtn.setEnabled(false);
        wDownBtn.setEnabled(false);
        iDownBtn.setEnabled(false);
        vDownBtn.setEnabled(false);
        aDownBtn.setEnabled(false);
        tDownBtn.setEnabled(false);
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
                        Intent intant =new Intent(MtvActivity.this,LevelThreeActivity.class);
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
