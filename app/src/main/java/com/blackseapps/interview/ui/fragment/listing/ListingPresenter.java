package com.blackseapps.interview.ui.fragment.listing;

import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;

import com.blackseapps.interview.R;
import com.blackseapps.interview.data.DataManager;
import com.blackseapps.interview.data.network.model.Product;
import com.blackseapps.interview.ui.activity.details.DetailsActivity;
import com.blackseapps.interview.ui.base.BasePresenter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

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
    public void requestProductList() {
        getMvpView().showLoading();

        DatabaseReference referenceProduct = getDataManager().getProductApiCall();
        referenceProduct.addValueEventListener(addValueEventListener);
    }

    @Override
    public void onSortByNameIncreasing() {
        getMvpView().showLoading();
        Query query = getDataManager().getSortByNameIncreasingApiCall();
        query.addValueEventListener(addValueEventListener);
    }

    @Override
    public void onSortByNameDescending() {
        getMvpView().onSortListDescending();
    }

    @Override
    public void onSortByPriceIncreasing() {
        getMvpView().showLoading();
        Query query = getDataManager().getSortByPriceIncreasingApiCall();
        query.addValueEventListener(addValueEventListener);
    }

    @Override
    public void onSortByPriceDescending() {
        getMvpView().onSortListDescending();
    }

    private ValueEventListener addValueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            List<Product> productList = new ArrayList<>();

            for (DataSnapshot ds : snapshot.getChildren()) {
                Product product = ds.getValue(Product.class);
                productList.add(product);
            }

            if (productList.size() > 0)
                getMvpView().onResponseProduct(productList);
            else
                getMvpView().onResponseEmpty(null);

            getMvpView().hideLoading();
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {
            getMvpView().onError(error.getMessage());
            getMvpView().hideLoading();
        }
    };


}
