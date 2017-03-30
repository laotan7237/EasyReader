package com.laotan.easyreader.presenter;

import com.laotan.easyreader.bean.topnews.NewsDetailBean;
import com.laotan.easyreader.bean.topnews.NewsListBean;
import com.laotan.easyreader.http.LifeSubscription;

/**
 * Created by quantan.liu on 2017/3/27.
 */

public interface TopNewsPresenter {

    interface View extends LifeSubscription {
        void refreshView(NewsListBean data);
    }

    interface Presenter{
        void fetchTopNewsList(int id);
    }
    interface ViewActivity extends View {
        void refreshActivityView(NewsDetailBean newsDetailBean);
    }

}
