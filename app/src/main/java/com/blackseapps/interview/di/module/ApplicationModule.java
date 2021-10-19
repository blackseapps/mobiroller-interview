package com.blackseapps.interview.di.module;

import android.app.Application;
import android.content.Context;

import com.blackseapps.interview.data.AppDataManager;
import com.blackseapps.interview.data.DataManager;
import com.blackseapps.interview.data.network.ApiHelper;
import com.blackseapps.interview.data.network.AppApiHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mertKaradeniz on 17.10.2021
 * <p>
 * This is an interview project.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Context provideContext() {
        return mApplication;
    }

    @Provides
    public Application provideApplication() {
        return mApplication;
    }


    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }


    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
       return appDataManager;
    }

}

