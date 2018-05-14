package com.github.rogerp91.ml.services.definition;

import com.github.rogerp91.ml.data.model.QuerySearch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SearchDefinition {

    @GET("sites/{site}/search")
    Call<QuerySearch> searchQuery(@Path("site") String site, @Query("q") String q, @Query("paging") String paging);

}