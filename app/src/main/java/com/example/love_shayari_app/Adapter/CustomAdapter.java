package com.example.love_shayari_app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.love_shayari_app.Activity.MainActivity;
import com.example.love_shayari_app.R;

public class CustomAdapter extends BaseAdapter {
    MainActivity mainActivity;
    int[] img;
    String[] category;
    public CustomAdapter(MainActivity mainActivity, int[] img, String[] category) {
        this.mainActivity=mainActivity;
        this.img=img;
        this.category=category;
    }

    @Override
    public int getCount() {
        return category.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view= LayoutInflater.from(mainActivity).inflate(R.layout.list_activity,parent,false);
        ImageView imageView=view.findViewById(R.id.image);
        TextView txt1=view.findViewById(R.id.txt);

        imageView.setImageResource(img[position]);
        txt1.setText(category[position]);
        return view;
    }
}
