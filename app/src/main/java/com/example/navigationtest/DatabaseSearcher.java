package com.example.navigationtest;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class DatabaseSearcher extends AppCompatActivity {

    private static final String TAG ="DatabaseSearcher";

    DatabaseHelper mDatabaseHelper;
    private Button btnAdd, btnViewData;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_search);//The xml file to be used
        editText = (EditText) findViewById(R.id.editText);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnViewData = (Button) findViewById(R.id.btnView);
        mDatabaseHelper = new DatabaseHelper(this);

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String newEntry = editText.getText().toString();
                if (editText.length() != 0){
                    AddData(newEntry);
                    editText.setText("");
                }else{
                    toastMessage("You must put something in the text field!");
                }
            }
        });
        btnViewData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(DatabaseSearcher.this, ListDataActivity.class);
                startActivity(intent);
            }
        });


    }

    public void AddData (String newEntry){
        boolean insertData = mDatabaseHelper.addData(newEntry);

        if (insertData){
            toastMessage("Data Successfully Inserted!");
        } else{
            toastMessage("Something went wrong");
        }
    }

    //Custom toast message @param message
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
