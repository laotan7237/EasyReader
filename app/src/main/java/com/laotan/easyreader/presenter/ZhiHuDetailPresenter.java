package com.laotan.easyreader.presenter;

import com.laotan.easyreader.bean.zhihu.DetailExtraBean;
import com.laotan.easyreader.bean.zhihu.ZhihuDetailBean;
import com.laotan.easyreader.http.LifeSubscription;

/**
 * Created by quantan.liu on 2017/3/24.
 */

public interface ZhiHuDetailPresenter {

    interface View extends LifeSubscription {
        void showExtraInfo(DetailExtraBean detailExtraBean);
        void showContent(ZhihuDetailBean zhihuDetailBean);
    }

    interface Presenter{
        void fetchDetailInfo(int id);
        void fetchDetailExtraInfo(int id);
    }
}
