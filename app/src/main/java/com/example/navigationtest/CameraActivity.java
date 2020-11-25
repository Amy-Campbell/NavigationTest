package com.example.navigationtest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraActivity extends AppCompatActivity {

    Context context;
    Button btOpen;
    Activity activity;
    ImageButton btBack;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        context = this;

        imageView = findViewById(R.id.imageView);
        btOpen = findViewById(R.id.bt_open);
        btBack = (ImageButton) findViewById(R.id.button_home);

        btBack.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                finish();
            }
        });

        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 100);
        }
        btOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
            }
        });
    }

    //images get saved to data > data > com.example.cmpt385 > app_imageDir
    private String saveLocationAlternateTest(Bitmap image){

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = timeStamp + ".png";
        ContextWrapper cw = new ContextWrapper((context.getApplicationContext()));
        File storageLocation = cw.getDir("imageDir",context.MODE_PRIVATE);
        File path = new File(storageLocation,imageFileName);

        FileOutputStream outWrite = null;
        try {
            outWrite = new FileOutputStream(path);
            image.compress(Bitmap.CompressFormat.PNG, 100, outWrite);
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                outWrite.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return storageLocation.getAbsolutePath();
    }


    /**
     * THIS NEEDS A DESCRIPTION
     * @param requestCode
     * @param data
     * @param resultCode
     */
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
            saveLocationAlternateTest(imageBitmap);
            //Toast.makeText(context,"Image Saved.",Toast.LENGTH_SHORT).show();
        }
    }
}
