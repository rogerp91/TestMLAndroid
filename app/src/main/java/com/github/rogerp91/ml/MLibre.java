package com.github.rogerp91.ml;

import android.app.Application;

import com.github.rogerp91.ml.util.Prefs;

public class MLibre extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        new Prefs.Builder().setContext(this).build();
    }
}