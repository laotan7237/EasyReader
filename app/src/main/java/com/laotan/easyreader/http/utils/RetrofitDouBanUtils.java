package com.laotan.easyreader.http.utils;

import com.laotan.easyreader.bean.douban.HotMovieBean;
import com.laotan.easyreader.bean.douban.MovieDetailBean;
import com.laotan.easyreader.http.service.DoubanService;

import rx.Observable;

/**
 * Created by quantan.liu on 2017/3/28.
 */

public class RetrofitDouBanUtils extends HttpUtils {
    private DoubanService mDoubanService;

    public RetrofitDouBanUtils(DoubanService mDoubanService) {
        this.mDoubanService = mDoubanService;
    }
    public Observable<HotMovieBean> fetchMovieTop250(int start, int count){
       return mDoubanService.getMovieTop250(start,count);
    }
    public Observable<HotMovieBean> fetchHotMovie(){
        return mDoubanService.getHotMovie();
    }

    public Observable<MovieDetailBean> fetchMovieDetail(String id){
        return mDoubanService.getMovieDetail(id);
    }
}
