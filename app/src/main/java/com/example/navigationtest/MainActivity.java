package com.example.navigationtest;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/*********************************************************************************
 * AddNewKeywordActivity
 *
 * Description:
 * This class runs on launch and serves as home screen for navigation
 *
 *Team Name: Team 10+10
 * Authors: Amy Campbell, Andrew Dunham, Terrence Yang, Jimmy Kha
 * Date: October 30 2020
 *
 * Input: touch sensor
 * Output: none
 *
 ********************************************************************************/
public class MainActivity extends AppCompatActivity {
    ImageButton btGallery, btSearch, btCamera, btKeywords;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the reference of Buttons

        btGallery = (ImageButton) findViewById(R.id.button_gallery);
        btSearch = (ImageButton) findViewById(R.id.button_search);
        btCamera = (ImageButton) findViewById(R.id.button_camera);
        btKeywords = (ImageButton) findViewById(R.id.button_keywords);




        //set up listeners
        btGallery.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                launchGallery();
            }
        });
        btSearch.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                launchSearch();
            }
        });
        btCamera.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                launchCamera();
            }
        });
        btKeywords.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                launchWeb();
            }
        });



    }



    //launch individual activities
    private void launchGallery(){
        Intent intent = new Intent(this, GalleryActivity.class);
        startActivity(intent);

    }
    private void launchSearch(){
        Intent intent = new Intent(this, DatabaseSearcher.class);
        startActivity(intent);

    }
    private void launchCamera(){
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);

    }
    private void launchKeywords(){
        Intent intent = new Intent(this, KeywordsActivity.class);
        startActivity(intent);

    }
    private void launchWeb(){
        Intent intent = new Intent(this, WebActivity.class);
        startActivity(intent);

    }


}