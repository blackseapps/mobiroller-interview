package com.blackseapps.interview.ui.fragment.listing;

import com.blackseapps.interview.data.DataManager;
import com.blackseapps.interview.data.network.model.Product;
import com.blackseapps.interview.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by mertKaradeniz on 17.10.2021
 * <p>
 * This is an interview project.
 */

public class ListingPresenter<V extends ListingMvpView> extends BasePresenter<V>
        implements ListingMvpPresenter<V> {

    @Inject
    public ListingPresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void requestProduct(Product product) {
        getDataManager().setProductApiCall(product);
    }
}
