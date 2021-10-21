package com.blackseapps.interview.ui.fragment.listing;

import com.blackseapps.interview.data.network.model.Product;
import com.blackseapps.interview.ui.base.BaseMvpView;

import java.util.List;

/**
 * Created by mertKaradeniz on 17.10.2021
 * <p>
 * This is an interview project.
 */

public interface ListingMvpView extends BaseMvpView {

    void onResponseProduct(List<Product> productList);

    void onResponseError(String error);

    void onResponseEmpty(String message);
}
