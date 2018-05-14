package com.github.rogerp91.ml.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.github.rogerp91.ml.R;
import com.github.rogerp91.ml.common.BaseActivity;
import com.github.rogerp91.ml.item.ItemActivity;
import com.github.rogerp91.ml.util.Const;
import com.github.rogerp91.ml.util.Prefs;

import butterknife.BindView;

import static com.github.rogerp91.ml.util.Const.Splash.MILLIS;
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
        if (!Prefs.getBoolean(Const.Splash.PREF_SHOW_SPLASH)) {
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade);
            mImageIso.startAnimation(animation);
            initialize();
        } else {
            startActivity(new Intent(SplashActivity.this, ItemActivity.class));
            finish();
        }
    }

    /**
     * Inicializar la animación
     */
    private void initialize() {
        Thread thread = new Thread(() -> {
            try {
                sleep(MILLIS);
            } catch (InterruptedException e) {
                Log.e(TAG, e.getMessage());
            } finally {
                startActivity(new Intent(SplashActivity.this, ItemActivity.class));
                finish();
            }
        });
        thread.start();
        Prefs.putBoolean(Const.Splash.PREF_SHOW_SPLASH, Boolean.TRUE);
    }
}
