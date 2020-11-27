package com.example.navigationtest;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageButton btGallery, btSearch, btCamera, btKeywords;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get the reference of Button's

        btGallery = (ImageButton) findViewById(R.id.button_gallery);
        btSearch = (ImageButton) findViewById(R.id.button_search);
        btCamera = (ImageButton) findViewById(R.id.button_camera);
        btKeywords = (ImageButton) findViewById(R.id.button_keywords);



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
                launchKeywords();
            }
        });

    }

    private void launchGallery(){
        Intent intent = new Intent(this, GalleryActivity.class);
        startActivity(intent);

    }
    private void launchSearch(){
        Intent intent = new Intent(this, SearchActivity.class);
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

}