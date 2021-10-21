package com.blackseapps.interview.ui.fragment.adding;

/**
 * Created by mertKaradeniz on 17.10.2021
 * <p>
 * This is an interview project.
 */

import com.blackseapps.interview.data.network.model.Product;
import com.blackseapps.interview.ui.base.BaseMvpPresenter;

public interface AddingMvpPresenter<V extends AddingMvpView> extends BaseMvpPresenter<V> {

    void onViewPrepared();

    void onClickSaveButton(Product product);
}
