package com.laotan.easyreader.di.component;

import android.app.Activity;

import com.laotan.easyreader.di.module.FragmentModule;
import com.laotan.easyreader.di.scope.FragmentScope;
import com.laotan.easyreader.ui.fragment.home.child.zhihu.ZhiHuHomeFragment;
import com.laotan.easyreader.ui.fragment.home.child.zhihu.ZhiHuCommentFragment;

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

}
