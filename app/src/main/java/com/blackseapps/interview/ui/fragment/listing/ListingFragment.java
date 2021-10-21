package com.blackseapps.interview.ui.fragment.listing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blackseapps.interview.R;
import com.blackseapps.interview.data.network.model.Product;
import com.blackseapps.interview.di.component.ActivityComponent;
import com.blackseapps.interview.ui.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListingFragment extends BaseFragment implements ListingMvpView {

    public static final String TAG = "ListingFragment";


    @Inject
    ListingMvpPresenter<ListingMvpView> mPresenter;

    @Inject
    ListingAdapter listingAdapter;

    @Inject
    GridLayoutManager mLayoutManager;

    @BindView(R.id.listing_recycler_view)
    RecyclerView mRecyclerView;

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
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
        }

        mPresenter.requestProductList();

        return view;
    }

    @Override
    protected void setUp(View view) {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(listingAdapter);
    }

    @Override
    public void openActivityOnTokenExpire() {

    }

    @Override
    public void onResponseProduct(List<Product> productList) {
        mLayoutManager.setSpanCount(2);
        listingAdapter.addItems(productList);
    }

    @Override
    public void onResponseError(String error) {
        mLayoutManager.setSpanCount(1);
    }

    @Override
    public void onResponseEmpty(String message) {
        mLayoutManager.setSpanCount(1);
    }
}
