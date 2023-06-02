package com.example.love_shayari_app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.love_shayari_app.Activity.Shayari_Edit_Activity;
import com.example.love_shayari_app.R;

public class Color_Adapter extends BaseAdapter {
    Shayari_Edit_Activity shayari_edit_activity;
    int[] colorArr;
    public Color_Adapter(Shayari_Edit_Activity shayari_edit_activity, int[] colorArr) {
        this.shayari_edit_activity=shayari_edit_activity;
        this.colorArr=colorArr;
    }

    @Override
    public int getCount() {
        return colorArr.length;
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
        view= LayoutInflater.from(shayari_edit_activity).inflate(R.layout.color_dialog_layout_item,parent,false);
        TextView textView=view.findViewById(R.id.color_item_box);

        textView.setBackgroundResource(colorArr[position]);
        textView.setTextColor(colorArr[position]);
        return view;
    }
}
