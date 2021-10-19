package com.blackseapps.interview.ui.fragment.listing;

import com.blackseapps.interview.data.network.model.Product;
import com.blackseapps.interview.ui.base.BaseMvpPresenter;

/**
 * Created by mertKaradeniz on 17.10.2021
 * <p>
 * This is an interview project.
 */

public interface ListingMvpPresenter<V extends ListingMvpView> extends BaseMvpPresenter<V> {

    void requestProduct(Product product);
}
