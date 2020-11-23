package com.example.bikensave;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.bikensave.R.anim.top_animation;



public class SplashScreen extends AppCompatActivity {

    //Setting Timer For SplashScreen for 5 seconds

    private static int SPLASH_SCREEN = 5000;


    //Variables
    Animation topAnim;
    Animation bottomAnim;
    ImageView image;
    TextView logo;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        //Animations
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);


        //Hooks
        image =findViewById(R.id.BikePicSplash);
        logo =findViewById(R.id.BikeSplash_text);

        image.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);

        // Creating a new Handler to finish this activity and move to main page.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run ()  {
                Intent intent = new Intent(SplashScreen.this,MainActivityBikeNSave.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}