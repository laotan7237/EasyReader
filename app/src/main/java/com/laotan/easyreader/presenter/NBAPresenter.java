package com.laotan.easyreader.presenter;

import com.laotan.easyreader.bean.topnews.NBAListBean;

/**
 * Created by quantan.liu on 2017/4/12.
 */

public interface NBAPresenter {

    interface View extends BaseView<NBAListBean> {
    }

    interface Presenter {
        void fetchNBAList(int id);
    }

}
