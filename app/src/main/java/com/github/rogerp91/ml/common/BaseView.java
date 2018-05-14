package com.github.rogerp91.ml.common;

import android.app.Activity;

public interface BaseView<T> {

    void setPresenter(T t);

    Activity getContextActivity();

    void showMessage(String message);
}