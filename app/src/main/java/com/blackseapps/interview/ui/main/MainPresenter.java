package com.blackseapps.interview.ui.main;

import com.blackseapps.interview.data.DataManager;
import com.blackseapps.interview.ui.base.BasePresenter;
import com.blackseapps.interview.ui.fragment.adding.AddingMvpPresenter;
import com.blackseapps.interview.ui.fragment.adding.AddingMvpView;

import javax.inject.Inject;

/**
 * Created by mertKaradeniz on 17.10.2021
 * <p>
 * This is an interview project.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V> {

    @Inject
    public MainPresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void onOpenAddingFragment() {
        getMvpView().showAddingFragment();
    }

    @Override
    public void onOpenListingFragment() {
        getMvpView().showListingFragment();
    }
}
