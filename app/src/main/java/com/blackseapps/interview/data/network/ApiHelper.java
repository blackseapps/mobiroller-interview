package com.blackseapps.interview.data.network;

import com.blackseapps.interview.data.network.model.Product;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import io.reactivex.Single;

/**
 * Created by mertKaradeniz on 19.10.2021
 * <p>
 * This is an interview project.
 */

public interface ApiHelper {

    DatabaseReference getProductApiCall();

    Single<Product> setProductApiCall(Product product);

    Query getSortByNameIncreasingApiCall();

    Query getSortByNameDescendingApiCall();

    Query getSortByPriceIncreasingApiCall();

    Query getSortByPriceDescendingApiCall();

    Query deleteProductApiCall();

    DatabaseReference updateProductApiCall(Product product);

}

