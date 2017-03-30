package com.laotan.easyreader.presenter;

import com.laotan.easyreader.bean.douban.HotMovieBean;
import com.laotan.easyreader.http.LifeSubscription;

/**
 * Created by quantan.liu on 2017/3/29.
 */

public interface DoubanHotMoviePresenter {
    interface View extends LifeSubscription {
        void refreshView(HotMovieBean data);
    }

    interface Presenter {
        void fetchHotMovie();
    }
}
