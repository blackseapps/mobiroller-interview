package com.blackseapps.interview.ui.fragment.adding;


import android.annotation.SuppressLint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import com.blackseapps.interview.data.network.model.Category;
import com.blackseapps.interview.data.network.model.Product;
import com.blackseapps.interview.di.component.ActivityComponent;
import com.blackseapps.interview.ui.base.BaseFragment;
import com.blackseapps.interview.ui.dilalog.CategoryAddDialog.CategoryAdapter;
import com.blackseapps.interview.ui.dilalog.CategoryAddDialog.CategoryAddDialog;
import com.blackseapps.interview.ui.fragment.listing.ListingMvpPresenter;
import com.blackseapps.interview.ui.fragment.listing.ListingMvpView;

import java.util.ArrayList;
import java.util.List;

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

    // @Inject
    CategoryAdapter categoryAdapter;

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

    ArrayList<Category> rowItems;


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
            setHasOptionsMenu(true);
        }

        return view;
    }

    @Override
    protected void setUp(View view) {

        rowItems = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            Category item = new Category(String.valueOf(i), String.valueOf(i), String.valueOf(i));
            rowItems.add(item);
        }

        categoryAdapter = new CategoryAdapter(getActivity(), rowItems);

        productCategoryTxt.setAdapter(categoryAdapter);

        //  categoryAdapter.addItems(rowItems);

    }


    void onSaveProductClick() {
        int productStatus = productStatusStrToBool(productStatusTxt.getSelectedItem().toString());

        int stockTotal = 0;
        double price = 0;

        if (!stockTotalTxt.getText().toString().isEmpty())
            stockTotal = Integer.parseInt(stockTotalTxt.getText().toString());

        if (!productPriceTxt.getText().toString().isEmpty())
            price = Double.parseDouble(productPriceTxt.getText().toString());


        String CategoryTxt = "";
        if (productCategoryTxt.getSelectedItem() != null)
            CategoryTxt = productCategoryTxt.getSelectedItem().toString();


        product.setTitle(productTitleTxt.getText().toString());
        product.setDescription(productDescriptionTxt.getText().toString());
        product.setCategoryUid(1);
        product.setCategoryName(CategoryTxt);
        product.setPrice(price);
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
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.adding_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Drawable drawable = item.getIcon();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
        if (item.getItemId() == R.id.action_save) {
            onSaveProductClick();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setUpSpinnerAdapter() {


    }

    @Override
    public void openActivityOnTokenExpire() {

    }
}
