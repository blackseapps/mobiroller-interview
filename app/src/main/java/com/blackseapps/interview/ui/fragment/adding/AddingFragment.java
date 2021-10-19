package com.blackseapps.interview.ui.fragment.adding;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.blackseapps.interview.R;
import com.blackseapps.interview.ui.base.BaseFragment;

public class AddingFragment extends BaseFragment implements AddingMvpView {

    public static final String TAG = "AddingFragment";

    public static AddingFragment newInstance() {
        Bundle args = new Bundle();
        AddingFragment fragment = new AddingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_adding, container, false);

        return view;
    }

    @Override
    protected void setUp(View view) {

    }

    @Override
    public void openActivityOnTokenExpire() {

    }
}
