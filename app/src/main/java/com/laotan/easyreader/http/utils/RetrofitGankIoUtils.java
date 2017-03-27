package com.laotan.easyreader.http.utils;

import com.laotan.easyreader.bean.gankio.GankIoDayBean;
import com.laotan.easyreader.http.service.GankIoService;

import rx.Observable;

/**
 * Created by quantan.liu on 2017/3/22.
 */

public class RetrofitGankIoUtils extends HttpUtils {

    private GankIoService mGankIoService;

    public RetrofitGankIoUtils(GankIoService mGankIoService) {
        this.mGankIoService = mGankIoService;
    }

    public Observable<GankIoDayBean> fetchGankIoDay(String year, String month, String day) {
        return mGankIoService.getGankIoDay(year, month, day);
    }


}