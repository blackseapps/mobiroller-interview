package com.blackseapps.interview.ui.dilalog.CategoryAddDialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentManager;

import com.blackseapps.interview.R;
import com.blackseapps.interview.di.component.ActivityComponent;
import com.blackseapps.interview.ui.base.BaseDialog;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by mertKaradeniz on 21.10.2021
 * <p>
 * This is an interview project.
 */

public class CategoryAddDialog extends BaseDialog implements CategoryAddDialogMvpView {

    private static final String TAG = "CategoryAddDialog";


    @Inject
    CategoryAddDialogPresenter<CategoryAddDialogMvpView> mPresenter;

    public static CategoryAddDialog newInstance() {
        CategoryAddDialog fragment = new CategoryAddDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_category_adding, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
        }

        return view;
    }

    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager, TAG);
    }


    @Override
    protected void setUp(View view) {

    }


    @Override
    public void dismissDialog() {
        super.dismissDialog(TAG);
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }
}
