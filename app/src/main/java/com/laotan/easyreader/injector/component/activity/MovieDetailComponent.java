package com.laotan.easyreader.injector.component.activity;

import com.laotan.easyreader.injector.module.http.DoubanHttpModule;
import com.laotan.easyreader.ui.activity.douban.MovieTopDetailActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by quantan.liu on 2017/4/8.
 */
@Singleton
@Component(modules = { DoubanHttpModule.class})
public interface MovieDetailComponent {
    void injectMovieDetail(MovieTopDetailActivity movieTopDetailActivity);
}
