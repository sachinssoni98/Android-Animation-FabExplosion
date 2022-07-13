package com.example.animation2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.animation2.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        activityMainBinding.floatingActionButton.setOnClickListener(this::scaleView);
    }

    private void scaleView(View view) {
        Animation animation= AnimationUtils.loadAnimation(this, R.anim.zoom);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                activityMainBinding.getRoot().setBackgroundColor(getResources().getColor(R.color.purple_500));
                activityMainBinding.fab.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        activityMainBinding.fab.setVisibility(View.VISIBLE);
        activityMainBinding.floatingActionButton.setVisibility(View.INVISIBLE);
        activityMainBinding.fab.startAnimation(animation);
    }
    //    @Override
    //    public void onBackPressed() {
    //        super.onBackPressed();
    //        activityMainBinding.getRoot().setBackgroundColor(getResources().getColor(R.color.white));
    //        activityMainBinding.floatingActionButton.setVisibility(View.VISIBLE);
    //        activityMainBinding.fab.setVisibility(View.INVISIBLE);
    //    }
}

// References: https://youtu.be/vc70qmG8d4Y