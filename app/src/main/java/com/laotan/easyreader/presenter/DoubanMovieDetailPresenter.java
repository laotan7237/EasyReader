package com.laotan.easyreader.presenter;

import com.laotan.easyreader.bean.douban.MovieDetailBean;

/**
 * Created by quantan.liu on 2017/3/28.
 */

public interface DoubanMovieDetailPresenter {
    interface View extends BaseView<MovieDetailBean> {
    }

    interface Presenter {
        void fetchMovieDetail(String id);
    }
}
