package com.example.love_shayari_app.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.love_shayari_app.Activity.Details_activity;
import com.example.love_shayari_app.R;

public class ShayriPagerAdapter extends PagerAdapter
{
    Details_activity details_activity;
    String[] shayri;
    TextView shayaridisp;

    public ShayriPagerAdapter(Details_activity details_activity, String[] shayri, TextView shayaridisp) {
        this.details_activity = details_activity;
        this.shayri = shayri;
        this.shayaridisp=shayaridisp;
    }

    @Override
    public int getCount() {
        return shayri.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(details_activity).inflate(R.layout.pager_item_,container,false);
       // shayaridisp.setText(""+shayri[position]);
        container.addView(view);
//        TextView textView=view.findViewById(R.id.shayaridisp_item);
//        textView.setText(""+shayri[position]);
       // Log.d("TTT", "instantiateItem: "+position);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //super.destroyItem(container, position, object);
        container.removeView((View) object);
    }
}
