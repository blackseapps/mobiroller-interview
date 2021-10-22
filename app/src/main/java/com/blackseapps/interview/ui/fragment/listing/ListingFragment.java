package com.blackseapps.interview.ui.fragment.listing;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
import com.blackseapps.interview.ui.activity.details.DetailsActivity;
import com.blackseapps.interview.ui.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListingFragment extends BaseFragment implements ListingMvpView, ListingAdapter.Callback {

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
            listingAdapter.setCallback(this);
            setHasOptionsMenu(true);
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
    public void onSortListDescending() {
        listingAdapter.reverseList();
    }

    @Override
    public void onResponseError(String error) {
        mLayoutManager.setSpanCount(1);
    }

    @Override
    public void onResponseEmpty(String message) {
        mLayoutManager.setSpanCount(1);
    }

    @Override
    public void onRetryClick() {

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.listing_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Drawable drawable = item.getIcon();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
        switch (item.getItemId()) {
            case R.id.action_sorting_name_growing:
                mPresenter.onSortByNameIncreasing();
                break;
            case R.id.action_sorting_name_decreasing:
                mPresenter.onSortByNameDescending();
                break;
            case R.id.action_sorting_price_growing:
                mPresenter.onSortByPriceIncreasing();
                break;
            case R.id.action_sorting_price_decreasing:
                mPresenter.onSortByPriceDescending();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(Product product) {
        Intent intent = DetailsActivity.getStartIntent(getContext(), product);
        startActivity(intent);
    }
}
