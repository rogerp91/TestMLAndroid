package com.github.rogerp91.ml.detail;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.github.rogerp91.ml.R;
import com.github.rogerp91.ml.common.BaseActivity;
import com.github.rogerp91.ml.data.model.Attribute;
import com.github.rogerp91.ml.data.model.Picture;
import com.github.rogerp91.ml.data.model.Product;
import com.github.rogerp91.ml.data.model.Result;
import com.github.rogerp91.ml.data.model.SellerAddress;
import com.github.rogerp91.ml.detail.fragment.CharacteristicsFragment;
import com.github.rogerp91.ml.detail.fragment.DescriptionFragment;
import com.github.rogerp91.ml.detail.fragment.OtherProductFragment;
import com.github.rogerp91.ml.detail.fragment.PictureFragment;
import com.github.rogerp91.ml.detail.fragment.SellerFragment;
import com.github.rogerp91.ml.util.Const;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;

public class DetailActivity extends BaseActivity implements DetailContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.nested_scroll)
    NestedScrollView nestedScroll;
    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;

    private DetailContract.Presenter mPresenter;

    private String idProduct;

    private Bundle savedInstanceState = null;

    private PictureFragment mPictureFragment;
    private DescriptionFragment mDescriptionFragment;
    private SellerFragment mSellerFragment;
    private CharacteristicsFragment mCharacteristicsFragment;
    private OtherProductFragment mOtherProductFragment;

    private Result mResult;
    private List<Result> mResults;

    @Override
    protected int getLayout() {
        return R.layout.activity_detail;
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
        setToolbar(toolbar);
        setName(getString(R.string.product));
        setToolbarHomeAsUpEnabled();

        if (getIntent() != null) {
            mResult = Parcels.unwrap(getIntent().getExtras().getParcelable(Const.BUNDLE_RESULT));
            mResults = Parcels.unwrap(getIntent().getExtras().getParcelable(Const.BUNDLE_RESULT_LIST));
            System.out.println("SIZ: " + mResults.size());
            setPresenter(new DetailPresenter(this, mResult.getId()));
            mPresenter.getDetailProduct();
        } else {
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showPicture(List<Picture> pictures) {
        mPictureFragment = (PictureFragment) getSupportFragmentManager().findFragmentById(R.id.section_picture);
        mPictureFragment.bind(pictures);
    }

    @Override
    public void showDescription(Product product) {
        mDescriptionFragment = (DescriptionFragment) getSupportFragmentManager().findFragmentById(R.id.section_description);
        mDescriptionFragment.bind(product, mResult);
    }

    @Override
    public void showSellerAddress(SellerAddress sellerAddress, String warranty) {
        mSellerFragment = (SellerFragment) getSupportFragmentManager().findFragmentById(R.id.section_seller);
        mSellerFragment.bind(sellerAddress, warranty);
    }

    @Override
    public void showAttributes(List<Attribute> attributes) {
        mCharacteristicsFragment = (CharacteristicsFragment) getSupportFragmentManager().findFragmentById(R.id.section_characteristics);
        mCharacteristicsFragment.bind(attributes);
    }

    @Override
    public void showOtherProduct() {
        mOtherProductFragment = (OtherProductFragment) getSupportFragmentManager().findFragmentById(R.id.section_other);
        mOtherProductFragment.bind(mResults);
    }

    @Override
    public void setPresenter(DetailContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public Activity getContextActivity() {
        return this;
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

}