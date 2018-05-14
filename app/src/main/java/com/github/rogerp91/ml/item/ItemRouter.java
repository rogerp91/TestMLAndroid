package com.github.rogerp91.ml.item;

import android.content.Intent;
import android.support.v4.app.FragmentManager;

import com.github.rogerp91.ml.R;
import com.github.rogerp91.ml.data.model.Result;
import com.github.rogerp91.ml.detail.DetailActivity;

import org.parceler.Parcels;

import java.util.List;

import static com.github.rogerp91.ml.util.Const.BUNDLE_RESULT;
import static com.github.rogerp91.ml.util.Const.BUNDLE_RESULT_ID;
import static com.github.rogerp91.ml.util.Const.BUNDLE_RESULT_LIST;

public class ItemRouter implements ItemContract.Router {

    private ItemContract.View mView;

    public ItemRouter(ItemContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void goToDetail(Result result) {
        Intent intent = new Intent(mView.getContextActivity(), DetailActivity.class);
        intent.putExtra(BUNDLE_RESULT, Parcels.wrap(result));
        mView.getContextActivity().startActivity(intent);
    }

    @Override
    public void goToDetail(Result result, List<Result> results) {
        Intent intent = new Intent(mView.getContextActivity(), DetailActivity.class);
        intent.putExtra(BUNDLE_RESULT, Parcels.wrap(result));
        intent.putExtra(BUNDLE_RESULT_LIST, Parcels.wrap(results));
        mView.getContextActivity().startActivity(intent);
    }

    @Override
    public void unRegister() {
        mView = null;
    }

    @Override
    public void goToDetail(String idProduct) {
        Intent intent = new Intent(mView.getContextActivity(), DetailActivity.class);
        intent.putExtra(BUNDLE_RESULT_ID, idProduct);
        mView.getContextActivity().startActivity(intent);
    }

    @Override
    public void goToSearch(FragmentManager supportFragmentManager, ItemFragment fragment) {
        supportFragmentManager.beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.search_container, fragment).commit();
    }

    @Override
    public void becomingSearch(FragmentManager supportFragmentManager, ItemFragment fragment) {
        supportFragmentManager.beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .remove(fragment).commit();
    }
}