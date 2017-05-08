package com.laotan.easyreader.presenter.impl;

import com.blankj.utilcode.utils.NetworkUtils;
import com.blankj.utilcode.utils.ToastUtils;
import com.laotan.easyreader.bean.douban.HotMovieBean;
import com.laotan.easyreader.http.service.DoubanService;
import com.laotan.easyreader.http.utils.Callback;
import com.laotan.easyreader.presenter.BasePresenter;
import com.laotan.easyreader.presenter.DouBanMovieTopPresenter;

import javax.inject.Inject;

/**
 * Created by quantan.liu on 2017/3/28.
 */

public class DouBanMovieTopPresenterImpl extends BasePresenter<DouBanMovieTopPresenter.View> implements DouBanMovieTopPresenter.Presenter {
    private DoubanService mDoubanService;

    @Inject
    public DouBanMovieTopPresenterImpl(DoubanService mDoubanService) {
        this.mDoubanService = mDoubanService;
    }
    public void fetchMovieTop250(final int start, int count){
        invoke(mDoubanService.fetchMovieTop250(start,count),new Callback<HotMovieBean>(){

            /**
             * 错误我们基本上采用统一处理，直接整个界面切换成错误界面，如果想在下拉
             * 刷新的最底下提示可以模仿以下方法。
             */
            @Override
            public void onfail() {
                if (start<=0){
                    super.onfail();
                    return;
                }
                if (!NetworkUtils.isAvailableByPing()) {
                    ToastUtils.showShortToast("你连接的网络有问题，请检查路由器");
                    mView.showLoadMoreError();
                    return;
                }
                ToastUtils.showShortToast("程序员哥哥偷懒去了，快去举报他");
            }
        });
    }

}
