package com.laotan.easyreader.presenter.impl;

import com.laotan.easyreader.bean.gankio.GankIoDataBean;
import com.laotan.easyreader.http.service.GankIoService;
import com.laotan.easyreader.http.utils.Callback;
import com.laotan.easyreader.presenter.BasePresenter;
import com.laotan.easyreader.presenter.GankIoAndroidPresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by quantan.liu on 2017/3/30.
 */

public class GankIoAndroidPresenterImpl extends BasePresenter<GankIoAndroidPresenter.View> implements GankIoAndroidPresenter.Presenter {
    private GankIoService mGankIoService;

    @Inject
    public GankIoAndroidPresenterImpl(GankIoService mGankIoService) {
        this.mGankIoService = mGankIoService;
    }


    @Override
    public void fetchGankIoData(int page, int pre_page) {
        invoke(mGankIoService.getGankIoData("Android",page,pre_page),new Callback<GankIoDataBean>(){
            @Override
            public void onResponse(GankIoDataBean data) {
                List<GankIoDataBean.ResultBean> results = data.getResults();
                checkState(results);
                mView.refreshView(results);

            }
        });
    }
}
