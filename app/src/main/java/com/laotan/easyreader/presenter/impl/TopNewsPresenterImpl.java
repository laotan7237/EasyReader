package com.laotan.easyreader.presenter.impl;

import com.blankj.utilcode.utils.LogUtils;
import com.laotan.easyreader.app.AppConstants;
import com.laotan.easyreader.bean.topnews.NewsDetailBean;
import com.laotan.easyreader.bean.topnews.NewsListBean;
import com.laotan.easyreader.http.Stateful;
import com.laotan.easyreader.http.utils.Callback;
import com.laotan.easyreader.http.utils.RetrofitTopNewsUtils;
import com.laotan.easyreader.presenter.BasePresenter;
import com.laotan.easyreader.presenter.TopNewsPresenter;
import com.laotan.easyreader.utils.NewsJsonUtils;
import com.laotan.easyreader.utils.OkHttpUtils;

import javax.inject.Inject;

/**
 * Created by quantan.liu on 2017/3/27.
 */

public class TopNewsPresenterImpl  extends BasePresenter<TopNewsPresenter.View> implements TopNewsPresenter.Presenter {
    private RetrofitTopNewsUtils mRetrofitTopNewsUtils;

    @Inject
    public TopNewsPresenterImpl(RetrofitTopNewsUtils mRetrofitTopNewsUtils) {
        this.mRetrofitTopNewsUtils = mRetrofitTopNewsUtils;
    }


    @Override
    public void fetchTopNewsList(int id) {
        invoke(mRetrofitTopNewsUtils.fetchTopNewsList(id),new Callback<NewsListBean>(){
            @Override
            public void onResponse(NewsListBean data) {
                checkState(data.getNewsList());
                mLifeSubscription.refreshView(data);
            }
        });
    }

    public void getDescrible(final String docid) {
        String url = getDetailUrl(docid);
        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                if (response==null){
                    if (mLifeSubscription instanceof Stateful)
                        ((Stateful) mLifeSubscription).setState(AppConstants.STATE_EMPTY);
                }
                NewsDetailBean newsDetailBean = NewsJsonUtils.readJsonNewsDetailBeans(response, docid);
                ((TopNewsPresenter.ViewActivity)mLifeSubscription).refreshActivityView(newsDetailBean);
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
