package com.github.rogerp91.ml.detail;

import com.github.rogerp91.ml.R;
import com.github.rogerp91.ml.common.ProductDetailCallback;
import com.github.rogerp91.ml.data.model.Product;
import com.github.rogerp91.ml.services.EmptyException;
import com.github.rogerp91.ml.services.interactor.ProductDetailInteractor;

import java.io.IOException;
import java.net.SocketTimeoutException;

public class DetailPresenter implements DetailContract.Presenter {

    private DetailContract.View mView;
    private DetailContract.Router mRouter;
    private String idProduct;

    public DetailPresenter(DetailContract.View mView, String idProduct) {
        this.mView = mView;
        this.idProduct = idProduct;

        this.mRouter = new DetailRouter(this.mView);
        this.mView.setPresenter(this);
    }

    @Override
    public void onDestroy() {
        this.mView = null;
        this.idProduct = null;
    }

    @Override
    public void getDetailProduct() {
        ProductDetailInteractor.with().id(idProduct).listener(new ProductDetailCallback() {
            @Override
            public void onSuccess(Product product) {
                if (mView != null) {
                    mView.showPicture(product.getPictures());
                    mView.showDescription(product);
                    mView.showSellerAddress(product.getSellerAddress(), product.getWarranty());
                    mView.showAttributes(product.getAttributes());
                    mView.showOtherProduct();
                }
            }

            @Override
            public void onError(Exception e) {
                if (mView == null) {
                    return;
                }
                mapperError(e);
            }
        }).call();
    }

    private void mapperError(Exception e) {
        if (e instanceof SocketTimeoutException) {
            mView.showMessage(getString(R.string.time_out_error));
        } else {
            if (e instanceof IOException) {
                mView.showMessage(getString(R.string.io_error));
            } else {
                if (e instanceof EmptyException) {
                    mView.showMessage(getString(R.string.not_result));
                } else {
                    mView.showMessage(getString(R.string.error_ocurred) + e.getMessage());
                }
            }
        }
    }

    private String getString(int res) {
        return mView.getContextActivity().getString(res);
    }
}
