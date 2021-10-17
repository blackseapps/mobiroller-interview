package com.blackseapps.interview.ui.base;

import javax.inject.Inject;

public class BasePresenter<V extends BaseMvpView> implements BaseMvpPresenter<V> {


    private V mMvpView;

    @Inject
    public BasePresenter() {

    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    public V getMvpView() {
        return mMvpView;
    }

    @Override
    public void onDetach() {
        mMvpView = null;
    }

    @Override
    public void handleApiError(String error) {

    }

    @Override
    public void setUserAsLoggedOut() {

    }
}
