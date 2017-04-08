package com.laotan.easyreader.injector.component.fragment;

import com.laotan.easyreader.injector.module.fragment.DoubanMovieLatestModule;
import com.laotan.easyreader.injector.module.http.DoubanHttpModule;
import com.laotan.easyreader.ui.fragment.home.child.DouBanMovieLatestFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by quantan.liu on 2017/4/8.
 */
@Singleton
@Component(modules = { DoubanHttpModule.class,DoubanMovieLatestModule.class})
public interface DoubanMovieLatestComponent {
    void injectDoubanMovieLatest(DouBanMovieLatestFragment douBanMovieLatestFragment);
}
