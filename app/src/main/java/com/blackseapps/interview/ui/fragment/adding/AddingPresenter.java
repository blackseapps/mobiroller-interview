package com.blackseapps.interview.ui.fragment.adding;

/**
 * Created by mertKaradeniz on 17.10.2021
 * <p>
 * This is an interview project.
 */

import android.util.Log;

import androidx.fragment.app.FragmentManager;

import com.blackseapps.interview.R;
import com.blackseapps.interview.data.DataManager;
import com.blackseapps.interview.data.network.model.Product;
import com.blackseapps.interview.ui.base.BasePresenter;
import com.blackseapps.interview.ui.dilalog.CategoryAddDialog.CategoryAddDialog;

import javax.inject.Inject;

public class AddingPresenter<V extends AddingMvpView> extends BasePresenter<V>
        implements AddingMvpPresenter<V> {


    @Inject
    public AddingPresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void onViewPrepared() {

    }

    @Override
    public void onClickSaveButton(Product product) {

        if (product.getCategoryName() == null || product.getCategoryName().isEmpty()) {
            getMvpView().onError(R.string.adding_empty_category);
            return;
        }

        if (product.getTitle() == null || product.getTitle().isEmpty()) {
            getMvpView().onError(R.string.adding_empty_title);
            return;
        }

        if (product.getDescription() == null || product.getDescription().isEmpty()) {
            getMvpView().onError(R.string.adding_empty_description);
            return;
        }

        if (product.getBrandName() == null || product.getBrandName().isEmpty()) {
            getMvpView().onError(R.string.adding_empty_brand);
            return;
        }

        if (product.getPrice() == 0) {
            getMvpView().onError(R.string.adding_empty_price);
            return;
        }

        if (product.getStockTotal() == 0) {
            getMvpView().onError(R.string.adding_empty_stock_total);
            return;
        }

        if (product.getStockCode() == null || product.getStockCode().isEmpty()) {
            getMvpView().onError(R.string.adding_empty_stock_code);
            return;
        }

        getDataManager().setProductApiCall(product);

    }

    @Override
    public void showCategoryAddingDialog(FragmentManager fragmentManager) {
        CategoryAddDialog.newInstance().show(fragmentManager);
    }
}
