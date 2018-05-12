package com.github.rogerp91.ml.item;

import com.github.rogerp91.ml.R;
import com.github.rogerp91.ml.common.SearchCallback;
import com.github.rogerp91.ml.data.Search;
import com.github.rogerp91.ml.data.model.Result;
import com.github.rogerp91.ml.data.source.SearchDataSource;
import com.github.rogerp91.ml.services.SearchItem;

import java.io.IOException;
import java.net.SocketTimeoutException;

public class ItemPresenter implements ItemContract.Presenter, SearchCallback {

    private final static String TAG = ItemPresenter.class.getSimpleName();

    private ItemContract.View mView;
    private SearchDataSource mRepository;
    private ItemContract.Router mRouter;

    private String mQuery;

    public ItemPresenter(ItemContract.View mView, SearchDataSource mRepository) {
        this.mView = mView;
        this.mRepository = mRepository;

        this.mRouter = new ItemRouter(this.mView.getContextApp());
        this.mView.setPresenter(this);
    }

    @Override
    public void onDestroy() {
        mView = null;
        mRouter = null;
    }

    @Override
    public void queryTextSubmit(String query) {
        if (query.isEmpty()) {
            return;
        }
        if (query.length() < 3) {
            return;
        }
        mQuery = query;
        SearchItem.with(this).site("MLA").query(query).pag("1").call();
    }

    @Override
    public void queryTextChange(String query) {
        if (query.isEmpty()) {
            return;
        }
        if (query.length() < 2) {
            return;
        }
        if (query.length() < 3) {
            return;
        }
        mQuery = query;
        SearchItem.with(this).site("MLA").query(query).pag("1").call();
    }

    @Override
    public void setLast(ItemActivity.SearchCallback searchCallback) {
        mRepository.getSearch(new SearchDataSource.GetSearchCallback() {
            @Override
            public void onSearchLoaded(String[] searchs) {
                if (searchs.length == 0) {
                    return;
                }
                if (!mView.isActive()) {
                    return;
                }
                searchCallback.lastSearches(searchs);
            }

            @Override
            public void onDataNotAvailable() {
                if (!mView.isActive()) {
                    return;
                }
                searchCallback.lastSearches(new String[0]);
            }
        });
    }

    @Override
    public void onSuccess(Result result) {
        if (!mView.isActive()) {
            return;
        }
        mRepository.saveSearch(new Search(mQuery));
    }

    @Override
    public void onError(Exception e) {
        if (!mView.isActive()) {
            return;
        }
        if (e instanceof SocketTimeoutException) {
            mView.showMessage(mView.getContextApp().getString(R.string.time_out_error));
        } else {
            if (e instanceof IOException) {
                mView.showMessage(mView.getContextApp().getString(R.string.io_error));
            } else {
                mView.showMessage(mView.getContextApp().getString(R.string.error_ocurred) + e.getMessage());
            }
        }
    }
}