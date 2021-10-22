package com.blackseapps.interview.ui.activity.update;

import com.blackseapps.interview.data.network.model.Product;
import com.blackseapps.interview.ui.base.BaseMvpPresenter;

/**
 * Created by mertKaradeniz on 23.10.2021
 * <p>
 * This is an interview project.
 */

public interface ProductUpdateMvpPresenter<V extends ProductUpdateMvpView> extends BaseMvpPresenter<V> {

    void onClickUpdateButton(Product product);
}
