package com.laotan.easyreader.injector.module.activity;

import com.laotan.easyreader.adapter.ZhihuThemeAdapter;

import java.util.ArrayList;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by quantan.liu on 2017/4/8.
 */
@Module
public class ZhihuThemeModule {
    @Provides
    @Singleton
    public ZhihuThemeAdapter provideAdapter() {
        return new ZhihuThemeAdapter(new ArrayList());
    }
}
