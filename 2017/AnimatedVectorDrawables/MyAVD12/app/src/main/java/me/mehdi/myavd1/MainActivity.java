package me.mehdi.myavd1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.view.View;
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
                AnimatedVectorDrawable avd = (AnimatedVectorDrawable) mImage.getDrawable();
                avd.start();
            }
        });
    }
}
