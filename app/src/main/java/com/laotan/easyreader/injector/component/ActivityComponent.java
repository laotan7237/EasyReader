package com.laotan.easyreader.injector.component;

import android.app.Activity;

import com.laotan.easyreader.injector.module.ActivityModule;
import com.laotan.easyreader.injector.scope.ActivityScope;

import dagger.Component;

/**
 * Created by quantan.liu on 2017/3/21.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();
}
