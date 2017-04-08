package com.laotan.easyreader.injector.component.fragment;

import com.laotan.easyreader.injector.module.fragment.TopNewsModule;
import com.laotan.easyreader.injector.module.http.TopNewsHttpModule;
import com.laotan.easyreader.ui.fragment.home.child.TopNewsFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by quantan.liu on 2017/4/8.
 */
@Singleton
@Component(modules = { TopNewsHttpModule.class,TopNewsModule.class})
public interface TopNewsComponent {
    void injectTopNews(TopNewsFragment topNewsFragment);
}
