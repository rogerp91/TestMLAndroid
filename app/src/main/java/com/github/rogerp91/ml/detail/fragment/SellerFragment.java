package com.github.rogerp91.ml.detail.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.rogerp91.ml.R;
import com.github.rogerp91.ml.common.BaseFragment;
import com.github.rogerp91.ml.data.model.SellerAddress;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SellerFragment extends BaseFragment implements BindFragment {

    @BindView(R.id.title)
    AppCompatTextView title;
    @BindView(R.id.location)
    TextView location;
    @BindView(R.id.ll_shipping)
    LinearLayout llShipping;
    @BindView(R.id.warranty)
    TextView warranty;
    @BindView(R.id.ll_warranty)
    LinearLayout llWarranty;
    @BindView(R.id.ll_seller)
    LinearLayout llSeller;

    @BindView(R.id.progress)
    ProgressBar progressBar;

    @Override
    public int getLayoutView() {
        return R.layout.fragment_seller;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void onViewReady(@Nullable Bundle savedInstanceState, @Nullable View view) {

    }

    @Override
    public void bind(Object... t) {
        progressBar.setVisibility(View.GONE);
        llSeller.setVisibility(View.VISIBLE);

        if (t[0] instanceof SellerAddress) {
            bindSellerAddress((SellerAddress) t[0]);
        }

        if (t[1] instanceof String) {
            bindWarranty((String) t[1]);
        }

    }

    private void bindWarranty(String s) {
        warranty.setText(s);
    }

    private void bindSellerAddress(SellerAddress sellerAddress) {
        String loc = sellerAddress.getCity().getName() + ", " + sellerAddress.getState().getName();
        location.setText(loc);
    }
}