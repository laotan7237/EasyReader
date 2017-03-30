package com.laotan.easyreader.http.utils;

import com.laotan.easyreader.app.AppConstants;
import com.laotan.easyreader.bean.wechat.WXHttpResponse;
import com.laotan.easyreader.bean.wechat.WXItemBean;
import com.laotan.easyreader.http.service.WeChatService;

import java.util.List;

import rx.Observable;

/**
 * Created by quantan.liu on 2017/3/21.
 */

public class RetrofitWeChatUtils extends HttpUtils {

    private WeChatService mWeChatService;

    public RetrofitWeChatUtils(WeChatService mWeChatService) {
        this.mWeChatService = mWeChatService;
    }

    public Observable<WXHttpResponse<List<WXItemBean>>> fetchWeChatHot(int num, int page) {
       return mWeChatService.getWXHot(AppConstants.KEY_API, num, page);
    }

    public Observable<WXHttpResponse<List<WXItemBean>>> fetchWXHotSearch(int num, int page, String word) {
       return mWeChatService.getWXHotSearch(AppConstants.KEY_API, num, page, word);
    }

}
