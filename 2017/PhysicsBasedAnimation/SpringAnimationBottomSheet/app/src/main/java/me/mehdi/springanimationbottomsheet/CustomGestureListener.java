package me.mehdi.springanimationbottomsheet;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

import com.google.android.material.snackbar.Snackbar;

public class CustomGestureListener extends GestureDetector.SimpleOnGestureListener {
    View mView;

    public CustomGestureListener(View view){
        mView = view;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        SpringAnimation springAnimation = new SpringAnimation(mView, DynamicAnimation.Y);
        springAnimation.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
               Snackbar.make(mView, "WELCOME TO MY APP", Snackbar.LENGTH_LONG).show();
            }
        });
        SpringForce force = new SpringForce();
        force.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
        force.setStiffness(SpringForce.STIFFNESS_LOW);
        springAnimation.animateToFinalPosition(0);
        return super.onFling(e1, e2, velocityX, velocityY);
    }
}
