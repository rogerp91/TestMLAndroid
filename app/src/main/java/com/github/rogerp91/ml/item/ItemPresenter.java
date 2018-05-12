package com.github.rogerp91.ml.item;

import android.util.Log;

public class ItemPresenter implements ItemContract.Presenter {

    private final static String TAG = ItemPresenter.class.getSimpleName();

    private ItemContract.View mView;
    private ItemContract.Interactor mInteractor;
    private ItemContract.Router mRouter;

    public ItemPresenter(ItemContract.View mView, ItemContract.Interactor mInteractor) {
        this.mView = mView;
        this.mInteractor = mInteractor;

        this.mRouter = new ItemRouter(this.mView.getContextApp());
        this.mView.setPresenter(this);
    }

    @Override
    public void onDestroy() {
        mView = null;
        mRouter = null;
    }

    @Override
    public void queryTextSubmit(String query) {
        Log.w(TAG, "query1: " + query);
    }

    @Override
    public void queryTextChange(String query) {
        Log.w(TAG, "query2: " + query);
    }

    @Override
    public String[] getStrings() {
        return new String[]{"android", "ios", "java", "php"};
    }
}