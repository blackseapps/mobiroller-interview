package com.blackseapps.interview.ui.base;

public interface BaseMvpPresenter<V extends BaseMvpView> {

    void onAttach(V mvpView);

    void onDetach();

    void handleApiError(String error);

    void setUserAsLoggedOut();
}
