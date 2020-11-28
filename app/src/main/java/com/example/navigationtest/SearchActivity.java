package com.example.navigationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;

public class SearchActivity extends AppCompatActivity {

    ImageView imageView;
    ImageButton btBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        btBack = (ImageButton) findViewById(R.id.button_home);
        imageView = (ImageView) findViewById(R.id.display_image);

        //String path = Environment.getExternalStorageDirectory()+ "" + CameraActivity.getNameOfFile();
        //File imgFile = new File(path);
        //if(imgFile.exists())
        //{
            //Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            //ImageView myImage = (ImageView) findViewById(R.id.display_image);
            //myImage.setImageBitmap(myBitmap);
        //}
        //else {
            //Toast.makeText(this,"no IMAGE IS PRESENT'",Toast.LENGTH_SHORT).show();
    //}
        try{
            File imageFile = new File("/data/data/com.example.navigationtest/app_imageDir/" + CameraActivity.nameOfFile);
            ImageView jpgView = (ImageView)findViewById(R.id.display_image);
            BitmapDrawable d = new BitmapDrawable(getResources(), imageFile.getAbsolutePath());
            jpgView.setImageDrawable(d);

        }
        catch(Exception e){
            Toast.makeText(this,"could not load file",Toast.LENGTH_SHORT).show();
        }






        btBack.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                finish();
            }
        });
    }
}