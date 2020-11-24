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

public class GalleryActivity extends AppCompatActivity {

    public String[] titles = {"My Family (1957)",
            "Baby Agatha (My Sister) on the left, next to Mom",
            "Ben (My son) with his wife (Angela) and their eldest child (Ryan)",
            "My Sister (Agatha) and Me. (1955)",
            "Mom and Dad",
            "Agatha (my sister) and her daughter, Elise",
            "Me and my husband, Gregory, at our wedding. (1960)",
            "Mom and Dad in 1993",
            "My nieces, Elise and Charlotte",
            "Portrait of my cousing Tabitha's family",
            "Me and Agatha",
            "Gregory in his Navy uniform",
            "Name13"};

    private ImageButton btBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        btBack = (ImageButton) findViewById(R.id.button_home);

        btBack.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                finish();
            }
        });
        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this));


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