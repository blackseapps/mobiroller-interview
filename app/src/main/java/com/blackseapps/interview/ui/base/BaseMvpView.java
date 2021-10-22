package com.blackseapps.interview.ui.base;

import android.content.DialogInterface;

import androidx.annotation.StringRes;

public interface BaseMvpView {
    void showLoading();

    void hideLoading();

    void openActivityOnTokenExpire();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    boolean isNetworkConnected();

    void hideKeyboard();


}
