package com.blackseapps.interview.ui.activity.details;

import android.app.DownloadManager;
import android.util.Log;

import androidx.annotation.NonNull;

import com.blackseapps.interview.data.DataManager;
import com.blackseapps.interview.ui.base.BasePresenter;
import com.blackseapps.interview.ui.main.MainMvpPresenter;
import com.blackseapps.interview.ui.main.MainMvpView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import javax.inject.Inject;

/**
 * Created by mertKaradeniz on 17.10.2021
 * <p>
 * This is an interview project.
 */

public class DetailsPresenter<V extends DetailsMvpView> extends BasePresenter<V>
        implements DetailsMvpPresenter<V> {

    @Inject
    public DetailsPresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void onHandleDeleteItem(String uId) {
        getMvpView().showLoading();
        Query query = getDataManager().deleteProductApiCall().equalTo(uId);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot appleSnapshot : snapshot.getChildren()) {
                    appleSnapshot.getRef().removeValue();
                    getMvpView().hideLoading();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                getMvpView().hideLoading();
            }
        });
    }
}
