package me.mehdi.groupanimation;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.Group;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Group group;
    Button start;
    ConstraintLayout rootLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        group = findViewById(R.id.group);
        start = findViewById(R.id.start);
        rootLayout = findViewById(R.id.rootLayout);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start.setVisibility(View.GONE);
                group.setVisibility(View.VISIBLE);
                Transition fade = new Fade();
                fade.setDuration(1000);
                TransitionManager.beginDelayedTransition(rootLayout, fade);
            }
        });
    }
}
