package com.github.rogerp91.ml.data.source.local;

import android.support.annotation.NonNull;
import android.util.Log;

import com.github.rogerp91.ml.data.Search;
import com.github.rogerp91.ml.data.source.SearchDataSource;
import com.github.rogerp91.ml.util.AppExecutors;

public class SearchLocalDataSource implements SearchDataSource {

    private static volatile SearchLocalDataSource INSTANCE;

    private SearchDao mSearchDao;

    private AppExecutors mAppExecutors;

    private SearchLocalDataSource(@NonNull AppExecutors appExecutors, @NonNull SearchDao searchDao) {
        mAppExecutors = appExecutors;
        mSearchDao = searchDao;
    }

    public static SearchLocalDataSource getInstance(@NonNull AppExecutors appExecutors, @NonNull SearchDao searchDao) {
        if (INSTANCE == null) {
            synchronized (SearchLocalDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SearchLocalDataSource(appExecutors, searchDao);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void getSearch(@NonNull GetSearchCallback callback) {
        Runnable runnable = () -> {
            final String[] search = mSearchDao.getSearch();
            Log.d("TAG", Integer.toString(search.length));
            mAppExecutors.mainThread().execute(() -> {
                if (search.length == 0) {
                    callback.onDataNotAvailable();
                } else {
                    callback.onSearchLoaded(search);
                }
            });
        };

        mAppExecutors.diskIO().execute(runnable);
    }

    @Override
    public void saveSearch(@NonNull Search search) {
        Runnable runnable = () -> {
            mSearchDao.insert(search);
        };
        mAppExecutors.diskIO().execute(runnable);
    }
}