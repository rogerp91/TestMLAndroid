package com.github.rogerp91.ml.services.definition;

import com.github.rogerp91.ml.data.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SearchDefinition {

    @GET("sites/{site}/search")
    Call<Result> searchQuery(@Path("site") String site, @Query("q") String q, @Query("paging") String paging);

}