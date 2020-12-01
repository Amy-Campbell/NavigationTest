package com.example.navigationtest;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
/*********************************************************************************
 * GalleryActivity
 *
 * Description:
 * This class displays all images in a gridView Gallery
 *
 *Team Name: Team 10+10
 * Authors: Amy Campbell
 * Date: November 24 2020
 *
 * Input: touch sensor
 * Output: image display
 *
 ********************************************************************************/
public class GalleryActivity extends AppCompatActivity {



    private ImageButton btBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        //set up listeners
        btBack = (ImageButton) findViewById(R.id.button_home);

        btBack.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                finish();
            }
        });

        //add images to the adapter
        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this));


        //display the large image
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), FullImageActivity.class);
                i.putExtra("id",position);
                startActivity(i);
            }
        });
    }


}