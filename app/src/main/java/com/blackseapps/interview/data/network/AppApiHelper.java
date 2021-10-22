package com.blackseapps.interview.data.network;

import com.blackseapps.interview.BuildConfig;
import com.blackseapps.interview.data.network.model.Category;
import com.blackseapps.interview.data.network.model.Product;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by mertKaradeniz on 19.10.2021
 * <p>
 * This is an interview project.
 */

@Singleton
public class AppApiHelper implements ApiHelper {


    @Inject
    public AppApiHelper() {

    }

    @Override
    public DatabaseReference getProductApiCall() {
        return FirebaseDatabase.
                getInstance(BuildConfig.BASE_URL).
                getReference().
                getDatabase().
                getReference(ApiEndPoint.ENDPOINT_PRODUCT);
    }

    @Override
    public DatabaseReference getCategoryApiCall() {
        return FirebaseDatabase.
                getInstance(BuildConfig.BASE_URL).
                getReference().
                getDatabase().
                getReference(ApiEndPoint.ENDPOINT_PRODUCT);
    }

    @Override
    public Single<Product> setProductApiCall(Product product) {
        DatabaseReference myRef = FirebaseDatabase.
                getInstance(BuildConfig.BASE_URL).
                getReference().
                getDatabase().
                getReference(ApiEndPoint.ENDPOINT_PRODUCT);
        myRef.push().setValue(product);
        return null;
    }

    @Override
    public Single<Category> setCategoryApiCall(Category category) {
        DatabaseReference myRef = FirebaseDatabase.
                getInstance(BuildConfig.BASE_URL).
                getReference().
                getDatabase().
                getReference(ApiEndPoint.ENDPOINT_CATEGORY);
        myRef.push().setValue(category);

        return null;
    }

    @Override
    public Query getSortByNameIncreasingApiCall() {
        return FirebaseDatabase.
                getInstance(BuildConfig.BASE_URL).
                getReference().
                getDatabase().
                getReference(ApiEndPoint.ENDPOINT_PRODUCT).
                orderByChild("title");
    }

    @Override
    public Query getSortByNameDescendingApiCall() {
        return FirebaseDatabase.
                getInstance(BuildConfig.BASE_URL).
                getReference().
                getDatabase().
                getReference(ApiEndPoint.ENDPOINT_PRODUCT).
                orderByChild("title");
    }

    @Override
    public Query getSortByPriceIncreasingApiCall() {
        return FirebaseDatabase.
                getInstance(BuildConfig.BASE_URL).
                getReference().
                getDatabase().
                getReference(ApiEndPoint.ENDPOINT_PRODUCT).
                orderByChild("price");
    }

    @Override
    public Query getSortByPriceDescendingApiCall() {
        return FirebaseDatabase.
                getInstance(BuildConfig.BASE_URL).
                getReference().
                getDatabase().
                getReference(ApiEndPoint.ENDPOINT_PRODUCT).
                orderByChild("price");
    }
}

