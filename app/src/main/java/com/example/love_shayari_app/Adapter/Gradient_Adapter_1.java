package com.example.love_shayari_app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.love_shayari_app.Activity.Shayari_Edit_Activity;
import com.example.love_shayari_app.Config;
import com.example.love_shayari_app.R;

public class Gradient_Adapter_1 extends BaseAdapter {
    Shayari_Edit_Activity shayari_edit_activity;
    String emoji;
    int[] gradArr;
    public Gradient_Adapter_1(Shayari_Edit_Activity shayari_edit_activity, String emoji, int[] gradArr) {
        this.shayari_edit_activity=shayari_edit_activity;
        this.emoji=emoji;
        this.gradArr=gradArr;
    }

    @Override
    public int getCount() {
        return gradArr.length;
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
        view= LayoutInflater.from(shayari_edit_activity).inflate(R.layout.gradient_dialog_layout_item_1,parent,false);
        TextView textView=view.findViewById(R.id.grad_item_txt1);
        textView.setText(emoji+"\nShayariApp\n"+emoji);
        textView.setBackgroundResource(gradArr[position]);
        return view;
    }
}
