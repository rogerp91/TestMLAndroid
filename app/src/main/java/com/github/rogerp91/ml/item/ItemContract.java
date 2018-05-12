package com.github.rogerp91.ml.item;

import android.support.annotation.NonNull;

import com.github.rogerp91.ml.common.BasePresenter;
import com.github.rogerp91.ml.common.BaseRouter;
import com.github.rogerp91.ml.common.BaseView;
import com.github.rogerp91.ml.data.model.Result;
import com.github.rogerp91.ml.domain.interactor.ItemList;
import com.github.rogerp91.ml.domain.interactor.RunInteractor;

public interface ItemContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {

        void queryTextSubmit(String query);

        void queryTextChange(String query);

        String[] getStrings();
    }

    interface Router extends BaseRouter {

    }

    interface Interactor extends RunInteractor {

        interface Callback {

            void onUserListLoaded(@NonNull Result result);

            void onError(Exception e);
        }

        void execute(ItemList.Callback callback);
    }
}