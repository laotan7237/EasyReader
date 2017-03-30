package com.laotan.easyreader.di.component;

import com.laotan.easyreader.app.App;
import com.laotan.easyreader.di.module.AppModule;
import com.laotan.easyreader.di.module.HttpModule;
import com.laotan.easyreader.http.utils.RetrofitDouBanUtils;
import com.laotan.easyreader.http.utils.RetrofitGankIoUtils;
import com.laotan.easyreader.http.utils.RetrofitTopNewsUtils;
import com.laotan.easyreader.http.utils.RetrofitWeChatUtils;
import com.laotan.easyreader.http.utils.RetrofitZhiHuUtils;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by quantan.liu on 2017/3/21.
 */
@Singleton
@Component(modules = {AppModule.class,HttpModule.class})
public interface AppComponent {

    App getContext();  // 提供App的Context

    /**
     * 提供http的帮助类
     * 更换链接的请求，需要添加如AppModule的provideRetrofitZhiHuUtils()方法 命名规则provideRetrofitXXXUtils()
     * HttpModule的provideZhiHuRetrofit()和provideZhihuService() 命名规则provideXXXService
     * 还有以下方法 命名规则retrofitXXXUtils  命名规则怎么开心怎么来。
     * @return
     */
    RetrofitZhiHuUtils retrofitZhiHuUtils();

    RetrofitGankIoUtils mRetrofitGankIoUtils();

    RetrofitTopNewsUtils mRetrofitTopNewsUtils();

    RetrofitDouBanUtils mRetrofitDouBanUtils();

    RetrofitWeChatUtils mRetrofitWeChatUtils();
}
