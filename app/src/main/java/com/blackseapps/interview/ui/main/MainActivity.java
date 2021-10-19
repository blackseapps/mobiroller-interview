package com.blackseapps.interview.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;

import com.blackseapps.interview.R;
import com.blackseapps.interview.ui.base.BaseActivity;
import com.blackseapps.interview.ui.fragment.adding.AddingFragment;
import com.blackseapps.interview.ui.fragment.listing.ListingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainMvpView {


    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @BindView(R.id.nav_view)
    BottomNavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);
        setUp();
    }

    @Override
    protected void setUp() {
        setupNavMenu();
    }


    @Override
    public void showAddingFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .replace(R.id.nav_host_fragment_activity_main, AddingFragment.newInstance(), AddingFragment.TAG)
                .commit();
    }

    @Override
    public void showListingFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .replace(R.id.nav_host_fragment_activity_main, ListingFragment.newInstance(), ListingFragment.TAG)
                .commit();
    }

    @SuppressLint("NonConstantResourceId")
    void setupNavMenu() {
        mNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_listing:
                    mPresenter.onOpenListingFragment();
                    return true;
                case R.id.navigation_adding:
                    mPresenter.onOpenAddingFragment();
                    return true;
                default:
                    return false;
            }
        });
    }

}