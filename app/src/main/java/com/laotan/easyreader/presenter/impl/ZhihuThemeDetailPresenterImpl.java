package com.laotan.easyreader.presenter.impl;

import com.laotan.easyreader.bean.zhihu.SectionChildListBean;
import com.laotan.easyreader.bean.zhihu.ThemeChildListBean;
import com.laotan.easyreader.http.utils.Callback;
import com.laotan.easyreader.http.utils.RetrofitZhiHuUtils;
import com.laotan.easyreader.presenter.BasePresenter;
import com.laotan.easyreader.presenter.ZhihuThemeDetailPresenter;

import javax.inject.Inject;

/**
 * Created by quantan.liu on 2017/3/27.
 */

public class ZhihuThemeDetailPresenterImpl extends BasePresenter<ZhihuThemeDetailPresenter.View> implements ZhihuThemeDetailPresenter.Presenter {
    private RetrofitZhiHuUtils mRetrofitZhiHuUtils;

    @Inject
    public ZhihuThemeDetailPresenterImpl(RetrofitZhiHuUtils mRetrofitZhiHuUtils) {
        this.mRetrofitZhiHuUtils = mRetrofitZhiHuUtils;
    }

    @Override
    public void fetchThemeChildList(int id) {
        invoke(mRetrofitZhiHuUtils.fetchThemeChildList(id),new Callback<ThemeChildListBean>(){
            @Override
            public void onResponse(ThemeChildListBean data) {
                mLifeSubscription.refreshData(data);
            }
        });
    }

    @Override
    public void fetchSectionChildList(int id) {
        invoke(mRetrofitZhiHuUtils.fetchSectionChildList(id),new Callback<SectionChildListBean>(){
            @Override
            public void onResponse(SectionChildListBean data) {
                mLifeSubscription.refreshSectionData(data);
            }
        });
    }


}
