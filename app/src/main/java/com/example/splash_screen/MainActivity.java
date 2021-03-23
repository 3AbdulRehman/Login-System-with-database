package com.example.splash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler ghori = new Handler();
        ghori.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent gh1 = new Intent(MainActivity.this,Login.class);
                startActivity(gh1);

            }
        },2000);
    }
}
