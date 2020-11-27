package com.example.navigationtest.db;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface KeywordDao {

    @Query("SELECT * FROM keyword")
    List<Keyword> getAllKeywords();

    @Insert
    void insertKeyword(Keyword... keywords);

    @Delete
    void delete(Keyword keyword);
}