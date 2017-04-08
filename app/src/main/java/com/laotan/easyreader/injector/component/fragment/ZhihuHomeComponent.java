package com.laotan.easyreader.injector.component.fragment;

import com.laotan.easyreader.injector.module.fragment.ZhihuHomeModule;
import com.laotan.easyreader.injector.module.http.ZhihuHttpModule;
import com.laotan.easyreader.ui.fragment.home.child.zhihu.ZhiHuHomeFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by quantan.liu on 2017/4/8.
 */
@Singleton
@Component(modules = { ZhihuHttpModule.class,ZhihuHomeModule.class})
public interface ZhihuHomeComponent {
    void injectZhihuhome(ZhiHuHomeFragment zhiHuFragment);
}
