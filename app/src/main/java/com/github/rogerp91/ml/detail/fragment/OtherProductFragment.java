package com.github.rogerp91.ml.detail.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.github.rogerp91.ml.R;
import com.github.rogerp91.ml.common.BaseFragment;
import com.github.rogerp91.ml.data.model.Result;
import com.github.rogerp91.ml.item.ItemFragment;
import com.github.rogerp91.ml.ui.adapte.OtherProductAdapte;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class OtherProductFragment extends BaseFragment implements BindFragment {

    @BindView(R.id.search_results_recycler)
    RecyclerView searchResultsRecycler;
    @BindView(R.id.progress)
    ProgressBar progress;

    private OtherProductAdapte mOtherProductAdapte;

    @Override
    public int getLayoutView() {
        return R.layout.fragment_other_product;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void onViewReady(@Nullable Bundle savedInstanceState, @Nullable View view) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        searchResultsRecycler.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void bind(Object... t) {
        progress.setVisibility(View.GONE);
        searchResultsRecycler.setVisibility(View.VISIBLE);

        List<Result> list = getListOfResultFromObject(t[0]);
        bindResult(list);
    }

    private void bindResult(List<Result> results) {
        mOtherProductAdapte = new OtherProductAdapte(results, onClickItem);
        mOtherProductAdapte.setHasStableIds(true);
        searchResultsRecycler.setAdapter(mOtherProductAdapte);
    }

    private List<Result> getListOfResultFromObject(final Object objectList) {
        List<Result> resultList = new ArrayList<>();
        if (objectList instanceof List<?>) {
            for (Object object : (List<?>) objectList) {
                if (object instanceof Result) {
                    resultList.add((Result) object);
                }
            }
        }
        return resultList;
    }


    private ItemFragment.ClickItemListener onClickItem = new ItemFragment.ClickItemListener() {
        @Override
        public void onClick(@NonNull Result result) {

        }

        @Override
        public void onClick(String idProduct) {

        }

        @Override
        public void onClick(@NonNull Result result, List<Result> results) {

        }
    };

}