package com.example.love_shayari_app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.love_shayari_app.Activity.Shayari_Edit_Activity;
import com.example.love_shayari_app.R;

public class Emoji_Adapter extends BaseAdapter {
    Shayari_Edit_Activity shayari_edit_activity;
    String[] emoji;
    String shayari;
    public Emoji_Adapter(Shayari_Edit_Activity shayari_edit_activity, String[] emoji, String shayari) {
        this.shayari_edit_activity=shayari_edit_activity;
        this.emoji=emoji;
        this.shayari=shayari;
    }

    @Override
    public int getCount() {
        return emoji.length;
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
        view= LayoutInflater.from(shayari_edit_activity).inflate(R.layout.emoji_listview_layout_item,parent,false);
        TextView textView=view.findViewById(R.id.emoji_item_txt);
        textView.setText(emoji[position]);
        return view;
    }
}
