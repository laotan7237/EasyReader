package com.laotan.easyreader.presenter.impl;

import com.blankj.utilcode.utils.LogUtils;
import com.blankj.utilcode.utils.NetworkUtils;
import com.blankj.utilcode.utils.ToastUtils;
import com.laotan.easyreader.bean.douban.HotMovieBean;
import com.laotan.easyreader.http.utils.Callback;
import com.laotan.easyreader.http.utils.RetrofitDouBanUtils;
import com.laotan.easyreader.presenter.BasePresenter;
import com.laotan.easyreader.presenter.DouBanMovieTopPresenter;

import javax.inject.Inject;

/**
 * Created by quantan.liu on 2017/3/28.
 */

public class DouBanMovieTopPresenterImpl extends BasePresenter<DouBanMovieTopPresenter.View> implements DouBanMovieTopPresenter.Presenter {
    private RetrofitDouBanUtils mRetrofitDouBanUtils;

    @Inject
    public DouBanMovieTopPresenterImpl(RetrofitDouBanUtils mRetrofitDouBanUtils) {
        this.mRetrofitDouBanUtils = mRetrofitDouBanUtils;
    }
    public void fetchMovieTop250(final int start, int count){
        invoke(mRetrofitDouBanUtils.fetchMovieTop250(start,count),new Callback<HotMovieBean>(){
            @Override
            public void onResponse(HotMovieBean data) {
                checkState(data.getSubjects());
                LogUtils.e("aaaaaHotMovieBean"+data);
                mLifeSubscription.refreshView(data);
            }

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
                    mLifeSubscription.showLoadMoreError();
                    return;
                }
                ToastUtils.showShortToast("程序员哥哥偷懒去了，快去举报他");
            }
        });
    }

}
