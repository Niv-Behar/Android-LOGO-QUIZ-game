package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class TutorialActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_main);

        final Button nextTutBtn = findViewById(R.id.next_tut_btn);
        final TextView tvTut = findViewById(R.id.tv_tut);
        final TextView rightArrow = findViewById(R.id.right_arrow);
        final TextView upArrow = findViewById(R.id.up_arrow);
        final Button finishTutBtn = findViewById(R.id.finish_tut_btn);
        final Button yUpBtn = findViewById(R.id.yUp_btn);
        final Button yDownBtn = findViewById(R.id.yDown_btn);

        rightArrow.setVisibility(View.INVISIBLE);
        upArrow.setVisibility(View.VISIBLE);
        finishTutBtn.setVisibility(View.INVISIBLE);

        nextTutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvTut.getText().toString().equals("for choose press on the letter")) {
                    upArrow.setVisibility(View.INVISIBLE);
                    rightArrow.setVisibility(View.VISIBLE);
                    tvTut.setText("for delete press on the letter");
                    yUpBtn.setText("Y");
                    yDownBtn.setVisibility(View.INVISIBLE);
                    Animation animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.btn);
                    animation.setDuration(250);
                    Bounce bounce = new Bounce(0.5, 20);
                    animation.setInterpolator(bounce);
                    view.startAnimation(animation);
                    MediaPlayer back_btn= MediaPlayer.create(view.getContext(),R.raw.home_btn);
                    back_btn.start();
                }
                else if(tvTut.getText().toString().equals("for delete press on the letter")){
                    rightArrow.setVisibility(View.INVISIBLE);
                    upArrow.setVisibility(View.VISIBLE);
                    tvTut.setText("the letter return down");
                    yUpBtn.setText("");
                    yDownBtn.setVisibility(View.VISIBLE);
                    finishTutBtn.setVisibility(View.VISIBLE);
                    nextTutBtn.setVisibility(View.INVISIBLE);
                    Animation animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.btn);
                    animation.setDuration(250);
                    Bounce bounce = new Bounce(0.5, 20);
                    animation.setInterpolator(bounce);
                    view.startAnimation(animation);
                    MediaPlayer back_btn= MediaPlayer.create(view.getContext(),R.raw.home_btn);
                    back_btn.start();
                }
            }
        });

                finishTutBtn.setOnClickListener(new View.OnClickListener(){
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
                                MediaPlayer back_btn= MediaPlayer.create(view.getContext(),R.raw.home_btn);
                                back_btn.start();
                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                Intent intent = new Intent(TutorialActivity.this, LevelOneActivity.class);
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

            }

    }
