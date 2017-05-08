package com.laotan.easyreader.presenter.impl;

import com.laotan.easyreader.bean.zhihu.SectionChildListBean;
import com.laotan.easyreader.bean.zhihu.ThemeChildListBean;
import com.laotan.easyreader.http.service.ZhiHuService;
import com.laotan.easyreader.http.utils.Callback;
import com.laotan.easyreader.presenter.BasePresenter;
import com.laotan.easyreader.presenter.ZhihuThemeDetailPresenter;

import javax.inject.Inject;

/**
 * Created by quantan.liu on 2017/3/27.
 */

public class ZhihuThemeDetailPresenterImpl extends BasePresenter<ZhihuThemeDetailPresenter.View> implements ZhihuThemeDetailPresenter.Presenter {
    private ZhiHuService mZhiHuService;


    @Inject
    public ZhihuThemeDetailPresenterImpl(ZhiHuService mZhiHuService) {
        this.mZhiHuService = mZhiHuService;
    }

    @Override
    public void fetchThemeChildList(int id) {
        invoke(mZhiHuService.fetchThemeChildList(id), new Callback<ThemeChildListBean>() {
            @Override
            public void onResponse(ThemeChildListBean data) {
                mView.refreshView(data);
            }
        });
    }

    @Override
    public void fetchSectionChildList(int id) {
        invoke(mZhiHuService.fetchSectionChildList(id), new Callback<SectionChildListBean>() {
            @Override
            public void onResponse(SectionChildListBean data) {
                mView.refreshSectionData(data);
            }
        });
    }


}
