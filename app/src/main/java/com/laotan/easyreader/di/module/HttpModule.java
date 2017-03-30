package com.laotan.easyreader.di.module;

import com.laotan.easyreader.di.qualifier.DoubanUrl;
import com.laotan.easyreader.di.qualifier.GankUrl;
import com.laotan.easyreader.di.qualifier.TopNewsUrl;
import com.laotan.easyreader.di.qualifier.WeChatUrl;
import com.laotan.easyreader.di.qualifier.ZhihuUrl;
import com.laotan.easyreader.http.service.DoubanService;
import com.laotan.easyreader.http.service.GankIoService;
import com.laotan.easyreader.http.service.TopNewsService;
import com.laotan.easyreader.http.service.WeChatService;
import com.laotan.easyreader.http.service.ZhiHuService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by quantan.liu on 2017/3/21.
 */
@Module
public class HttpModule {

    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }


    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder) {
        //设置超时
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        return builder.build();
    }


    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {
        return builder
                .baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    @ZhihuUrl
    Retrofit provideZhiHuRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, ZhiHuService.HOST);
    }

    @Singleton
    @Provides
    ZhiHuService provideZhihuService(@ZhihuUrl Retrofit retrofit) {
        return retrofit.create(ZhiHuService.class);
    }

    @Singleton
    @Provides
    @GankUrl
    Retrofit provideGankIoRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, GankIoService.API_GANKIO);
    }

    @Singleton
    @Provides
    GankIoService provideGankIoService(@GankUrl Retrofit retrofit) {
        return retrofit.create(GankIoService.class);
    }


    @Singleton
    @Provides
    @TopNewsUrl
    Retrofit provideTopNewsRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, TopNewsService.API_TOPNEWS);
    }

    @Singleton
    @Provides
    TopNewsService provideTopNewsService(@TopNewsUrl Retrofit retrofit) {
        return retrofit.create(TopNewsService.class);
    }


    @Singleton
    @Provides
    @DoubanUrl
    Retrofit provideDoubanRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, DoubanService.API_DOUBAN);
    }

    @Singleton
    @Provides
    DoubanService provideDoubanService(@DoubanUrl Retrofit retrofit) {
        return retrofit.create(DoubanService.class);
    }


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
