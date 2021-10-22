package com.blackseapps.interview.ui.activity.details;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.blackseapps.interview.R;
import com.blackseapps.interview.data.network.model.Product;
import com.blackseapps.interview.ui.activity.update.ProductUpdateActivity;
import com.blackseapps.interview.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mertKaradeniz on 17.10.2021
 * <p>
 * This is an interview project.
 */

public class DetailsActivity extends BaseActivity implements DetailsMvpView {

    @Inject
    DetailsMvpPresenter<DetailsMvpView> mPresenter;

    @BindView(R.id.productTitleTxt)
    TextView productTitleTxt;

    @BindView(R.id.productDescriptionTxt)
    TextView productDescriptionTxt;

    @BindView(R.id.productPriceTxt)
    TextView productPriceTxt;

    @BindView(R.id.productCategoryTxt)
    TextView productCategoryTxt;

    @BindView(R.id.productBrandTxt)
    TextView productBrandTxt;

    @BindView(R.id.stockCodeTxt)
    TextView stockCodeTxt;

    private Product data;

    public static Intent getStartIntent(Context context, Product product) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra("data", product);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);

        setUp();
    }


    @SuppressLint("SetTextI18n")
    @Override
    protected void setUp() {
        data = getIntentData("data");
        if (data == null)
            finish();

        setTitle(data.getTitle());

        productTitleTxt.setText(data.getTitle());
        productDescriptionTxt.setText(data.getDescription());
        productPriceTxt.setText(data.getPrice() + " " + getResources().getString(R.string.unit_tl));
        productBrandTxt.setText(data.getBrandName());
        stockCodeTxt.setText("#" + data.getStockCode());
        productCategoryTxt.setText(data.getCategoryName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.details_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Drawable drawable = item.getIcon();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
        switch (item.getItemId()) {
            case R.id.action_delete:
                mPresenter.onHandleDeleteItem(data.getKey());
                finish();
                break;
            case R.id.action_update:
                Intent intent = ProductUpdateActivity.getStartIntent(DetailsActivity.this, data);
                startActivity(intent);
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}
