package com.example.love_shayari_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.love_shayari_app.Config;
import com.example.love_shayari_app.R;
import com.example.love_shayari_app.Adapter.TestAdapter;

public class Shayari_List_Aactivity extends AppCompatActivity {
    ListView shayarilist;
    TestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shayari_list_aactivity);
        shayarilist=findViewById(R.id.shayarilist);
        int poss=getIntent().getIntExtra("position",0);
        if(poss==0)
        {
           adapter=new TestAdapter(Shayari_List_Aactivity.this, Config.img[poss],Config.jivanshayari);
        }
        else if(poss==1)
        {
            adapter=new TestAdapter(Shayari_List_Aactivity.this,Config.img[poss], Config.mohobbatshayari);
        }
        else if(poss==2)
        {
            adapter=new TestAdapter(Shayari_List_Aactivity.this,Config.img[poss], Config.yaadeshayari);
        }
        else if(poss==3)
        {
            adapter=new TestAdapter(Shayari_List_Aactivity.this,Config.img[poss], Config.anyashayari);
        }
        else if(poss==4)
        {
            adapter=new TestAdapter(Shayari_List_Aactivity.this,Config.img[poss], Config.politics);
        }
        else if(poss==5)
        {
            adapter=new TestAdapter(Shayari_List_Aactivity.this,Config.img[poss], Config.love);
        }else if(poss==6)
        {
            adapter=new TestAdapter(Shayari_List_Aactivity.this,Config.img[poss], Config.sad);
        }else if(poss==7)
        {
            adapter=new TestAdapter(Shayari_List_Aactivity.this,Config.img[poss], Config.bearbar);
        }
        else if(poss==8)
        {
            adapter=new TestAdapter(Shayari_List_Aactivity.this,Config.img[poss], Config.bewfa);
        }
        shayarilist.setAdapter(adapter);
        shayarilist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(Shayari_List_Aactivity.this,Details_activity.class);
               if(poss==0)
               {
                   intent.putExtra("position",position);
                   intent.putExtra("shayari",Config.jivanshayari);
               }
               else if(poss==1)
               {
                   intent.putExtra("position",position);
                   intent.putExtra("shayari",Config.mohobbatshayari);
               }
               else if(poss==2)
               {
                   intent.putExtra("position",position);
                   intent.putExtra("shayari",Config.yaadeshayari);
               }
               else if(poss==3)
               {
                   intent.putExtra("position",position);
                   intent.putExtra("shayari",Config.anyashayari);
               }
               else if(poss==4)
               {
                   intent.putExtra("position",position);
                   intent.putExtra("shayari",Config.politics);
               }
               else if(poss==5)
               {
                   intent.putExtra("position",position);
                   intent.putExtra("shayari",Config.love);
               }
               else if(poss==6)
               {
                   intent.putExtra("position",position);
                   intent.putExtra("shayari",Config.sad);
               }
               else if(poss==7)
               {
                   intent.putExtra("position",position);
                   intent.putExtra("shayari",Config.bearbar);
               }
               else if(poss==8)
               {
                   intent.putExtra("position",position);
                   intent.putExtra("shayari",Config.bewfa);
               }
                startActivity(intent);
            }
        });
    }


}