package com.example.love_shayari_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.love_shayari_app.Config;
import com.example.love_shayari_app.R;

import java.lang.reflect.Array;

public class Shayari_Edit_Activity extends AppCompatActivity {
    TextView shayariedit;
    ImageView expand1,reload1;
    Button background,textcolor,share,font,emoji,textsize;

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
        String shayari=getIntent().getStringExtra("shayari");

        shayariedit.setText(Config.emoji[position]+"\n"+shayari+"\n"+Config.emoji[position]);

    }
}