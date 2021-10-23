package com.blackseapps.interview.ui.activity.splash;

import android.os.Handler;
import android.os.Looper;

import com.blackseapps.interview.data.DataManager;
import com.blackseapps.interview.ui.base.BasePresenter;
import com.blackseapps.interview.ui.main.MainMvpPresenter;
import com.blackseapps.interview.ui.main.MainMvpView;

import javax.inject.Inject;

/**
 * Created by mertKaradeniz on 17.10.2021
 * <p>
 * This is an interview project.
 */

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V>
        implements SplashMvpPresenter<V> {

    private long milliseconds = 2000;

    @Inject
    public SplashPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);

        Handler handler = new Handler(Looper.getMainLooper());
        Runnable runnable = () -> getMvpView().openMainActivity();
        handler.postDelayed(runnable, milliseconds);
    }
}
