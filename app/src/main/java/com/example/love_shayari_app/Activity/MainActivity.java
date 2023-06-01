package com.example.love_shayari_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.love_shayari_app.Config;
import com.example.love_shayari_app.Adapter.CustomAdapter;
import com.example.love_shayari_app.R;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);

        adapter=new CustomAdapter(MainActivity.this, Config.img,Config.category);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int poss, long id) {
                Intent intent=new Intent(MainActivity.this,Shayari_List_Aactivity.class);
                intent.putExtra("position",poss);
                startActivity(intent);
            }
        });


    }
}