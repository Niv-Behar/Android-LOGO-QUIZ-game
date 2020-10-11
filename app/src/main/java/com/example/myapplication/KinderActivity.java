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
import java.nio.file.WatchEvent;

public class KinderActivity extends AppCompatActivity {
    Person person;
    Button kUpBtn;
    Button iUpBtn;
    Button nUpBtn;
    Button dUpBtn;
    Button eUpBtn;
    Button rUpBtn;
    Button kDownBtn;
    Button yDownBtn;
    Button tDownBtn;
    Button iDownBtn;
    Button eDownBtn;
    Button dDownBtn;
    Button lDownBtn;
    Button rDownBtn;
    Button nDownBtn;
    Button sDownBtn;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.main_page){
            Intent intent = new Intent(KinderActivity.this, HomeActivity.class);
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(KinderActivity.this, InstructionActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kinder_main);

        kUpBtn = findViewById(R.id.kUp_btn);
        iUpBtn = findViewById(R.id.iUp_btn);
        nUpBtn = findViewById(R.id.nUp_btn);
        dUpBtn = findViewById(R.id.dUp_btn);
        eUpBtn = findViewById(R.id.eUp_btn);
        rUpBtn = findViewById(R.id.rUp_btn);
        kDownBtn = findViewById(R.id.kDown_btn);
        yDownBtn = findViewById(R.id.yDown_btn);
        tDownBtn = findViewById(R.id.tDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);
        eDownBtn = findViewById(R.id.eDown_btn);
        dDownBtn = findViewById(R.id.dDown_btn);
        lDownBtn = findViewById(R.id.lDown_btn);
        rDownBtn = findViewById(R.id.rDown_btn);
        nDownBtn = findViewById(R.id.nDown_btn);
        sDownBtn = findViewById(R.id.sDown_btn);
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
                    kUpBtn.setText("K");
                    iUpBtn.setText("I");
                    nUpBtn.setText("N");
                    dUpBtn.setText("D");
                    eUpBtn.setText("E");
                    rUpBtn.setText("R");
                    kUpBtn.setEnabled(false);
                    iUpBtn.setEnabled(false);
                    nUpBtn.setEnabled(false);
                    dUpBtn.setEnabled(false);
                    eUpBtn.setEnabled(false);
                    rUpBtn.setEnabled(false);
                    kDownBtn.setEnabled(false);
                    yDownBtn.setEnabled(false);
                    tDownBtn.setEnabled(false);
                    iDownBtn.setEnabled(false);
                    eDownBtn.setEnabled(false);
                    dDownBtn.setEnabled(false);
                    lDownBtn.setEnabled(false);
                    rDownBtn.setEnabled(false);
                    nDownBtn.setEnabled(false);
                    sDownBtn.setEnabled(false);
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
                                    Intent intant = new Intent(KinderActivity.this, LevelThreeActivity.class);
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
                        Intent intent = new Intent(KinderActivity.this, LevelThreeActivity.class);
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
                if (kUpBtn.getText().toString() == "K") {
                    kUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "Y") {
                    kUpBtn.setText("");
                    yDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "T") {
                    kUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "I") {
                    kUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "E") {
                    kUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "D") {
                    kUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "L") {
                    kUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "R") {
                    kUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "N") {
                    kUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "S") {
                    kUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        iUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (iUpBtn.getText().toString() == "K") {
                    iUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "Y") {
                    iUpBtn.setText("");
                    yDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "T") {
                    iUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "I") {
                    iUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "E") {
                    iUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "D") {
                    iUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "L") {
                    iUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "R") {
                    iUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "N") {
                    iUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "S") {
                    iUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        nUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (nUpBtn.getText().toString() == "K") {
                    nUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "Y") {
                    nUpBtn.setText("");
                    yDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "T") {
                    nUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "I") {
                    nUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "E") {
                    nUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "D") {
                    nUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "L") {
                    nUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "R") {
                    nUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "N") {
                    nUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (nUpBtn.getText().toString() == "S") {
                    nUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        dUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (dUpBtn.getText().toString() == "K") {
                    dUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "Y") {
                    dUpBtn.setText("");
                    yDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "T") {
                    dUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "I") {
                    dUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "E") {
                    dUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "D") {
                    dUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "L") {
                    dUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "R") {
                    dUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "N") {
                    dUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (dUpBtn.getText().toString() == "S") {
                    dUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        eUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (eUpBtn.getText().toString() == "K") {
                    eUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "Y") {
                    eUpBtn.setText("");
                    yDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "T") {
                    eUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "I") {
                    eUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "E") {
                    eUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "D") {
                    eUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "L") {
                    eUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "R") {
                    eUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "N") {
                    eUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "S") {
                    eUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        rUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (rUpBtn.getText().toString() == "K") {
                    rUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "Y") {
                    rUpBtn.setText("");
                    yDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "T") {
                    rUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "I") {
                    rUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "E") {
                    rUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "D") {
                    rUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "L") {
                    rUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "R") {
                    rUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "N") {
                    rUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "S") {
                    rUpBtn.setText("");
                    sDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        kDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                } else if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && nUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+iUpBtn.getText().toString()+nUpBtn.getText().toString()+dUpBtn.getText().toString()+eUpBtn.getText().toString()+rUpBtn.getText().toString()).equals("KINDER")){
                        setWin();                     }
                    else{
                        Toast.makeText(KinderActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        yDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("Y");
                    yDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("Y");
                    yDownBtn.setVisibility(View.INVISIBLE);
                } else if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("Y");
                    yDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("Y");
                    yDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("Y");
                    yDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("Y");
                    yDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && nUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+iUpBtn.getText().toString()+nUpBtn.getText().toString()+dUpBtn.getText().toString()+eUpBtn.getText().toString()+rUpBtn.getText().toString()).equals("KINDER")){
                        setWin();                     }
                    else{
                        Toast.makeText(KinderActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        tDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && nUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+iUpBtn.getText().toString()+nUpBtn.getText().toString()+dUpBtn.getText().toString()+eUpBtn.getText().toString()+rUpBtn.getText().toString()).equals("KINDER")){
                        setWin();                     }
                    else{
                        Toast.makeText(KinderActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        iDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && nUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+iUpBtn.getText().toString()+nUpBtn.getText().toString()+dUpBtn.getText().toString()+eUpBtn.getText().toString()+rUpBtn.getText().toString()).equals("KINDER")){
                        setWin();                     }
                    else{
                        Toast.makeText(KinderActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        eDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && nUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+iUpBtn.getText().toString()+nUpBtn.getText().toString()+dUpBtn.getText().toString()+eUpBtn.getText().toString()+rUpBtn.getText().toString()).equals("KINDER")){
                        setWin();                     }
                    else{
                        Toast.makeText(KinderActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        dDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && nUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+iUpBtn.getText().toString()+nUpBtn.getText().toString()+dUpBtn.getText().toString()+eUpBtn.getText().toString()+rUpBtn.getText().toString()).equals("KINDER")){
                        setWin();                     }
                    else{
                        Toast.makeText(KinderActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        lDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && nUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+iUpBtn.getText().toString()+nUpBtn.getText().toString()+dUpBtn.getText().toString()+eUpBtn.getText().toString()+rUpBtn.getText().toString()).equals("KINDER")){
                        setWin();                     }
                    else{
                        Toast.makeText(KinderActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        rDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && nUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+iUpBtn.getText().toString()+nUpBtn.getText().toString()+dUpBtn.getText().toString()+eUpBtn.getText().toString()+rUpBtn.getText().toString()).equals("KINDER")){
                        setWin();                     }
                    else{
                        Toast.makeText(KinderActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && nUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+iUpBtn.getText().toString()+nUpBtn.getText().toString()+dUpBtn.getText().toString()+eUpBtn.getText().toString()+rUpBtn.getText().toString()).equals("KINDER")){
                        setWin();                     }
                    else{
                        Toast.makeText(KinderActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        sDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (nUpBtn.getText().toString() == "") {
                    nUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (dUpBtn.getText().toString() == "") {
                    dUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("S");
                    sDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && nUpBtn.getText().toString() != "" && dUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+iUpBtn.getText().toString()+nUpBtn.getText().toString()+dUpBtn.getText().toString()+eUpBtn.getText().toString()+rUpBtn.getText().toString()).equals("KINDER")){
                        setWin();                     }
                    else{
                        Toast.makeText(KinderActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
        iUpBtn = findViewById(R.id.iUp_btn);
        nUpBtn = findViewById(R.id.nUp_btn);
        dUpBtn = findViewById(R.id.dUp_btn);
        eUpBtn = findViewById(R.id.eUp_btn);
        rUpBtn = findViewById(R.id.rUp_btn);
        kDownBtn = findViewById(R.id.kDown_btn);
        yDownBtn = findViewById(R.id.yDown_btn);
        tDownBtn = findViewById(R.id.tDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);
        eDownBtn = findViewById(R.id.eDown_btn);
        dDownBtn = findViewById(R.id.dDown_btn);
        lDownBtn = findViewById(R.id.lDown_btn);
        rDownBtn = findViewById(R.id.rDown_btn);
        nDownBtn = findViewById(R.id.nDown_btn);
        sDownBtn = findViewById(R.id.sDown_btn);
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
        kDownBtn.setVisibility(View.VISIBLE);
        iDownBtn.setVisibility(View.VISIBLE);
        nDownBtn.setVisibility(View.VISIBLE);
        dDownBtn.setVisibility(View.VISIBLE);
        eDownBtn.setVisibility(View.VISIBLE);
        rDownBtn.setVisibility(View.VISIBLE);
        kUpBtn.setEnabled(false);
        iUpBtn.setEnabled(false);
        nUpBtn.setEnabled(false);
        dUpBtn.setEnabled(false);
        eUpBtn.setEnabled(false);
        rUpBtn.setEnabled(false);
        kDownBtn.setEnabled(false);
        yDownBtn.setEnabled(false);
        tDownBtn.setEnabled(false);
        iDownBtn.setEnabled(false);
        eDownBtn.setEnabled(false);
        dDownBtn.setEnabled(false);
        lDownBtn.setEnabled(false);
        rDownBtn.setEnabled(false);
        nDownBtn.setEnabled(false);
        sDownBtn.setEnabled(false);

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
                        Intent intant =new Intent(KinderActivity.this,LevelThreeActivity.class);
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

