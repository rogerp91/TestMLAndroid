package com.github.rogerp91.ml.main;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;
import com.github.rogerp91.ml.R;
import com.github.rogerp91.ml.common.BaseFragment;
import com.github.rogerp91.ml.util.ProductSuggestion;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment implements AppBarLayout.OnOffsetChangedListener, MainContract.View {

    @NonNull
    public static MainFragment newInstance() {
        return new MainFragment();
    }

    private MainContract.Presenter mPresenter;
    private final String TAG = MainFragment.class.getSimpleName();

    @BindView(R.id.floating_search_view)
    FloatingSearchView mSearchView;

    @BindView(R.id.appbar)
    AppBarLayout mAppBar;

    private String mLastQuery = "";

    @Override
    public int getLayoutView() {
        return R.layout.fragment_main;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public Activity getContextActivity() {
        return getActivity();
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public FloatingSearchView getFloatingSearchView() {
        return mSearchView;
    }

    @Override
    public void onViewReady(@Nullable Bundle savedInstanceState, @Nullable View view) {
        mAppBar.addOnOffsetChangedListener(this);
        setupSearchBar();
    }

    private void setupSearchBar() {
        mSearchView.setOnQueryChangeListener((oldQuery, newQuery) -> {
            mPresenter.searchTextChanged(oldQuery, newQuery);
            Log.d(TAG, "onSearchTextChanged()");
        });

        mSearchView.setOnSearchListener(new FloatingSearchView.OnSearchListener() {
            @Override
            public void onSuggestionClicked(final SearchSuggestion searchSuggestion) {

                Log.d(TAG, "onSuggestionClicked()");
                mLastQuery = searchSuggestion.getBody();
                mPresenter.suggestionClicked(mLastQuery);
            }

            @Override
            public void onSearchAction(String query) {
                mLastQuery = query;
                mPresenter.suggestionClicked(query);
                Log.d(TAG, "onSearchAction()");
            }
        });

        mSearchView.setOnFocusChangeListener(new FloatingSearchView.OnFocusChangeListener() {
            @Override
            public void onFocus() {
                Log.d(TAG, "onFocus()");
            }

            @Override
            public void onFocusCleared() {
                Log.d(TAG, "onFocusCleared()");
            }
        });

        mSearchView.setOnMenuItemClickListener(item -> {

        });

        mSearchView.setOnBindSuggestionCallback((suggestionView, leftIcon, textView, item, itemPosition) -> {

        });
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        mSearchView.setTranslationY(verticalOffset);
    }

    @Override
    public void setWapSuggestions(List<ProductSuggestion> wapSuggestions) {
        mSearchView.swapSuggestions(wapSuggestions);
        mSearchView.hideProgress();
    }
}
