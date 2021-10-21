package com.blackseapps.interview;

import android.app.Application;

import com.blackseapps.interview.data.DataManager;
import com.blackseapps.interview.di.component.ApplicationComponent;
import com.blackseapps.interview.di.component.DaggerApplicationComponent;
import com.blackseapps.interview.di.module.ApplicationModule;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.FirebaseAppCheck;
import com.google.firebase.appcheck.safetynet.SafetyNetAppCheckProviderFactory;

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

        /** Firebase Check App*/
        FirebaseApp.initializeApp(this);
        FirebaseAppCheck firebaseAppCheck = FirebaseAppCheck.getInstance();
        firebaseAppCheck.installAppCheckProviderFactory(SafetyNetAppCheckProviderFactory.getInstance());
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public void setApplicationComponent(ApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }
}
