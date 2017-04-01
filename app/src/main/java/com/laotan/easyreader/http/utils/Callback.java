package com.laotan.easyreader.http.utils;

import com.blankj.utilcode.utils.NetworkUtils;
import com.blankj.utilcode.utils.ToastUtils;
import com.laotan.easyreader.app.AppConstants;
import com.laotan.easyreader.http.Stateful;

import rx.Subscriber;

/**
 * Created by quantan.liu on 2017/3/21.
 */

public class Callback<T> extends Subscriber<T> {
    private Stateful target;

    public void setTarget(Stateful target) {
        this.target = target;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        onfail();
    }

    @Override
    public void onNext(T data) {
        //// TODO: 2017/3/22 这边网络请求成功返回都不一样所以不能在这里统一写了（如果是自己公司需要规定一套返回方案）
        /// TODO: 2017/3/22 这里先统一处理为成功   我们要是想检查返回结果的集合是否是空，只能去子类回掉中完成了。

        target.setState(AppConstants.STATE_SUCCESS);
        onResponse();
        onResponse(data);
    }

    public void onResponse(T data) {
    }

    public void onResponse() {
    }

    public void onfail() {
        if (!NetworkUtils.isAvailableByPing()) {
            ToastUtils.showShortToast("你连接的网络有问题，请检查路由器");
            if (target != null) {
                target.setState(AppConstants.STATE_ERROR);
            }
            return;
        }
        ToastUtils.showShortToast("程序员哥哥偷懒去了，快去举报他");
        if (target != null) {
            target.setState(AppConstants.STATE_EMPTY);
        }
    }
}
