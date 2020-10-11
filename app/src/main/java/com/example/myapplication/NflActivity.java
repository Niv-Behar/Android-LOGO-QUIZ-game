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

public class NflActivity extends AppCompatActivity {
    Person person;
    Button nUpBtn;
    Button fUpBtn;
    Button lUpBtn;
    Button zDownBtn;
    Button oDownBtn;
    Button cDownBtn;
    Button lDownBtn;
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
            Intent intent = new Intent(NflActivity.this, HomeActivity.class);
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(NflActivity.this, InstructionActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nfl_main);

        nUpBtn = findViewById(R.id.nUp_btn);
        fUpBtn = findViewById(R.id.fUp_btn);
        lUpBtn = findViewById(R.id.lUp_btn);
        zDownBtn = findViewById(R.id.zDown_btn);
        oDownBtn = findViewById(R.id.oDown_btn);
        cDownBtn = findViewById(R.id.cDown_btn);
        lDownBtn = findViewById(R.id.lDown_btn);
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
                if (person.getArr2()>=50) {
                    nUpBtn.setText("N");
                    fUpBtn.setText("F");
                    lUpBtn.setText("L");
                    nUpBtn.setEnabled(false);
                    fUpBtn.setEnabled(false);
                    lUpBtn.setEnabled(false);
                    zDownBtn.setEnabled(false);
                    oDownBtn.setEnabled(false);
                    cDownBtn.setEnabled(false);
                    lDownBtn.setEnabled(false);
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
                                    Intent intant = new Intent(NflActivity.this, LevelThreeActivity.class);
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
                        Intent intent = new Intent(NflActivity.this, LevelThreeActivity.class);
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
                if (nUpBtn.getText().toString() == "Z") {
                    nUpBtn.setText("");
                    zDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "O") {
                    nUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "C") {
                    nUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "L") {
                    nUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "V") {
                    nUpBtn.setText("");
                    vDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "F") {
                    nUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "W") {
                    nUpBtn.setText("");
                    wDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "N") {
                    nUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "K") {
                    nUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "U") {
                    nUpBtn.setText("");
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
                } else if (fUpBtn.getText().toString() == "L") {
                    fUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
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

        lUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (lUpBtn.getText().toString() == "Z") {
                    lUpBtn.setText("");
                    zDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "O") {
                    lUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "C") {
                    lUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "L") {
                    lUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "V") {
                    lUpBtn.setText("");
                    vDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "F") {
                    lUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "W") {
                    lUpBtn.setText("");
                    wDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "N") {
                    lUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "K") {
                    lUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (lUpBtn.getText().toString() == "U") {
                    lUpBtn.setText("");
                    uDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        zDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("Z");
                    zDownBtn.setVisibility(View.INVISIBLE);
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("Z");
                    zDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("Z");
                    zDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+fUpBtn.getText().toString()+lUpBtn.getText().toString()).equals("NFL")){
                        setWin();                     }
                    else{
                        Toast.makeText(NflActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        oDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+fUpBtn.getText().toString()+lUpBtn.getText().toString()).equals("NFL")){
                        setWin();                     }
                    else{
                        Toast.makeText(NflActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        cDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+fUpBtn.getText().toString()+lUpBtn.getText().toString()).equals("NFL")){
                        setWin();                     }
                    else{
                        Toast.makeText(NflActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+fUpBtn.getText().toString()+lUpBtn.getText().toString()).equals("NFL")){
                        setWin();                     }
                    else{
                        Toast.makeText(NflActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        vDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("V");
                    vDownBtn.setVisibility(View.INVISIBLE);
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("V");
                    vDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("V");
                    vDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+fUpBtn.getText().toString()+lUpBtn.getText().toString()).equals("NFL")){
                        setWin();                     }
                    else{
                        Toast.makeText(NflActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+fUpBtn.getText().toString()+lUpBtn.getText().toString()).equals("NFL")){
                        setWin();                     }
                    else{
                        Toast.makeText(NflActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("W");
                    wDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("W");
                    wDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+fUpBtn.getText().toString()+lUpBtn.getText().toString()).equals("NFL")){
                        setWin();                     }
                    else{
                        Toast.makeText(NflActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+fUpBtn.getText().toString()+lUpBtn.getText().toString()).equals("NFL")){
                        setWin();                     }
                    else{
                        Toast.makeText(NflActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+fUpBtn.getText().toString()+lUpBtn.getText().toString()).equals("NFL")){
                        setWin();                     }
                    else{
                        Toast.makeText(NflActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                } else if (lUpBtn.getText().toString() == "") {
                    lUpBtn.setText("U");
                    uDownBtn.setVisibility(View.INVISIBLE);
                }
                if(nUpBtn.getText().toString() != "" && fUpBtn.getText().toString() != "" && lUpBtn.getText().toString() != ""){
                    if((nUpBtn.getText().toString()+fUpBtn.getText().toString()+lUpBtn.getText().toString()).equals("NFL")){
                        setWin();                     }
                    else{
                        Toast.makeText(NflActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
        fUpBtn = findViewById(R.id.fUp_btn);
        lUpBtn = findViewById(R.id.lUp_btn);
        zDownBtn = findViewById(R.id.zDown_btn);
        oDownBtn = findViewById(R.id.oDown_btn);
        cDownBtn = findViewById(R.id.cDown_btn);
        lDownBtn = findViewById(R.id.lDown_btn);
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
                person.setScore2(person.getArr2()+10);
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
        fDownBtn.setVisibility(View.VISIBLE);
        lDownBtn.setVisibility(View.VISIBLE);
        nUpBtn.setEnabled(false);
        fUpBtn.setEnabled(false);
        lUpBtn.setEnabled(false);
        zDownBtn.setEnabled(false);
        oDownBtn.setEnabled(false);
        cDownBtn.setEnabled(false);
        lDownBtn.setEnabled(false);
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
                        Intent intant =new Intent(NflActivity.this,LevelThreeActivity.class);
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

