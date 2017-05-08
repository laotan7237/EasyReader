package com.laotan.easyreader.presenter.impl;

import com.laotan.easyreader.bean.zhihu.CommentBean;
import com.laotan.easyreader.http.service.ZhiHuService;
import com.laotan.easyreader.http.utils.Callback;
import com.laotan.easyreader.presenter.BasePresenter;
import com.laotan.easyreader.presenter.ZhihuCommentPresenter;

import javax.inject.Inject;

/**
 * Created by quantan.liu on 2017/3/25.
 */

public class ZhihuCommentPresenterImpl extends BasePresenter<ZhihuCommentPresenter.View> implements ZhihuCommentPresenter.Presenter {
    private ZhiHuService mZhiHuService;

    @Inject
    public ZhihuCommentPresenterImpl(ZhiHuService mZhiHuService) {
        this.mZhiHuService = mZhiHuService;
    }


    public void fetchLongCommentInfo(int id){
        invoke(mZhiHuService.fetchLongCommentInfo(id),new Callback<CommentBean>(){
            @Override
            public void onResponse(CommentBean data) {
                checkState(data.getComments());
                mView.refreshView(data.getComments());
            }
        });
    }
    public void fetchShortCommentInfo(int id){
        invoke(mZhiHuService.fetchShortCommentInfo(id),new Callback<CommentBean>(){
            @Override
            public void onResponse(CommentBean data) {
                checkState(data.getComments());
                mView.refreshView(data.getComments());
            }
        });
    }

}
