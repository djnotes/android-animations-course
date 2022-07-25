package me.mehdi.xmlanimators;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView myImage;
    AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myImage = findViewById(R.id.animatedObject);
        myImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View image) {
                animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.my_animator);
                animatorSet.setDuration(2000);
                animatorSet.setTarget(image);
                animatorSet.start();

                animatorSet.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        new AlertDialog.Builder(MainActivity.this).setMessage("Animation Ended").show();
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });
            }
        });
    }
}
