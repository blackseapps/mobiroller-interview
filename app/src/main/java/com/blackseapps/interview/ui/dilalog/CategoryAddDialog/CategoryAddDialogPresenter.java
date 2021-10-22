package com.blackseapps.interview.ui.dilalog.CategoryAddDialog;

import com.blackseapps.interview.data.DataManager;
import com.blackseapps.interview.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by mertKaradeniz on 21.10.2021
 * <p>
 * This is an interview project.
 */

public class CategoryAddDialogPresenter<V extends CategoryAddDialogMvpView> extends BasePresenter<V> implements CategoryAddDialogMvpPresenter<V> {

    @Inject
    public CategoryAddDialogPresenter(DataManager mDataManager) {
        super(mDataManager);
    }


    @Override
    public void onCancelClicked() {

    }
}
