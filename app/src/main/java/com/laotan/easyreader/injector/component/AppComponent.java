package com.laotan.easyreader.injector.component;

import com.laotan.easyreader.app.App;
import com.laotan.easyreader.http.utils.RetrofitDouBanUtils;
import com.laotan.easyreader.injector.module.AppModule;
import com.laotan.easyreader.injector.module.http.DoubanHttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by quantan.liu on 2017/3/21.
 */
@Singleton
@Component(modules = {AppModule.class, DoubanHttpModule.class})
public interface AppComponent {
    App getContext();  // 提供App的Context

    RetrofitDouBanUtils mRetrofitDouBanUtils();
}
