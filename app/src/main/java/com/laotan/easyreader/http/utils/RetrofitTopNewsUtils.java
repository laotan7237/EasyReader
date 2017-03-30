package com.laotan.easyreader.http.utils;

import com.laotan.easyreader.bean.topnews.NewsListBean;
import com.laotan.easyreader.http.service.TopNewsService;

import rx.Observable;

/**
 * Created by quantan.liu on 2017/3/27.
 */

public class RetrofitTopNewsUtils extends HttpUtils {

    private TopNewsService mTopNewsService;

    public RetrofitTopNewsUtils(TopNewsService mTopNewsService) {
        this.mTopNewsService = mTopNewsService;
    }
    public Observable<NewsListBean> fetchTopNewsList(int id) {
        return mTopNewsService.getNews(id);
    }

}
