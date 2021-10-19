package com.blackseapps.interview.data;

import com.blackseapps.interview.data.network.ApiHelper;
import com.blackseapps.interview.data.network.model.Category;
import com.blackseapps.interview.data.network.model.Product;
import com.google.firebase.database.DatabaseReference;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by mertKaradeniz on 19.10.2021
 * <p>
 * This is an interview project.
 */

public class AppDataManager implements DataManager {

    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(ApiHelper mApiHelper) {
        this.mApiHelper = mApiHelper;
    }


    @Override
    public DatabaseReference getProductApiCall() {
        return mApiHelper.getProductApiCall();
    }

    @Override
    public DatabaseReference getCategoryApiCall() {
        return mApiHelper.getCategoryApiCall();
    }

    @Override
    public Single<Product> setProductApiCall(Product product) {
        return mApiHelper.setProductApiCall(product);
    }

    @Override
    public Single<Category> setCategoryApiCall(Category category) {
        return mApiHelper.setCategoryApiCall(category);
    }
}
