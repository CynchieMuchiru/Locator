package ke.co.locator.hostel.startup;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import ke.co.locator.hostel.R;

public class SplashScreenActivity extends AppCompatActivity implements Animation.AnimationListener {

    Animation animeFadeIn;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (Build.VERSION.SDK_INT < 16){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        else{
            View decorView = getWindow().getDecorView();
            //Hide Status Bar
            int uIoptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uIoptions);
        }
        // load the animation
        animeFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_fade_in);
        // set animation listener
        animeFadeIn.setAnimationListener(this);
        //load layout for image to be animated
        linearLayout = (LinearLayout) findViewById(R.id.splash_screen_img);
        // start the animation
        linearLayout.setVisibility(View.VISIBLE);

        //Start the welcome view
        Intent i = new Intent(SplashScreenActivity.this, WelcomeActivity.class);
        startActivity(i);
    }




    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        //Start the welcome view
        Intent i = new Intent(SplashScreenActivity.this, WelcomeActivity.class);
        startActivity(i);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
