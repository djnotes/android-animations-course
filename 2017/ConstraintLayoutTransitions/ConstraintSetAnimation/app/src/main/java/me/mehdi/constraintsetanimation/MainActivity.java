package me.mehdi.constraintsetanimation;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout rootLayout;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootLayout = findViewById(R.id.rootLayout);
        start = findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintSet set = new ConstraintSet();
                set.clone(MainActivity.this, R.layout.second_keyframe);
                set.applyTo(rootLayout);
                Transition transition = new ChangeBounds();
                transition.setInterpolator(new OvershootInterpolator());
                transition.setDuration(2000);
                TransitionManager.beginDelayedTransition(rootLayout, transition);
            }
        });
    }

}
