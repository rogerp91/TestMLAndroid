package com.github.rogerp91.ml.item;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.github.rogerp91.ml.R;
import com.github.rogerp91.ml.common.BaseActivity;
import com.github.rogerp91.ml.data.source.SearchDataSource;
import com.github.rogerp91.ml.data.source.SearchRepository;
import com.github.rogerp91.ml.data.source.local.SearchDatabase;
import com.github.rogerp91.ml.data.source.local.SearchLocalDataSource;
import com.github.rogerp91.ml.util.AppExecutors;
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
        initializeSearchFragment();

        searchView.setVoiceSearch(false);
        searchView.setCursorDrawable(R.drawable.custom_cursor);
        searchView.setEllipsize(true);

        SearchDatabase database = SearchDatabase.getInstance(getApplicationContext());
        SearchDataSource mRepository = SearchRepository.getInstance(SearchLocalDataSource.getInstance(new AppExecutors(), database.searchDao()));

        mPresenter = new ItemPresenter(mItemFragment, mRepository);

        searchOnQuery();
        searchOnSearch();
    }

    private void initializeSearchFragment() {
        mItemFragment = (ItemFragment) getSupportFragmentManager().findFragmentById(R.id.search_container);
        if (mItemFragment == null) {
            mItemFragment = ItemFragment.newInstance();
        }
    }

    private void searchOnSearch() {
        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                disableToolbarScrolling();
                mPresenter.goToSearch(getSupportFragmentManager(), mItemFragment);
                mPresenter.setLast(searchCallback);
            }

            @Override
            public void onSearchViewClosed() {
                enableToolbarScrolling();
                mPresenter.becomingSearch(getSupportFragmentManager(), mItemFragment);
            }

        });
    }

    private void searchOnQuery() {
        searchView.setHint(getString(R.string.search));
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mPresenter.queryTextSubmit(query);
                return Boolean.TRUE;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
//                mPresenter.queryTextChange(newText);
                return Boolean.TRUE;
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

    private ItemActivity.SearchCallback searchCallback = search -> {
//            searchView.setSuggestions(search);
    };

    public interface SearchCallback {

        void lastSearches(String[] search);

    }

}
