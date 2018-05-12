package com.github.rogerp91.ml.data.source;

import android.support.annotation.NonNull;

import com.github.rogerp91.ml.data.Search;

public interface SearchDataSource {

    interface GetSearchCallback {

        void onSearchLoaded(String[] searchs);

        void onDataNotAvailable();
    }

    void getSearch(@NonNull GetSearchCallback callback);

    void saveSearch(@NonNull Search search);
}