package com.example.naturalwonders;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainView = (RecyclerView) findViewById(R.id.all_attractions_list);
        WonderRecyclerViewAdapter adapter = new WonderRecyclerViewAdapter(this, DataCollection.getFullAttractionsList(this));
        mainView.setAdapter(adapter);
        mainView.setLayoutManager(new LinearLayoutManager(this));
    }
}