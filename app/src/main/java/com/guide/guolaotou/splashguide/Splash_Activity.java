package com.guide.guolaotou.splashguide;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean isFirstOpen = Sp_Utils.getBoolen(this,AppConstants.First_Open);
        if(!isFirstOpen)
        {
            startActivity(new Intent(this,WelcomeGuideActivity.class));
            finish();
            return;
        }
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                enterHomeActivity();
            }
        },1500);
    }
    private void enterHomeActivity()
    {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
