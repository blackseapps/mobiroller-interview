package com.blackseapps.interview.ui.fragment.adding;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blackseapps.interview.R;
import com.blackseapps.interview.data.network.model.Product;
import com.blackseapps.interview.di.component.ActivityComponent;
import com.blackseapps.interview.ui.base.BaseFragment;
import com.blackseapps.interview.ui.fragment.listing.ListingMvpPresenter;
import com.blackseapps.interview.ui.fragment.listing.ListingMvpView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddingFragment extends BaseFragment implements AddingMvpView {

    public static final String TAG = "AddingFragment";

    @Inject
    Product product;

    @Inject
    AddingMvpPresenter<AddingMvpView> mPresenter;


    @BindView(R.id.productCategoryTxt)
    Spinner productCategoryTxt;

    @BindView(R.id.productTitleTxt)
    EditText productTitleTxt;

    @BindView(R.id.productDescriptionTxt)
    EditText productDescriptionTxt;

    @BindView(R.id.brandNameTxt)
    EditText brandNameTxt;

    @BindView(R.id.productPriceTxt)
    EditText productPriceTxt;

    @BindView(R.id.stockCodeTxt)
    EditText stockCodeTxt;

    @BindView(R.id.stockTotalTxt)
    EditText stockTotalTxt;

    @BindView(R.id.productStatusTxt)
    Spinner productStatusTxt;


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

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
        }

        return view;
    }

    @Override
    protected void setUp(View view) {

    }

    @OnClick(R.id.saveProductButton)
    void onSaveProductClick(View v) {
        int productStatus = productStatusStrToBool(productStatusTxt.getSelectedItem().toString());

        int stockTotal = 0;

        if (!stockTotalTxt.getText().toString().isEmpty())
            stockTotal = Integer.parseInt(stockTotalTxt.getText().toString());

        String CategoryTxt = "";
        if (productCategoryTxt.getSelectedItem() != null)
            CategoryTxt = productCategoryTxt.getSelectedItem().toString();


        product.setTitle(productTitleTxt.getText().toString());
        product.setDescription(productDescriptionTxt.getText().toString());
        product.setCategoryUid(1);
        product.setCategoryName(CategoryTxt);
        product.setPrice(productPriceTxt.getText().toString());
        product.setBrandName(brandNameTxt.getText().toString());
        product.setStockCode(stockCodeTxt.getText().toString());
        product.setStockTotal(stockTotal);
        product.setStockStatus(productStatus);

        mPresenter.onClickSaveButton(product);
    }


    int productStatusStrToBool(String value) {
        if (value.equals("Yes"))
            return 1;
        else
            return 0;
    }

    @Override
    public void setUpSpinnerAdapter() {


    }

    @Override
    public void openActivityOnTokenExpire() {

    }
}
