package com.blackseapps.interview.ui.base;

import android.view.View;

import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment implements BaseMvpView{

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void openActivityOnTokenExpire() {

    }

    @Override
    public void onError(int resId) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMessage(int resId) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void hideKeyboard() {

    }

    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }

    protected abstract void setUp(View view);

}
