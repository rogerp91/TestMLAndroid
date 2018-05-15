package com.github.rogerp91.ml.main;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.github.rogerp91.ml.common.BasePresenter;
import com.github.rogerp91.ml.common.BaseRouter;
import com.github.rogerp91.ml.common.BaseView;
import com.github.rogerp91.ml.util.ProductSuggestion;

import java.util.List;

public interface MainContract {

    interface View extends BaseView<Presenter> {

        FloatingSearchView getFloatingSearchView();

        void setWapSuggestions(List<ProductSuggestion> wapSuggestions);

    }

    interface Presenter extends BasePresenter {

        void searchTextChanged(String oldQuery, final String newQuery);

        void suggestionClicked(String name);

        void searchAction();

        void setOnFocusChangeListener();

        void setFocusCleared();

    }

    interface Router extends BaseRouter {

    }

}