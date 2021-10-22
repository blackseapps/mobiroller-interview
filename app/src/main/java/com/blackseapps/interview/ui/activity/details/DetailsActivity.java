package com.blackseapps.interview.ui.activity.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.blackseapps.interview.R;
import com.blackseapps.interview.data.network.model.Product;
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


    @Override
    protected void setUp() {
        Product data = getIntentData("data");
        if (data == null)
            finish();
        productTitleTxt.setText(data.getTitle());
        productDescriptionTxt.setText(data.getDescription());
        productPriceTxt.setText(String.valueOf(data.getPrice()));
    }
}
