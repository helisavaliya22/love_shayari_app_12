package com.example.love_shayari_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.love_shayari_app.Adapter.Color_Adapter;
import com.example.love_shayari_app.Adapter.Emoji_Adapter;
import com.example.love_shayari_app.Adapter.Gradient_Adapter;
import com.example.love_shayari_app.Adapter.Gradient_Adapter_1;
import com.example.love_shayari_app.Config;
import com.example.love_shayari_app.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.lang.reflect.Array;
import java.util.Random;

public class Shayari_Edit_Activity extends AppCompatActivity {
    TextView shayariedit;
    ImageView expand1,reload1;
    Button background,textcolor,share,font,emoji,textsize;
    String shayari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shayari_edit);
        shayariedit=findViewById(R.id.shayariedit);
        expand1=findViewById(R.id.expand1);
        reload1=findViewById(R.id.reload1);
        background=findViewById(R.id.background);
        textcolor=findViewById(R.id.textcolor);
        share=findViewById(R.id.share);
        font=findViewById(R.id.font);
        emoji=findViewById(R.id.emoji);
        textsize=findViewById(R.id.textsize);


        int position=getIntent().getIntExtra("position",0);
        shayari=getIntent().getStringExtra("shayari");

        shayariedit.setText(Config.emoji[position]+"\n"+shayari+"\n"+Config.emoji[position]);
        reload1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int min=1,max=Config.gradArr.length;
                int r=new Random().nextInt(max-min)+min;
                shayariedit.setBackgroundResource(Config.gradArr[r]);
            }
        });
        expand1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog dialog=new BottomSheetDialog(Shayari_Edit_Activity.this);
                dialog.setContentView(R.layout.gradient_dialog_layout_1);
                GridView gridView=dialog.findViewById(R.id.grad_GridView1);

                Gradient_Adapter_1 adapter=new Gradient_Adapter_1(Shayari_Edit_Activity.this,Config.emoji[position],Config.gradArr);
                gridView.setAdapter(adapter);

                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                       shayariedit.setBackgroundResource(Config.gradArr[position]);
                       dialog.dismiss();
                    }
                });
              dialog.show();

            }
        });

        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog dialog=new BottomSheetDialog(Shayari_Edit_Activity.this);
                dialog.setContentView(R.layout.color_dialog_layout);

                GridView gridView=dialog.findViewById(R.id.color_gridview);
                Button colorbutton=dialog.findViewById(R.id.colorbutton);
                Color_Adapter adapter=new Color_Adapter(Shayari_Edit_Activity.this,Config.colorArr);
                gridView.setAdapter(adapter);

                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        shayariedit.setBackgroundResource(Config.colorArr[position]);
                        dialog.dismiss();
                    }
                });
                dialog.show();
                colorbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });
         textcolor.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 BottomSheetDialog dialog=new BottomSheetDialog(Shayari_Edit_Activity.this);
                 dialog.setContentView(R.layout.color_dialog_layout);

                 GridView gridView=dialog.findViewById(R.id.color_gridview);
                 Button button=dialog.findViewById(R.id.colorbutton);
                 Color_Adapter adapter=new Color_Adapter(Shayari_Edit_Activity.this,Config.colorArr);
                 gridView.setAdapter(adapter);
                 gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                     @Override
                     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                         shayariedit.setTextColor(Config.colorArr[position]);
                         dialog.dismiss();
                     }
                 });
                 dialog.show();
             }
         });
         emoji.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 BottomSheetDialog dialog=new BottomSheetDialog(Shayari_Edit_Activity.this);
                 dialog.setContentView(R.layout.emoji_list_view_layout);
                 ListView listView=dialog.findViewById(R.id.emoji_list_view);
                 Emoji_Adapter adapter=new Emoji_Adapter(Shayari_Edit_Activity.this,Config.emoji,shayari);
                 listView.setAdapter(adapter);
                 listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                     @Override
                     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                         shayariedit.setText(Config.emoji[position]+"\n"+shayari+"\n"+Config.emoji[position]);
                         dialog.dismiss();
                     }
                 });
                 dialog.show();
             }
         });
    }
}