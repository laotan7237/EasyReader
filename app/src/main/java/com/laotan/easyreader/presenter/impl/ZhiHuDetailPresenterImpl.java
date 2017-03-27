package com.laotan.easyreader.presenter.impl;

import com.laotan.easyreader.bean.zhihu.DetailExtraBean;
import com.laotan.easyreader.bean.zhihu.ZhihuDetailBean;
import com.laotan.easyreader.http.utils.Callback;
import com.laotan.easyreader.http.utils.RetrofitZhiHuUtils;
import com.laotan.easyreader.presenter.BasePresenter;
import com.laotan.easyreader.presenter.ZhiHuDetailPresenter;

import javax.inject.Inject;

/**
 * Created by quantan.liu on 2017/3/24.
 */

public class ZhiHuDetailPresenterImpl extends BasePresenter<ZhiHuDetailPresenter.View> implements ZhiHuDetailPresenter.Presenter {
    private RetrofitZhiHuUtils mRetrofitZhiHuUtils;

    @Inject
    public ZhiHuDetailPresenterImpl(RetrofitZhiHuUtils mRetrofitZhiHuUtils) {
        this.mRetrofitZhiHuUtils = mRetrofitZhiHuUtils;
    }

    public void fetchDetailInfo(int id){
        invoke(mRetrofitZhiHuUtils.fetchDetailInfo(id),new Callback<ZhihuDetailBean>(){
            @Override
            public void onResponse(ZhihuDetailBean data) {
                mLifeSubscription.showContent(data);
            }
        });
    }

    @Override
    public void fetchDetailExtraInfo(int id) {
        invoke(mRetrofitZhiHuUtils.fetchDetailExtraInfo(id),new Callback<DetailExtraBean>(){
            @Override
            public void onResponse(DetailExtraBean data) {
                mLifeSubscription.showExtraInfo(data);
            }
        });
    }

}
