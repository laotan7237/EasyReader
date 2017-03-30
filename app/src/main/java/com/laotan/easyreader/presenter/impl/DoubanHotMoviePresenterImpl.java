package com.laotan.easyreader.presenter.impl;

import com.laotan.easyreader.bean.douban.HotMovieBean;
import com.laotan.easyreader.http.utils.Callback;
import com.laotan.easyreader.http.utils.RetrofitDouBanUtils;
import com.laotan.easyreader.presenter.BasePresenter;
import com.laotan.easyreader.presenter.DoubanHotMoviePresenter;

import javax.inject.Inject;

/**
 * Created by quantan.liu on 2017/3/29.
 */

public class DoubanHotMoviePresenterImpl extends BasePresenter<DoubanHotMoviePresenter.View> implements  DoubanHotMoviePresenter.Presenter {
    private RetrofitDouBanUtils mRetrofitDouBanUtils;

    @Inject
    public DoubanHotMoviePresenterImpl(RetrofitDouBanUtils mRetrofitDouBanUtils) {
        this.mRetrofitDouBanUtils = mRetrofitDouBanUtils;
    }
    @Override
    public void fetchHotMovie() {
        invoke(mRetrofitDouBanUtils.fetchHotMovie(),new Callback<HotMovieBean>(){
            @Override
            public void onResponse(HotMovieBean data) {
                mLifeSubscription.refreshView(data);
            }
        });
    }
}
