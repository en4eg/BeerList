package com.example.retrofitandpicasso;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    private static final int DELAY = 3000;

    private Timer mTimer = null;
    private final TimerTask mTimerTask = new TimerTask() {
        @Override
        public void run() {
            startActivity(new Intent(SplashActivity.this, GridActivity.class));
            finish();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTimer = new Timer();
        mTimer.schedule(mTimerTask, DELAY);
    }

    @Override
    protected void onPause() {
        mTimer.cancel();
        super.onPause();
    }
}