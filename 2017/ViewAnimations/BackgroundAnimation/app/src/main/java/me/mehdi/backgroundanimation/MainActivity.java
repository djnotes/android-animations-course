package me.mehdi.backgroundanimation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    boolean animationRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.start);
        final AnimationDrawable animationDrawable = (AnimationDrawable) startButton.getBackground();

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View button) {
                if(animationRunning) {
                    animationDrawable.stop();
                    startButton.setText(R.string.start);
                    animationRunning = false;
                }
                else {
                    animationDrawable.start();
                    startButton.setText(R.string.stop);
                    animationRunning = true;
                }
            }
        });
    }
}
