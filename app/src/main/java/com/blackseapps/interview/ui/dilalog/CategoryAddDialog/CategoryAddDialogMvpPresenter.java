package com.blackseapps.interview.ui.dilalog.CategoryAddDialog;

import com.blackseapps.interview.ui.base.BaseMvpPresenter;

/**
 * Created by mertKaradeniz on 21.10.2021
 * <p>
 * This is an interview project.
 */

public interface CategoryAddDialogMvpPresenter<V extends CategoryAddDialogMvpView> extends BaseMvpPresenter<V> {

    void onCancelClicked();

}
