package com.laotan.easyreader.injector.component.activity;

import com.laotan.easyreader.injector.module.http.ZhihuHttpModule;
import com.laotan.easyreader.ui.activity.zhihu.ZhiHuDetailActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by quantan.liu on 2017/4/8.
 */
@Singleton
@Component(modules = { ZhihuHttpModule.class})
public interface ZhihuDetailComponent {
    void injectZhiHuDetail(ZhiHuDetailActivity zhiHuDetailActivity);
}
