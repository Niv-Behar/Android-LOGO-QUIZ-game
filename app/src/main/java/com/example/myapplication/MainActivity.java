package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MainActivity extends AppCompatActivity implements com.example.myapplication.Dialog.ExampleDialogListener {
    Person person;
    int score;
    HomeWatcher mHomeWatcher;
    SharedPreferences sp;
    Button snd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.steps_layout);

        Button button1 = findViewById(R.id.one);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Animation animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.btn);
                animation.setDuration(300);
                Bounce bounce = new Bounce(0.5, 20);
                animation.setInterpolator(bounce);
                view.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer back_btn = MediaPlayer.create(view.getContext(), R.raw.slide);
                        back_btn.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intant = new Intent(MainActivity.this, LevelOneActivity.class);
                        finish();
                        startActivity(intant);
                        Animatoo.animateFade(view.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
        Button button2 = findViewById(R.id.one1);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Animation animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.btn);
                animation.setDuration(300);
                Bounce bounce = new Bounce(0.5, 20);
                animation.setInterpolator(bounce);
                view.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer back_btn = MediaPlayer.create(view.getContext(), R.raw.slide);
                        back_btn.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(MainActivity.this, LevelTwoActivity.class);
                        finish();
                        startActivity(intent);
                        Animatoo.animateFade(view.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
        Button button3 = findViewById(R.id.one2);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Animation animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.btn);
                animation.setDuration(300);
                Bounce bounce = new Bounce(0.5, 20);
                animation.setInterpolator(bounce);
                view.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MediaPlayer back_btn = MediaPlayer.create(view.getContext(), R.raw.slide);
                        back_btn.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intant = new Intent(MainActivity.this, LevelThreeActivity.class);
                        finish();
                        startActivity(intant);
                        Animatoo.animateFade(view.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
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
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        finish();
                        startActivity(intent);
                        Animatoo.animateSlideRight(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });

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
                setScore(person.getArr()+person.getArr1()+person.getArr2());
            }
            else setScore(0);
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setScore(int num) {
        Button button2 = findViewById(R.id.one1);
        Button button3 = findViewById(R.id.one2);

        score = num;
        TextView textView = findViewById(R.id.score);
        textView.setText(num + "");


        if(score==0)
        {
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
                if(person==null) {
                    person=new Person();
                }
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else if (score >= 120) {
            button3.setEnabled(true);
            button3.setBackgroundResource(R.drawable.but);
            button2.setEnabled(true);
            button2.setBackgroundResource(R.drawable.but);
            Button imageView1=findViewById(R.id.one);
            Button imageView2=findViewById(R.id.one1);
            Button imageView3=findViewById(R.id.one2);
            if(person.getArr()==60)
                imageView1.setBackgroundResource(R.drawable.bronze);
            else if(person.getArr()==75)
                imageView1.setBackgroundResource(R.drawable.silver);
            else if(person.getArr()==95)
                imageView1.setBackgroundResource(R.drawable.gold);
            if(person.getArr1()==60)
                imageView2.setBackgroundResource(R.drawable.bronze);
            else if(person.getArr1()==80)
                imageView2.setBackgroundResource(R.drawable.silver);
            else if(person.getArr1()==105)
                imageView2.setBackgroundResource(R.drawable.gold);
            if(person.getArr2()==60)
                imageView3.setBackgroundResource(R.drawable.bronze);
            else if(person.getArr2()==80)
                imageView3.setBackgroundResource(R.drawable.silver);
            else if(person.getArr2()==110)
                imageView3.setBackgroundResource(R.drawable.gold);
        } else if (person.getArr() >= 60) {
            Button imageView=findViewById(R.id.one);
            if(person.getArr()==75)
                imageView.setBackgroundResource(R.drawable.silver);
            else if(person.getArr()==95)
                imageView.setBackgroundResource(R.drawable.gold);
            else if(person.getArr()==60)
                imageView.setBackgroundResource(R.drawable.bronze);
            button2.setEnabled(true);
            button2.setBackgroundResource(R.drawable.but);
        }
    }

    @Override
    public void applyTexts(String username) throws IOException, ClassNotFoundException {
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.main_page){
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(MainActivity.this, InstructionActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}