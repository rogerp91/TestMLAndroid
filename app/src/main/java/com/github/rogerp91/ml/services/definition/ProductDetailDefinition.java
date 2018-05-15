package com.github.rogerp91.ml.services.definition;

import com.github.rogerp91.ml.data.model.Product;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 *  Definición de APIs de api de ML - Búsqueda de Item
 */
public interface ProductDetailDefinition {

    @GET("items/{id}")
    Call<Product> productDetail(@Path("id") String id);

}