package com.blackseapps.interview.ui.fragment.adding;

/**
 * Created by mertKaradeniz on 17.10.2021
 * <p>
 * This is an interview project.
 */

import com.blackseapps.interview.data.DataManager;
import com.blackseapps.interview.ui.base.BasePresenter;

import javax.inject.Inject;

public class AddingPresenter<V extends AddingMvpView> extends BasePresenter<V>
        implements AddingMvpPresenter<V> {

    @Inject
    public AddingPresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void onViewPrepared() {

    }
}
