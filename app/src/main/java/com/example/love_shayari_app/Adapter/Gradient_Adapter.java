package com.example.love_shayari_app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.love_shayari_app.Activity.Details_activity;
import com.example.love_shayari_app.R;

public class Gradient_Adapter extends BaseAdapter
{
    Details_activity details_activity;
    String emoji;
    int[] gradArr;
    public Gradient_Adapter(Details_activity details_activity, String emoji, int[] gradArr) {
        this.details_activity = details_activity;
        this.emoji = emoji;
        this.gradArr = gradArr;
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
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView= LayoutInflater.from(details_activity).inflate(R.layout.gradient_dialog_layout_item,parent,false);
        TextView textView=convertView.findViewById(R.id.grad_item_txt);
        textView.setText(emoji+"\nShayriApp\n"+emoji);
        textView.setBackgroundResource(gradArr[position]);
        return convertView;
    }
}
