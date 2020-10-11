package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AnimActivity extends Activity {
    private static int splash_screen = 3000;

    Animation topAnim, bottomAnim;
    ImageView imageAnim;
    TextView logoQuizTv, sloganTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anim_main);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        imageAnim = findViewById(R.id.image_anim);
        logoQuizTv = findViewById(R.id.logo_quiz_tv);
        sloganTv = findViewById(R.id.slogan_tv);

        imageAnim.setAnimation(topAnim);
        logoQuizTv.setAnimation(bottomAnim);
        sloganTv.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(AnimActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, splash_screen);

    }
}
