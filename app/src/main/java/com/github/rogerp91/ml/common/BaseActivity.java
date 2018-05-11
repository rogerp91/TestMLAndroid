package com.github.rogerp91.ml.common;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        onCreateView(savedInstanceState);
    }

    protected void setToolbar(@NonNull Toolbar toolbar) {
        if (toolbar != null) {
            mToolbar = toolbar;
            mToolbar.setTitle("");
            mToolbar.setSubtitle("");
            setSupportActionBar(toolbar);
        }
    }

    protected void setToolbarHomeAsUpEnabled() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    protected void showToastMessage(@StringRes int message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    protected void setName(String name) {
        if (mToolbar != null) {
            mToolbar.setTitle(name);
        }
    }

    protected abstract int getLayout();

    protected abstract void onCreateView(Bundle savedInstanceState);

}