package com.laotan.easyreader.presenter.impl;

import com.laotan.easyreader.bean.wechat.WXHttpResponse;
import com.laotan.easyreader.bean.wechat.WXItemBean;
import com.laotan.easyreader.http.utils.Callback;
import com.laotan.easyreader.http.utils.RetrofitWeChatUtils;
import com.laotan.easyreader.presenter.BasePresenter;
import com.laotan.easyreader.presenter.WeChatPresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by quantan.liu on 2017/3/30.
 */

public class WeChatPresenterImpl extends BasePresenter<WeChatPresenter.View> implements WeChatPresenter.Presenter {
    private RetrofitWeChatUtils mRetrofitWeChatUtils;

    @Inject
    public WeChatPresenterImpl(RetrofitWeChatUtils mRetrofitWeChatUtils) {
        this.mRetrofitWeChatUtils = mRetrofitWeChatUtils;
    }

    @Override
    public void fetchWeChatHot(int num, int page) {
        invoke(mRetrofitWeChatUtils.fetchWeChatHot(num, page), new Callback<WXHttpResponse<List<WXItemBean>>>() {
            @Override
            public void onResponse(WXHttpResponse<List<WXItemBean>> data) {
                List<WXItemBean> newslist = data.getNewslist();
                checkState(newslist);
                mLifeSubscription.refreshView(newslist);
            }
        });
    }

    @Override
    public void fetchWXHotSearch(int num, int page, String word) {
        invoke(mRetrofitWeChatUtils.fetchWXHotSearch(num, page, word), new Callback<WXHttpResponse<List<WXItemBean>>>() {
            @Override
            public void onResponse(WXHttpResponse<List<WXItemBean>> data) {
                List<WXItemBean> newslist = data.getNewslist();
                checkState(newslist);
                mLifeSubscription.refreshView(newslist);
            }
        });

    }



}
