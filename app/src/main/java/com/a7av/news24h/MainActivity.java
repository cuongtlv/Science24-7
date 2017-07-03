package com.a7av.news24h;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
@EActivity
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ReadRss readRss = new ReadRss(this, recyclerView);
        readRss.execute();
    }
}
