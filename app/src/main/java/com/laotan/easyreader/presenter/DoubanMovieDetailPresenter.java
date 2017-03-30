package com.laotan.easyreader.presenter;

import com.laotan.easyreader.bean.douban.MovieDetailBean;
import com.laotan.easyreader.http.LifeSubscription;

/**
 * Created by quantan.liu on 2017/3/28.
 */

public interface DoubanMovieDetailPresenter {
    interface View extends LifeSubscription {
        void refreshView(MovieDetailBean data);
    }

    interface Presenter {
        void fetchMovieDetail(String id);
    }
}
