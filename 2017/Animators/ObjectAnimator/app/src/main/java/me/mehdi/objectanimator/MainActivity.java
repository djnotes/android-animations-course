package me.mehdi.objectanimator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mButton;
    ObjectAnimator mScaleX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.start);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View button) {
                mScaleX = ObjectAnimator.ofFloat(button, "scaleX", 5);
                mScaleX.setDuration(1000);
                mScaleX.setRepeatCount(ValueAnimator.INFINITE);
                mScaleX.setRepeatMode(ValueAnimator.REVERSE);
                mScaleX.start();
            }
        });
    }
}
