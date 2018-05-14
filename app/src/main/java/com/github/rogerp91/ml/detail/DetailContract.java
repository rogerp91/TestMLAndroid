package com.github.rogerp91.ml.detail;

import android.support.v4.app.Fragment;

import com.github.rogerp91.ml.common.BasePresenter;
import com.github.rogerp91.ml.common.BaseRouter;
import com.github.rogerp91.ml.common.BaseView;
import com.github.rogerp91.ml.data.model.Attribute;
import com.github.rogerp91.ml.data.model.Picture;
import com.github.rogerp91.ml.data.model.Product;
import com.github.rogerp91.ml.data.model.SellerAddress;

import java.util.List;

public interface DetailContract {

    interface View extends BaseView<DetailContract.Presenter> {

        void showPicture(List<Picture> pictures);

        void showDescription(Product product);

        void showSellerAddress(SellerAddress sellerAddress, String warranty);

        void showAttributes(List<Attribute> attributes);

        void showOtherProduct();
    }

    interface Presenter extends BasePresenter {

        void getDetailProduct();

    }

    interface Router extends BaseRouter {

        void goToFragmentSection(Fragment fragment);

    }

}
