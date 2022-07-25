package me.mehdi.combinedanimation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class A_Activity extends AppCompatActivity {

    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        startButton = findViewById(R.id.start);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View button) {
                Animation viewAnimation = AnimationUtils.loadAnimation(A_Activity.this, R.anim.animate_view);
                button.startAnimation(viewAnimation);
            }
        });
    }
}
