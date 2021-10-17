package com.blackseapps.interview.ui.fragment.listing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.blackseapps.interview.R;
import com.blackseapps.interview.ui.base.BaseFragment;

public class ListingFragment extends BaseFragment {


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

        return view;
    }

    @Override
    protected void setUp(View view) {

    }
}
