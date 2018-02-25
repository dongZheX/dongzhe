package com.example.noticeme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import org.litepal.crud.DataSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    static List<Content> list;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this,NoticeService.class);
        startService(intent);
        recyclerView= (RecyclerView)findViewById(R.id.list_item);
        list = DataSupport.findAll(Content.class);
        ContentAdapter contentAdapter = new ContentAdapter(list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(contentAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()){
           case R.id.item_add:
               ContentActivity.actionStart(this,null,null);
       }
       return true;
    }

    @Override
    protected void onResume() {
        list = DataSupport.findAll(Content.class);
        recyclerView.setAdapter(new ContentAdapter(list));
        super.onResume();
    }
}
