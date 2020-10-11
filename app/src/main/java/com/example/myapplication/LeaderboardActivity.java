package com.example.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LeaderboardActivity extends AppCompatActivity implements com.example.myapplication.Dialog.ExampleDialogListener{
    Person person;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.main_page){
            Intent intent = new Intent(LeaderboardActivity.this, HomeActivity.class);
            startActivity(intent);
            return true;

        } else if(item.getItemId() == R.id.how_to_play){
            Intent intent = new Intent(LeaderboardActivity.this, InstructionActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leaderboard);

        Button button=findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Animation animation= AnimationUtils.loadAnimation(v.getContext(),R.anim.bck);
                animation.setDuration(150);
                v.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent=new Intent(LeaderboardActivity.this,HomeActivity.class);
                        startActivity(intent);
                        Animatoo.animateSlideRight(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                MediaPlayer back_btn= MediaPlayer.create(v.getContext(),R.raw.back_button);
                back_btn.start();
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
                ListView listView = findViewById(R.id.country_list);

                ArrayList<Country> countries = new ArrayList<>();

                if(person.getArr()==0){
                    countries.add(new Country(getString(R.string.step)+" 1",R.drawable.fila,true));
                    countries.add(new Country(getString(R.string.step)+" 2",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 3",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 4",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 5",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 6",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 7",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 8",R.drawable.locked,false));
                }
                else if(person.getArr()==10){
                    countries.add(new Country(getString(R.string.step)+" 1",R.drawable.fila,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 2",R.drawable.honda,true));
                    countries.add(new Country(getString(R.string.step)+" 3",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 4",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 5",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 6",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 7",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 8",R.drawable.locked,false));
                }
                else if(person.getArr()==20){
                    countries.add(new Country(getString(R.string.step)+" 1",R.drawable.fila,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 2",R.drawable.honda,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 3",R.drawable.gmail,true));
                    countries.add(new Country(getString(R.string.step)+" 4",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 5",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 6",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 7",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 8",R.drawable.locked,false));
                }
                else if(person.getArr()==30){
                    countries.add(new Country(getString(R.string.step)+" 1",R.drawable.fila,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 2",R.drawable.honda,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 3",R.drawable.gmail,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 4",R.drawable.nba,true));
                    countries.add(new Country(getString(R.string.step)+" 5",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 6",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 7",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 8",R.drawable.locked,false));
                }
                else if(person.getArr()==40){
                    countries.add(new Country(getString(R.string.step)+" 1",R.drawable.fila,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 2",R.drawable.honda,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 3",R.drawable.gmail,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 4",R.drawable.nba,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 5",R.drawable.lacoste,true));
                    countries.add(new Country(getString(R.string.step)+" 6",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 7",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 8",R.drawable.locked,false));
                }
                else if(person.getArr()==50){
                    countries.add(new Country(getString(R.string.step)+" 1",R.drawable.fila,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 2",R.drawable.honda,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 3",R.drawable.gmail,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 4",R.drawable.nba,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 5",R.drawable.lacoste,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 6",R.drawable.bmw,true));
                    countries.add(new Country(getString(R.string.step)+" 7",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 8",R.drawable.locked,false));
                }
                else if(person.getArr()==60){
                    countries.add(new Country(getString(R.string.step)+" 1",R.drawable.fila,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 2",R.drawable.honda,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 3",R.drawable.gmail,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 4",R.drawable.nba,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 5",R.drawable.lacoste,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 6",R.drawable.bmw,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 7",R.drawable.puma,true));
                    countries.add(new Country(getString(R.string.step)+" 8",R.drawable.locked,false));
                }
                else if(person.getArr()==75){
                    countries.add(new Country(getString(R.string.step)+" 1",R.drawable.fila,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 2",R.drawable.honda,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 3",R.drawable.gmail,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 4",R.drawable.nba,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 5",R.drawable.lacoste,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 6",R.drawable.bmw,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 7",R.drawable.puma,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 8",R.drawable.chrome,true));
                }
                else if(person.getArr()==95){
                    countries.add(new Country(getString(R.string.step)+" 1",R.drawable.fila,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 2",R.drawable.honda,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 3",R.drawable.gmail,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 4",R.drawable.nba,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 5",R.drawable.lacoste,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 6",R.drawable.bmw,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 7",R.drawable.puma,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 8",R.drawable.chrome,true,getString(R.string.complete)));
                }
                if(person.getArr1()==0&&person.getArr()>=60){
                    countries.add(new Country(getString(R.string.step)+" 9",R.drawable.lego,true));
                    countries.add(new Country(getString(R.string.step)+" 10",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 11",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 12",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 13",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 14",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 15",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 16",R.drawable.locked,false));
                }
                else if(person.getArr1()==0&&person.getArr()<60){
                    countries.add(new Country(getString(R.string.step)+" 9",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 10",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 11",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 12",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 13",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 14",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 15",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 16",R.drawable.locked,false));
                }
                else if(person.getArr1()==10){
                    countries.add(new Country(getString(R.string.step)+" 9",R.drawable.lego,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 10",R.drawable.kfc,true));
                    countries.add(new Country(getString(R.string.step)+" 11",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 12",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 13",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 14",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 15",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 16",R.drawable.locked,false));
                }
                else if(person.getArr1()==20){
                    countries.add(new Country(getString(R.string.step)+" 9",R.drawable.lego,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 10",R.drawable.kfc,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 11",R.drawable.fcb,true));
                    countries.add(new Country(getString(R.string.step)+" 12",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 13",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 14",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 15",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 16",R.drawable.locked,false));
                }
                else if(person.getArr1()==30){
                    countries.add(new Country(getString(R.string.step)+" 9",R.drawable.lego,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 10",R.drawable.kfc,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 11",R.drawable.fcb,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 12",R.drawable.mars,true));
                    countries.add(new Country(getString(R.string.step)+" 13",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 14",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 15",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 16",R.drawable.locked,false));
                }
                else if(person.getArr1()==40){
                    countries.add(new Country(getString(R.string.step)+" 9",R.drawable.lego,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 10",R.drawable.kfc,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 11",R.drawable.fcb,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 12",R.drawable.mars,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 13",R.drawable.netflix,true));
                    countries.add(new Country(getString(R.string.step)+" 14",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 15",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 16",R.drawable.locked,false));
                }
                else if(person.getArr1()==50){
                    countries.add(new Country(getString(R.string.step)+" 9",R.drawable.lego,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 10",R.drawable.kfc,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 11",R.drawable.fcb,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 12",R.drawable.mars,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 13",R.drawable.netflix,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 14",R.drawable.nike,true));
                    countries.add(new Country(getString(R.string.step)+" 15",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 16",R.drawable.locked,false));
                }
                else if(person.getArr1()==60){
                    countries.add(new Country(getString(R.string.step)+" 9",R.drawable.lego,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 10",R.drawable.kfc,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 11",R.drawable.fcb,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 12",R.drawable.mars,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 13",R.drawable.netflix,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 14",R.drawable.nike,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 15",R.drawable.opel,true));
                    countries.add(new Country(getString(R.string.step)+" 16",R.drawable.locked,false));
                }
                else if(person.getArr1()==80){
                    countries.add(new Country(getString(R.string.step)+" 9",R.drawable.lego,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 10",R.drawable.kfc,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 11",R.drawable.fcb,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 12",R.drawable.mars,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 13",R.drawable.netflix,true, getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 14",R.drawable.nike,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 15",R.drawable.opel,true));
                    countries.add(new Country(getString(R.string.step)+" 16",R.drawable.mtv,true));
                }
                else if(person.getArr1()==105){
                    countries.add(new Country(getString(R.string.step)+" 9",R.drawable.lego,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 10",R.drawable.kfc,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 11",R.drawable.fcb,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 12",R.drawable.mars,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 13",R.drawable.netflix,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 14",R.drawable.nike,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 15",R.drawable.opel,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 16",R.drawable.mtv,true,getString(R.string.complete)));
                }
                if(person.getArr2()==0&&person.getArr1()<60){
                    countries.add(new Country(getString(R.string.step)+" 17",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 18",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 19",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 20",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 21",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 22",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 23",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 24",R.drawable.locked,false));
                }
                else if(person.getArr2()==0&&person.getArr1()>=60){
                    countries.add(new Country(getString(R.string.step)+" 17",R.drawable.kia,true));
                    countries.add(new Country(getString(R.string.step)+" 18",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 19",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 20",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 21",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 22",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 23",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 24",R.drawable.locked,false));
                }
                else if(person.getArr2()==10){
                    countries.add(new Country(getString(R.string.step)+" 17",R.drawable.kia,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 18",R.drawable.hit,false));
                    countries.add(new Country(getString(R.string.step)+" 19",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 20",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 21",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 22",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 23",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 24",R.drawable.locked,false));
                }
                else if(person.getArr2()==20){
                    countries.add(new Country(getString(R.string.step)+" 17",R.drawable.kia,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 18",R.drawable.hit,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 19",R.drawable.sprite,true));
                    countries.add(new Country(getString(R.string.step)+" 20",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 21",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 22",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 23",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 24",R.drawable.locked,false));
                }
                else if(person.getArr2()==30){
                    countries.add(new Country(getString(R.string.step)+" 17",R.drawable.kia,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 18",R.drawable.hit,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 19",R.drawable.sprite,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 20",R.drawable.visa,true));
                    countries.add(new Country(getString(R.string.step)+" 21",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 22",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 23",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 24",R.drawable.locked,false));
                }
                else if(person.getArr2()==40){
                    countries.add(new Country(getString(R.string.step)+" 17",R.drawable.kia,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 18",R.drawable.hit,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 19",R.drawable.sprite,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 20",R.drawable.visa,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 21",R.drawable.nfl,true));
                    countries.add(new Country(getString(R.string.step)+" 22",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 23",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 24",R.drawable.locked,false));
                }
                else if(person.getArr2()==50){
                    countries.add(new Country(getString(R.string.step)+" 17",R.drawable.kia,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 18",R.drawable.hit,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 19",R.drawable.sprite,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 20",R.drawable.visa,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 21",R.drawable.nfl,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 22",R.drawable.kinder,true));
                    countries.add(new Country(getString(R.string.step)+" 23",R.drawable.locked,false));
                    countries.add(new Country(getString(R.string.step)+" 24",R.drawable.locked,false));
                }
                else if(person.getArr2()==60){
                    countries.add(new Country(getString(R.string.step)+" 17",R.drawable.kia,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 18",R.drawable.hit,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 19",R.drawable.sprite,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 20",R.drawable.visa,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 21",R.drawable.nfl,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 22",R.drawable.kinder,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 23",R.drawable.ikea,true));
                    countries.add(new Country(getString(R.string.step)+" 24",R.drawable.locked,false));
                }
                else if(person.getArr2()==80){
                    countries.add(new Country(getString(R.string.step)+" 17",R.drawable.kia,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 18",R.drawable.hit,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 19",R.drawable.sprite,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 20",R.drawable.visa,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 21",R.drawable.nfl,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 22",R.drawable.kinder,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 23",R.drawable.ikea,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 24",R.drawable.ford,true));
                }
                else{
                    countries.add(new Country(getString(R.string.step)+" 17",R.drawable.kia,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 18",R.drawable.hit,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 19",R.drawable.sprite,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 20",R.drawable.visa,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 21",R.drawable.nfl,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 22",R.drawable.kinder,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 23",R.drawable.ikea,true,getString(R.string.complete)));
                    countries.add(new Country(getString(R.string.step)+" 24",R.drawable.ford,true,getString(R.string.complete)));
                }

                CountryAdapter countryAdapter = new CountryAdapter(countries,this);
                listView.setAdapter(countryAdapter);
            }
            else {
                ListView listView = findViewById(R.id.country_list);
                ArrayList<Country> countries = new ArrayList<>();

                countries.add(new Country(getString(R.string.step)+" 1",R.drawable.locked,false));
                countries.add(new Country(getString(R.string.step)+" 2",R.drawable.locked,false));
                countries.add(new Country(getString(R.string.step)+" 3",R.drawable.locked,false));
                countries.add(new Country(getString(R.string.step)+" 4",R.drawable.locked,false));
                countries.add(new Country(getString(R.string.step)+" 5",R.drawable.locked,false));
                countries.add(new Country(getString(R.string.step)+" 6",R.drawable.locked,false));
                countries.add(new Country(getString(R.string.step)+" 7",R.drawable.locked,false));
                countries.add(new Country(getString(R.string.step)+" 8",R.drawable.locked,false));
                countries.add(new Country(getString(R.string.step)+" 9",R.drawable.locked,false));
                countries.add(new Country(getString(R.string.step)+" 10",R.drawable.locked,false));
                countries.add(new Country(getString(R.string.step)+" 11",R.drawable.locked,false));
                countries.add(new Country(getString(R.string.step)+" 12",R.drawable.locked,false));
                countries.add(new Country(getString(R.string.step)+" 13",R.drawable.locked,false));
                countries.add(new Country(getString(R.string.step)+" 14",R.drawable.locked,false));
                countries.add(new Country(getString(R.string.step)+" 15",R.drawable.locked,false));
                countries.add(new Country(getString(R.string.step)+" 16",R.drawable.locked,false));
                countries.add(new Country(getString(R.string.step)+" 17",R.drawable.locked,false));
                countries.add(new Country(getString(R.string.step)+" 18",R.drawable.locked,false));
                countries.add(new Country(getString(R.string.step)+" 19",R.drawable.locked,false));
                countries.add(new Country(getString(R.string.step)+" 20",R.drawable.locked,false));
                countries.add(new Country(getString(R.string.step)+" 21",R.drawable.locked,false));
                countries.add(new Country(getString(R.string.step)+" 22",R.drawable.locked,false));
                countries.add(new Country(getString(R.string.step)+" 23",R.drawable.locked,false));
                countries.add(new Country(getString(R.string.step)+" 24",R.drawable.locked,false));

                CountryAdapter countryAdapter = new CountryAdapter(countries,this);
                listView.setAdapter(countryAdapter);
            }
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void applyTexts(String username) throws IOException, ClassNotFoundException {
        
    }
}
