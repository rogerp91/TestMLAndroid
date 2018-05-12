package com.github.rogerp91.ml.common;

import android.content.Context;

public interface BaseView<T> {

    void setPresenter(T t);

    Context getContextApp();

}