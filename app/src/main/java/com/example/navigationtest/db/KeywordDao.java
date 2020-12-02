package com.example.navigationtest.db;

/*********************************************************************************
 * KeywordDao
 *
 * Description:
 * This allows database interaction
 *
 *Team Name: Team 10+10
 * Authors: Amy Campbell with help from https://www.youtube.com/watch?v=ONb_MuPBBlg&t=465s
 * Date:November 24 2020
 *
 * Input:none
 * Output: none
 *
 ********************************************************************************/
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