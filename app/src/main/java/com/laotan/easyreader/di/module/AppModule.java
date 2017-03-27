package com.laotan.easyreader.di.module;

import com.laotan.easyreader.app.App;
import com.laotan.easyreader.http.service.GankIoService;
import com.laotan.easyreader.http.service.ZhiHuService;
import com.laotan.easyreader.http.utils.RetrofitGankIoUtils;
import com.laotan.easyreader.http.utils.RetrofitZhiHuUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by quantan.liu on 2017/3/21.
 */
@Module
public class AppModule {

    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    App provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    RetrofitZhiHuUtils provideRetrofitZhiHuUtils(ZhiHuService zhihuApiService) {
        return new RetrofitZhiHuUtils(zhihuApiService);
    }

    @Provides
    @Singleton
    RetrofitGankIoUtils provideRetrofitGankIoUtils(GankIoService gankIoService) {
        return new RetrofitGankIoUtils(gankIoService);
    }

}
