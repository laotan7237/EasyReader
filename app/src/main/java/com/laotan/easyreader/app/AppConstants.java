package com.laotan.easyreader.app;

/**
 * Created by quantan.liu on 2017/3/21.
 */

public class AppConstants {
    public static final int STATE_UNKNOWN = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_ERROR = 2;
    public static final int STATE_EMPTY = 3;
    public static final int STATE_SUCCESS = 4;
    //需要APIKEY请去 http://www.tianapi.com/#wxnew 申请,复用会减少访问可用次数。还有很多别的接口大家可以研究。
    public static final String KEY_API = "e6d6ec3ba2f9d7a3051a6c09f0524738";

    public static  final int WECHA_SEARCH = 1000;
}
