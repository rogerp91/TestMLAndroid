package com.github.rogerp91.ml.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

@Entity(tableName = "search", indices = {@Index(value = {"title"}, unique = true)})
public class Search {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "_id")
    private String mId;

    @Nullable
    @ColumnInfo(name = "title")
    private String mTitle;

    @NonNull
    public String getmId() {
        return mId;
    }

    @Nullable
    public String getmTitle() {
        return mTitle;
    }
}