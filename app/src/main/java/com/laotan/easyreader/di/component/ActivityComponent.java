package com.laotan.easyreader.di.component;

import android.app.Activity;

import com.laotan.easyreader.di.module.ActivityModule;
import com.laotan.easyreader.di.scope.ActivityScope;
import com.laotan.easyreader.ui.activity.main.MainActivity;
import com.laotan.easyreader.ui.activity.douban.MovieTopDetailActivity;
import com.laotan.easyreader.ui.activity.topnews.TopNewsActivity;
import com.laotan.easyreader.ui.activity.zhihu.ZhiHuDetailActivity;
import com.laotan.easyreader.ui.activity.zhihu.ZhihuThemeActivity;

import dagger.Component;

/**
 * Created by quantan.liu on 2017/3/21.
 */
@ActivityScope
@Component(dependencies = AppComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();

    void inject(MainActivity mainActivity);
    void inject(ZhiHuDetailActivity zhiHuDetailActivity);
    void inject(ZhihuThemeActivity zhihuThemeActivity);
    void inject(TopNewsActivity topNewsActivity);
    void inject(MovieTopDetailActivity movieTopDetailActivity);
}
