package com.cassule.braulio.well_architected.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by Braulio on 3/28/2018.
 **/

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordDatabase extends RoomDatabase {
    public abstract WordDao wordDao();
    public static WordDatabase INSTANCE;

    public static WordDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (WordDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context, WordDatabase.class, "word_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
