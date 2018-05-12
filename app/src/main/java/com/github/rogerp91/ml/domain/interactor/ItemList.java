package com.github.rogerp91.ml.domain.interactor;

import com.github.rogerp91.ml.domain.executor.Executor;
import com.github.rogerp91.ml.domain.executor.MainThread;
import com.github.rogerp91.ml.item.ItemContract;

public class ItemList implements ItemContract.Interactor {

    private final Executor executor;
    private final MainThread mainThread;

    private Callback callback;

    public ItemList(Executor executor, MainThread mainThread) {
        this.executor = executor;
        this.mainThread = mainThread;
    }

    @Override
    public void execute(Callback callback) {

    }

    @Override
    public void run() {

    }
}