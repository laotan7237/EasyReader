package com.laotan.easyreader.presenter.impl;

import com.laotan.easyreader.bean.zhihu.CommentBean;
import com.laotan.easyreader.http.utils.Callback;
import com.laotan.easyreader.http.utils.RetrofitZhiHuUtils;
import com.laotan.easyreader.presenter.BasePresenter;
import com.laotan.easyreader.presenter.ZhihuCommentPresenter;

import javax.inject.Inject;

/**
 * Created by quantan.liu on 2017/3/25.
 */

public class ZhihuCommentPresenterImpl extends BasePresenter<ZhihuCommentPresenter.View> implements ZhihuCommentPresenter.Presenter {
    private RetrofitZhiHuUtils mRetrofitZhiHuUtils;

    @Inject
    public ZhihuCommentPresenterImpl(RetrofitZhiHuUtils mRetrofitZhiHuUtils) {
        this.mRetrofitZhiHuUtils = mRetrofitZhiHuUtils;
    }


    public void fetchLongCommentInfo(int id){
        invoke(mRetrofitZhiHuUtils.fetchLongCommentInfo(id),new Callback<CommentBean>(){
            @Override
            public void onResponse(CommentBean data) {
                checkState(data.getComments());
                mLifeSubscription.showRecyclerView(data.getComments());
            }
        });
    }
    public void fetchShortCommentInfo(int id){
        invoke(mRetrofitZhiHuUtils.fetchShortCommentInfo(id),new Callback<CommentBean>(){
            @Override
            public void onResponse(CommentBean data) {
                checkState(data.getComments());
                mLifeSubscription.showRecyclerView(data.getComments());
            }
        });
    }

}
