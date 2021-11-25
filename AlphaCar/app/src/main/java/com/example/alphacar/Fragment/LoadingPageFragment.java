package com.example.alphacar.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.example.alphacar.MainActivity;
import com.example.alphacar.R;

public class LoadingPageFragment extends AppCompatActivity {

    LottieAnimationView animationView;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation);

        animationView = findViewById(R.id.lottie);
        animationView.setAnimation("test8.json");
        animationView.loop(true);
        animationView.playAnimation();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(LoadingPageFragment.this, MainActivity.class);
                LoadingPageFragment.this.startActivity(intent);
                LoadingPageFragment.this.finish();
            }
        },1000);
    }

}
