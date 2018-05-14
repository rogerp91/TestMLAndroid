package com.github.rogerp91.ml.item;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.rogerp91.ml.R;
import com.github.rogerp91.ml.common.BaseFragment;
import com.github.rogerp91.ml.data.model.Result;
import com.github.rogerp91.ml.ui.adapte.ItemAdapte;

import java.util.List;

import butterknife.BindView;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static android.widget.GridLayout.HORIZONTAL;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemFragment extends BaseFragment implements ItemContract.View {

    @NonNull
    public static ItemFragment newInstance() {
        return new ItemFragment();
    }

    @BindView(R.id.search_results_recycler)
    RecyclerView rvSearchResult;

    @BindView(R.id.progress)
    ProgressBar progressBarBar;

    private ItemAdapte mItemAdapte;
    private ItemContract.Presenter mPresenter;

    @Override
    public int getLayoutView() {
        return R.layout.fragment_item;
    }

    @Override
    public String getName() {
        return getResources().getString(R.string.app_name);
    }

    @Override
    public void onViewReady(@Nullable Bundle savedInstanceState, @Nullable View view) {
        rvSearchResult.setHasFixedSize(true);

        DividerItemDecoration itemDecor = new DividerItemDecoration(getActivity(), HORIZONTAL);
        rvSearchResult.addItemDecoration(itemDecor);

        LinearLayoutManager linearManager = new LinearLayoutManager(getActivity());
        rvSearchResult.setLayoutManager(linearManager);
    }

    @Override
    public void setPresenter(ItemContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public Activity getContextActivity() {
        return getActivity();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void showSearchedResult(List<Result> results) {
        mItemAdapte = new ItemAdapte(results, onClickItem);
        mItemAdapte.setHasStableIds(true);
        rvSearchResult.setAdapter(mItemAdapte);
        hideSoftKeyboard();
    }

    @Override
    public void showProgress() {
        rvSearchResult.setVisibility(View.GONE);
        progressBarBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        Log.d("TAG", "hide");
        progressBarBar.setVisibility(View.GONE);
        rvSearchResult.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideSoftKeyboard() {
        if (getActivity().getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
            }
        }
    }

    private ClickItemListener onClickItem = new ClickItemListener() {
        @Override
        public void onClick(@NonNull Result result) {
            mPresenter.goToDetail(result);
        }

        @Override
        public void onClick(String idProduct) {
            mPresenter.goToDetail(idProduct);
        }

        @Override
        public void onClick(@NonNull Result result, List<Result> results) {
            mPresenter.goToDetail(result, results);
        }
    };

    public interface ClickItemListener {

        void onClick(@NonNull Result result);

        void onClick(@NonNull Result result, List<Result> results);

        void onClick(String idProduct);

    }

}
