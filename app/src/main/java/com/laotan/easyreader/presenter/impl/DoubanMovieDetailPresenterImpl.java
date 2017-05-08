package com.laotan.easyreader.presenter.impl;

import com.laotan.easyreader.bean.douban.MovieDetailBean;
import com.laotan.easyreader.http.service.DoubanService;
import com.laotan.easyreader.http.utils.Callback;
import com.laotan.easyreader.presenter.BasePresenter;
import com.laotan.easyreader.presenter.DoubanMovieDetailPresenter;

import javax.inject.Inject;

/**
 * Created by quantan.liu on 2017/3/28.
 */

public class DoubanMovieDetailPresenterImpl extends BasePresenter<DoubanMovieDetailPresenter.View> implements DoubanMovieDetailPresenter.Presenter {
    private DoubanService mDoubanService;

    @Inject
    public DoubanMovieDetailPresenterImpl(DoubanService mDoubanService) {
        this.mDoubanService = mDoubanService;
    }

    @Override
    public void fetchMovieDetail(String id) {
        invoke(mDoubanService.fetchMovieDetail(id),new Callback<MovieDetailBean>(){
        });
    }
}
