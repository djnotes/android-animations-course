package me.mehdi.contenttransitions;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Transition;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Transition explode = new Explode();
//        explode.setDuration(2000);
//        getWindow().setExitTransition(explode);
//        getWindow().setReenterTransition(explode);
        mStart = findViewById(R.id.startContentTransitions);
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(detailIntent, ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this).toBundle());
            }
        });
    }
}
