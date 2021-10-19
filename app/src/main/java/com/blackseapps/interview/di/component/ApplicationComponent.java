package com.blackseapps.interview.di.component;

import android.app.Application;
import android.content.Context;

import com.blackseapps.interview.MainApplication;
import com.blackseapps.interview.data.DataManager;
import com.blackseapps.interview.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mertKaradeniz on 17.10.2021
 * <p>
 * This is an interview project.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MainApplication app);

    Context context();

    Application application();

    DataManager getDataManager();

}
