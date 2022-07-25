package me.mehdi.simpleviewpropertyanimator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.start);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.animate()
                        .translationY(300)
                        .scaleX(2)
                        .alpha(0.5f)
                        .setDuration(2000)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "The Animation Ended", Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });
    }
}
