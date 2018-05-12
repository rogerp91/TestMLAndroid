package com.github.rogerp91.ml.item;

import android.content.Context;

public class ItemRouter implements ItemContract.Router {

    private Context mContext;

    public ItemRouter(Context mContext) {
        if (mContext != null) {
            this.mContext = mContext;
        }
    }

    @Override
    public void unRegister() {

    }
}