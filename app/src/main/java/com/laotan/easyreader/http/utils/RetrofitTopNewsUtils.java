package com.laotan.easyreader.http.utils;

import com.laotan.easyreader.bean.topnews.NBADetailBean;
import com.laotan.easyreader.bean.topnews.NBAListBean;
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

    public Observable<NBAListBean> fetchNBAList(int id) {
        return mTopNewsService.getNBA(id);
    }

    public Observable<NBADetailBean> fetchNBADetail(String id) {
        return mTopNewsService.getNewDetail(id);
    }
}
