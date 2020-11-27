package com.example.navigationtest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.navigationtest.db.AppDatabase;
import com.example.navigationtest.db.Keyword;

import java.util.List;

public class KeywordsActivity extends AppCompatActivity {
    private KeywordListAdapter keywordListAdapter;
    Context context = this;
    private ImageButton btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keywords);

        btBack = (ImageButton) findViewById(R.id.button_home);

        btBack.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                finish();
            }
        });

        ImageButton addNewKeywordButton = findViewById(R.id.button_addNewKeyword);
        addNewKeywordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AddNewKeywordActivity.class);
                startActivityForResult(intent, 100);

            }
        });

        initRecyclerView();

        loadUserList();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        keywordListAdapter = new KeywordListAdapter(this);
        recyclerView.setAdapter(keywordListAdapter);
    }

    private void loadUserList() {
        //get records from database
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        List<Keyword> keywordList =db.keywordDao().getAllKeywords();
        keywordListAdapter.setKeywordList(keywordList);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100) {
            loadUserList();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}