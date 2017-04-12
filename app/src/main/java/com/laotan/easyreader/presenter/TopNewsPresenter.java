package com.laotan.easyreader.presenter;

import com.laotan.easyreader.bean.topnews.NewsDetailBean;
import com.laotan.easyreader.bean.topnews.NewsListBean;

/**
 * Created by quantan.liu on 2017/3/27.
 */

public interface TopNewsPresenter {

    interface View extends BaseView<NewsListBean>{
    }

    interface Presenter{
        void fetchTopNewsList(int id);
    }
    interface ViewActivity extends View {
        void refreshActivityView(NewsDetailBean newsDetailBean);
    }

}
