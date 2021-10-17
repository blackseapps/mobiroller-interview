package com.blackseapps.interview.ui.base;

public class BasePresenter<V extends BaseMvpView> implements BaseMvpPresenter<V> {
    @Override
    public void onAttach(V mvpView) {

    }

    @Override
    public void onDetach() {

    }

    @Override
    public void handleApiError(String error) {

    }

    @Override
    public void setUserAsLoggedOut() {

    }
}
