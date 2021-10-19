package com.blackseapps.interview.ui.fragment.listing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.blackseapps.interview.R;
import com.blackseapps.interview.data.network.model.Product;
import com.blackseapps.interview.di.component.ActivityComponent;
import com.blackseapps.interview.ui.base.BaseFragment;

import javax.inject.Inject;

public class ListingFragment extends BaseFragment implements ListingMvpView {


    @Inject
    Product product;

    @Inject
    ListingMvpPresenter<ListingMvpView> mPresenter;

    public static final String TAG = "ListingFragment";

    public static ListingFragment newInstance() {
        Bundle args = new Bundle();
        ListingFragment fragment = new ListingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_listing, container, false);


        ActivityComponent component = getActivityComponent();

        if (component != null) {
            component.inject(this);
            mPresenter.onAttach(this);
        }

        product.setTitle("test");
        product.setDescription("test");
        product.setCategoryUid(0);
        product.setPrice("test");
        product.setBrandName("test");
        product.setStockCode("test");
        product.setStockTotal(10);


        mPresenter.requestProduct(product);

        return view;
    }

    @Override
    protected void setUp(View view) {

    }

    @Override
    public void openActivityOnTokenExpire() {

    }

}
