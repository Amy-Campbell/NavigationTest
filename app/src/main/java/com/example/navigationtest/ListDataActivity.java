package com.example.navigationtest;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
/*********************************************************************************
 * List Data Activity
 *
 * Description:
 * This class displays data from SQLite database in a list
 *
 *Team Name: Team 10+10
 * Authors: Andrew Dunham
 * Date: November 24 2020
 *
 * Input: none
 * Output: list text data from database
 *
 ********************************************************************************/
public class ListDataActivity extends AppCompatActivity{

    private static final String TAG = "ListDataActivity";

    DatabaseHelper mDatabaseHelper;
    ImageButton btBack;

    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        mListView = (ListView) findViewById(R.id.listView);
        mDatabaseHelper = new DatabaseHelper(this);

        //initialize buttons
        btBack = (ImageButton) findViewById(R.id.button_home);

        btBack.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                finish();
            }
        });

        populateListView();
    }

    //display data in ListView
    private void populateListView(){
        Log.d(TAG, "populateListView: Displaying data in the ListView");

        //Get the data and append to a list
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            //get the value of data at column 1 then add to array list
            listData.add(data.getString(1));
        }
        //Create list adapter
        ListAdapter adapater = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listData);
        mListView.setAdapter(adapater);
    }
    //toast
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
