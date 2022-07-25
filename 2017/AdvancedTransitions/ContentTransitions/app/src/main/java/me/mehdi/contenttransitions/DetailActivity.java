package me.mehdi.contenttransitions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

//        Transition slide = new Slide();
//        getWindow().setEnterTransition(slide);
//        getWindow().setReturnTransition(slide);
    }
}
