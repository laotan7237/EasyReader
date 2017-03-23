package com.laotan.easyreader.presenter;

import com.laotan.easyreader.bean.zhihu.DailyListBean;
import com.laotan.easyreader.bean.gankio.GankIoDayBean;
import com.laotan.easyreader.http.utils.Callback;
import com.laotan.easyreader.http.utils.RetrofitGankIoUtils;
import com.laotan.easyreader.http.utils.RetrofitZhiHuUtils;

import javax.inject.Inject;

/**
 * Created by quantan.liu on 2017/3/22.
 */

public class EverydayPresenter extends BasePresenter {
    private RetrofitGankIoUtils mRetrofitGankIoUtils;
    private RetrofitZhiHuUtils mRetrofitZhiHuUtils;
    @Inject
    public EverydayPresenter(RetrofitGankIoUtils mRetrofitGankIoUtils, RetrofitZhiHuUtils mRetrofitZhiHuUtils) {
        this.mRetrofitGankIoUtils= mRetrofitGankIoUtils;
        this.mRetrofitZhiHuUtils= mRetrofitZhiHuUtils;

    }
    public void fetchDailyData(){
        invoke(mRetrofitZhiHuUtils.fetchDailyListInfo(),new Callback<DailyListBean>(){
            @Override
            public void onResponse(DailyListBean data) {
                System.out.println("aaaaamRetrofitZhiHuUtils"+data);
            }
        });
    }

    public void fetchGankIoDay(String year, String month, String day){
        invoke(mRetrofitGankIoUtils.fetchGankIoDay(year, month, day),new Callback<GankIoDayBean>(){
            @Override
            public void onResponse(GankIoDayBean data) {
                System.out.println("aaaaaaGankIoDayBean:"+data);
            }
        });
    }

}
