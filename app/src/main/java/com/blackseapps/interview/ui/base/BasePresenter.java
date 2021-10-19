package com.blackseapps.interview.ui.base;


import com.blackseapps.interview.data.DataManager;

import javax.inject.Inject;

public class BasePresenter<V extends BaseMvpView> implements BaseMvpPresenter<V> {

    private final DataManager mDataManager;

    private V mMvpView;

    @Inject
    public BasePresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    public DataManager getDataManager() {
        return mDataManager;
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
