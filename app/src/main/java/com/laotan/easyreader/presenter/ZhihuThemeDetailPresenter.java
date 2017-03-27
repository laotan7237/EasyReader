package com.laotan.easyreader.presenter;

import com.laotan.easyreader.bean.zhihu.SectionChildListBean;
import com.laotan.easyreader.bean.zhihu.ThemeChildListBean;
import com.laotan.easyreader.http.LifeSubscription;

/**
 * Created by quantan.liu on 2017/3/27.
 */

public interface ZhihuThemeDetailPresenter {

    interface View extends LifeSubscription {
        void refreshData(ThemeChildListBean data);
        void refreshSectionData(SectionChildListBean data);
    }

    interface Presenter{
        void fetchThemeChildList(int id);
        void fetchSectionChildList(int id);
    }
}
