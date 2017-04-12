package com.laotan.easyreader.presenter;

import com.laotan.easyreader.bean.zhihu.DetailExtraBean;
import com.laotan.easyreader.bean.zhihu.ZhihuDetailBean;

/**
 * Created by quantan.liu on 2017/3/24.
 */

public interface ZhiHuDetailPresenter {

    interface View extends BaseView<ZhihuDetailBean> {
        void showExtraInfo(DetailExtraBean detailExtraBean);
    }

    interface Presenter{
        void fetchDetailInfo(int id);
        void fetchDetailExtraInfo(int id);
    }
}
