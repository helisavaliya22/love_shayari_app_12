package com.example.love_shayari_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.love_shayari_app.Adapter.Color_Adapter;
import com.example.love_shayari_app.Adapter.Emoji_Adapter;
import com.example.love_shayari_app.Adapter.Font_Adapter;
import com.example.love_shayari_app.Adapter.Gradient_Adapter;
import com.example.love_shayari_app.Adapter.Gradient_Adapter_1;
import com.example.love_shayari_app.Config;
import com.example.love_shayari_app.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Shayari_Edit_Activity extends AppCompatActivity {
    TextView shayariedit;
    ImageView expand1,reload1;
    Button background,textcolor,share,font,emoji,textsize;
    String shayari;
    private File downloadedFile;

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
                         shayariedit.setTextColor(getResources().getColor(Config.colorArr[position]));
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
         font.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 BottomSheetDialog dialog=new BottomSheetDialog(Shayari_Edit_Activity.this);
                 dialog.setContentView(R.layout.font_dialog_layout_);
                 GridView gridView=dialog.findViewById(R.id.fontGrid);
                 gridView.setNumColumns(Config.font.length);
                 Font_Adapter adapter = new Font_Adapter(Shayari_Edit_Activity.this,Config.font);
                 gridView.setAdapter(adapter);
                 gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                     @Override
                     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                         Typeface typeface= Typeface.createFromAsset(getAssets(),Config.font[position]);

                         shayariedit.setTypeface(typeface);
                         dialog.dismiss();
                     }
                 });
                 dialog.show();
             }
         });
         textsize.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 BottomSheetDialog dialog=new BottomSheetDialog(Shayari_Edit_Activity.this);
                 dialog.setContentView(R.layout.font_size_layout_);
                 SeekBar seekBar=dialog.findViewById(R.id.seekBar);

                 seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                     @Override
                     public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                         shayariedit.setTextSize(2,30+progress);
                         Log.d("TTT", "onProgressChanged: "+progress);
                     }
                     @Override
                     public void onStartTrackingTouch(SeekBar seekBar) {

                     }
                     @Override
                     public void onStopTrackingTouch(SeekBar seekBar) {
                            dialog.dismiss();
                     }
                 });
                 dialog.show();
             }
         });
         share.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v)
             {
                 Bitmap icon = getBitmapFromView(shayariedit);
                 //Intent share = new Intent(Intent.ACTION_SEND);
                 Intent share =new Intent(Intent.ACTION_SEND);
                 share.setType("image/jpeg");
                 ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                 icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

                 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
                 String currentDateandTime = sdf.format(new Date());

                 downloadedFile= new File(Config.file.getAbsolutePath() + "/IMG_"+currentDateandTime+".jpg");
                 try
                 {
                     downloadedFile.createNewFile();
                     FileOutputStream fo = new FileOutputStream(downloadedFile);
                     fo.write(bytes.toByteArray());
                     Toast.makeText(Shayari_Edit_Activity.this,"File Downloaded",Toast.LENGTH_SHORT).show();
                 }
                 catch (IOException e)
                 {
                     e.printStackTrace();
                 }

                 share.putExtra(Intent.EXTRA_STREAM, Uri.parse(downloadedFile.getAbsolutePath()));
                 startActivity(Intent.createChooser(share, "Share Image"));
             }
         });
    }

    private Bitmap getBitmapFromView(TextView shayariedit)
    {
        //Define a bitmap with the same size as the view
        Bitmap returnedBitmap = Bitmap.createBitmap(shayariedit.getWidth(), shayariedit.getHeight(), Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnedBitmap);
        //Get the view's background
        Drawable bgDrawable = shayariedit.getBackground();
        if (bgDrawable != null)
        {
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        }
        else
        {
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE);
        }
        // draw the view on the canvas
        shayariedit.draw(canvas);
        //return the bitmap
        return returnedBitmap;
    }
}