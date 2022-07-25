package me.mehdi.transitionstest;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeClipBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button mButton;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.start);
        mImageView = findViewById(R.id.image);

        final TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new ChangeTransform());
        transitionSet.addTransition(new ChangeImageTransform());
        transitionSet.addTransition(new ChangeClipBounds());

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition((ViewGroup)findViewById(android.R.id.content), transitionSet);
                mImageView.setScaleX(2.0f);
                mImageView.setScaleY(2.0f);
                mImageView.setRotation(45);
                mImageView.setScaleType(ImageView.ScaleType.CENTER);
                mImageView.setClipBounds(new Rect(10, 20, 500, 400));
            }
        });
    }
}
