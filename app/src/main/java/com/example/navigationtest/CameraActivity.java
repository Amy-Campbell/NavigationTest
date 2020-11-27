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
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
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
    ImageButton btOpen;
    ImageButton btSave;
    ImageButton btPlay;
    ImageButton btStop;
    ImageButton btRecord;
    Activity activity;
    ImageButton btBack;

    private ImageView imageView;
    MediaPlayer mediaPlayer = new MediaPlayer();
    MediaRecorder mediaRecorder = new MediaRecorder();
    private static String fileName = null;
    private static final String LOG_TAG = "AudioRecordTest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        context = this;

        imageView = findViewById(R.id.imageView);
        btOpen = findViewById(R.id.button_open_camera);
        btBack = (ImageButton) findViewById(R.id.button_home);
        btSave = findViewById(R.id.bt_save_picture);
        btPlay = findViewById(R.id.bt_play_audio);
        btStop = findViewById(R.id.bt_stop_audio);
        btRecord = findViewById(R.id.bt_record_audio);

        btBack.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                finish();
            }
        });

        if (ContextCompat.checkSelfPermission(CameraActivity.this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(CameraActivity.this,
                    new String[]{Manifest.permission.CAMERA}, 100);
        }

        btOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
            }
        });
        btSave.setOnClickListener(new View.OnClickListener() {
            private View view;

            @Override
            public void onClick(View view) {

                saveLocationAlternateTest(imageView.getDrawingCache());
            }


        });
        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioPlayer("/data/data/com.example.navigationtest/app_audioDir", "12pm.mp3");
            }
        });

        btStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaRecorder.stop();
                releaseMediaPlayer();
            }
        });
        btRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioRecorder();
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

    public void audioPlayer(String path, String fileName){
        {
            try {
                mediaPlayer.setDataSource(path + File.separator + fileName);
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void releaseMediaPlayer() {
        try {
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying())
                    mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void audioRecorder(){
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String audioFileName = timeStamp + ".MPEG_4";
        ContextWrapper cw = new ContextWrapper((getApplicationContext()));
        File storageLocation = cw.getDir("audioDir", MODE_PRIVATE);
        File path = new File(storageLocation, audioFileName);

        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        mediaRecorder.setOutputFile(path.getAbsolutePath());
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mediaRecorder.prepare();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }

        mediaRecorder.start();
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
            //saveLocationAlternateTest(imageBitmap);
            //Toast.makeText(context,"Image Saved.",Toast.LENGTH_SHORT).show();
        }
    }
}