package com.laotan.easyreader.injector.component;

import com.laotan.easyreader.app.App;
import com.laotan.easyreader.http.utils.RetrofitTopNewsUtils;
import com.laotan.easyreader.injector.module.AppModule;
import com.laotan.easyreader.injector.module.http.TopNewsHttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by quantan.liu on 2017/3/21.
 */
@Singleton
@Component(modules = {AppModule.class,  TopNewsHttpModule.class})
public interface AppComponent {
    App getContext();  // 提供App的Context


    RetrofitTopNewsUtils mRetrofitTopNewsUtils();
}
