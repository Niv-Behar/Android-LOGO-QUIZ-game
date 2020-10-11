package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.service.controls.Control;
import android.text.Annotation;
import android.text.Layout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.state.State;
import androidx.core.content.ContextCompat;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.muddzdev.styleabletoast.StyleableToast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import de.hdodenhof.circleimageview.CircleImageView;
import pl.droidsonroids.gif.GifImageView;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity implements com.example.myapplication.Dialog.ExampleDialogListener {
    private TextView textView;
    Bitmap bitmap;
    HomeWatcher mHomeWatcher;
    Button snd;
    GifImageView pror;
    GifImageView prol;



    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        pror=findViewById(R.id.pror);
        prol=findViewById(R.id.prol);
        Button button = findViewById(R.id.start);
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
                        MediaPlayer back_btn= MediaPlayer.create(v.getContext(),R.raw.home_btn);
                        back_btn.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                        startActivity(intent);
                        Animatoo.animateFade(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        Button buttonI = findViewById(R.id.intruction);
        buttonI.setOnClickListener(new View.OnClickListener() {
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
                        MediaPlayer back_btn= MediaPlayer.create(v.getContext(),R.raw.home_btn);
                        back_btn.start();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(HomeActivity.this, InstructionActivity.class);
                        startActivity(intent);
                        Animatoo.animateFade(v.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });

        Button profileBtn = findViewById(R.id.profile);
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Animation animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.btn);
                animation.setDuration(150);
                Bounce bounce = new Bounce(0.5, 15);
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
                        pror.setVisibility(View.INVISIBLE);
                        prol.setVisibility(View.INVISIBLE);
                        openDialog();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });

        Button leaderBtn = findViewById(R.id.leader);
        leaderBtn.setOnClickListener(new View.OnClickListener() {
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
                        Intent intent = new Intent(HomeActivity.this, LeaderboardActivity.class);
                        startActivity(intent);
                        Animatoo.animateFade(view.getContext());
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });


        //image and username
        TextView textView = findViewById(R.id.usr);
        CircleImageView imageView = findViewById(R.id.img);
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
            Person person = null;
            try {
                person = (Person) ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (person != null) {
                pror.setVisibility(View.INVISIBLE);
                prol.setVisibility(View.INVISIBLE);
                if (person.getPhoto() != null) {
                    imageView.setImageBitmap(person.getPhoto());
                } else {
                    if (person.getGender() == 20)
                        imageView.setImageResource(R.drawable.female);
                    else imageView.setImageResource(R.drawable.male);
                }
                textView.setText(person.getUsername());
                Button but=findViewById(R.id.start);
                pror.setVisibility(View.INVISIBLE);
                prol.setVisibility(View.INVISIBLE);
                TextView text=findViewById(R.id.fir);
                text.setVisibility(View.INVISIBLE);
                but.setEnabled(true);
            }
            else {
                TextView text=findViewById(R.id.fir);
                text.setVisibility(View.VISIBLE);
                pror.setVisibility(View.VISIBLE);
                prol.setVisibility(View.VISIBLE);
                Button but=findViewById(R.id.start);
                but.setEnabled(false);
            }
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //music
        doBindService();
        Intent music = new Intent();
        music.setClass(this, MusicService.class);
        startService(music);
        mHomeWatcher = new HomeWatcher(this);
        mHomeWatcher.setOnHomePressedListener(new HomeWatcher.OnHomePressedListener() {
            @Override
            public void onHomePressed() {
                if (mServ != null) {
                    mServ.pauseMusic();
                }
            }

            @Override
            public void onHomeLongPressed() {
                if (mServ != null) {
                    mServ.pauseMusic();
                }
            }
        });
        mHomeWatcher.startWatch();
    }

    public void openDialog() {
        Dialog dialog = new Dialog();
        dialog.show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public void applyTexts(String username) throws IOException, ClassNotFoundException {
        TextView textView = findViewById(R.id.usr);
        ImageView imageView = findViewById(R.id.img);
        FileInputStream fis = openFileInput("person");
        if(fis!=null) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            Person person = (Person) ois.readObject();
            if(person!=null) {
                if (person.getPhoto() != null) {
                    imageView.setImageBitmap(person.getPhoto());
                } else {
                    if (person.getGender() == 20)
                        imageView.setImageResource(R.drawable.female);
                    else imageView.setImageResource(R.drawable.male);
                }
            }
            textView.setText(person.getUsername());
            Button but=findViewById(R.id.start);
            but.setEnabled(true);
            TextView text=findViewById(R.id.fir);
            text.setVisibility(View.INVISIBLE);
            ois.close();
        }
    }

    //music
    private boolean mIsBound = false;
    private MusicService mServ;
    private ServiceConnection Scon = new ServiceConnection() {

        public void onServiceConnected(ComponentName name, IBinder
                binder) {
            mServ = ((MusicService.ServiceBinder) binder).getService();
        }

        public void onServiceDisconnected(ComponentName name) {
            mServ = null;
        }
    };

    void doBindService() {
        bindService(new Intent(this, MusicService.class),
                Scon, Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    void doUnbindService() {
        if (mIsBound) { unbindService(Scon);
            mIsBound = false;
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        if (mServ != null) {
            mServ.resumeMusic();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        doUnbindService();
        Intent music = new Intent();
        music.setClass(this, MusicService.class);
        stopService(music);

    }

    @Override
    public void onPause() {
        super.onPause();
        PowerManager pm = (PowerManager)
                getSystemService(Context.POWER_SERVICE);
        boolean isScreenOn = false;
        if (pm != null) {
            isScreenOn = pm.isScreenOn();
        }
        if (!isScreenOn) {
            if (mServ != null) {
                mServ.pauseMusic();
            }
        }

    }

}