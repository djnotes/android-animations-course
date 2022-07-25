package me.mehdi.classicanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button hello;
    TranslateAnimation translate;
    RotateAnimation rotate;
    ScaleAnimation scale;
    AnimationSet animationSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hello = findViewById(R.id.hello);

        translate = new TranslateAnimation(0, 200, 0, 200 );
        rotate = new RotateAnimation(0, 360);
        scale = new ScaleAnimation(0, 3, 0, 3);

        animationSet = new AnimationSet(this, null);
        animationSet.addAnimation(translate);
        animationSet.addAnimation(rotate);
        animationSet.addAnimation(scale);
        animationSet.setDuration(3000);



        hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animationSet);
            }
        });
    }
}
