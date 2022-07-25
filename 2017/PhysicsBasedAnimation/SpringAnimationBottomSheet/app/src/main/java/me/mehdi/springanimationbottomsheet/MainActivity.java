package me.mehdi.springanimationbottomsheet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    View mBottomSheet;
    GestureDetectorCompat mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomSheet = findViewById(R.id.bottomSheet);
        mGestureDetector = new GestureDetectorCompat(this, new CustomGestureListener(mBottomSheet));

        mBottomSheet.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }
}
