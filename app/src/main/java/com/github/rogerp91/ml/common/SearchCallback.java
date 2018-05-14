package com.github.rogerp91.ml.common;

import com.github.rogerp91.ml.data.model.QuerySearch;

public interface SearchCallback {

    void onSuccess(QuerySearch querySearch);

    void onError(Exception e);

}