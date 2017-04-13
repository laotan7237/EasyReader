package com.laotan.easyreader.presenter;

import com.laotan.easyreader.bean.topnews.NewsDetailBean;

/**
 * Created by quantan.liu on 2017/4/13.
 */

public interface NBADetailPresenter {
    interface View extends BaseView<NewsDetailBean> {
    }

    interface Presenter{
        void fetchNBADetail(String  id);
    }
}
