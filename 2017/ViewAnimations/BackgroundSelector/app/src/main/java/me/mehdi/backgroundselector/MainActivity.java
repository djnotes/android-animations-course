package me.mehdi.backgroundselector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
private RecyclerView myRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = findViewById(R.id.recyclerView);
        myRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));
        myRecyclerView.setAdapter(new MyAdapter(MainActivity.this));
    }
}
