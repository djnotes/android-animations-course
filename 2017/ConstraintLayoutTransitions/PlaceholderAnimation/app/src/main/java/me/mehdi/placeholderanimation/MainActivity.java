package me.mehdi.placeholderanimation;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.Placeholder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Placeholder placeholder;
    ConstraintLayout rootLayout;
    ImageView img1, img2, img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        placeholder = findViewById(R.id.placeholder);
        rootLayout = findViewById(R.id.rootLayout);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Transition transition = new ChangeBounds();
        transition.setInterpolator(new BounceInterpolator());
        transition.setDuration(2000);
        TransitionManager.beginDelayedTransition(rootLayout, transition);
        placeholder.setContentId(v.getId());
    }
}
