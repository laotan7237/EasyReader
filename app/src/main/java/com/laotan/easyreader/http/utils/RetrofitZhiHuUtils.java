package com.laotan.easyreader.http.utils;

import com.laotan.easyreader.bean.zhihu.CommentBean;
import com.laotan.easyreader.bean.zhihu.DailyListBean;
import com.laotan.easyreader.bean.zhihu.DetailExtraBean;
import com.laotan.easyreader.bean.zhihu.HotListBean;
import com.laotan.easyreader.bean.zhihu.SectionChildListBean;
import com.laotan.easyreader.bean.zhihu.SectionListBean;
import com.laotan.easyreader.bean.zhihu.ThemeChildListBean;
import com.laotan.easyreader.bean.zhihu.ThemeListBean;
import com.laotan.easyreader.bean.zhihu.WelcomeBean;
import com.laotan.easyreader.bean.zhihu.ZhihuDetailBean;
import com.laotan.easyreader.http.service.ZhiHuService;

import rx.Observable;

/**
 * Created by quantan.liu on 2017/3/21.
 */

public class RetrofitZhiHuUtils extends HttpUtils {

    private ZhiHuService mZhiHuService;

    public RetrofitZhiHuUtils(ZhiHuService mZhiHuService) {
        this.mZhiHuService = mZhiHuService;
    }

    public Observable<DailyListBean> fetchDailyListInfo() {
        return mZhiHuService.getDailyList();
    }

    public Observable<ThemeListBean> fetchThemeList() {
        return mZhiHuService.getThemeList();
    }

    public Observable<SectionListBean> fetchSectionList() {
        return mZhiHuService.getSectionList();
    }

    public Observable<HotListBean> fetchHotList() {
        return mZhiHuService.getHotList();
    }

    public Observable<WelcomeBean> fetchWelcomeInfo(String res) {
        return mZhiHuService.getWelcomeInfo(res);
    }

    public Observable<ThemeChildListBean> fetchThemeChildList(int id) {
        return mZhiHuService.getThemeChildList(id);
    }

    public Observable<SectionChildListBean> fetchSectionChildList(int id) {
        return mZhiHuService.getSectionChildList(id);
    }

    public Observable<ZhihuDetailBean> fetchDetailInfo(int id) {
        return mZhiHuService.getDetailInfo(id);
    }

    public Observable<DetailExtraBean> fetchDetailExtraInfo(int id) {
        return mZhiHuService.getDetailExtraInfo(id);
    }

    public Observable<CommentBean> fetchLongCommentInfo(int id) {
        return mZhiHuService.getLongCommentInfo(id);
    }

    public Observable<CommentBean> fetchShortCommentInfo(int id) {
        return mZhiHuService.getShortCommentInfo(id);
    }
}
