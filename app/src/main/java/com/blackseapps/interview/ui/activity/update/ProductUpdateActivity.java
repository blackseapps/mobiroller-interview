package com.blackseapps.interview.ui.activity.update;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;

import com.blackseapps.interview.R;
import com.blackseapps.interview.data.network.model.Product;
import com.blackseapps.interview.ui.activity.details.DetailsActivity;
import com.blackseapps.interview.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mertKaradeniz on 23.10.2021
 * <p>
 * This is an interview project.
 */

public class ProductUpdateActivity extends BaseActivity implements ProductUpdateMvpView {


    @Inject
    Product product;

    @Inject
    ProductUpdatePresenter<ProductUpdateMvpView> mPresenter;

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

    private Product data;


    public static Intent getStartIntent(Context context, Product product) {
        Intent intent = new Intent(context, ProductUpdateActivity.class);
        intent.putExtra("data", product);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_adding);

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);

        setUp();
    }


    @Override
    protected void setUp() {
        data = getIntentData("data");
        if (data == null)
            finish();

        setTitle(data.getTitle());
        productTitleTxt.setText(data.getTitle());
        productDescriptionTxt.setText(data.getDescription());
        productPriceTxt.setText(String.valueOf(data.getPrice()));
        brandNameTxt.setText(data.getBrandName());
        stockCodeTxt.setText(data.getStockCode());

        // productCategoryTxt.setText(data.getCategoryName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.adding_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Drawable drawable = item.getIcon();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
        if (item.getItemId() == R.id.action_save) {
            onClickUpdate();
        }

        return super.onOptionsItemSelected(item);
    }

    private void onClickUpdate() {
        int productStatus = productStatusStrToBool(productStatusTxt.getSelectedItem().toString());

        int stockTotal = 0;
        double price = 0;
        String CategoryTxt = "";

        if (!stockTotalTxt.getText().toString().isEmpty()) {
            stockTotal = Integer.parseInt(stockTotalTxt.getText().toString());
        }
        if (!productPriceTxt.getText().toString().isEmpty()) {
            price = Double.parseDouble(productPriceTxt.getText().toString());
        }
        if (productCategoryTxt.getSelectedItem() != null) {
            CategoryTxt = productCategoryTxt.getSelectedItem().toString();
        }

        product.setKey(data.getKey());
        product.setTitle(productTitleTxt.getText().toString());
        product.setDescription(productDescriptionTxt.getText().toString());
        product.setCategoryUid(1);
        product.setCategoryName(CategoryTxt);
        product.setPrice(price);
        product.setBrandName(brandNameTxt.getText().toString());
        product.setStockCode(stockCodeTxt.getText().toString());
        product.setStockTotal(stockTotal);
        product.setStockStatus(productStatus);

        mPresenter.onClickUpdateButton(product);
        finish();
    }

    int productStatusStrToBool(String value) {
        if (value.equals("Yes"))
            return 1;
        else
            return 0;
    }
}
