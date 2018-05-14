package com.github.rogerp91.ml.services.interactor;

import android.util.Log;

import com.github.rogerp91.ml.common.AbstractRestService;
import com.github.rogerp91.ml.common.SearchCallback;
import com.github.rogerp91.ml.data.model.QuerySearch;
import com.github.rogerp91.ml.services.EmptyException;
import com.github.rogerp91.ml.services.definition.SearchDefinition;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchInteractor extends AbstractRestService<SearchDefinition> {

    private final static String TAG = SearchInteractor.class.getSimpleName();

    private String mSite;
    private String mQuery;
    private String mPagin;

    private static SearchInteractor searchInteractor;

    private SearchCallback searchCallback;

    public static SearchInteractor with() {
        if (searchInteractor == null)
            searchInteractor = new SearchInteractor();

        return searchInteractor;
    }

    public static SearchInteractor with(SearchCallback loginCallback) {
        if (searchInteractor == null)
            searchInteractor = new SearchInteractor(loginCallback);

        return searchInteractor;
    }

    private SearchInteractor() {
    }

    private SearchInteractor(SearchCallback loginCallback) {
        this.searchCallback = loginCallback;
    }

    public SearchInteractor listener(SearchCallback searchCallback) {
        this.searchCallback = searchCallback;
        return this;
    }

    public SearchInteractor site(String mSite) {
        this.mSite = mSite;
        return this;
    }

    public SearchInteractor query(String mQuery) {
        this.mQuery = mQuery;
        return this;
    }

    public SearchInteractor pag(String mPagin) {
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
        getService().searchQuery(mSite, mQuery, mPagin).enqueue(new Callback<QuerySearch>() {
            @Override
            public void onResponse(Call<QuerySearch> call, Response<QuerySearch> response) {
                if (response.isSuccessful()) {
                    verifyResponse(response);
                } else {
                    //Respuesta inesperada
                    searchCallback.onError(new RuntimeException("Unexpected response " + response));
                }
            }

            @Override
            public void onFailure(Call<QuerySearch> call, Throwable t) {
                Log.d(TAG, t.getMessage());
                searchCallback.onError(new Exception(t.getMessage(), t.getCause()));
            }
        });
    }

    private void verifyResponse(Response<QuerySearch> response) {
        if (response.body() != null && response.body().getResults() != null) {
            if (response.body().getResults().size() != 0) {
                Log.d(TAG, "Response: " + response.body().getResults().size());
                searchCallback.onSuccess(response.body());
            } else {
                searchCallback.onError(new EmptyException());
            }
        } else {
            searchCallback.onError(new EmptyException());
        }
    }

}