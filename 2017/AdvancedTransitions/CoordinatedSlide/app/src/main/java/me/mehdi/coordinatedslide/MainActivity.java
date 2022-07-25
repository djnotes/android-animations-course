package me.mehdi.coordinatedslide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int TRANSITION_DURATION = 300;
    ViewGroup mRoot;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        for(int i = 0; i < mRoot.getChildCount(); i++) {
            final View view = mRoot.getChildAt(i);
            view.postDelayed(new Runnable() {
                @Override
                public void run() {
                    TransitionManager.beginDelayedTransition(mRoot, new Slide(Gravity.END));
                    view.setVisibility(view.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
                }
            }, TRANSITION_DURATION * i);

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRoot = findViewById(R.id.linearLayout);
    }
}
