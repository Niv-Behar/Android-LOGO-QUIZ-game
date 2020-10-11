package com.example.myapplication;

import android.view.animation.Interpolator;

public class Bounce implements Interpolator {

    private double my=1;
    private double fre=10;

    Bounce(double my, double fre){
        this.my=my;
        this.fre=fre;
    }

    @Override
    public float getInterpolation(float time) {
        return (float)(-1*Math.pow(Math.E,-time/my)*Math.cos(fre*time)+1);
    }
}
