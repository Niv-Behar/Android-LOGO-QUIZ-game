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

public class KiaActivity extends AppCompatActivity {
    Person person;
    Button kUpBtn;
    Button iUpBtn;
    Button aUpBtn;
    Button bDownBtn;
    Button cDownBtn;
    Button xDownBtn;
    Button iDownBtn;
    Button eDownBtn;
    Button kDownBtn;
    Button tDownBtn;
    Button aDownBtn;
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
            Intent intent = new Intent(KiaActivity.this, HomeActivity.class);
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(KiaActivity.this, InstructionActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kia_main);

        kUpBtn = findViewById(R.id.kUp_btn);
        iUpBtn = findViewById(R.id.iUp_btn);
        aUpBtn = findViewById(R.id.aUp_btn);
        bDownBtn = findViewById(R.id.bDown_btn);
        cDownBtn = findViewById(R.id.cDown_btn);
        xDownBtn = findViewById(R.id.xDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);
        eDownBtn = findViewById(R.id.eDown_btn);
        kDownBtn = findViewById(R.id.kDown_btn);
        tDownBtn = findViewById(R.id.tDown_btn);
        aDownBtn = findViewById(R.id.aDown_btn);
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
                if (person.getArr2()>=10) {
                    kUpBtn.setText("K");
                    iUpBtn.setText("I");
                    aUpBtn.setText("A");
                    kUpBtn.setEnabled(false);
                    iUpBtn.setEnabled(false);
                    aUpBtn.setEnabled(false);
                    bDownBtn.setEnabled(false);
                    cDownBtn.setEnabled(false);
                    xDownBtn.setEnabled(false);
                    iDownBtn.setEnabled(false);
                    eDownBtn.setEnabled(false);
                    kDownBtn.setEnabled(false);
                    tDownBtn.setEnabled(false);
                    aDownBtn.setEnabled(false);
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
                                    Intent intant = new Intent(KiaActivity.this, LevelThreeActivity.class);
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
                        Intent intent = new Intent(KiaActivity.this, LevelThreeActivity.class);
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
                if (kUpBtn.getText().toString() == "B") {
                    kUpBtn.setText("");
                    bDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "C") {
                    kUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "X") {
                    kUpBtn.setText("");
                    xDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "I") {
                    kUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "E") {
                    kUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "K") {
                    kUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "T") {
                    kUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "A") {
                    kUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "W") {
                    kUpBtn.setText("");
                    wDownBtn.setVisibility(View.VISIBLE);
                } else if (kUpBtn.getText().toString() == "M") {
                    kUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        iUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (iUpBtn.getText().toString() == "B") {
                    iUpBtn.setText("");
                    bDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "C") {
                    iUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "X") {
                    iUpBtn.setText("");
                    xDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "I") {
                    iUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "E") {
                    iUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "K") {
                    iUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "T") {
                    iUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "A") {
                    iUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "W") {
                    iUpBtn.setText("");
                    wDownBtn.setVisibility(View.VISIBLE);
                } else if (iUpBtn.getText().toString() == "M") {
                    iUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        aUpBtn.setOnClickListener(new View.OnClickListener(){ //clear the 'f' btn
            @Override
            public void onClick(View view) {
                if (aUpBtn.getText().toString() == "B") {
                    aUpBtn.setText("");
                    bDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "C") {
                    aUpBtn.setText("");
                    cDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "X") {
                    aUpBtn.setText("");
                    xDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "I") {
                    aUpBtn.setText("");
                    iDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "E") {
                    aUpBtn.setText("");
                    eDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "K") {
                    aUpBtn.setText("");
                    kDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "T") {
                    aUpBtn.setText("");
                    tDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "A") {
                    aUpBtn.setText("");
                    aDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "W") {
                    aUpBtn.setText("");
                    wDownBtn.setVisibility(View.VISIBLE);
                } else if (aUpBtn.getText().toString() == "M") {
                    aUpBtn.setText("");
                    mDownBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        bDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("B");
                    bDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("B");
                    bDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("B");
                    bDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+iUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("KIA")){
                        setWin();                     }
                    else{
                        Toast.makeText(KiaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("C");
                    cDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+iUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("KIA")){
                        setWin();                     }
                    else{
                        Toast.makeText(KiaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        xDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("X");
                    xDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("X");
                    xDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("X");
                    xDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+iUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("KIA")){
                        setWin();                     }
                    else{
                        Toast.makeText(KiaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("I");
                    iDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+iUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("KIA")){
                        setWin();                     }
                    else{
                        Toast.makeText(KiaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("E");
                    eDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+iUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("KIA")){
                        setWin();                     }
                    else{
                        Toast.makeText(KiaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("K");
                    kDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+iUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("KIA")){
                        setWin();                     }
                    else{
                        Toast.makeText(KiaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("T");
                    tDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+iUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("KIA")){
                        setWin();                     }
                    else{
                        Toast.makeText(KiaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        aDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("A");
                    aDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+iUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("KIA")){
                        setWin();                     }
                    else{
                        Toast.makeText(KiaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("W");
                    wDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("W");
                    wDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+iUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("KIA")){
                        setWin();                     }
                    else{
                        Toast.makeText(KiaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
                        MediaPlayer wrong = MediaPlayer.create(view.getContext(), R.raw.wrong);
                        wrong.start();
                    }
                }
            }
        });

        mDownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kUpBtn.getText().toString() == "") {
                    kUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (iUpBtn.getText().toString() == "") {
                    iUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                } else if (aUpBtn.getText().toString() == "") {
                    aUpBtn.setText("M");
                    mDownBtn.setVisibility(View.INVISIBLE);
                }
                if(kUpBtn.getText().toString() != "" && iUpBtn.getText().toString() != "" && aUpBtn.getText().toString() != ""){
                    if((kUpBtn.getText().toString()+iUpBtn.getText().toString()+aUpBtn.getText().toString()).equals("KIA")){
                        setWin();                     }
                    else{
                        Toast.makeText(KiaActivity.this, getString(R.string.not_correct), Toast.LENGTH_SHORT).show();
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
        iUpBtn = findViewById(R.id.iUp_btn);
        aUpBtn = findViewById(R.id.aUp_btn);
        bDownBtn = findViewById(R.id.bDown_btn);
        cDownBtn = findViewById(R.id.cDown_btn);
        xDownBtn = findViewById(R.id.xDown_btn);
        iDownBtn = findViewById(R.id.iDown_btn);
        eDownBtn = findViewById(R.id.eDown_btn);
        kDownBtn = findViewById(R.id.kDown_btn);
        tDownBtn = findViewById(R.id.tDown_btn);
        aDownBtn = findViewById(R.id.aDown_btn);
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
        aDownBtn.setVisibility(View.VISIBLE);
        kUpBtn.setEnabled(false);
        iUpBtn.setEnabled(false);
        aUpBtn.setEnabled(false);
        bDownBtn.setEnabled(false);
        cDownBtn.setEnabled(false);
        xDownBtn.setEnabled(false);
        iDownBtn.setEnabled(false);
        eDownBtn.setEnabled(false);
        kDownBtn.setEnabled(false);
        tDownBtn.setEnabled(false);
        aDownBtn.setEnabled(false);
        wDownBtn.setEnabled(false);
        mDownBtn.setEnabled(false);

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
                        Intent intant =new Intent(KiaActivity.this,LevelThreeActivity.class);
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

