package com.laotan.easyreader.utils;

import android.app.Activity;

/**
 * Created by quantan.liu on 2017/6/17 0017 22:00.
 */

public class LoginUtils {
public static boolean isLogin = false;
    public static void isLogin(){
        //下面先判断到底有没有登录，一般都会在本地保存。
        if (isLogin){
            //登录了就执行
            if(iLogin!=null){
                LoginUtils.iLogin.onlogin();
            }
        }else{
            //去登录界面，如果登录成功了在调用这个方法就会走上面代码就可以了
        }
    }

    public static void clear(){
        if (iLogin!=null){
            iLogin = null;
        }
        if (activity!=null){
            activity = null;
        }
    }
    static ILogin iLogin;
    static Activity activity;
    public static void setIlogin(ILogin ilogin,Activity activity){
        LoginUtils.iLogin = ilogin;
        LoginUtils.activity = activity;
        isLogin();
    }
    public interface ILogin {
         void onlogin();
    }
}
