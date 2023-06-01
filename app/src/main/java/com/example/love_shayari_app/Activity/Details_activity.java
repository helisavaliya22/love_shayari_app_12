package com.example.love_shayari_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.love_shayari_app.Adapter.Gradient_Adapter;
import com.example.love_shayari_app.Config;
import com.example.love_shayari_app.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Random;

public class Details_activity extends AppCompatActivity {
    TextView shayaridisp,shayarinumber;
    ImageView expand,reload,copy,previous,pencil,next,share;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        shayaridisp=findViewById(R.id.shayaridisp);
        expand=findViewById(R.id.expand);
        shayarinumber=findViewById(R.id.shayarinumber);
        reload=findViewById(R.id.reload);
        copy=findViewById(R.id.copy);
        previous=findViewById(R.id.previous);
        pencil=findViewById(R.id.pencil);
        next=findViewById(R.id.next);
        share=findViewById(R.id.share);
        position=getIntent().getIntExtra("position",0);
        String[] shayari=getIntent().getStringArrayExtra("shayari");

        shayaridisp.setText(Config.emoji[position]+"\n"+shayari[position]+"\n"+Config.emoji[position]);

        expand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BottomSheetDialog dialog=new BottomSheetDialog(Details_activity.this);
                dialog.setContentView(R.layout.gradient_dialog_layout);
                GridView gridView=dialog.findViewById(R.id.grad_GridView);

                Gradient_Adapter adapter=new Gradient_Adapter(Details_activity.this,Config.emoji[position],Config.gradArr);
                gridView.setAdapter(adapter);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        shayaridisp.setBackgroundResource(Config.gradArr[position]);
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

       shayarinumber.setText(position+"/"+shayari.length);


        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int min=1,max=Config.gradArr.length;
                int r=new Random().nextInt(max-min)+min;
                shayaridisp.setBackgroundResource(Config.gradArr[r]);
            }
        });
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              ClipboardManager cm = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
                cm.setText(shayaridisp.getText());
                Toast.makeText(Details_activity.this, "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position>0)
                {
                    shayaridisp.setText(Config.emoji[position]+"\n"+shayari[position]+"\n"+Config.emoji[position]);
                    position--;
                    shayarinumber.setText((position+1)+"/"+shayari.length);
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position<shayari.length)
                {
                    shayaridisp.setText(Config.emoji[position]+"\n"+shayari[position]+"\n"+Config.emoji[position]);
                    position++;
                    shayarinumber.setText((position+1)+"/"+shayari.length);
                }
            }
        });
       pencil.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(Details_activity.this,Shayari_Edit_Activity.class);
               intent.putExtra("position",position);
               intent.putExtra("shayari",shayari[position]);
               startActivity(intent);
           }
       });
      share.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intentt = new Intent(Intent.ACTION_SEND);

              // setting type of data shared as text
              intentt.setType("text/plain");
              //intentt.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");

              // Adding the text to share using putExtra
              intentt.putExtra(Intent.EXTRA_TEXT, shayaridisp.getText().toString());
              startActivity(Intent.createChooser(intentt, "Share Via"));
          }
      });


    }
}