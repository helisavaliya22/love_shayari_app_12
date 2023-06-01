package com.example.love_shayari_app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.love_shayari_app.Activity.Shayari_List_Aactivity;
import com.example.love_shayari_app.Config;
import com.example.love_shayari_app.R;

public class TestAdapter extends BaseAdapter {
    Shayari_List_Aactivity shayari_list_aactivity;
    int img;
    String[] shayari;

    public TestAdapter(Shayari_List_Aactivity shayari_list_aactivity, int img, String[] shayari) {
        this.shayari_list_aactivity=shayari_list_aactivity;
        this.img=img;
        this.shayari=shayari;

    }

    @Override
    public int getCount() {
        return shayari.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view= LayoutInflater.from(shayari_list_aactivity).inflate(R.layout.shayari_list,parent,false);
        ImageView imageView=view.findViewById(R.id.image1);
        TextView textView=view.findViewById(R.id.t1);


        imageView.setImageResource(img);
        textView.setText(Config.emoji[position]+"\n"+shayari[position]);

       return view;
    }
}
