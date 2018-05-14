package com.github.rogerp91.ml.common;

import com.github.rogerp91.ml.data.model.Product;

public interface ProductDetailCallback {

    void onSuccess(Product product);

    void onError(Exception e);

}