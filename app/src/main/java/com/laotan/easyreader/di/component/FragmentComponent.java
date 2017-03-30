package com.laotan.easyreader.di.component;

import android.app.Activity;

import com.laotan.easyreader.di.module.FragmentModule;
import com.laotan.easyreader.di.scope.FragmentScope;
import com.laotan.easyreader.ui.fragment.home.child.DouBanMovieLatestFragment;
import com.laotan.easyreader.ui.fragment.home.child.DouBanMovieTopFragment;
import com.laotan.easyreader.ui.fragment.home.child.TopNewsFragment;
import com.laotan.easyreader.ui.fragment.home.child.zhihu.ZhiHuCommentFragment;
import com.laotan.easyreader.ui.fragment.home.child.zhihu.ZhiHuHomeFragment;

import dagger.Component;

/**
 * Created by quantan.liu on 2017/3/21.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(ZhiHuHomeFragment zhiHuFragment);

    void inject(ZhiHuCommentFragment zhiHuCommentFragment);

    void inject(TopNewsFragment topNewsFragment);

    void inject(DouBanMovieTopFragment douBanMovieTopFragment);

    void inject(DouBanMovieLatestFragment douBanMovieLatestFragment);

}
