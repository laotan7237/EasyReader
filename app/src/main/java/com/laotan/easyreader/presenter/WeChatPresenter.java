package com.laotan.easyreader.presenter;

import com.laotan.easyreader.bean.wechat.WXItemBean;
import com.laotan.easyreader.http.LifeSubscription;

import java.util.List;

/**
 * Created by quantan.liu on 2017/3/28.
 */

public interface WeChatPresenter {
    interface View extends LifeSubscription {
       void refreshView(List<WXItemBean> data);
    }

    interface Presenter {
        void fetchWeChatHot(int num, int page);
        void fetchWXHotSearch(int num, int page, String word);
    }
}
