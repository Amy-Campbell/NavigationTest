package com.example.navigationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class FullImageActivity extends AppCompatActivity {

    private ImageButton btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        btBack = (ImageButton) findViewById(R.id.button_home);

        btBack.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                finish();
            }
        });

        Intent i = getIntent();

        int position = i.getExtras().getInt("id");
        ImageAdapter adapter = new ImageAdapter(this);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);



        //set the title
        if(position < adapter.imageList.length){

            imageView.setImageResource(adapter.imageList[position]);

            TextView titleTextView = (TextView) findViewById(R.id.titleTextView);
            titleTextView.setText(adapter.titles[position]);

            //set the description
            TextView descriptionTextView = (TextView) findViewById(R.id.descriptionTextView);
            descriptionTextView.setText(adapter.descriptions[position]);

            //set the date
            TextView dateTextView = (TextView) findViewById(R.id.dateTextView);
            dateTextView.setText(adapter.dates[position]);
        }
        else{
            try{
                File imageFile = new File("/data/data/com.example.navigationtest/app_imageDir/" + ImageAdapter.storedImageList.get(position - ImageAdapter.imageList.length));
                BitmapDrawable d = new BitmapDrawable(getResources(), imageFile.getAbsolutePath());


                imageView.setImageDrawable(d);

                TextView titleTextView = (TextView) findViewById(R.id.titleTextView);
                titleTextView.setText(adapter.storedTitlesList.get(position - ImageAdapter.imageList.length));

                TextView descriptionTextView = (TextView) findViewById(R.id.descriptionTextView);
                descriptionTextView.setText(adapter.storedDescriptionsList.get(position - ImageAdapter.imageList.length));

                TextView dateTextView = (TextView) findViewById(R.id.dateTextView);
                dateTextView.setText(adapter.storedDatesList.get(position - ImageAdapter.imageList.length));


            }
            catch(Exception e){
                Toast.makeText(this,"could not load file",Toast.LENGTH_SHORT).show();
            }

        }

    }
}