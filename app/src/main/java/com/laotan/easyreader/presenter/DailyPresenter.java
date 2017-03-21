package com.laotan.easyreader.presenter;

import com.laotan.easyreader.bean.DailyListBean;
import com.laotan.easyreader.http.RetrofitUtils;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by quantan.liu on 2017/3/21.
 */

public class DailyPresenter {

    private  RetrofitUtils mRetrofitUtils;

    @Inject
    public DailyPresenter(RetrofitUtils mRetrofitUtils) {
        this.mRetrofitUtils = mRetrofitUtils;
    }

    public void getDailyData(){
        mRetrofitUtils.fetchDailyListInfo().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DailyListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("aaaaThrowable:"+e);
                    }

                    @Override
                    public void onNext(DailyListBean dailyListBean) {

                        System.out.println("aaaa:"+dailyListBean);
                    }
                });;
    }
}
