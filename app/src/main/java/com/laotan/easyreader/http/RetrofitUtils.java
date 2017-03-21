package com.laotan.easyreader.http;

import com.laotan.easyreader.bean.DailyListBean;
import com.laotan.easyreader.http.service.ZhiHuService;

import rx.Observable;

/**
 * Created by quantan.liu on 2017/3/21.
 */

public class RetrofitUtils {

    private ZhiHuService mZhiHuService;

    public RetrofitUtils(ZhiHuService mZhiHuService){
        this.mZhiHuService = mZhiHuService;
    }

    public Observable<DailyListBean> fetchDailyListInfo() {
        return mZhiHuService.getDailyList();
    }
}
