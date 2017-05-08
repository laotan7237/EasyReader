package com.laotan.easyreader.presenter.impl;

import com.laotan.easyreader.bean.topnews.NBAListBean;
import com.laotan.easyreader.http.service.TopNewsService;
import com.laotan.easyreader.http.utils.Callback;
import com.laotan.easyreader.presenter.BasePresenter;
import com.laotan.easyreader.presenter.NBAPresenter;

import javax.inject.Inject;

/**
 * Created by quantan.liu on 2017/4/12.
 */

public class NBAPresenterImpl extends BasePresenter<NBAPresenter.View> implements NBAPresenter.Presenter {
    private TopNewsService mTopNewsService;

    @Inject
    public NBAPresenterImpl(TopNewsService mTopNewsService) {
        this.mTopNewsService = mTopNewsService;
    }

    @Override
    public void fetchNBAList(int id) {
        invoke(mTopNewsService.fetchNBA(id),new Callback<NBAListBean>());
    }
}
