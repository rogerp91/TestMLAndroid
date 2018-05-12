package com.github.rogerp91.ml.item;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.github.rogerp91.ml.R;
import com.github.rogerp91.ml.common.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemFragment extends BaseFragment implements ItemContract.View {

    @NonNull
    public static ItemFragment newInstance() {
        return new ItemFragment();
    }

    private ItemContract.Presenter mPresenter;

    @Override
    public int getLayoutView() {
        return R.layout.fragment_search;
    }

    @Override
    public String getName() {
        return getResources().getString(R.string.app_name);
    }

    @Override
    public void onViewReady(@Nullable Bundle savedInstanceState, @Nullable View view) {

    }

    @Override
    public void setPresenter(ItemContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public Context getContextApp() {
        return getActivity();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContextApp(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }
}
