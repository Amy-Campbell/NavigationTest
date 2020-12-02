package com.example.navigationtest.db;
/*********************************************************************************
 * Keyword
 *
 * Description:
 * This class holds information for data
 *
 *Team Name: Team 10+10
 * Authors: Amy Campbell with help from https://www.youtube.com/watch?v=ONb_MuPBBlg&t=465s
 * Date:November 24 2020
 *
 * Input:none
 * Output: none
 *
 ********************************************************************************/
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Keyword {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "name")
    public String name;


}
