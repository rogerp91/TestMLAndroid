package com.github.rogerp91.ml.data.source;

import android.support.annotation.NonNull;
import android.util.Log;

import com.github.rogerp91.ml.data.Search;

public class SearchRepository implements SearchDataSource {

    private SearchDataSource mLocalSearchDataSource;
    private SearchDataSource mRemoteSearchDataSource;// No se va a buscar información de manera remota

    private static SearchRepository INSTANCE = null;

    public SearchRepository(SearchDataSource localSearchDataSource) {
        this.mLocalSearchDataSource = localSearchDataSource;
    }

    public static SearchRepository getInstance(SearchDataSource tasksLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new SearchRepository(tasksLocalDataSource);
        }
        return INSTANCE;
    }

    @Override
    public void getSearch(@NonNull GetSearchCallback callback) {
        mLocalSearchDataSource.getSearch(new GetSearchCallback() {
            @Override
            public void onSearchLoaded(String[] searchs) {
                Log.d("TAG2", Integer.toString(searchs.length));

                callback.onSearchLoaded(searchs);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void saveSearch(@NonNull Search search) {
        mLocalSearchDataSource.saveSearch(search);
    }
}
