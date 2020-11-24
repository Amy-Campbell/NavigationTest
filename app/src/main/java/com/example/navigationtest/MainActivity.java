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
    ImageButton btGallery, btSearch, btCamera;

    Button firstFragment, secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get the reference of Button's
        firstFragment = (Button) findViewById(R.id.firstFragment);
        secondFragment = (Button) findViewById(R.id.secondFragment);
        btGallery = (ImageButton) findViewById(R.id.button_gallery);
        btSearch = (ImageButton) findViewById(R.id.button_search);
        btCamera = (ImageButton) findViewById(R.id.button_camera);

        // perform setOnClickListener event on First Button
        firstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // load First Fragment
                loadFragment(new FirstFragment());
            }
        });
        // perform setOnClickListener event on Second Button
        secondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // load Second Fragment
                loadFragment(new SecondFragment());
            }
        });

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

    }

    private void launchGallery(){
        Intent intent = new Intent(this, GalleryActivity.class);
        startActivity(intent);

    }
    private void launchSearch(){
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);

    }

    private void loadFragment(Fragment fragment) {
        // create a FragmentManager
        FragmentManager fm = getFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit(); // save the changes
    }
}