package com.github.rogerp91.ml.item;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.github.rogerp91.ml.R;
import com.github.rogerp91.ml.common.BaseActivity;
import com.github.rogerp91.ml.domain.executor.MainThread;
import com.github.rogerp91.ml.domain.executor.PoolThreadExecutor;
import com.github.rogerp91.ml.domain.interactor.ItemList;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import butterknife.BindView;

public class ItemActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar tolbar;
    @BindView(R.id.search_view)
    MaterialSearchView searchView;
    @BindView(R.id.toolbarScroller)
    FrameLayout toolbarScroller;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.search_container)
    FrameLayout searchContainer;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    private ItemContract.Presenter mPresenter;

    private ItemFragment mItemFragment;

    @Override
    protected int getLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        setToolbar(tolbar);
        setName(getResources().getString(R.string.app_name));

        mItemFragment = (ItemFragment) getSupportFragmentManager().findFragmentById(R.id.search_container);
        if (mItemFragment == null) {
            mItemFragment = ItemFragment.newInstance();
        }

        mPresenter = new ItemPresenter(mItemFragment, new ItemList(new PoolThreadExecutor(), new MainThread()));
        initializeSearch();
    }

    private void initializeSearch() {
        searchView.setVoiceSearch(false);
        searchView.setCursorDrawable(R.drawable.custom_cursor);
        searchView.setEllipsize(true);
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mPresenter.queryTextSubmit(query);
                Snackbar.make(coordinatorLayout, "Query: " + query, Snackbar.LENGTH_LONG).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mPresenter.queryTextSubmit(newText);
                return Boolean.TRUE;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                disableToolbarScrolling();
                callFragmentCommit();
                searchView.setSuggestions(mPresenter.getStrings());
            }

            @Override
            public void onSearchViewClosed() {
                enableToolbarScrolling();
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .remove(mItemFragment).commit();
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (searchView.isSearchOpen()) {
            searchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }

    private void disableToolbarScrolling() {
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) toolbarScroller.getLayoutParams();
        params.setScrollFlags(0);
    }

    private void enableToolbarScrolling() {
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) toolbarScroller.getLayoutParams();
        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
    }

    private void callFragmentCommit() {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.search_container, mItemFragment).commit();
    }
}