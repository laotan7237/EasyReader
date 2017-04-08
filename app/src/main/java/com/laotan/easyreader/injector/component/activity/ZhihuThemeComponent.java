package com.laotan.easyreader.injector.component.activity;

import com.laotan.easyreader.injector.module.activity.ZhihuThemeModule;
import com.laotan.easyreader.injector.module.http.ZhihuHttpModule;
import com.laotan.easyreader.ui.activity.zhihu.ZhihuThemeActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by quantan.liu on 2017/4/8.
 */
@Singleton
@Component(modules = { ZhihuHttpModule.class,ZhihuThemeModule.class})
public interface ZhihuThemeComponent {
    void injectZhiHuTheme(ZhihuThemeActivity zhihuThemeActivity);
}
