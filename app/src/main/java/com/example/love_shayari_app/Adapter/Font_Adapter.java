package com.example.love_shayari_app.Adapter;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.love_shayari_app.Activity.Shayari_Edit_Activity;
import com.example.love_shayari_app.Config;
import com.example.love_shayari_app.R;

public class Font_Adapter extends BaseAdapter {
    Shayari_Edit_Activity shayari_edit_activity;
    String[] fontArr;
    public Font_Adapter(Shayari_Edit_Activity shayari_edit_activity, String[] fontArr) {
        this.shayari_edit_activity=shayari_edit_activity;
        this.fontArr=fontArr;
    }

    @Override
    public int getCount() {
        return fontArr.length;
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
        view= LayoutInflater.from(shayari_edit_activity).inflate(R.layout.font_dialog_layout_item,parent,false);
        TextView textView=view.findViewById(R.id.font_grid_item);
        Typeface typeface= Typeface.createFromAsset(shayari_edit_activity.getAssets(),fontArr[position]);
        textView.setTypeface(typeface);

        return view;
    }
}
