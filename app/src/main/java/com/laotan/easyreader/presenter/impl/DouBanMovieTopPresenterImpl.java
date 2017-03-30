package com.laotan.easyreader.presenter.impl;

import com.blankj.utilcode.utils.LogUtils;
import com.laotan.easyreader.bean.douban.HotMovieBean;
import com.laotan.easyreader.http.utils.Callback;
import com.laotan.easyreader.http.utils.RetrofitDouBanUtils;
import com.laotan.easyreader.presenter.BasePresenter;
import com.laotan.easyreader.presenter.DouBanMovieTopPresenter;

import javax.inject.Inject;

/**
 * Created by quantan.liu on 2017/3/28.
 */

public class DouBanMovieTopPresenterImpl extends BasePresenter<DouBanMovieTopPresenter.View> implements DouBanMovieTopPresenter.Presenter {
    private RetrofitDouBanUtils mRetrofitDouBanUtils;

    @Inject
    public DouBanMovieTopPresenterImpl(RetrofitDouBanUtils mRetrofitDouBanUtils) {
        this.mRetrofitDouBanUtils = mRetrofitDouBanUtils;
    }
    public void fetchMovieTop250(int start,int count){
        invoke(mRetrofitDouBanUtils.fetchMovieTop250(start,count),new Callback<HotMovieBean>(){
            @Override
            public void onResponse(HotMovieBean data) {
                checkState(data.getSubjects());
                LogUtils.e("aaaaaHotMovieBean"+data);
                mLifeSubscription.refreshView(data);
            }
        });;
    }

}
