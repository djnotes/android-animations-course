package me.mehdi.progresslottie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void startAnimation(View view) {
        LottieAnimationView lottie = findViewById(R.id.lottieView);
        lottie.setVisibility(View.VISIBLE);
        lottie.playAnimation();
    }
}
