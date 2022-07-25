package me.mehdi.slideexplode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView mImage;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImage = findViewById(R.id.image);
        mButton = findViewById(R.id.start);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition((ViewGroup)findViewById(android.R.id.content), new Slide(Gravity.RIGHT));
                mImage.setVisibility(mImage.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
            }
        });
    }
}
