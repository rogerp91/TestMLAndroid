package com.github.rogerp91.ml.item;

import android.support.v4.app.FragmentManager;

import com.github.rogerp91.ml.common.BasePresenter;
import com.github.rogerp91.ml.common.BaseRouter;
import com.github.rogerp91.ml.common.BaseView;
import com.github.rogerp91.ml.data.model.Result;

import java.util.List;

public interface ItemContract {

    interface View extends BaseView<Presenter> {

        void showSearchedResult(List<Result> results);

        void showProgress();

        void hideProgress();

        boolean isActive();

        void hideSoftKeyboard();

    }

    interface Presenter extends BasePresenter {

        void queryTextSubmit(String query);

        void queryTextChange(String query);

        void setLast(ItemActivity.SearchCallback searchCallback);

        void goToDetail(Result result);

        void goToDetail(Result result, List<Result> results);

        void goToDetail(String idProduct);

        void goToSearch(FragmentManager supportFragmentManager, ItemFragment mItemFragment);

        void becomingSearch(FragmentManager supportFragmentManager, ItemFragment mItemFragment);
    }

    interface Router extends BaseRouter {

        void goToDetail(Result result);

        void goToDetail(Result result, List<Result> results);

        void goToDetail(String idProduct);

        void goToSearch(FragmentManager supportFragmentManager, ItemFragment mItemFragment);

        void becomingSearch(FragmentManager supportFragmentManager, ItemFragment mItemFragment);
    }

}