package com.laotan.easyreader.injector.component.activity;

import com.laotan.easyreader.injector.module.http.TopNewsHttpModule;
import com.laotan.easyreader.ui.activity.topnews.NBAActivity;
import com.laotan.easyreader.ui.activity.topnews.TopNewsActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by quantan.liu on 2017/4/8.
 */
@Singleton
@Component(modules = { TopNewsHttpModule.class})
public interface TopNewsComponent {
    void injectTopNews(TopNewsActivity topNewsActivity);
    void injectNBA(NBAActivity nbaActivity);
}
