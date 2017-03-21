package com.laotan.easyreader.di.component;

import android.app.Activity;

import com.laotan.easyreader.MainActivity;
import com.laotan.easyreader.di.module.ActivityModule;
import com.laotan.easyreader.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by quantan.liu on 2017/3/21.
 */
@ActivityScope
@Component(dependencies = AppComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();

    void inject(MainActivity mainActivity);
}
