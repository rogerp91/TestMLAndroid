package com.github.rogerp91.ml.main;

import android.util.Log;

import com.github.rogerp91.ml.data.model.Search;
import com.github.rogerp91.ml.data.source.SearchDataSource;
import com.github.rogerp91.ml.item.ItemContract;
import com.github.rogerp91.ml.util.ProductSuggestion;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private SearchDataSource mRepository;
    private ItemContract.Router mRouter;

    private String mQuery;

    public MainPresenter(MainContract.View mView, SearchDataSource mRepository) {
        this.mView = mView;
        this.mRepository = mRepository;
        this.mView.setPresenter(this);
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void searchTextChanged(String oldQuery, String newQuery) {
        if (mView != null) {
            if (!oldQuery.equals("") && newQuery.equals("")) {
                mView.getFloatingSearchView().clearSuggestions();
            } else {
                mView.getFloatingSearchView().showProgress();
                searchQuery(newQuery);
            }
        }
    }

    private void searchQuery(String newQuery) {
        mRepository.getSearchLike(newQuery, new SearchDataSource.GetSearchLikeCallback() {
            @Override
            public void onSearchLoaded(String[] searchs) {
                if (searchs.length == 0) {
                    return;
                }
                Log.d("BlankFragment NUMBER", String.valueOf(searchs.length));
                List<ProductSuggestion> productSuggestions = new ArrayList<>();
                for (String search : searchs) {
                    ProductSuggestion product = new ProductSuggestion(search);
                    productSuggestions.add(product);
                }

                mView.setWapSuggestions(productSuggestions);
            }

            @Override
            public void onDataNotAvailable() {
                mRepository.saveSearch(new Search(newQuery));
            }
        });

    }

    @Override
    public void suggestionClicked(String name) {
        mRepository.saveSearch(new Search(name));
    }

    @Override
    public void searchAction() {

    }

    @Override
    public void setOnFocusChangeListener() {

    }

    @Override
    public void setFocusCleared() {

    }

    private String getString(int res) {
        return mView.getContextActivity().getString(res);
    }

}
