package com.pain.coordinatortest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LangAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= (RecyclerView) findViewById(R.id.recycle_view);
        adapter=new LangAdapter(this);
        adapter.setListener(new LangViewHolder.OnEventListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(MainActivity.this, "click"+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int positon) {
                Toast.makeText(MainActivity.this, "longclick"+positon, Toast.LENGTH_SHORT).show();

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerGridItemDecoration(this));
    }
}
