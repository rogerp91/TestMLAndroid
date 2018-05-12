package com.github.rogerp91.ml.common;

import com.github.rogerp91.ml.data.model.Result;

public interface SearchCallback {

    void onSuccess(Result result);

    void onErrorLogin(Exception e);

}