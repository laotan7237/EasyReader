package com.laotan.easyreader.presenter.impl;

import com.blankj.utilcode.utils.LogUtils;
import com.laotan.easyreader.bean.douban.MovieDetailBean;
import com.laotan.easyreader.http.utils.Callback;
import com.laotan.easyreader.http.utils.RetrofitDouBanUtils;
import com.laotan.easyreader.presenter.BasePresenter;
import com.laotan.easyreader.presenter.DoubanMovieDetailPresenter;

import javax.inject.Inject;

/**
 * Created by quantan.liu on 2017/3/28.
 */

public class DoubanMovieDetailPresenterImpl extends BasePresenter<DoubanMovieDetailPresenter.View> implements DoubanMovieDetailPresenter.Presenter {
    private RetrofitDouBanUtils mRetrofitDouBanUtils;

    @Inject
    public DoubanMovieDetailPresenterImpl(RetrofitDouBanUtils mRetrofitDouBanUtils) {
        this.mRetrofitDouBanUtils = mRetrofitDouBanUtils;
    }

    @Override
    public void fetchMovieDetail(String id) {
        invoke(mRetrofitDouBanUtils.fetchMovieDetail(id),new Callback<MovieDetailBean>(){
            @Override
            public void onResponse(MovieDetailBean data) {
                mLifeSubscription.refreshView(data);
                LogUtils.e("aaaaaMovieDetailBean"+data);
            }
        });
    }
}
