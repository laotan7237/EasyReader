package com.laotan.easyreader.presenter;

import com.laotan.easyreader.bean.douban.HotMovieBean;
import com.laotan.easyreader.http.LifeSubscription;

/**
 * Created by quantan.liu on 2017/3/28.
 */

public interface DouBanMovieTopPresenter {
    interface View extends LifeSubscription {
       void refreshView(HotMovieBean data);
        void showLoadMoreError();
    }

    interface Presenter {
        void fetchMovieTop250(int start,int count);
    }
}
