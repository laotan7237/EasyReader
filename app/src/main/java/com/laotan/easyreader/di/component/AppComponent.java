package com.laotan.easyreader.di.component;

import com.laotan.easyreader.app.App;
import com.laotan.easyreader.di.module.AppModule;
import com.laotan.easyreader.di.module.HttpModule;
import com.laotan.easyreader.http.RetrofitUtils;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by quantan.liu on 2017/3/21.
 */
@Singleton
@Component(modules = {AppModule.class,HttpModule.class})
public interface AppComponent {

    App getContext();  // 提供App的Context

    RetrofitUtils retrofitUtils();  //提供http的帮助类

}
