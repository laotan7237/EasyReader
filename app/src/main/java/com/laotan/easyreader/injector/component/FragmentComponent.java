package com.laotan.easyreader.injector.component;

import android.app.Activity;

import com.laotan.easyreader.injector.module.FragmentModule;
import com.laotan.easyreader.injector.scope.FragmentScope;

import dagger.Component;

/**
 * Created by quantan.liu on 2017/3/21.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    Activity getActivity();

}
