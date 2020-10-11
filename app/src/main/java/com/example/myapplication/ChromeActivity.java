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

public class ChromeActivity extends AppCompatActivity {
     Person person;
     Button cUpBtn;
     Button hUpBtn;
     Button rUpBtn;
     Button oUpBtn;
     Button mUpBtn;
     Button eUpBtn;

     Button mDownBtn;
     Button aDownBtn;
     Button rDownBtn;
     Button iDownBtn;
     Button cDownBtn;
     Button oDownBtn;
     Button hDownBtn;
     Button fDownBtn;
     Button eDownBtn;
     Button xDownBtn;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.main_page){
            Intent intent = new Intent(ChromeActivity.this, HomeActivity.class);
            finish();
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(ChromeActivity.this, InstructionActivity.class);
            finish();
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chrome_main);

          cUpBtn = findViewById(R.id.cUp_btn);
          hUpBtn = findViewById(R.id.hUp_btn);
          rUpBtn = findViewById(R.id.rUp_btn);
          oUpBtn = findViewById(R.id.oUp_btn);
          mUpBtn = findViewById(R.id.mUp_btn);
          eUpBtn = findViewById(R.id.eUp_btn);

          mDownBtn = findViewById(R.id.mDown_btn);
          aDownBtn = findViewById(R.id.aDown_btn);
          rDownBtn = findViewById(R.id.rDown_btn);
          iDownBtn = findViewById(R.id.iDown_btn);
          cDownBtn = findViewById(R.id.cDown_btn);
          oDownBtn = findViewById(R.id.oDown_btn);
          hDownBtn = findViewById(R.id.hDown_btn);
          fDownBtn = findViewById(R.id.fDown_btn);
          eDownBtn = findViewById(R.id.eDown_btn);
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
                if (person.getArr()>=95) {
                    cUpBtn.setText("C");
                    hUpBtn.setText("H");
                    rUpBtn.setText("R");
                    oUpBtn.setText("O");
                    mUpBtn.setText("M");
                    eUpBtn.setText("E");
                    cUpBtn.setEnabled(false);
                    hUpBtn.setEnabled(false);
                    rUpBtn.setEnabled(false);
                    oUpBtn.setEnabled(false);
                    mUpBtn.setEnabled(false);
                    eUpBtn.setEnabled(false);
                    mDownBtn.setEnabled(false);
                    aDownBtn.setEnabled(false);
                    rDownBtn.setEnabled(false);
                    iDownBtn.setEnabled(false);
                    cDownBtn.setEnabled(false);
                    oDownBtn.setEnabled(false);
                    hDownBtn.setEnabled(false);
                    fDownBtn.setEnabled(false);
                    eDownBtn.setEnabled(false);
                    xDownBtn.setEnabled(false);
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
                                    Intent intant = new Intent(ChromeActivity.this, LevelTwoActivity.class);
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
                        Intent intent = new Intent(ChromeActivity.this, LevelOneActivity.class);
                        startActivity(intent);
                        Animatoo.animateSlideRight(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });
        cUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (cUpBtn.getText().toString() == "M") {
                    cUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "A") {
                    cUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "R") {
                    cUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "I") {
                    cUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "C") {
                    cUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "O") {
                    cUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "H") {
                    cUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "F") {
                    cUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "E") {
                    cUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "X") {
                    cUpBtn.setText("");
                    xDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        hUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (hUpBtn.getText().toString() == "M") {
                    hUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "A") {
                    hUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "R") {
                    hUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "I") {
                    hUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "C") {
                    hUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "O") {
                    hUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "H") {
                    hUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "F") {
                    hUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "E") {
                    hUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (hUpBtn.getText().toString() == "X") {
                    hUpBtn.setText("");
                    xDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        rUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (rUpBtn.getText().toString() == "M") {
                    rUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "A") {
                    rUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "R") {
                    rUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "I") {
                    rUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "C") {
                    rUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "O") {
                    rUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "H") {
                    rUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "F") {
                    rUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "E") {
                    rUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (rUpBtn.getText().toString() == "X") {
                    rUpBtn.setText("");
                    xDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        oUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (oUpBtn.getText().toString() == "M") {
                    oUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "A") {
                    oUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "R") {
                    oUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "I") {
                    oUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "C") {
                    oUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "O") {
                    oUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "H") {
                    oUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "F") {
                    oUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "E") {
                    oUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (oUpBtn.getText().toString() == "X") {
                    oUpBtn.setText("");
                    xDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        mUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (mUpBtn.getText().toString() == "M") {
                    mUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "A") {
                    mUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "R") {
                    mUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "I") {
                    mUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "C") {
                    mUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "O") {
                    mUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "H") {
                    mUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "F") {
                    mUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "E") {
                    mUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (mUpBtn.getText().toString() == "X") {
                    mUpBtn.setText("");
                    xDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        eUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (eUpBtn.getText().toString() == "M") {
                    eUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "A") {
                    eUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "R") {
                    eUpBtn.setText("");
                    rDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "I") {
                    eUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "C") {
                    eUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "O") {
                    eUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "H") {
                    eUpBtn.setText("");
                    hDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "F") {
                    eUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "E") {
                    eUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (eUpBtn.getText().toString() == "X") {
                    eUpBtn.setText("");
                    xDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        mDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                }
                if(cUpBtn.getText().toString() != "" && hUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((cUpBtn.getText().toString()+hUpBtn.getText().toString()+rUpBtn.getText().toString()+oUpBtn.getText().toString()+mUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("CHROME")){
                        setWin();                     }
                    else{
                        Toast.makeText(ChromeActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        aDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                }
                if(cUpBtn.getText().toString() != "" && hUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((cUpBtn.getText().toString()+hUpBtn.getText().toString()+rUpBtn.getText().toString()+oUpBtn.getText().toString()+mUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("CHROME")){
                        setWin();                     }
                    else{
                        Toast.makeText(ChromeActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        rDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("R");
                    rDownBtn.setVisibility(View.INVISIBLE);
                }
                if(cUpBtn.getText().toString() != "" && hUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((cUpBtn.getText().toString()+hUpBtn.getText().toString()+rUpBtn.getText().toString()+oUpBtn.getText().toString()+mUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("CHROME")){
                        setWin();                     }
                    else{
                        Toast.makeText(ChromeActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        iDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                }
                if(cUpBtn.getText().toString() != "" && hUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((cUpBtn.getText().toString()+hUpBtn.getText().toString()+rUpBtn.getText().toString()+oUpBtn.getText().toString()+mUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("CHROME")){
                        setWin();                     }
                    else{
                        Toast.makeText(ChromeActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        cDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                }
                if(cUpBtn.getText().toString() != "" && hUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((cUpBtn.getText().toString()+hUpBtn.getText().toString()+rUpBtn.getText().toString()+oUpBtn.getText().toString()+mUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("CHROME")){
                        setWin();                     }
                    else{
                        Toast.makeText(ChromeActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        oDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                }
                if(cUpBtn.getText().toString() != "" && hUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((cUpBtn.getText().toString()+hUpBtn.getText().toString()+rUpBtn.getText().toString()+oUpBtn.getText().toString()+mUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("CHROME")){
                        setWin();                     }
                    else{
                        Toast.makeText(ChromeActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        hDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("H");
                    hDownBtn.setVisibility(View.INVISIBLE);
                }
                if(cUpBtn.getText().toString() != "" && hUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((cUpBtn.getText().toString()+hUpBtn.getText().toString()+rUpBtn.getText().toString()+oUpBtn.getText().toString()+mUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("CHROME")){
                        setWin();                     }
                    else{
                        Toast.makeText(ChromeActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        fDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                }
                if(cUpBtn.getText().toString() != "" && hUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((cUpBtn.getText().toString()+hUpBtn.getText().toString()+rUpBtn.getText().toString()+oUpBtn.getText().toString()+mUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("CHROME")){
                        setWin();                     }
                    else{
                        Toast.makeText(ChromeActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        eDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                }
                if(cUpBtn.getText().toString() != "" && hUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((cUpBtn.getText().toString()+hUpBtn.getText().toString()+rUpBtn.getText().toString()+oUpBtn.getText().toString()+mUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("CHROME")){
                        setWin();                     }
                    else{
                        Toast.makeText(ChromeActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        xDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("X");
                    xDownBtn.setVisibility(View.INVISIBLE);
                } else if (hUpBtn.getText().toString() == "") {
                    hUpBtn.setText("X");
                    xDownBtn.setVisibility(View.INVISIBLE);
                } else if (rUpBtn.getText().toString() == "") {
                    rUpBtn.setText("X");
                    xDownBtn.setVisibility(View.INVISIBLE);
                } else if (oUpBtn.getText().toString() == "") {
                    oUpBtn.setText("X");
                    xDownBtn.setVisibility(View.INVISIBLE);
                } else if (mUpBtn.getText().toString() == "") {
                    mUpBtn.setText("X");
                    xDownBtn.setVisibility(View.INVISIBLE);
                } else if (eUpBtn.getText().toString() == "") {
                    eUpBtn.setText("X");
                    xDownBtn.setVisibility(View.INVISIBLE);
                }
                if(cUpBtn.getText().toString() != "" && hUpBtn.getText().toString() != "" && rUpBtn.getText().toString() != "" && oUpBtn.getText().toString() != "" && mUpBtn.getText().toString() != "" && eUpBtn.getText().toString() != ""){
                    if((cUpBtn.getText().toString()+hUpBtn.getText().toString()+rUpBtn.getText().toString()+oUpBtn.getText().toString()+mUpBtn.getText().toString()+eUpBtn.getText().toString()).equals("CHROME")){
                        setWin();                     }
                    else{
                        Toast.makeText(ChromeActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
        cUpBtn = findViewById(R.id.cUp_btn);
        hUpBtn = findViewById(R.id.hUp_btn);
        rUpBtn = findViewById(R.id.rUp_btn);
        oUpBtn = findViewById(R.id.oUp_btn);
        mUpBtn = findViewById(R.id.mUp_btn);
        eUpBtn = findViewById(R.id.eUp_btn);

        mDownBtn = findViewById(R.id.mDown_btn);
        aDownBtn = findViewById(R.id.aDown_btn);
        rDownBtn = findViewById(R.id.rDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);
        cDownBtn = findViewById(R.id.cDown_btn);
        oDownBtn = findViewById(R.id.oDown_btn);
        hDownBtn = findViewById(R.id.hDown_btn);
        fDownBtn = findViewById(R.id.fDown_btn);
        eDownBtn = findViewById(R.id.eDown_btn);
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
                person.setScore(person.getArr()+20);
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
        cDownBtn.setVisibility(View.VISIBLE);
        hDownBtn.setVisibility(View.VISIBLE);
        rDownBtn.setVisibility(View.VISIBLE);
        oDownBtn.setVisibility(View.VISIBLE);
        mDownBtn.setVisibility(View.VISIBLE);
        eDownBtn.setVisibility(View.VISIBLE);
        cUpBtn.setEnabled(false);
        hUpBtn.setEnabled(false);
        rUpBtn.setEnabled(false);
        oUpBtn.setEnabled(false);
        mUpBtn.setEnabled(false);
        eUpBtn.setEnabled(false);
        mDownBtn.setEnabled(false);
        aDownBtn.setEnabled(false);
        rDownBtn.setEnabled(false);
        iDownBtn.setEnabled(false);
        cDownBtn.setEnabled(false);
        oDownBtn.setEnabled(false);
        hDownBtn.setEnabled(false);
        fDownBtn.setEnabled(false);
        eDownBtn.setEnabled(false);
        xDownBtn.setEnabled(false);

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
                        Intent intant =new Intent(ChromeActivity.this,LevelTwoActivity.class);
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
