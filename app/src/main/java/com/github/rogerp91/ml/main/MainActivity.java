package com.github.rogerp91.ml.main;

import android.os.Bundle;

import com.github.rogerp91.ml.R;
import com.github.rogerp91.ml.common.BaseActivity;
import com.github.rogerp91.ml.data.source.SearchDataSource;
import com.github.rogerp91.ml.data.source.SearchRepository;
import com.github.rogerp91.ml.data.source.local.SearchDatabase;
import com.github.rogerp91.ml.data.source.local.SearchLocalDataSource;
import com.github.rogerp91.ml.util.AppExecutors;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (mainFragment == null) {
            mainFragment = MainFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mainFragment).commit();
        }

        SearchDatabase database = SearchDatabase.getInstance(getApplicationContext());
        SearchDataSource mRepository = SearchRepository.getInstance(SearchLocalDataSource.getInstance(new AppExecutors(), database.searchDao()));

        new MainPresenter(mainFragment, mRepository);
    }

}