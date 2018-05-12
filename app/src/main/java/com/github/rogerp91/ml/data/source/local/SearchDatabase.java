package com.github.rogerp91.ml.data.source.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.github.rogerp91.ml.data.Search;

@Database(entities = {Search.class}, version = 1, exportSchema = false)
public abstract class SearchDatabase extends RoomDatabase {

    private static SearchDatabase INSTANCE;

    public abstract SearchDao searchDao();

    public static SearchDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), SearchDatabase.class, "ML.db").build();
        }
        return INSTANCE;
    }

}
