package com.laotan.easyreader.injector.component.fragment;

import com.laotan.easyreader.injector.module.fragment.AndroidModule;
import com.laotan.easyreader.injector.module.http.GankIoHttpModule;
import com.laotan.easyreader.ui.fragment.gank.AndroidFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by quantan.liu on 2017/4/8.
 */
@Singleton
@Component(modules = { GankIoHttpModule.class,AndroidModule.class})
public interface AndroidComponent {
    void injectAndroid(AndroidFragment androidFragment);
}
