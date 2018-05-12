package com.github.rogerp91.ml.common;

import com.github.rogerp91.ml.BuildConfig;
import com.github.rogerp91.ml.util.Const;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class AbstractRestService<T> {

    private final static String TAG = AbstractRestService.class.getSimpleName();

    private T service;

    public T getService() {
        if (service == null)
            service = createService(getRestApiDefinitionInterface());
        return service;
    }

    private T createService(Class<T> definitionInterface) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Const.Api.END_POINT).addConverterFactory(GsonConverterFactory.create()).client(getOkHttpClient()).build();
        return retrofit.create(definitionInterface);
    }

    private OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(getRequestInterceptor())
                .build();
    }

    private HttpLoggingInterceptor getRequestInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        return loggingInterceptor;
    }

    protected abstract Class<T> getRestApiDefinitionInterface();

    public abstract void call();

}