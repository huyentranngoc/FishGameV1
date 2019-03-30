package com.example.fishgame;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

//Import Static Variables from SplashActivity.java
import static com.example.fishgame.SplashActivity.StaticRedSpd;
import static com.example.fishgame.SplashActivity.StaticGrnSpd;
import static com.example.fishgame.SplashActivity.StaticYlwSpd;

public class MainActivity extends AppCompatActivity {
    private HappyFishView gameView;
    private Handler handler = new Handler();
    private final static long Interval = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new HappyFishView(this);

        gameView.setNum(StaticGrnSpd, StaticYlwSpd, StaticRedSpd);  //setNum will take static variables and apply them to the speeds of the balls

        setContentView(gameView);                                   //setting the actual game view

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        gameView.invalidate();
                    }
                });
            }
        }, 0,Interval);
    }
}
