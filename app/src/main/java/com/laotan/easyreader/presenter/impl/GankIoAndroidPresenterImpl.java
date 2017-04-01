package com.laotan.easyreader.presenter.impl;

import com.blankj.utilcode.utils.LogUtils;
import com.laotan.easyreader.bean.gankio.GankIoDataBean;
import com.laotan.easyreader.http.utils.Callback;
import com.laotan.easyreader.http.utils.RetrofitGankIoUtils;
import com.laotan.easyreader.presenter.BasePresenter;
import com.laotan.easyreader.presenter.GankIoAndroidPresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by quantan.liu on 2017/3/30.
 */

public class GankIoAndroidPresenterImpl extends BasePresenter<GankIoAndroidPresenter.View> implements GankIoAndroidPresenter.Presenter {
    private RetrofitGankIoUtils mRetrofitGankIoUtils;

    @Inject
    public GankIoAndroidPresenterImpl(RetrofitGankIoUtils mRetrofitGankIoUtils) {
        this.mRetrofitGankIoUtils = mRetrofitGankIoUtils;
    }


    @Override
    public void fetchGankIoData(int page, int pre_page) {
        invoke(mRetrofitGankIoUtils.fetchGankIoData("Android",page,pre_page),new Callback<GankIoDataBean>(){
            @Override
            public void onResponse(GankIoDataBean data) {
                List<GankIoDataBean.ResultBean> results = data.getResults();
                checkState(results);
                mLifeSubscription.refreshView(results);
            }
        });
    }
}
