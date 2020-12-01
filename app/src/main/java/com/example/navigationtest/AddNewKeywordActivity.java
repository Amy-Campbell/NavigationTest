package com.example.navigationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.navigationtest.db.AppDatabase;
import com.example.navigationtest.db.Keyword;
/*********************************************************************************
 * AddNewKeywordActivity
 *
 * Description:
 * This class allows users to add keywords to Room Persistence Library
 *
 *Team Name: Team 10+10
 * Authors: Amy Campbell
 * Date: November 24 2020
 *
 * Input: Keyboard Input
 * Output: none
 *
 ********************************************************************************/
public class AddNewKeywordActivity extends AppCompatActivity {

    private ImageButton btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_keyword);

        //set up back button
        btBack = (ImageButton) findViewById(R.id.button_home);

        btBack.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                finish();
            }
        });

        //get input from textbox
        final EditText NameInput =  findViewById(R.id.NameInput);
        ImageButton saveButton =  findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewKeyword(NameInput.getText().toString());
            }
        });
    }

    //save the keyword to database
    private void saveNewKeyword(String name) {
        AppDatabase db  = AppDatabase.getDbInstance(this.getApplicationContext());

        Keyword keyword = new Keyword();
        keyword.name = name;
        db.keywordDao().insertKeyword(keyword);

        finish();

    }

}