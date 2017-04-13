package com.laotan.easyreader.injector.component.fragment;

import com.laotan.easyreader.injector.module.fragment.NBAModule;
import com.laotan.easyreader.injector.module.http.TopNewsHttpModule;
import com.laotan.easyreader.ui.fragment.wechat.NBAFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by quantan.liu on 2017/4/8.
 */
@Singleton
@Component(modules = { TopNewsHttpModule.class,NBAModule.class})
public interface NBAComponent {
    void injectNBA(NBAFragment nbaFragment);
}
