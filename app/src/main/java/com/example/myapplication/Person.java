package com.example.myapplication;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

public class Person extends Activity implements Serializable {
    private String username;
    private String email;
    private int gender;
    transient private Bitmap photo;
    private int score;
    private int score1;
    private int score2;
    private boolean tutorial;

    public Person(){
        this.score=0;
        this.score1=0;
        this.score2=0;
    }
    public Person(String username,String email,Bitmap photo,int radioGroup,int i){
        this.username=username;
        this.email=email;
        this.photo=photo;
        this.gender=radioGroup;
        this.score=i;
    }
    public Person(String username,String email,Bitmap photo,int radioGroup){
        this.username=username;
        this.email=email;
        this.photo=photo;
        this.gender=radioGroup;
    }
    public String getUsername(){
        return username;
    }
    public String getEmail(){
        return email;
    }
    public Bitmap getPhoto(){
        return this.photo;
    }
    public int getGender(){return this.gender;}
    public int getArr() {
        return score;
    }
    public int getArr1() {
        return score1;
    }
    public int getArr2() {
        return score2;
    }
    public boolean getTutorial() {
        return tutorial;
    }
    public void setTutorial(boolean tutorial){this.tutorial=tutorial;}
    public void setScore(int score){this.score=score;}
    public void setScore1(int score){this.score1=score;}
    public void setScore2(int score){this.score2=score;}
    public void setUsername(String username){
        this.username=username;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setPhoto(Bitmap photo){
        this.photo=photo;
    }
    public void setGender(int radioGroup){this.gender=radioGroup;}

    private void writeObject(java.io.ObjectOutputStream out) throws IOException{
        if(photo!=null) {
            photo.compress(Bitmap.CompressFormat.JPEG, 25, out);
        }
        out.defaultWriteObject();
    }
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException{
        photo=BitmapFactory.decodeStream(in);
        in.defaultReadObject();
    }

}
