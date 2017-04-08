package com.laotan.easyreader.injector.module.fragment;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.laotan.easyreader.adapter.ZhiHuAdapter;
import com.laotan.easyreader.bean.zhihu.HomeListBean;

import java.util.ArrayList;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by quantan.liu on 2017/4/8.
 */
@Module
public class ZhihuHomeModule {
    @Provides
    @Singleton
    public BaseQuickAdapter provideAdapter() {
        return new ZhiHuAdapter(new ArrayList<HomeListBean>());//new ArrayList()这样子也可以，不过这里我们为了给自己看就写了泛型。
    }
}
