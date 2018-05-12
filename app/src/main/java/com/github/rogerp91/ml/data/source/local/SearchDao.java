package com.github.rogerp91.ml.data.source.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.github.rogerp91.ml.data.Search;

import java.util.List;

@Dao
public interface SearchDao {

    @Query("SELECT * FROM search")
    String[] getSearch();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Search> searches);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Search searche);
}
