package com.blackseapps.interview.ui.activity.details;

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

public class DetailsPresenter<V extends DetailsMvpView> extends BasePresenter<V>
        implements DetailsMvpPresenter<V> {

    @Inject
    public DetailsPresenter(DataManager mDataManager) {
        super(mDataManager);
    }
}
