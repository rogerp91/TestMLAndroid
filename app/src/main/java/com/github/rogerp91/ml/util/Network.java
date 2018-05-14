package com.github.rogerp91.ml.util;

import android.content.Context;
import android.net.ConnectivityManager;

import com.github.rogerp91.ml.MLibre;

public class Network {

    public static boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) MLibre.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

}