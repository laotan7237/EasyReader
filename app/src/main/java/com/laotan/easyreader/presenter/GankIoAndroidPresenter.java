package com.laotan.easyreader.presenter;

import com.laotan.easyreader.bean.gankio.GankIoDataBean;
import com.laotan.easyreader.http.LifeSubscription;

import java.util.List;

/**
 * Created by quantan.liu on 2017/3/30.
 */

public interface GankIoAndroidPresenter {

    interface View extends LifeSubscription {
        void refreshView(List<GankIoDataBean.ResultBean> data);
    }

    interface Presenter{
        void fetchGankIoData(int page, int pre_page);
    }
}
