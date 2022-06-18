package uz.gita.myquizappp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.example.quiz.R;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if(Build.VERSION.SDK_INT>23){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        }

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                LottieAnimationView animationView = findViewById(R.id.animation);
                animationView.playAnimation();
                animationView.setProgress(0);
                animationView.pauseAnimation();
                Intent intent=new Intent(SplashActivity.this,FistActivity.class);
                startActivity(intent);
                finishAffinity();
            }
        },3000);

    }
    }
