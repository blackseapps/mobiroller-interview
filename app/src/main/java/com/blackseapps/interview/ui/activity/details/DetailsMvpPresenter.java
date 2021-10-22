package com.blackseapps.interview.ui.activity.details;

import com.blackseapps.interview.ui.base.BaseMvpPresenter;
import com.blackseapps.interview.ui.main.MainMvpView;

/**
 * Created by mertKaradeniz on 17.10.2021
 * <p>
 * This is an interview project.
 */

public interface DetailsMvpPresenter<V extends DetailsMvpView> extends BaseMvpPresenter<V> {

    void onHandleDeleteItem(String uId);

    void onHandleUpdateItem(String uId);
}
