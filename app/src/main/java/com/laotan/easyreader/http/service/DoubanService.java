package com.laotan.easyreader.http.service;

import com.laotan.easyreader.bean.douban.MovieDetailBean;
import com.laotan.easyreader.bean.douban.HotMovieBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by quantan.liu on 2017/3/28.
 */

public interface DoubanService {
    String API_DOUBAN = "https://api.douban.com/";
    /**
     * 豆瓣热映电影，每日更新
     */
    @GET("v2/movie/in_theaters")
    Observable<HotMovieBean> fetchHotMovie();

    /**
     * 获取电影详情
     *
     * @param id 电影bean里的id
     */
    @GET("v2/movie/subject/{id}")
    Observable<MovieDetailBean> fetchMovieDetail(@Path("id") String id);

    /**
     * 获取豆瓣电影top250
     *
     * @param start 从多少开始，如从"0"开始
     * @param count 一次请求的数目，如"10"条，最多100
     */
    @GET("v2/movie/top250")
    Observable<HotMovieBean> fetchMovieTop250(@Query("start") int start, @Query("count") int count);
}
