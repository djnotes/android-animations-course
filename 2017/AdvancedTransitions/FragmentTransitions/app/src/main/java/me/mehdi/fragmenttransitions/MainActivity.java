package me.mehdi.fragmenttransitions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStartButton = findViewById(R.id.start);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleFragment fragment = new SimpleFragment();
                fragment.setEnterTransition(new Slide(Gravity.START));
                fragment.setReturnTransition(new Slide(Gravity.END));
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.fragmentContainer, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}
