package com.github.rogerp91.ml.detail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class DetailRouter implements DetailContract.Router {

    private DetailContract.View mView;

    FragmentManager supportFragmentManager;

    public DetailRouter(DetailContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void goToFragmentSection(Fragment fragment) {
    }

    @Override
    public void unRegister() {
        mView = null;
    }
}
