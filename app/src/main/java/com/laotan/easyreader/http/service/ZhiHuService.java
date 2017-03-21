package com.laotan.easyreader.http.service;

import com.laotan.easyreader.bean.DailyListBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by quantan.liu on 2017/3/21.
 */

public interface ZhiHuService {
    String HOST = "http://news-at.zhihu.com/api/3/";
    /**
     * 最新日报
     */
    @GET("news/latest")
    Observable<DailyListBean> getDailyList();
}
