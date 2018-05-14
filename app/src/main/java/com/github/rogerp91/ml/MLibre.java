package com.github.rogerp91.ml;

import android.app.Application;
import android.content.Context;

import com.github.rogerp91.ml.util.Prefs;

public class MLibre extends Application {

    private static MLibre instance;

    public synchronized static MLibre getInstance() {
        return instance;
    }

    public synchronized static Context getContext() {
        return instance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        new Prefs.Builder().setContext(this).build();
    }
}