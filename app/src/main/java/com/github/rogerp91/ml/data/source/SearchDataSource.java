package com.github.rogerp91.ml.data.source;

import android.support.annotation.NonNull;

import com.github.rogerp91.ml.data.model.Search;

/**
 * Acceder a datos de las búsquedas realizadas por el usuario
 * <p>
 * Métodos para informar al usuario las operaciones exitosas de la DB
 */
public interface SearchDataSource {

    interface GetSearchCallback {

        void onSearchLoaded(String[] searchs);

        void onDataNotAvailable();
    }

    interface GetSearchLikeCallback {

        void onSearchLoaded(String[] searchs);

        void onDataNotAvailable();
    }


    void getSearch(@NonNull GetSearchCallback callback);

    void getSearchLike(String query, @NonNull GetSearchLikeCallback callback);

    void saveSearch(@NonNull Search search);
}