package com.laotan.easyreader.http.service;

import com.laotan.easyreader.bean.topnews.NewsListBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by quantan.liu on 2017/3/27.
 */

public interface TopNewsService {
    String API_TOPNEWS = "http://c.m.163.com/nc/article/";

    @GET("headline/T1348647909107/{id}-20.html")
    Observable<NewsListBean> getNews(@Path("id") int id );



}
