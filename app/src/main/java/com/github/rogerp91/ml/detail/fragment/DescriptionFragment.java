package com.github.rogerp91.ml.detail.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.github.rogerp91.ml.R;
import com.github.rogerp91.ml.common.BaseFragment;
import com.github.rogerp91.ml.data.model.FreeMethod;
import com.github.rogerp91.ml.data.model.Product;
import com.github.rogerp91.ml.data.model.Result;

import butterknife.BindView;
import butterknife.OnClick;

public class DescriptionFragment extends BaseFragment implements BindFragment {

    @BindView(R.id.progress)
    ProgressBar progress;
    @BindView(R.id.title)
    AppCompatTextView title;
    @BindView(R.id.rating)
    RatingBar rating;
    @BindView(R.id.total)
    TextView total;
    @BindView(R.id.ll_rating)
    LinearLayout llRating;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.dues)
    TextView dues;
    @BindView(R.id.ll_dues)
    LinearLayout llDues;
    @BindView(R.id.ll_shipping)
    LinearLayout llShipping;
    @BindView(R.id.stock)
    TextView stock;
    @BindView(R.id.ll_stock)
    LinearLayout llStock;
    @BindView(R.id.buy)
    AppCompatButton buy;
    @BindView(R.id.add_car)
    AppCompatButton addCar;
    @BindView(R.id.ll_description)
    LinearLayout llDescription;
    @BindView(R.id.free)
    TextView free;

    private String mUrl;

    @Override
    public int getLayoutView() {
        return R.layout.fragment_description;
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
        progress.setVisibility(View.GONE);
        llDescription.setVisibility(View.VISIBLE);

        if (t[0] instanceof Product) {
            bindProduct((Product) t[0]);
        }

        if (t[1] instanceof Result) {
            bindResult((Result) t[1]);
        }
    }

    private void bindResult(Result result) {
        if (result.getReviews() != null) {
            if (result.getReviews().getRatingAverage() != null) {
                float f = result.getReviews().getRatingAverage().floatValue();
                rating.setRating(f);
                total.setText(String.format("(%s)", Integer.toString(result.getReviews().getTotal())));
            }
        }
    }

    private void bindProduct(Product product) {
        mUrl = product.getPermalink();

        title.setText(product.getTitle());
        if (product.getPrice() != null) {
            price.setText(String.format("$ %s", Double.toString(product.getPrice())));
        }

        if (product.getShipping() != null) {
            if (product.getShipping().getFreeMethods() != null) {
                FreeMethod freeMethod = product.getShipping().getFreeMethods().get(0);
                if (freeMethod.getRule().getFreeShippingFlag()) {
                    free.setText(R.string.product_free);
                } else {
                    free.setText(R.string.shipping_with_dues);
                }
            } else {
                free.setText(R.string.shipping_with_dues);
            }
        } else {
            llShipping.setVisibility(View.GONE);
        }

        try {
            stock.setText(String.format("%s %s", Integer.toString(product.getAvailableQuantity()), getString(R.string.produc_stock)));
        } catch (Exception e) {
            stock.setText(getString(R.string.quantity_available));
        }


    }

    @OnClick({R.id.buy, R.id.add_car})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buy:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(mUrl)));
                break;
            case R.id.add_car:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(mUrl)));
                break;
        }
    }
}