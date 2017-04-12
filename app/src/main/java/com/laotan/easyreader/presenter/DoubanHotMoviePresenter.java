package com.laotan.easyreader.presenter;

import com.laotan.easyreader.bean.douban.HotMovieBean;

/**
 * Created by quantan.liu on 2017/3/29.
 */

public interface DoubanHotMoviePresenter {
    interface View extends BaseView<HotMovieBean> {
    }

    interface Presenter {
        void fetchHotMovie();
    }
}
