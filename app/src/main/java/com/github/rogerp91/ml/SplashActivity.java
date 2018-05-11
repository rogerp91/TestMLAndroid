package com.github.rogerp91.ml;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.github.rogerp91.ml.category.CategoryActivity;
import com.github.rogerp91.ml.common.BaseActivity;

import butterknife.BindView;

import static java.lang.Thread.sleep;

public class SplashActivity extends BaseActivity {

    private final static String TAG = SplashActivity.class.getSimpleName();

    @BindView(R.id.img_iso)
    public ImageView mImageIso;

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade);
        mImageIso.startAnimation(animation);
        initialize();
    }

    /**
     * Inicializar la animación
     */
    private void initialize() {
        Thread thread = new Thread(() -> {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                Log.e(TAG, e.getMessage());
            } finally {
                startActivity(new Intent(SplashActivity.this, CategoryActivity.class));
                finish();
            }
        });
        thread.start();
    }
}
