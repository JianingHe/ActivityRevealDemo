package com.example.myapplication;

import android.animation.Animator;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        View myView = findViewById(R.id.root);

        myView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                // Check if the runtime version is at least Lollipop
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    // get the center for the clipping circle
                    int cx = myView.getWidth() / 2;
                    int cy = myView.getHeight() / 2;

                    // get the final radius for the clipping circle
                    float finalRadius = (float) Math.hypot(cx, cy);

                    // create the animator for this view (the start radius is zero)
                    Animator anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0f, finalRadius);

                    // make the view visible and start the animation
                    myView.setVisibility(View.VISIBLE);
                    anim.start();
                } else {
                    // set the view to invisible without a circular reveal animation below Lollipop
                    myView.setVisibility(View.INVISIBLE);
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

    }


}