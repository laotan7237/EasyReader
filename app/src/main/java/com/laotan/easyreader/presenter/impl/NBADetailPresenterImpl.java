package com.laotan.easyreader.presenter.impl;

import com.laotan.easyreader.app.AppConstants;
import com.laotan.easyreader.bean.topnews.NewsDetailBean;
import com.laotan.easyreader.http.Stateful;
import com.laotan.easyreader.http.service.TopNewsService;
import com.laotan.easyreader.presenter.BasePresenter;
import com.laotan.easyreader.presenter.NBADetailPresenter;
import com.laotan.easyreader.utils.NewsJsonUtils;
import com.laotan.easyreader.utils.OkHttpUtils;

import javax.inject.Inject;

/**
 * Created by quantan.liu on 2017/4/13.
 */

public class NBADetailPresenterImpl extends BasePresenter<NBADetailPresenter.View> implements NBADetailPresenter.Presenter {
    private TopNewsService mTopNewsService;

    @Inject
    public NBADetailPresenterImpl(TopNewsService mTopNewsService) {
        this.mTopNewsService = mTopNewsService;
    }
    @Override
    public void fetchNBADetail(final String id) {
        String url = getDetailUrl(id);
        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                if (response==null){
                    if (mView instanceof Stateful)
                        ((Stateful) mView).setState(AppConstants.STATE_EMPTY);
                }
                NewsDetailBean newsDetailBean = NewsJsonUtils.readJsonNewsDetailBeans(response, id);
                mView.refreshView(newsDetailBean);
            }

            @Override
            public void onFailure(Exception e) {
            }
        };
        OkHttpUtils.get(url, loadNewsCallback);
    }

    private String getDetailUrl(String docId) {
        StringBuffer sb = new StringBuffer("http://c.m.163.com/nc/article/");
        sb.append(docId).append("/full.html");
        return sb.toString();
    }
}
