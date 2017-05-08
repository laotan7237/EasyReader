package com.laotan.easyreader.presenter.impl;

import com.laotan.easyreader.bean.douban.HotMovieBean;
import com.laotan.easyreader.http.service.DoubanService;
import com.laotan.easyreader.http.utils.Callback;
import com.laotan.easyreader.presenter.BasePresenter;
import com.laotan.easyreader.presenter.DoubanHotMoviePresenter;

import javax.inject.Inject;

/**
 * Created by quantan.liu on 2017/3/29.
 */

public class DoubanHotMoviePresenterImpl extends BasePresenter<DoubanHotMoviePresenter.View> implements  DoubanHotMoviePresenter.Presenter {
    private DoubanService mDoubanService;

    @Inject
    public DoubanHotMoviePresenterImpl(DoubanService mDoubanService) {
        this.mDoubanService = mDoubanService;
    }
    @Override
    public void fetchHotMovie() {
        invoke(mDoubanService.fetchHotMovie(),new Callback<HotMovieBean>(){});
    }
}
