package com.example.navigationtest.db;
/*********************************************************************************
 * AppDatabase
 *
 * Description:
 * This class holds the room database
 *
 *Team Name: Team 10+10
 * Authors: Amy Campbell
 * Date:November 24 2020
 *
 * Input:none
 * Output: none
 *
 ********************************************************************************/
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Keyword.class}, version  = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract KeywordDao keywordDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDbInstance(Context context) {

        if(INSTANCE == null) {
            //create new database
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "DB_NAME")
                    .allowMainThreadQueries()
                    .build();

        }
        return INSTANCE;
    }
}
