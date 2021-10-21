package com.blackseapps.interview.ui.fragment.listing;

import android.util.Log;

import androidx.annotation.NonNull;

import com.blackseapps.interview.R;
import com.blackseapps.interview.data.DataManager;
import com.blackseapps.interview.data.network.model.Product;
import com.blackseapps.interview.ui.base.BasePresenter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
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

        referenceProduct.addValueEventListener(new ValueEventListener() {
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
                getMvpView().onResponseError(error.getMessage());
            }
        });
    }
}
