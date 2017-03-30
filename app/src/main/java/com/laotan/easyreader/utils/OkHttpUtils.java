package com.laotan.easyreader.utils;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.internal.$Gson$Types;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Description : OkHttp网络连接封装工具类
 * Author : lauren
 * Email  : lauren.liuling@gmail.com
 * Blog   : http://www.liuling123.com
 * Date   : 15/12/17
 */
public class OkHttpUtils {

    private static final String TAG = "OkHttpUtils";

    private static OkHttpUtils mInstance;
    private OkHttpClient mOkHttpClient;
    private Handler mDelivery;

    private OkHttpUtils() {
        mOkHttpClient = new OkHttpClient();
        //cookie enabled
        mDelivery = new Handler(Looper.getMainLooper());
    }

    private synchronized static OkHttpUtils getmInstance() {
        if (mInstance == null) {
            mInstance = new OkHttpUtils();
        }
        return mInstance;
    }

    private void getRequest(String url, final ResultCallback callback) {
        final Request request = new Request.Builder().url(url).build();
        deliveryResult(callback, request);
    }


    private void deliveryResult(final ResultCallback callback, Request request) {

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                sendFailCallback(callback, e);

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String str = response.body().string();
                    if (callback.mType == String.class) {
                        sendSuccessCallBack(callback, str);
                    } else {
                        Object object = JsonUtils.deserialize(str, callback.mType);
                        sendSuccessCallBack(callback, object);
                    }
                } catch (final Exception e) {
                    sendFailCallback(callback, e);
                }

            }
    });
    }
    private void sendFailCallback(final ResultCallback callback, final Exception e) {
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                if (callback != null) {
                    callback.onFailure(e);
                }
            }
        });
    }

    private void sendSuccessCallBack(final ResultCallback callback, final Object obj) {
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                if (callback != null) {
                    callback.onSuccess(obj);
                }
            }
        });
    }



    /**********************对外接口************************/

    /**
     * get请求
     * @param url  请求url
     * @param callback  请求回调
     */
    public static void get(String url, ResultCallback callback) {
        getmInstance().getRequest(url, callback);
    }


    /**
     * http请求回调类,回调方法在UI线程中执行
     * @param <T>
     */
    public static abstract class ResultCallback<T> {

        Type mType;

        public ResultCallback(){
            mType = getSuperclassTypeParameter(getClass());
        }

        static Type getSuperclassTypeParameter(Class<?> subclass) {
            Type superclass = subclass.getGenericSuperclass();
            if (superclass instanceof Class) {
                throw new RuntimeException("Missing type parameter.");
            }
            ParameterizedType parameterized = (ParameterizedType) superclass;
            return $Gson$Types.canonicalize(parameterized.getActualTypeArguments()[0]);
        }

        /**
         * 请求成功回调
         * @param response
         */
        public abstract void onSuccess(T response);

        /**
         * 请求失败回调
         * @param e
         */
        public abstract void onFailure(Exception e);
    }

    /**
     * post请求参数类
     */
    public static class Param {

        String key;
        String value;

        public Param() {
        }

        public Param(String key, String value) {
            this.key = key;
            this.value = value;
        }

    }


}
