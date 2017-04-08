package com.laotan.easyreader.app;

import android.app.Application;

import com.blankj.utilcode.utils.Utils;


/**
 * Created by codeest on 2016/8/2.
 */
public class App extends Application{

    //现在只完成了dagger2和Retrofit配合完成网络请求
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Utils.init(this);//一个utils库的初始化 https://github.com/Blankj/AndroidUtilCode/blob/master/README-CN.md
    }

}
