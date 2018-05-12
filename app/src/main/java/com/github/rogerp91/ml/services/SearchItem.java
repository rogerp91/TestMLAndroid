package com.github.rogerp91.ml.services;

import android.util.Log;

import com.github.rogerp91.ml.common.AbstractRestService;
import com.github.rogerp91.ml.common.SearchCallback;
import com.github.rogerp91.ml.data.model.Result;
import com.github.rogerp91.ml.services.definition.SearchDefinition;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchItem extends AbstractRestService<SearchDefinition> {

    private final static String TAG = SearchItem.class.getSimpleName();

    private String mSite;
    private String mQuery;
    private String mPagin;

    private static SearchItem searchItem;

    private SearchCallback searchCallback;

    public static SearchItem with() {
        if (searchItem == null)
            searchItem = new SearchItem();

        return searchItem;
    }

    public static SearchItem with(SearchCallback loginCallback) {
        if (searchItem == null)
            searchItem = new SearchItem(loginCallback);

        return searchItem;
    }

    private SearchItem() {
    }

    private SearchItem(SearchCallback loginCallback) {
        this.searchCallback = loginCallback;
    }

    public SearchItem listener(SearchCallback searchCallback) {
        this.searchCallback = searchCallback;
        return this;
    }

    public SearchItem site(String mSite) {
        this.mSite = mSite;
        return this;
    }

    public SearchItem query(String mQuery) {
        this.mQuery = mQuery;
        return this;
    }

    public SearchItem pag(String mPagin) {
        this.mPagin = mPagin;
        return this;
    }

    @Override
    protected Class<SearchDefinition> getRestApiDefinitionInterface() {
        return SearchDefinition.class;
    }

    @Override
    public void call() {
        if (searchCallback == null) {
            throw new NullPointerException("Search callback is Null");
        } else {
            Log.w(TAG, "call");
            callApi();
        }
    }

    private void callApi() {
        getService().searchQuery(mSite, mQuery, mPagin).enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if (response.isSuccessful()) {
                    searchCallback.onSuccess(response.body());
                } else {
                    searchCallback.onError(new RuntimeException("Unexpected response " + response));
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                searchCallback.onError(new Exception(t.getMessage(), t.getCause()));
            }
        });
    }

}