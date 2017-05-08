package com.laotan.easyreader.presenter;

import com.laotan.easyreader.app.AppConstants;
import com.laotan.easyreader.http.LifeSubscription;
import com.laotan.easyreader.http.Stateful;
import com.laotan.easyreader.http.utils.Callback;
import com.laotan.easyreader.http.utils.HttpUtils;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

import rx.Observable;

/**
 * Created by quantan.liu on 2017/3/22.
 */

public class BasePresenter<T extends BaseView> {

    protected Reference<T> mReferenceView;//指的是界面，也就是BaseFragment或者BaseActivity

    protected T mView;
    private Callback callback;

    public void attachView(LifeSubscription mLifeSubscription) {
        this.mReferenceView = new WeakReference<>((T) mLifeSubscription);
        mView = mReferenceView.get();
    }

    protected <T> void invoke(Observable<T> observable, Callback<T> callback) {
        this.callback = callback;
        HttpUtils.invoke((LifeSubscription) mView, observable, callback);
    }

    /**
     * 给子类检查返回集合是否为空
     * 这样子做虽然耦合度高，但是接口都不是统一定的，我们没有什么更好的办法
     *
     * @param list
     */
    public void checkState(List list) {
        if (list.size() == 0) {
            if (mView instanceof Stateful)
                ((Stateful) mView).setState(AppConstants.STATE_EMPTY);
            return;
        }
    }

    public void detachView() {
        if (mReferenceView != null)
            mReferenceView.clear();
            mReferenceView = null;
        if (mView != null)
            mView = null;
        if (callback != null) {
            callback.detachView();
        }
    }
}
