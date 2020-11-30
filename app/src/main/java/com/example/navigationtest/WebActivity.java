package com.example.navigationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class WebActivity extends AppCompatActivity {
    ImageButton btAdd;
    EditText edtTitle;
    EditText edtDescription;
    EditText edtURL;
    ImageButton btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        btBack = findViewById(R.id.button_home);
        btAdd = findViewById(R.id.button_add);
        edtDescription = findViewById(R.id.editDescription);
        edtTitle = findViewById(R.id.editTitle);
        edtURL = findViewById(R.id.editURL);

        btBack.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                finish();
            }
        });

        btAdd.setOnClickListener(new View.OnClickListener() {
            private View view;

            @Override
            public void onClick(View view) {
                ImageAdapter.storedImageList.add(edtURL.getText().toString());
                ImageAdapter.storedDescriptionsList.add(edtDescription.getText().toString());
                ImageAdapter.storedTitlesList.add(edtTitle.getText().toString());
                ImageAdapter.storedDatesList.add("2020");
                Toast.makeText(WebActivity.this,"Image Saved",Toast.LENGTH_LONG).show();


            }
        });
    }
}