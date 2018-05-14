package com.github.rogerp91.ml.item;

import android.support.v4.app.FragmentManager;

import com.github.rogerp91.ml.R;
import com.github.rogerp91.ml.common.SearchCallback;
import com.github.rogerp91.ml.data.Search;
import com.github.rogerp91.ml.data.model.QuerySearch;
import com.github.rogerp91.ml.data.model.Result;
import com.github.rogerp91.ml.data.source.SearchDataSource;
import com.github.rogerp91.ml.services.EmptyException;
import com.github.rogerp91.ml.services.interactor.SearchInteractor;
import com.github.rogerp91.ml.util.Network;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;

public class ItemPresenter implements ItemContract.Presenter, SearchCallback {

    private final static String TAG = ItemPresenter.class.getSimpleName();

    private ItemContract.View mView;
    private SearchDataSource mRepository;
    private ItemContract.Router mRouter;

    private String mQuery;

    public ItemPresenter(ItemContract.View mView, SearchDataSource mRepository) {
        this.mView = mView;
        this.mRepository = mRepository;

        this.mRouter = new ItemRouter(this.mView);
        this.mView.setPresenter(this);
    }

    @Override
    public void onDestroy() {
        mView = null;
        mRouter = null;
    }

    @Override
    public void queryTextSubmit(String query) {
        if (query.isEmpty() || query.length() < 3) {
            return;
        }
        callSearch(query);
    }

    @Override
    public void queryTextChange(String query) {
        if (query.isEmpty() || query.length() < 3) {
            return;
        }
        callSearch(query);
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
    public void onSuccess(QuerySearch querySearch) {
        if (!mView.isActive()) {
            return;
        }
        mRepository.saveSearch(new Search(mQuery));
        mView.hideProgress();
        mView.showSearchedResult(querySearch.getResults());
    }

    @Override
    public void onError(Exception e) {
        if (!mView.isActive()) {
            return;
        }

        mView.hideSoftKeyboard();
        mView.hideProgress();
        if (e instanceof SocketTimeoutException) {
            mView.showMessage(getString(R.string.time_out_error));
        } else {
            if (e instanceof IOException) {
                mView.showMessage(getString(R.string.io_error));
            } else {
                if (e instanceof EmptyException) {
                    mView.showMessage(getString(R.string.not_result));
                } else {
                    mView.showMessage(getString(R.string.error_ocurred) + e.getMessage());
                }
            }
        }
    }

    @Override
    public void goToDetail(Result result) {
        mRouter.goToDetail(result);
    }

    @Override
    public void goToDetail(String idProduct) {
        mRouter.goToDetail(idProduct);
    }

    @Override
    public void goToDetail(Result result, List<Result> results) {
        mRouter.goToDetail(result, results);
    }

    private void callSearch(String query) {
        if (!Network.isNetworkConnected()) {
            mView.showMessage(getString(R.string.verify_network));
            return;
        }
        mQuery = query;

        mView.hideProgress();
        mView.showProgress();
        SearchInteractor.with(this).site("MLA").query(query).pag("1").call();
    }

    @Override
    public void goToSearch(FragmentManager supportFragmentManager, ItemFragment mItemFragment) {
        mRouter.goToSearch(supportFragmentManager, mItemFragment);
    }

    @Override
    public void becomingSearch(FragmentManager supportFragmentManager, ItemFragment mItemFragment) {
        mRouter.becomingSearch(supportFragmentManager, mItemFragment);
    }

    private String getString(int res) {
        return mView.getContextActivity().getString(res);
    }
}