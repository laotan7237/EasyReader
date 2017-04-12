package com.laotan.easyreader.presenter;

import com.laotan.easyreader.bean.zhihu.CommentBean;

import java.util.List;

/**
 * Created by quantan.liu on 2017/3/25.
 */

public interface ZhihuCommentPresenter {

    interface View extends BaseView<List<CommentBean.CommentsBean>> {
    }

    interface Presenter{
        void fetchLongCommentInfo(int id);
        void fetchShortCommentInfo(int id);
    }
}
