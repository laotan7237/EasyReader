package com.laotan.easyreader.injector.component.fragment;

import com.laotan.easyreader.injector.module.fragment.ZhihuCommentModule;
import com.laotan.easyreader.injector.module.http.ZhihuHttpModule;
import com.laotan.easyreader.ui.fragment.home.child.zhihu.ZhiHuCommentFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by quantan.liu on 2017/4/8.
 */
@Singleton
@Component(modules = { ZhihuHttpModule.class,ZhihuCommentModule.class})
public interface ZhihuCommentComponent {
    void injectZhihuComment(ZhiHuCommentFragment zhiHuCommentFragment);
}
