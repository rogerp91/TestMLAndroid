package com.github.rogerp91.ml.domain.executor;

import android.os.Handler;
import android.os.Looper;

public class MainThread implements MT {

    private Handler handler;

    public MainThread() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void post(Runnable task) {
        handler.post(task);
    }
}
