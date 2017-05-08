package com.laotan.easyreader.injector.module.http;

import com.laotan.easyreader.injector.qualifier.WeChatUrl;
import com.laotan.easyreader.http.service.WeChatService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by quantan.liu on 2017/4/8.
 */
@Module
public class WeChatHttpModule extends BaseHttpModule {
    @Singleton
    @Provides
    @WeChatUrl
    Retrofit provideWeChatRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, WeChatService.API_WeChat);
    }

    @Singleton
    @Provides
    WeChatService provideWeChatService(@WeChatUrl Retrofit retrofit) {
        return retrofit.create(WeChatService.class);
    }

}
