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

public class FcbActivity extends AppCompatActivity {
    Person person;
    Button fUpBtn;
    Button cUpBtn;
    Button bUpBtn;
    Button oDownBtn;
    Button yDownBtn;
    Button fDownBtn;
    Button wDownBtn;
    Button eDownBtn;
    Button dDownBtn;
    Button lDownBtn;
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
            Intent intent = new Intent(FcbActivity.this, HomeActivity.class);
            finish();
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(FcbActivity.this, InstructionActivity.class);
            finish();
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fcb_main);

        fUpBtn = findViewById(R.id.fUp_btn);
        cUpBtn = findViewById(R.id.cUp_btn);
        bUpBtn = findViewById(R.id.bUp_btn);
        oDownBtn = findViewById(R.id.oDown_btn);
        yDownBtn = findViewById(R.id.yDown_btn);
        fDownBtn = findViewById(R.id.fDown_btn);
        wDownBtn = findViewById(R.id.wDown_btn);
        eDownBtn = findViewById(R.id.eDown_btn);
        dDownBtn = findViewById(R.id.dDown_btn);
        lDownBtn = findViewById(R.id.lDown_btn);
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
                if (person.getArr1()>=30) {
                    fUpBtn.setText("F");
                    cUpBtn.setText("C");
                    bUpBtn.setText("B");
                    cUpBtn.setEnabled(false);
                    fUpBtn.setEnabled(false);
                    cUpBtn.setEnabled(false);
                    bUpBtn.setEnabled(false);
                    oDownBtn.setEnabled(false);
                    yDownBtn.setEnabled(false);
                    fDownBtn.setEnabled(false);
                    wDownBtn.setEnabled(false);
                    eDownBtn.setEnabled(false);
                    dDownBtn.setEnabled(false);
                    lDownBtn.setEnabled(false);
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
                                    Intent intant = new Intent(FcbActivity.this, LevelTwoActivity.class);
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
                        Intent intent = new Intent(FcbActivity.this, LevelTwoActivity.class);
                        startActivity(intent);
                        Animatoo.animateSlideRight(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });
        fUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "O") {
                    fUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "Y") {
                    fUpBtn.setText("");
                    yDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "F") {
                    fUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "W") {
                    fUpBtn.setText("");
                    wDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "E") {
                    fUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "D") {
                    fUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "L") {
                    fUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "C") {
                    fUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "N") {
                    fUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (fUpBtn.getText().toString() == "B") {
                    fUpBtn.setText("");
                    bDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        cUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (cUpBtn.getText().toString() == "O") {
                    cUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "Y") {
                    cUpBtn.setText("");
                    yDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "F") {
                    cUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "W") {
                    cUpBtn.setText("");
                    wDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "E") {
                    cUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "D") {
                    cUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "L") {
                    cUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "C") {
                    cUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "N") {
                    cUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (cUpBtn.getText().toString() == "B") {
                    cUpBtn.setText("");
                    bDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        bUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (bUpBtn.getText().toString() == "O") {
                    bUpBtn.setText("");
                    oDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "Y") {
                    bUpBtn.setText("");
                    yDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "F") {
                    bUpBtn.setText("");
                    fDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "W") {
                    bUpBtn.setText("");
                    wDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "E") {
                    bUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "D") {
                    bUpBtn.setText("");
                    dDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "L") {
                    bUpBtn.setText("");
                    lDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "C") {
                    bUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "N") {
                    bUpBtn.setText("");
                    nDownBtn.setVisibility(View.VISIBLE);
                } else if (bUpBtn.getText().toString() == "B") {
                    bUpBtn.setText("");
                    bDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        oDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                } else if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("O");
                    oDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != "" && bUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+cUpBtn.getText().toString()+bUpBtn.getText().toString()).equals("FCB")){
                        setWin();                     }
                    else{
                        Toast.makeText(FcbActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        yDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("Y");
                    yDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("Y");
                    yDownBtn.setVisibility(View.INVISIBLE);
                } else if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("Y");
                    yDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != "" && bUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+cUpBtn.getText().toString()+bUpBtn.getText().toString()).equals("FCB")){
                        setWin();                     }
                    else{
                        Toast.makeText(FcbActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        fDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                } else if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("F");
                    fDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != "" && bUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+cUpBtn.getText().toString()+bUpBtn.getText().toString()).equals("FCB")){
                        setWin();                     }
                    else{
                        Toast.makeText(FcbActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        wDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("W");
                    wDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("W");
                    wDownBtn.setVisibility(View.INVISIBLE);
                } else if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("W");
                    wDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != "" && bUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+cUpBtn.getText().toString()+bUpBtn.getText().toString()).equals("FCB")){
                        setWin();                     }
                    else{
                        Toast.makeText(FcbActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        eDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                } else if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != "" && bUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+cUpBtn.getText().toString()+bUpBtn.getText().toString()).equals("FCB")){
                        setWin();                     }
                    else{
                        Toast.makeText(FcbActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        dDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                } else if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("D");
                    dDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != "" && bUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+cUpBtn.getText().toString()+bUpBtn.getText().toString()).equals("FCB")){
                        setWin();                     }
                    else{
                        Toast.makeText(FcbActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        lDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                } else if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("L");
                    lDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != "" && bUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+cUpBtn.getText().toString()+bUpBtn.getText().toString()).equals("FCB")){
                        setWin();                     }
                    else{
                        Toast.makeText(FcbActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        cDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != "" && bUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+cUpBtn.getText().toString()+bUpBtn.getText().toString()).equals("FCB")){
                        setWin();                     }
                    else{
                        Toast.makeText(FcbActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        nDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                } else if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("N");
                    nDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != "" && bUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+cUpBtn.getText().toString()+bUpBtn.getText().toString()).equals("FCB")){
                        setWin();                     }
                    else{
                        Toast.makeText(FcbActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        bDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fUpBtn.getText().toString() == "") {
                    fUpBtn.setText("B");
                    bDownBtn.setVisibility(View.INVISIBLE);
                } else if (cUpBtn.getText().toString() == "") {
                    cUpBtn.setText("B");
                    bDownBtn.setVisibility(View.INVISIBLE);
                } else if (bUpBtn.getText().toString() == "") {
                    bUpBtn.setText("B");
                    bDownBtn.setVisibility(View.INVISIBLE);
                }
                if(fUpBtn.getText().toString() != "" && cUpBtn.getText().toString() != "" && bUpBtn.getText().toString() != ""){
                    if((fUpBtn.getText().toString()+cUpBtn.getText().toString()+bUpBtn.getText().toString()).equals("FCB")){
                        setWin();                     }
                    else{
                        Toast.makeText(FcbActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
        fUpBtn = findViewById(R.id.fUp_btn);
        cUpBtn = findViewById(R.id.cUp_btn);
        bUpBtn = findViewById(R.id.bUp_btn);
        oDownBtn = findViewById(R.id.oDown_btn);
        yDownBtn = findViewById(R.id.yDown_btn);
        fDownBtn = findViewById(R.id.fDown_btn);
        wDownBtn = findViewById(R.id.wDown_btn);
        eDownBtn = findViewById(R.id.eDown_btn);
        dDownBtn = findViewById(R.id.dDown_btn);
        lDownBtn = findViewById(R.id.lDown_btn);
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
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(person!=null) {
                person.setScore1(person.getArr1()+10);            }
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
        fDownBtn.setVisibility(View.VISIBLE);
        cDownBtn.setVisibility(View.VISIBLE);
        bDownBtn.setVisibility(View.VISIBLE);
        cUpBtn.setEnabled(false);
        fUpBtn.setEnabled(false);
        cUpBtn.setEnabled(false);
        bUpBtn.setEnabled(false);
        oDownBtn.setEnabled(false);
        yDownBtn.setEnabled(false);
        fDownBtn.setEnabled(false);
        wDownBtn.setEnabled(false);
        eDownBtn.setEnabled(false);
        dDownBtn.setEnabled(false);
        lDownBtn.setEnabled(false);
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
                        Intent intant =new Intent(FcbActivity.this,LevelTwoActivity.class);
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
