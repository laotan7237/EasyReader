package com.laotan.easyreader.injector.component.fragment;

import com.laotan.easyreader.injector.module.fragment.DoubanMovieTopModule;
import com.laotan.easyreader.injector.module.http.DoubanHttpModule;
import com.laotan.easyreader.ui.fragment.home.child.DouBanMovieTopFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by quantan.liu on 2017/4/8.
 */
@Singleton
@Component(modules = { DoubanHttpModule.class,DoubanMovieTopModule.class})
public interface DoubanMovieTopComponent {
    void injectDoubanMovieTop(DouBanMovieTopFragment douBanMovieTopFragment);
}
