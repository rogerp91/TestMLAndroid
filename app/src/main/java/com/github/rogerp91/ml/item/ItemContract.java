package com.github.rogerp91.ml.item;

import com.github.rogerp91.ml.common.BasePresenter;
import com.github.rogerp91.ml.common.BaseRouter;
import com.github.rogerp91.ml.common.BaseView;

public interface ItemContract {

    interface View extends BaseView<Presenter> {

        boolean isActive();

    }

    interface Presenter extends BasePresenter {

        void queryTextSubmit(String query);

        void queryTextChange(String query);

        void setLast(ItemActivity.SearchCallback searchCallback);
    }

    interface Router extends BaseRouter {

    }

}