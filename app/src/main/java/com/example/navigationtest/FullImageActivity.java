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

import com.bumptech.glide.Glide;

import java.io.File;
/*********************************************************************************
 * AddNewKeywordActivity
 *
 * Description:
 * This class allows users to add keywords to Room Persistence Library
 *
 *Team Name: Team 10+10
 * Authors: Amy Campbell
 * Date: November 24 2020
 *
 * Input: none
 * Output: display image and text
 *
 ********************************************************************************/
public class FullImageActivity extends AppCompatActivity {

    private ImageButton btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        //initialize button listeners
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
                if ((adapter.storedImageList.get(position - adapter.imageList.length)).charAt(0) == 'h'){
                    Glide.with(this).load(adapter.storedImageList.get(position - adapter.imageList.length)).into(imageView);
                }
                else{
                    File imageFile = new File(adapter.storedImageList.get(position - adapter.imageList.length));
                    BitmapDrawable d = new BitmapDrawable(getResources(), imageFile.getAbsolutePath());


                    imageView.setImageDrawable(d);
                }

                //store image information
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