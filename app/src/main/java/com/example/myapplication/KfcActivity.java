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

public class KfcActivity extends AppCompatActivity {
    Person person;
    Button kUpBtn;
    Button fUpBtn;
    Button cUpBtn;
    Button zDownBtn;
    Button oDownBtn;
    Button cDownBtn;
    Button pDownBtn;
    Button vDownBtn;
    Button fDownBtn;
    Button wDownBtn;
    Button nDownBtn;
    Button kDownBtn;
    Button uDownBtn;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.main_page){
            Intent intent = new Intent(KfcActivity.this, HomeActivity.class);
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(KfcActivity.this, InstructionActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kfc_main);

        kUpBtn = findViewById(R.id.kUp_btn);
        fUpBtn = findViewById(R.id.fUp_btn);
        cUpBtn = findViewById(R.id.cUp_btn);
        zDownBtn = findViewById(R.id.zDown_btn);
        oDownBtn = findViewById(R.id.oDown_btn);
        cDownBtn = findViewById(R.id.cDown_btn);
        pDownBtn = findViewById(R.id.pDown_btn);
        vDownBtn = findViewById(R.id.vDown_btn);
        fDownBtn = findViewById(R.id.fDown_btn);
        wDownBtn = findViewById(R.id.wDown_btn);
        nDownBtn = findViewById(R.id.nDown_btn);
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
                if (person.getArr1()>=20) {
                    kUpBtn.setText("K");
                    fUpBtn.setText("F");
                    cUpBtn.setText("C");
                    kUpBtn.setEnabled(false);
                    fUpBtn.setEnabled(false);
                    cUpBtn.setEnabled(false);
                    zDownBtn.setEnabled(false);
                    oDownBtn.setEnabled(false);
                    cDownBtn.setEnabled(false);
                    pDownBtn.setEnabled(false);
                    vDownBtn.setEnabled(false);
                    fDownBtn.setEnabled(false);
                    wDownBtn.setEnabled(false);
                    nDownBtn.setEnabled(false);
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
                                    Intent intant = new Intent(KfcActivity.this, LevelTwoActivity.class);
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
                        Intent intent = new Intent(KfcActivity.this, LevelTwoActivity.class);
                        startActivity(intent);
                        Animatoo.animateSlideRight(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });
        kUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (kUpBtn.getText().toString() == "Z") {
                    kUpBtn.setText("");
                    zDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "O") {
                    kUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "C") {
                    kUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "P") {
                    kUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "V") {
                    kUpBtn.setText("");
                    vDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "F") {
                    kUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "W") {
                    kUpBtn.setText("");
                    wDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "N") {
                    kUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "K") {
                    kUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "U") {
                    kUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        fUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "Z") {
                    fUpBtn.setText("");
                    zDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "O") {
                    fUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "C") {
                    fUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "P") {
                    fUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "V") {
                    fUpBtn.setText("");
                    vDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "F") {
                    fUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "W") {
                    fUpBtn.setText("");
                    wDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "N") {
                    fUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "K") {
                    fUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "U") {
                    fUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        cUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (cUpBtn.getText().toString() == "Z") {
                    cUpBtn.setText("");
                    zDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "O") {
                    cUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "C") {
                    cUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "P") {
                    cUpBtn.setText("");
                    pDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "V") {
                    cUpBtn.setText("");
                    vDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "F") {
                    cUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "W") {
                    cUpBtn.setText("");
                    wDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "N") {
                    cUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "K") {
                    cUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "U") {
                    cUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        zDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("Z");
                    zDownBtn.setVisibility(View.INVISIBLE);
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("Z");
                    zDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("Z");
                    zDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+fUpBtn.getText().toString()+cUpBtn.getText().toString()).equals("KFC")){
                        setWin();                     }
                    else{
                        Toast.makeText(KfcActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        oDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+fUpBtn.getText().toString()+cUpBtn.getText().toString()).equals("KFC")){
                        setWin();                     }
                    else{
                        Toast.makeText(KfcActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        cDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+fUpBtn.getText().toString()+cUpBtn.getText().toString()).equals("KFC")){
                        setWin();                     }
                    else{
                        Toast.makeText(KfcActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        pDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("P");
                    pDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+fUpBtn.getText().toString()+cUpBtn.getText().toString()).equals("KFC")){
                        setWin();                     }
                    else{
                        Toast.makeText(KfcActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        vDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("V");
                    vDownBtn.setVisibility(View.INVISIBLE);
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("V");
                    vDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("V");
                    vDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+fUpBtn.getText().toString()+cUpBtn.getText().toString()).equals("KFC")){
                        setWin();                     }
                    else{
                        Toast.makeText(KfcActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        fDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+fUpBtn.getText().toString()+cUpBtn.getText().toString()).equals("KFC")){
                        setWin();
                    }
                    else{
                        Toast.makeText(KfcActivity.this, getString(R.string.correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        wDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("W");
                    wDownBtn.setVisibility(View.INVISIBLE);
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("W");
                    wDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("W");
                    wDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+fUpBtn.getText().toString()+cUpBtn.getText().toString()).equals("KFC")){
                        setWin();                     }
                    else{
                        Toast.makeText(KfcActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        nDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+fUpBtn.getText().toString()+cUpBtn.getText().toString()).equals("KFC")){
                        setWin();                     }
                    else{
                        Toast.makeText(KfcActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        kDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+fUpBtn.getText().toString()+cUpBtn.getText().toString()).equals("KFC")){
                        setWin();                     }
                    else{
                        Toast.makeText(KfcActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        uDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+fUpBtn.getText().toString()+cUpBtn.getText().toString()).equals("KFC")){
                        setWin();                     }
                    else{
                        Toast.makeText(KfcActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
        kUpBtn = findViewById(R.id.kUp_btn);
        fUpBtn = findViewById(R.id.fUp_btn);
        cUpBtn = findViewById(R.id.cUp_btn);
        zDownBtn = findViewById(R.id.zDown_btn);
        oDownBtn = findViewById(R.id.oDown_btn);
        cDownBtn = findViewById(R.id.cDown_btn);
        pDownBtn = findViewById(R.id.pDown_btn);
        vDownBtn = findViewById(R.id.vDown_btn);
        fDownBtn = findViewById(R.id.fDown_btn);
        wDownBtn = findViewById(R.id.wDown_btn);
        nDownBtn = findViewById(R.id.nDown_btn);
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
        kDownBtn.setVisibility(View.VISIBLE);
        fDownBtn.setVisibility(View.VISIBLE);
        cDownBtn.setVisibility(View.VISIBLE);
        kUpBtn.setEnabled(false);
        fUpBtn.setEnabled(false);
        cUpBtn.setEnabled(false);
        zDownBtn.setEnabled(false);
        oDownBtn.setEnabled(false);
        cDownBtn.setEnabled(false);
        pDownBtn.setEnabled(false);
        vDownBtn.setEnabled(false);
        fDownBtn.setEnabled(false);
        wDownBtn.setEnabled(false);
        nDownBtn.setEnabled(false);
        kDownBtn.setEnabled(false);
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
                        Intent intant =new Intent(KfcActivity.this,LevelTwoActivity.class);
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

