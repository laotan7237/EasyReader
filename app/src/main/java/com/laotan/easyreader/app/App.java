package com.laotan.easyreader.app;

import android.app.Application;
import android.content.Context;
import com.laotan.easyreader.di.component.AppComponent;
import com.laotan.easyreader.di.component.DaggerAppComponent;
import com.laotan.easyreader.di.module.AppModule;
import com.laotan.easyreader.di.module.HttpModule;


/**
 * Created by codeest on 2016/8/2.
 */
public class App extends Application{

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
