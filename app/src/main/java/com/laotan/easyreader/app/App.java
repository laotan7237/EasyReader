package com.laotan.easyreader.app;

import android.app.Application;

import com.laotan.easyreader.di.component.AppComponent;
import com.laotan.easyreader.di.component.DaggerAppComponent;
import com.laotan.easyreader.di.module.AppModule;
import com.laotan.easyreader.di.module.HttpModule;


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
    }

    public static AppComponent getAppComponent(){
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(instance))
                    .httpModule(new HttpModule())
                    .build();
        }
        return appComponent;
    }
}
