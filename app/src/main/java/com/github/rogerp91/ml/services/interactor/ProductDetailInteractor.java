package com.github.rogerp91.ml.services.interactor;

import android.util.Log;

import com.github.rogerp91.ml.common.AbstractRestService;
import com.github.rogerp91.ml.common.ProductDetailCallback;
import com.github.rogerp91.ml.data.model.Product;
import com.github.rogerp91.ml.services.EmptyException;
import com.github.rogerp91.ml.services.definition.ProductDetailDefinition;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Servicio cliente para consumir los endpoints @{@link ProductDetailDefinition}
 * See {@linktourl https://es.wikipedia.org/wiki/Builder_(patr%C3%B3n_de_dise%C3%B1o)}
 */
public class ProductDetailInteractor extends AbstractRestService<ProductDetailDefinition> {

    private final static String TAG = ProductDetailInteractor.class.getSimpleName();

    private String idProduct;

    private static ProductDetailInteractor productDetailInteractor;
    private ProductDetailCallback productDetailCallback;

    public static ProductDetailInteractor with() {
        if (productDetailInteractor == null)
            productDetailInteractor = new ProductDetailInteractor();

        return productDetailInteractor;
    }

    public static ProductDetailInteractor with(ProductDetailCallback productDetailCallback) {
        if (productDetailInteractor == null)
            productDetailInteractor = new ProductDetailInteractor(productDetailCallback);

        return productDetailInteractor;
    }

    private ProductDetailInteractor() {
    }

    private ProductDetailInteractor(ProductDetailCallback productDetailCallback) {
        this.productDetailCallback = productDetailCallback;
    }

    public ProductDetailInteractor listener(ProductDetailCallback productDetailCallback) {
        this.productDetailCallback = productDetailCallback;
        return this;
    }

    public ProductDetailInteractor id(String id) {
        this.idProduct = id;
        return this;
    }

    @Override
    protected Class<ProductDetailDefinition> getRestApiDefinitionInterface() {
        return ProductDetailDefinition.class;
    }

    @Override
    public void call() {
        if (productDetailCallback == null) {
            throw new NullPointerException("Search callback is Null");
        } else {
            callApi();
        }
    }

    private void callApi() {
        getService().productDetail(idProduct).enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        productDetailCallback.onSuccess(response.body());
                    } else {
                        productDetailCallback.onError(new EmptyException());
                    }
                } else {
                    productDetailCallback.onError(new RuntimeException("Unexpected response " + response));
                }
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Log.e(TAG, t.getMessage());
                productDetailCallback.onError(new Exception(t.getMessage(), t.getCause()));
            }
        });
    }

}