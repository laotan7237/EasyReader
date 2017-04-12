package com.laotan.easyreader.presenter;

import com.laotan.easyreader.bean.zhihu.SectionChildListBean;
import com.laotan.easyreader.bean.zhihu.ThemeChildListBean;

/**
 * Created by quantan.liu on 2017/3/27.
 */

public interface ZhihuThemeDetailPresenter {

    interface View extends BaseView<ThemeChildListBean> {
        void refreshSectionData(SectionChildListBean data);
    }

    interface Presenter{
        void fetchThemeChildList(int id);
        void fetchSectionChildList(int id);
    }
}
