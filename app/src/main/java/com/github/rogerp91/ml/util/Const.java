package com.github.rogerp91.ml.util;

public interface Const {

    String MODEL = "MODEL";
    String BRAND = "BRAND";
    String ITEM_CONDITION = "ITEM_CONDITION";

    String BUNDLE_RESULT = "BUNDLE_RESULT";
    String BUNDLE_RESULT_LIST = "BUNDLE_RESULT_LIST";
    String BUNDLE_RESULT_ID = "BUNDLE_RESULT_ID";

    String ARGUMENT_LIST_PICURE = "ARGUMENT_LIST_PICTURE";

    interface Splash {

        String PREF_SHOW_SPLASH = "PREF_SHOW_SPLASH";
        int MILLIS = 2000;

    }

    interface Api {

        String END_POINT = "https://api.mercadolibre.com/";
    }

}