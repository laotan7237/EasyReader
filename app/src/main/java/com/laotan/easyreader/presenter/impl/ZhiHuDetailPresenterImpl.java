package com.laotan.easyreader.presenter.impl;

import com.laotan.easyreader.bean.zhihu.DetailExtraBean;
import com.laotan.easyreader.bean.zhihu.ZhihuDetailBean;
import com.laotan.easyreader.http.service.ZhiHuService;
import com.laotan.easyreader.http.utils.Callback;
import com.laotan.easyreader.presenter.BasePresenter;
import com.laotan.easyreader.presenter.ZhiHuDetailPresenter;

import javax.inject.Inject;

/**
 * Created by quantan.liu on 2017/3/24.
 */

public class ZhiHuDetailPresenterImpl extends BasePresenter<ZhiHuDetailPresenter.View> implements ZhiHuDetailPresenter.Presenter {
    private ZhiHuService mZhiHuService;

    @Inject
    public ZhiHuDetailPresenterImpl(ZhiHuService mZhiHuService) {
        this.mZhiHuService = mZhiHuService;
    }

    public void fetchDetailInfo(int id){
        invoke(mZhiHuService.fetchDetailInfo(id),new Callback<ZhihuDetailBean>(){
            @Override
            public void onResponse(ZhihuDetailBean data) {
                mView.refreshView(data);
            }
        });
    }

    @Override
    public void fetchDetailExtraInfo(int id) {
        invoke(mZhiHuService.fetchDetailExtraInfo(id),new Callback<DetailExtraBean>(){
            @Override
            public void onResponse(DetailExtraBean data) {
                mView.showExtraInfo(data);
            }
        });
    }

}
