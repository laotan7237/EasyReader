package com.laotan.easyreader.app;

import android.app.Application;

import com.blankj.utilcode.utils.Utils;
import com.laotan.easyreader.injector.component.AppComponent;
import com.laotan.easyreader.injector.component.DaggerAppComponent;
import com.laotan.easyreader.injector.module.AppModule;


/**
 * Created by codeest on 2016/8/2.
 */
public class App extends Application{

    //现在只完成了dagger2和Retrofit配合完成网络请求
    private static App instance;
    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Utils.init(this);//一个utils库的初始化 https://github.com/Blankj/AndroidUtilCode/blob/master/README-CN.md
    }

    public static AppComponent getAppComponent(){
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(instance))
                    .build();
        }
        return appComponent;
    }

}
