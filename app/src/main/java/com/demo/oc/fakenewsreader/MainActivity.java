package com.demo.oc.fakenewsreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView listNews = (RecyclerView) findViewById(R.id.list_news);
        listNews.setLayoutManager(new LinearLayoutManager(this));
        listNews.setAdapter(new MyAdapter());


    }
}
