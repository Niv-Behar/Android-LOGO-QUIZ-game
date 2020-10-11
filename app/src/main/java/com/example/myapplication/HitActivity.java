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

public class HitActivity extends AppCompatActivity {
    Person person;
    Button hUpBtn;
    Button iUpBtn;
    Button tUpBtn;
    Button oDownBtn;
    Button iDownBtn;
    Button fDownBtn;
    Button hDownBtn;
    Button eDownBtn;
    Button dDownBtn;
    Button tDownBtn;
    Button cDownBtn;
    Button nDownBtn;
    Button bDownBtn;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.main_page){
            Intent intent = new Intent(HitActivity.this, HomeActivity.class);
            finish();
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(HitActivity.this, InstructionActivity.class);
            finish();
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hit_main);

        hUpBtn = findViewById(R.id.hUp_btn);
        iUpBtn = findViewById(R.id.iUp_btn);
        tUpBtn = findViewById(R.id.tUp_btn);
        oDownBtn = findViewById(R.id.oDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);
        fDownBtn = findViewById(R.id.fDown_btn);
        hDownBtn = findViewById(R.id.hDown_btn);
        eDownBtn = findViewById(R.id.eDown_btn);
        dDownBtn = findViewById(R.id.dDown_btn);
        tDownBtn = findViewById(R.id.tDown_btn);
        cDownBtn = findViewById(R.id.cDown_btn);
        nDownBtn = findViewById(R.id.nDown_btn);
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
                if (person.getArr2()>=20) {
                    hUpBtn.setText("H");
                    iUpBtn.setText("I");
                    tUpBtn.setText("T");
                    hUpBtn.setEnabled(false);
                    iUpBtn.setEnabled(false);
                    tUpBtn.setEnabled(false);
                    oDownBtn.setEnabled(false);
                    iDownBtn.setEnabled(false);
                    fDownBtn.setEnabled(false);
                    hDownBtn.setEnabled(false);
                    eDownBtn.setEnabled(false);
                    dDownBtn.setEnabled(false);
                    tDownBtn.setEnabled(false);
                    cDownBtn.setEnabled(false);
                    nDownBtn.setEnabled(false);
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
                                    Intent intant = new Intent(HitActivity.this, LevelThreeActivity.class);
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
                        Intent intent = new Intent(HitActivity.this, LevelThreeActivity.class);
                        startActivity(intent);
                        Animatoo.animateSlideRight(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });
        hUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (hUpBtn.getText().toString() == "O") {
                    hUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "I") {
                    hUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "F") {
                    hUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "H") {
                    hUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "E") {
                    hUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "D") {
                    hUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "T") {
                    hUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "C") {
                    hUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "N") {
                    hUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "B") {
                    hUpBtn.setText("");
                    bDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        iUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (iUpBtn.getText().toString() == "O") {
                    iUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "I") {
                    iUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "F") {
                    iUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "H") {
                    iUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "E") {
                    iUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "D") {
                    iUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "T") {
                    iUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "C") {
                    iUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "N") {
                    iUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "B") {
                    iUpBtn.setText("");
                    bDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        tUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (tUpBtn.getText().toString() == "O") {
                    tUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "I") {
                    tUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "F") {
                    tUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "H") {
                    tUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "E") {
                    tUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "D") {
                    tUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "T") {
                    tUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "C") {
                    tUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "N") {
                    tUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (tUpBtn.getText().toString() == "B") {
                    tUpBtn.setText("");
                    bDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        oDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                }
                if(hUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != ""){
                    if((hUpBtn.getText().toString()+iUpBtn.getText().toString()+tUpBtn.getText().toString()).equals("HIT")){
                        setWin();                    }
                    else{
                        Toast.makeText(HitActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        iDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                }
                if(hUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != ""){
                    if((hUpBtn.getText().toString()+iUpBtn.getText().toString()+tUpBtn.getText().toString()).equals("HIT")){
                        setWin();                    }
                    else{
                        Toast.makeText(HitActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        fDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                }
                if(hUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != ""){
                    if((hUpBtn.getText().toString()+iUpBtn.getText().toString()+tUpBtn.getText().toString()).equals("HIT")){
                        setWin();                    }
                    else{
                        Toast.makeText(HitActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        hDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                }
                if(hUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != ""){
                    if((hUpBtn.getText().toString()+iUpBtn.getText().toString()+tUpBtn.getText().toString()).equals("HIT")){
                        setWin();                    }
                    else{
                        Toast.makeText(HitActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        eDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                }
                if(hUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != ""){
                    if((hUpBtn.getText().toString()+iUpBtn.getText().toString()+tUpBtn.getText().toString()).equals("HIT")){
                        setWin();                    }
                    else{
                        Toast.makeText(HitActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                }
                if(hUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != ""){
                    if((hUpBtn.getText().toString()+iUpBtn.getText().toString()+tUpBtn.getText().toString()).equals("HIT")){
                        setWin();                    }
                    else{
                        Toast.makeText(HitActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                }
                if(hUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != ""){
                    if((hUpBtn.getText().toString()+iUpBtn.getText().toString()+tUpBtn.getText().toString()).equals("HIT")){
                        setWin();                    }
                    else{
                        Toast.makeText(HitActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        cDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                }
                if(hUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != ""){
                    if((hUpBtn.getText().toString()+iUpBtn.getText().toString()+tUpBtn.getText().toString()).equals("HIT")){
                        setWin();                    }
                    else{
                        Toast.makeText(HitActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                }
                if(hUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != ""){
                    if((hUpBtn.getText().toString()+iUpBtn.getText().toString()+tUpBtn.getText().toString()).equals("HIT")){
                        setWin();                    }
                    else{
                        Toast.makeText(HitActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        bDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("B");
                    bDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("B");
                    bDownBtn.setVisibility(View.INVISIBLE);
                } else if (tUpBtn.getText().toString() == "") {
                    tUpBtn.setText("B");
                    bDownBtn.setVisibility(View.INVISIBLE);
                }
                if(hUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && tUpBtn.getText().toString() != ""){
                    if((hUpBtn.getText().toString()+iUpBtn.getText().toString()+tUpBtn.getText().toString()).equals("HIT")){
                        setWin();                    }
                    else{
                        Toast.makeText(HitActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
        iUpBtn = findViewById(R.id.iUp_btn);
        tUpBtn = findViewById(R.id.tUp_btn);
        oDownBtn = findViewById(R.id.oDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);
        fDownBtn = findViewById(R.id.fDown_btn);
        hDownBtn = findViewById(R.id.hDown_btn);
        eDownBtn = findViewById(R.id.eDown_btn);
        dDownBtn = findViewById(R.id.dDown_btn);
        tDownBtn = findViewById(R.id.tDown_btn);
        cDownBtn = findViewById(R.id.cDown_btn);
        nDownBtn = findViewById(R.id.nDown_btn);
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
                person.setScore2(person.getArr2()+10);            }
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
        iDownBtn.setVisibility(View.VISIBLE);
        tDownBtn.setVisibility(View.VISIBLE);
        hUpBtn.setEnabled(false);
        iUpBtn.setEnabled(false);
        tUpBtn.setEnabled(false);
        oDownBtn.setEnabled(false);
        iDownBtn.setEnabled(false);
        fDownBtn.setEnabled(false);
        hDownBtn.setEnabled(false);
        eDownBtn.setEnabled(false);
        dDownBtn.setEnabled(false);
        tDownBtn.setEnabled(false);
        cDownBtn.setEnabled(false);
        nDownBtn.setEnabled(false);
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
                        Intent intant =new Intent(HitActivity.this,LevelThreeActivity.class);
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
