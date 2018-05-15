package com.github.rogerp91.ml.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

/**
 * Clase para usar las @{@link SharedPreferences}
 */
public class Prefs {

    public final static String PREF_SUCCESSFUL_SEARCH_RESULT = "PREF_SUCCESSFUL_SEARCH_RESULT";
    public static final String PREF_USER_API_KEY = "PREF_USER_API_KEY";
    public static final String PREF_USER_ID = "PREF_USER_ID";
    public static final String PREF_LATERAL_MENU_ITEMS = "PREF_LATERAL_MENU_ITEMS";

    private static final String LENGTH = "#LENGTH";
    private static SharedPreferences mPrefs;

    private static void initPrefs(Context context) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    private static SharedPreferences getPreferences() {
        if (mPrefs != null) {
            return mPrefs;
        }
        throw new RuntimeException("Prefs class Application class.");

    }

    public static boolean getBoolean(final String key) {
        return getPreferences().getBoolean(key, Boolean.FALSE);
    }

    @NonNull
    public static String getString(final String key) {
        return getPreferences().getString(key, "");
    }

    public static void putBoolean(final String key, final boolean value) {
        final Editor editor = getPreferences().edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static void putString(final String key, final String value) {
        final Editor editor = getPreferences().edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void remove(final String key) {
        SharedPreferences prefs = getPreferences();
        final Editor editor = prefs.edit();
        if (prefs.contains(key + LENGTH)) {
            int stringSetLength = prefs.getInt(key + LENGTH, -1);
            if (stringSetLength >= 0) {
                editor.remove(key + LENGTH);
                for (int i = 0; i < stringSetLength; i++) {
                    editor.remove(key + "[" + i + "]");
                }
            }
        }
        editor.remove(key);

        editor.apply();
    }

    public static boolean contains(final String key) {
        return getPreferences().contains(key);
    }

    public static Editor clear() {
        final Editor editor = getPreferences().edit().clear();
        editor.apply();
        return editor;
    }

    public static Editor edit() {
        return getPreferences().edit();
    }

    public final static class Builder {
        private Context mContext;

        public Builder setContext(final Context context) {
            mContext = context;
            return this;
        }

        public void build() {
            if (mContext == null) {
                throw new RuntimeException("Context not set");
            }

            Prefs.initPrefs(mContext);
        }
    }
}
