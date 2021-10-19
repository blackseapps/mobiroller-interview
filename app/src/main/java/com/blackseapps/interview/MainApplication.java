package com.blackseapps.interview;

import android.app.Application;

import com.blackseapps.interview.data.DataManager;
import com.blackseapps.interview.di.component.ApplicationComponent;
import com.blackseapps.interview.di.component.DaggerApplicationComponent;
import com.blackseapps.interview.di.module.ApplicationModule;

import javax.inject.Inject;

public class MainApplication extends Application {

    @Inject
    DataManager manager;

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public void setApplicationComponent(ApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }
}
