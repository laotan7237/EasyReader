package com.laotan.easyreader.presenter;

import com.laotan.easyreader.bean.zhihu.CommentBean;
import com.laotan.easyreader.http.LifeSubscription;

import java.util.List;

/**
 * Created by quantan.liu on 2017/3/25.
 */

public interface ZhihuCommentPresenter {

    interface View extends LifeSubscription {
        void showRecyclerView(List<CommentBean.CommentsBean> list);
    }

    interface Presenter{
        void fetchLongCommentInfo(int id);
        void fetchShortCommentInfo(int id);
    }
}
