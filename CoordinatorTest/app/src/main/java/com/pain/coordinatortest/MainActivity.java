package com.pain.coordinatortest;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;
//activity_main1为图片折叠后变成toolbar的效果
//activity_main2为颜色折叠后渐变效果
public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LangAdapter adapter;
    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView= (RecyclerView) findViewById(R.id.recycle_view);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        collapsingToolbar= (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        adapter=new LangAdapter(this);
        setSupportActionBar(toolbar);
        collapsingToolbar.setTitle("122");
        collapsingToolbar.setContentScrimColor(0xffFF4081);
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
