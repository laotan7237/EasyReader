package com.laotan.easyreader.presenter;

/**
 * Created by quantan.liu on 2017/4/12.
 */

public interface BaseView<T> {
    void refreshView(T mData);//获取数据成功调用该方法。
}
