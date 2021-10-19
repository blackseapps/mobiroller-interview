package com.blackseapps.interview.di.component;

import com.blackseapps.interview.di.PerActivity;
import com.blackseapps.interview.di.module.ActivityModule;
import com.blackseapps.interview.ui.fragment.adding.AddingFragment;
import com.blackseapps.interview.ui.fragment.listing.ListingFragment;
import com.blackseapps.interview.ui.main.MainActivity;

import dagger.Component;

/**
 * Created by mertKaradeniz on 17.10.2021
 * <p>
 * This is an interview project.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(AddingFragment fragment);

    void inject(ListingFragment fragment);

}
