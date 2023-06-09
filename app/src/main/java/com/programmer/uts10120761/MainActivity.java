package com.programmer.uts10120761;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.programmer.uts10120761.R;

public class MainActivity extends AppCompatActivity {
    private static  int SPLASH_SCREEN = 4000;
// variables
    Animation anim_top, anim_bot;
    ImageView image;
    TextView tittle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Hooks
        image = findViewById(R.id.ss_header);
        tittle = findViewById(R.id.ss_tittle);


        new  Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,WalkThrough1.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}