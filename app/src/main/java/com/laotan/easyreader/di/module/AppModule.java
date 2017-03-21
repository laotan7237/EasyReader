package com.laotan.easyreader.di.module;

import com.laotan.easyreader.app.App;
import com.laotan.easyreader.http.RetrofitUtils;
import com.laotan.easyreader.http.service.ZhiHuService;

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
    RetrofitUtils provideRetrofitHelper(ZhiHuService zhihuApiService) {
        return new RetrofitUtils(zhihuApiService);
    }
}
